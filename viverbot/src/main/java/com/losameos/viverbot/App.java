package com.losameos.viverbot;

import com.losameos.viverbot.Controller.Verificacion.TransmisorHumedad;
import com.losameos.viverbot.Controller.Verificacion.TransmisorTemperatura;
//import com.losameos.viverbot.DTO.EspecieDTO;

public class App {
	public static void main(String[] args) {

		// capas este metodo deberia ser una clase que maneje todo el ciclo
		// referido desde que se toma
		// la temperatura hasta que se toma alguna accion.
		controlarTemperatura();
		controlarHumedad();

		// VerDetallesEspecie_Controller controladorPlanta = new
		// VerDetallesEspecie_Controller(new
		// EspecieDTO("especie0","blancas","rosa.jpg"));
		// AltaEspecie_Controller controladorAlta = new
		// AltaEspecie_Controller();
		// BajaEspecie_Controller controladorBaja = new
		// BajaEspecie_Controller();

	}

	private static void controlarHumedad() {
		Thread hiloTransmisor = new Thread(new TransmisorHumedad());
		hiloTransmisor.start();
	}

	private static void controlarTemperatura() {

		Thread hiloTransmisor = new Thread(new TransmisorTemperatura());
		hiloTransmisor.start();

	}
}
