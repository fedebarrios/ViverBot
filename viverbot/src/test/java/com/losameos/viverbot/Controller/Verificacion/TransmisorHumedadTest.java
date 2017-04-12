package com.losameos.viverbot.Controller.Verificacion;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.losameos.viverbot.DAO.PlantaDAO;
import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.Model.SoporteFactory;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class TransmisorHumedadTest {

	private TransmisorHumedad transmisorTest;
	private Thread hiloTest;
	private static Plantas p =  new Plantas();

	@Test
	public void testTrasnmitir() {
		this.inicialize();
		Hora h =  new Hora(6,0,0);
		this.transmisorTest.setHora(h);
		this.hiloTest.start();
		this.esperarHilo();
		ArrayList<PlantaDTO> plantas =  p.obtenerPlantas();
		//assertTrue(plantas.size() == this.transmisorTest.getMediciones().size());
		assertFalse(this.transmisorTest.isSeRealizoTransmision());
	}
	// metodos auxiliares

	private void esperarHilo() {
		while (this.transmisorTest.isSeRealizoTransmision()) {
			System.out.print("");
		}
	}

	private void inicialize() {
		this.transmisorTest = new TransmisorHumedad(SoporteFactory.crearSoporte(Magnitudes.HUMEDAD));
		this.hiloTest = new Thread(this.transmisorTest);
	}

}
