package com.losameos.viverbot;

import com.losameos.viverbot.Controller.AltaEspecie_Controller;
import com.losameos.viverbot.Controller.ConsultaBajaEspecie_Controller;
import com.losameos.viverbot.Controller.Verificacion.TransmisorHumedad;
import com.losameos.viverbot.Model.SoporteFactory;
import com.losameos.viverbot.Model.SoporteMovible;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Medicion.ColectorAltura;
import com.losameos.viverbot.Model.Medicion.ColectorTemperatura;
import com.losameos.viverbot.Model.Medicion.TransmisorAltura;
import com.losameos.viverbot.Model.Medicion.TransmisorTemperatura;
import com.losameos.viverobot.Controller.WebCam.BuscadorImagenControlador;
//import com.losameos.viverbot.DTO.EspecieDTO;
import com.losameos.viverobot.Controller.WebCam.ObtenedorComando;

public class App {
	public static void main(String[] args) {

		// capas este metodo deberia ser una clase que maneje todo el ciclo
		// referido desde que se toma
		// la temperatura hasta que se toma alguna accion.
		// controlarAltura();
		// controlarHumedad();
		// PlantaDAO plantaDAO = new PlantaDAO();
		// planta = new Plantas(plantaDAO);
		controlarTemperatura();
		// controlarAltura();
		// controlarHumedad();
		// controlarTemperatura();
		// ConsultaBajaEspecie_Controller mi = new
		// ConsultaBajaEspecie_Controller();
		//ObtenedorComando obtenedor = new ObtenedorComando();

		// BuscadorImagenControlador webCamControlador = new
		// BuscadorImagenControlador();
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
		SoporteMovible soporte = SoporteFactory.crearSoporte((TransmisorHumedad.getTipoMagnitud()));
		Thread hiloTransmisor = new Thread(new TransmisorHumedad(soporte));
		hiloTransmisor.start();
	}

	private static void controlarTemperatura() {
		ColectorTemperatura t = new ColectorTemperatura(5000, 0);

		TransmisorTemperatura tr = new TransmisorTemperatura();
		t.addObserver(tr);
		t.colectar();

	}

	@SuppressWarnings("unused")
	private static void controlarAltura() {
		ColectorAltura t = new ColectorAltura();
		TransmisorAltura tr = new TransmisorAltura();
		t.addObserver(tr);
		t.colectar();
	}
}
