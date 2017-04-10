package com.losameos.viverbot.Model;

import com.losameos.viverbot.Controller.AireAcondicionadoController;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class AutomatizacionDeClima extends Thread {

	@Override
	public void run() {
		Temperatura temp = new Temperatura(10.0);
		System.out.println("La temperatura es de " + temp.getValor());
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		System.out.println("El rango es entre " + rango.getMinimo() + " y " + rango.getMaximo());
		AireAcondicionadoController aireAcondicionado = new AireAcondicionadoController();

		boolean ret = false;
		if (temp.getValor() > rango.getMaximo()) {
			aireAcondicionado.encenderAireAcondicionado();
			while (ret == false) {
				
			}
		}
		if (temp.getValor() < rango.getMinimo()) {
			aireAcondicionado.encenderAireAcondicionado();
			aireAcondicionado.cambiarFrioCalor();
		}
	}

	public static void main(String[] args) {

		AutomatizacionDeClima automatizacion = new AutomatizacionDeClima();
		automatizacion.start();

	}

}
