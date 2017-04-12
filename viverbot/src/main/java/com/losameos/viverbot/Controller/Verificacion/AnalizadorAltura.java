package com.losameos.viverbot.Controller.Verificacion;

import java.util.ArrayList;
import com.losameos.viverbot.Model.HistorialAltura;
import com.losameos.viverbot.Model.LectorConsola;
import com.losameos.viverbot.Model.SeguimientoAltura;
import com.losameos.viverbot.Model.TuplaAltura;
import com.losameos.viverbot.Model.Magnitudes.Altura;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class AnalizadorAltura {
	private HistorialAltura historialOptimo;
	private HistorialAltura historialVerdadero;
	public String estadoPlantaAnalizada = "";
	public Altura diferenciaAltura = null;
	
	public AnalizadorAltura(){
		
	}
	
	public void analizarExaustivo(Magnitud altura, SeguimientoAltura seguimiento){
		System.out.println("-----------------------------------------------------------");
		
		//Tomo los historiales de la planta a analizar
		this.historialOptimo = seguimiento.getHistorialOptimo();
		this.historialVerdadero = seguimiento.getHistorialVerdadero();
		//Me fijo en que dia de medicion estamos con respecto a los dias de vida de la planta
		int diaActualPlanta = seguimiento.getUltimoDiaMedicion()+1;

		System.out.println("Hoy es el dia: "+ diaActualPlanta);
		System.out.println("La planta esta midiendo "+altura.getValor()+"cm actualmente");
		
		//Si no existe ya, una medicion tomada en el dia de hoy, la guardo en el hisotiral verdadero
		if (!this.historialVerdadero.verificarExistente(diaActualPlanta)){
			this.historialVerdadero.agregarTupla(new TuplaAltura((Altura) altura, diaActualPlanta));
		}
		
		//Si en el historial con el cual comparo los valores no hay una tupla para el dia deseado
		//se pregunta al usuario si desea actualizar el historial optimo
		if (this.historialOptimo.verificarExistente(diaActualPlanta)){
			System.out.println("La planta deberia estar midiendo "+seguimiento.getHistorialOptimo().buscarTupla(diaActualPlanta).getAltura().getCentimetros()+" cm actualmente");
		} else {
			System.out.println("La planta no tiene un historial asociado para el dia de hoy. Ingrese Si, si desea guardar la nueva medicion");
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
			System.out.println("La planta creció demasiado para lo que se esperaba.");
			System.out.println("Tiene "+this.diferenciaAltura.getCentimetros()+" cm de diferencia con lo optimo");
			this.estadoPlantaAnalizada = "Sublime";
		} else if (valorCrecimiento > 110 ){
			System.out.println("La planta ha crecido mas de lo esperado en su ciclo vital");
			this.estadoPlantaAnalizada = "Perfecta";
		} else if (valorCrecimiento > 90 ){
			System.out.println("La planta esta creciendo normalmente entre los valores esperados");
			this.estadoPlantaAnalizada = "Normal";
		}
		else if (valorCrecimiento > 70 ){
			System.out.println("La planta esta creciendo menos de lo esperado. Tomar accion lo antes posible");
			this.estadoPlantaAnalizada = "Anormal";
		}
		else { // La planta ha decrecido mucho, se pregunta si se desea podarla
			System.out.println("La planta tiene un problema de crecimiento. Ingrese Si, si desea podarla");
			String entradaTeclado = LectorConsola.getInstance().leerLinea();
		    if(entradaTeclado.equals("si"));{

				this.estadoPlantaAnalizada = "Defectuosa";
				seguimiento.setEstado(estadoPlantaAnalizada);
		    }
		}
		this.diferenciaAltura = null;
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
