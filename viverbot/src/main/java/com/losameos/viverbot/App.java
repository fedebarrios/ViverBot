package com.losameos.viverbot;

import com.losameos.viverbot.Controller.Verificacion.TransmisorAltura;
import com.losameos.viverbot.Controller.Verificacion.TransmisorHumedad;
import com.losameos.viverbot.Controller.Verificacion.TransmisorTemperatura;
import com.losameos.viverbot.DAO.PlantaDAO;
import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.Model.SoporteFactory;
import com.losameos.viverbot.Model.SoporteMovible;
//import com.losameos.viverbot.DTO.EspecieDTO;

public class App {
	static Plantas planta;
	public static void main(String[] args) {

		// capas este metodo deberia ser una clase que maneje todo el ciclo
		// referido desde que se toma
		// la temperatura hasta que se toma alguna accion.
		//controlarAltura();
		//controlarHumedad();
		PlantaDAO plantaDAO = new PlantaDAO();
		planta = new Plantas(plantaDAO);
		controlarTemperatura();

		// VerDetallesEspecie_Controller controladorPlanta = new
		// VerDetallesEspecie_Controller(new
		// EspecieDTO("especie0","blancas","rosa.jpg"));
		// AltaEspecie_Controller controladorAlta = new
		// AltaEspecie_Controller();
		// BajaEspecie_Controller controladorBaja = new
		// BajaEspecie_Controller();

	}

	@SuppressWarnings("unused")
	private static void controlarHumedad() {
		SoporteMovible soporte =  SoporteFactory.crearSoporte((TransmisorHumedad.getTipoMagnitud()));
		Thread hiloTransmisor = new Thread(new TransmisorHumedad(soporte));
		hiloTransmisor.start();
	}

	

	@SuppressWarnings("static-access")
	private static void controlarTemperatura() {
		TransmisorTemperatura t = new TransmisorTemperatura();
		Thread hiloTransmisor = new Thread(t);
		
		hiloTransmisor.start();

	}
	
	@SuppressWarnings("unused")
	private static void controlarAltura() {
		SoporteMovible soporte =  SoporteFactory.crearSoporte(TransmisorAltura.getTipoMagnitud());
		Thread hiloTransmisor = new Thread(new TransmisorAltura(planta));
		hiloTransmisor.start();
	}
}
