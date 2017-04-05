package com.losameos.viverbot;

import java.io.File;
import java.util.ArrayList;

import com.losameos.viverbot.Controller.AltaEspecie_Controller;
import com.losameos.viverbot.Controller.BajaEspecie_Controller;
import com.losameos.viverbot.Controller.VerDetallesEspecie_Controller;
import com.losameos.viverbot.Controller.Verificacion.TransmisorTemperatura;
//import com.losameos.viverbot.DTO.EspecieDTO;
import com.losameos.viverbot.Model.Medicion.ColectorHumedad;
import com.losameos.viverbot.Model.Medicion.ColectorTemperatura;

/**
 * Hello world!
 *
 */
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
//		ColectorHumedad colector = new ColectorHumedad();
//		Thread hiloColector =  new Thread(colector);
//		hiloColector.start();
	}

	private static void controlarTemperatura() {

		Thread hiloTransmisor = new Thread(new TransmisorTemperatura());
		hiloTransmisor.start();

	}
}
