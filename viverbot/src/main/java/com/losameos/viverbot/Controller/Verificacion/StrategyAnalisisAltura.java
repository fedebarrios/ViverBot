package com.losameos.viverbot.Controller.Verificacion;

import java.util.ArrayList;

import com.losameos.viverbot.Interfaces.IAnalisisAltura;
import com.losameos.viverbot.Model.HistorialAltura;
import com.losameos.viverbot.Model.LectorConsola;
import com.losameos.viverbot.Model.SeguimientoAltura;
import com.losameos.viverbot.Model.SoporteFactory;
import com.losameos.viverbot.Model.SoporteMovible;
import com.losameos.viverbot.Model.TuplaAltura;
import com.losameos.viverbot.Model.Magnitudes.Altura;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class StrategyAnalisisAltura implements IAnalisisAltura{
	
	private HistorialAltura historialOptimo;
	private HistorialAltura historialVerdadero;
	private Altura diferenciaAltura;
	public String estadoPlantaAnalizada;

	@Override
	public EstadoAltura analizar(Magnitud m, SeguimientoAltura seguimiento) {
		
		EstadoAltura estado = analizarExaustivo(m, seguimiento, true);
		return estado;
	}
	
	public EstadoAltura analizarExaustivo(Magnitud altura, SeguimientoAltura seguimiento, boolean calcular){
		boolean calcularFuturo = calcular;
		EstadoAltura estado;
		System.out.println("-----------------------------------------------------------");
		//Tomo los historiales de la planta a analizar
		this.historialOptimo = seguimiento.getHistorialOptimo();
		this.historialVerdadero = seguimiento.getHistorialVerdadero();
		//Me fijo en que dia de medicion estamos con respecto a los dias de vida de la planta
		int diaActualPlanta = seguimiento.getUltimoDiaMedicion()+1;

		System.out.println("Hoy es el dia "+ diaActualPlanta + " de vida de la planta "+ seguimiento.getPlanta().getCodigoPlanta());
		System.out.println("La planta "+ seguimiento.getPlanta().getCodigoPlanta()+ " esta midiendo "+altura.getValor()+"cm actualmente");
		
		//Si no existe ya, una medicion tomada en el dia de hoy, la guardo en el historial verdadero
		if (!this.historialVerdadero.verificarExistente(diaActualPlanta)){
			this.historialVerdadero.agregarTupla(new TuplaAltura((Altura) altura, diaActualPlanta));
		}
		
		//Si en el historial con el cual comparo los valores no hay una tupla para el dia deseado
		//se pregunta al usuario si desea actualizar el historial optimo
		if (this.historialOptimo.verificarExistente(diaActualPlanta)){
			System.out.println("La planta "+ seguimiento.getPlanta().getCodigoPlanta() +" deberia estar midiendo "+
					seguimiento.getHistorialOptimo().buscarTupla(diaActualPlanta).getAltura().getCentimetros()+" cm actualmente");
		} else {
			System.out.println("La planta " + seguimiento.getPlanta().getCodigoPlanta()+""
					+ " no tiene un historial asociado para el dia de hoy. Ingrese Si, si desea guardar la nueva medicion");
			String entradaTeclado = LectorConsola.getInstance().leerLinea();
		    if(entradaTeclado.equals("si"));{
		    	this.historialOptimo.agregarTupla( new TuplaAltura((Altura) altura, diaActualPlanta));
		    }
		}
		
		//Comparo cuanto crecio o decrecio una planta en toda su vida, para sacar un porcentaje global del crecimiento
		int valorCrecimiento = 0;
		ArrayList<Double> porcentajes = new ArrayList<Double>();
		for (int i = 0; i < this.historialVerdadero.tamaño(); i++){
			TuplaAltura tuplaReal = this.historialVerdadero.buscarPorIndice(i);
			TuplaAltura tuplaOptima = this.historialOptimo.buscarTupla(tuplaReal.getDiaDeVida());
			if (tuplaOptima != null){
				analizarPorcentajeEnDia(tuplaReal, tuplaOptima, porcentajes);
				if (i == (this.historialVerdadero.tamaño() - 1)){
					this.diferenciaAltura = diferenciaDeAlturas(tuplaOptima.getAltura(), tuplaReal.getAltura());
				}
			}
		}
		valorCrecimiento = calcularCrecimiento(valorCrecimiento, porcentajes);
		
		
		
		//Calculo cuantos cm de diferencia hay con la altura esperada
		verificarAlturaActual();
		
		//Casos segun el crecimientos
		if( valorCrecimiento > 150 ){
			estado = new EstadoAlturaPerfecta(this.diferenciaAltura.getCentimetros(), seguimiento.getPlanta());
		}else if (valorCrecimiento > 90 ){
			estado = new EstadoAlturaNormal(this.diferenciaAltura.getCentimetros(), seguimiento.getPlanta());
		}
		else if (valorCrecimiento > 70 ){
			estado = new EstadoAlturaAnormal(this.diferenciaAltura.getCentimetros(), seguimiento.getPlanta());
		}
		else { // La planta ha decrecido mucho, se pregunta si se desea podarla
	    	estado = new EstadoAlturaDefectuosa(this.diferenciaAltura.getCentimetros() , seguimiento.getPlanta());
	    	calcularFuturo = false;
		}
		if (calcularFuturo) calcularCrecimientoFaltante(seguimiento, diaActualPlanta, (Altura) altura);
		this.diferenciaAltura = null;
		
		return estado;
	}
	
	public void verificarAlturaActual() {
		if (this.diferenciaAltura == null){
			System.out.println("La planta no tiene un optimo en el historial para comparar en el dia de la fecha.");
		}
		else if (this.diferenciaAltura.getValor() > 10){
			System.out.println("La planta esta unos: " + (int) this.diferenciaAltura.getCentimetros() + "cm por encima de lo optimo.");
		}
		else if (this.diferenciaAltura.getValor() < 10  && this.diferenciaAltura.getValor()>0){
			System.out.println("La planta esta un rango aceptable, a "+(int) this.diferenciaAltura.getCentimetros()+" del valor optimo");
		}
		else if (this.diferenciaAltura.getValor() < 0  && this.diferenciaAltura.getValor()>-10){
			System.out.println("La planta esta un rango aceptable, a "+(int) this.diferenciaAltura.getCentimetros()*-1+" del valor optimo");
		}
		else if (this.diferenciaAltura.getValor() == 0){
			System.out.println("La planta esta exactamente en el valor optimo.");
		}
		else {
			System.out.println("La planta esta unos: " + (int) this.diferenciaAltura.getCentimetros() + "cm por debajo de lo optimo.");
		}
	}
	
	public void calcularCrecimientoFaltante(SeguimientoAltura seguimiento, int diaActualPlanta, Altura actual) {
		if (this.diferenciaAltura == null) return;
		int ultimoDia = seguimiento.getHistorialOptimo().diaUltimaMedicion();
		int diasRestantes = ultimoDia - diaActualPlanta;
		Altura ultimaAlturaDeseada = seguimiento.getHistorialOptimo().buscarTupla(ultimoDia).getAltura();
		double crecimientoFaltante = ultimaAlturaDeseada.getValor() - actual.getValor();
		if (crecimientoFaltante < 0.0){
			System.out.println("La planta ya ha sobrepasado su altura ideal.");
		}
		else{
			System.out.println("La planta debera crecer unos " + crecimientoFaltante + "cm en los proximos " + diasRestantes + " dias.");
		}
	}
	
	public Altura diferenciaDeAlturas(Altura optima, Altura actual){
		double dif = actual.getValor() - optima.getValor();
		return new Altura(dif , "cm");
	}
	
	public void analizarPorcentajeEnDia(TuplaAltura real, TuplaAltura tentativa, ArrayList<Double> porcentajes){
		double porcentaje =  (real.getAltura().getValor() / tentativa.getAltura().getValor() * 100);
		porcentajes.add(porcentaje);
	}
	
	public int calcularCrecimiento(int porcentajeTotal, ArrayList<Double> porcentajes){
		double porcentajeAcumulado = 0;
		for (int i = 0; i < porcentajes.size(); i++){
			porcentajeAcumulado = porcentajeAcumulado + porcentajes.get(i);
		}
		porcentajeAcumulado = porcentajeAcumulado / porcentajes.size();
		return (int) porcentajeAcumulado;
	}

}
