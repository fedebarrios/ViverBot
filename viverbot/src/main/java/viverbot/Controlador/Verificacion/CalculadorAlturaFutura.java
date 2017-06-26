package viverbot.Controlador.Verificacion;

import viverbot.Model.RegistroHistorial;

public class CalculadorAlturaFutura {
	
	private static CalculadorAlturaFutura calculador;
	
	private CalculadorAlturaFutura(){
		
	}
	
	public static CalculadorAlturaFutura getInstance(){
		if( calculador == null){ 
			calculador = new CalculadorAlturaFutura();
		}
		return calculador;
	}
	
	public double calcular(RegistroHistorial ultimaTupla, int diaActualPlanta, double alturaActual) {
		int ultimoDia = ultimaTupla.getDiaDeVida();
		int diasRestantes = ultimoDia - diaActualPlanta;
		double ultimaAlturaDeseada = ultimaTupla.getAltura().getValor();
		double crecimientoFaltante = ultimaAlturaDeseada - alturaActual;
		if (crecimientoFaltante < 0.0){
			//System.out.println("La planta ya ha sobrepasado su altura ideal.");
			return 0.0;
		}
		else{
			//System.out.println("La planta debera crecer unos " + crecimientoFaltante + "cm en los proximos " + diasRestantes + " dias.");
			return crecimientoFaltante;
		} 
	}
}
