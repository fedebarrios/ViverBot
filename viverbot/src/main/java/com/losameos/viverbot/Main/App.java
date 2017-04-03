package com.losameos.viverbot.Main;

import com.losameos.viverbot.Controller.AltaEspecieController;
import com.losameos.viverbot.Controller.BajaEspecieController;
import com.losameos.viverbot.Controller.ColectorTemperatura;
import com.losameos.viverbot.Controller.TransmisorTemperatura;
import com.losameos.viverbot.Controller.VerDetallesEspecieController;
import com.losameos.viverbot.DTO.EspecieDTO;

public class App {
	
	private static void controlarTemperatura() {
		ColectorTemperatura colector = new ColectorTemperatura();
		Thread hiloColector = new Thread(colector);
		hiloColector.start();

		Thread hiloTransmisor = new Thread(new TransmisorTemperatura(colector));
		hiloTransmisor.start();

	}

	public static void main(String[] args) {

		// capas este metodo deberia ser una clase que maneje todo el ciclo
		// referido desde que se toma
		// la temperatura hasta que se toma alguna accion.
		controlarTemperatura();

		VerDetallesEspecieController controladorPlanta = new VerDetallesEspecieController(
				new EspecieDTO("rosas", "blancas", "mascara.jpg"));
		AltaEspecieController controladorAlta = new AltaEspecieController();
		BajaEspecieController controladorBaja = new BajaEspecieController();

	}

}
