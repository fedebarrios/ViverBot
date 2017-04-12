package com.losameos.viverbot.Controller.Verificacion;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.losameos.viverbot.DAO.PlantaDAO;
import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.DTO.UbicacionDTO;
import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.Model.SoporteFactory;
import com.losameos.viverbot.Model.Tupla;
import com.losameos.viverbot.Model.Magnitudes.Humedad;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class TransmisorHumedadTest {

	private TransmisorHumedad transmisorTest;
	private Thread hiloTest;
	private static Plantas p = new Plantas();

	@Test
	public void TransmisorTest() {
		this.inicialize();
		assertNotNull(this.transmisorTest.getColector());
		assertNotNull(this.transmisorTest.getSoporte());
		assertNotNull(this.transmisorTest.getPlantas());
		assertFalse(this.transmisorTest.isSeRealizoTransmision());
		assertTrue(this.transmisorTest.getHoraInicio().equals(TransmisorHumedad.getHoraInicioDefoult()));
		assertNotNull(this.transmisorTest.getMediciones());
		assertNotNull(TransmisorHumedad.getP());
		assertEquals(TransmisorHumedad.getTipoMagnitud(), Magnitudes.HUMEDAD);
		this.clear();

	}

	@Test
	public void testTrasnmitir() {
		this.inicialize();
		Hora h = new Hora(0, 0, 0);
		this.transmisorTest.setHora(h);
		this.hiloTest.start();
		this.esperarHilo();
		ArrayList<PlantaDTO> plantas = p.obtenerPlantas();
		assertTrue(this.transmisorTest.getMediciones().size() == plantas.size());
		assertTrue(this.transmisorTest.isSeRealizoTransmision());
		this.hiloTest.interrupt();
		this.clear();
	}

	@Test
	public void testTrasnmitirHoraErronea() {
		this.inicialize();
		Hora h = Hora.obtenerHoraActual();
		h.incrementarHora(1);
		this.transmisorTest.setHora(h);
		this.hiloTest.start();
		this.esperar(2);
		this.hiloTest.interrupt();
		assertFalse(this.transmisorTest.isSeRealizoTransmision());
		this.clear();
	}

	@Test
	public void verificarTiempoTest() {
		this.inicialize();
		Hora h = Hora.obtenerHoraActual();

		int seg = 10;
		h.incrementarSegundos(seg);
		this.transmisorTest.setHora(h);
		while (!this.transmisorTest.verificarTiempo()) {
		}
		assertTrue(this.transmisorTest.verificarTiempo());
		this.clear();

	}
	
	@Test
	public void verificarTiempoFalseTest() {
		this.inicialize();
		Hora h = new Hora(23,59,59);
		this.transmisorTest.setHora(h);
		
		assertFalse(this.transmisorTest.verificarTiempo());
		this.clear();

	}

	@Test
	public void moverSoporteTest() {
		this.inicialize();
		UbicacionDTO u = new UbicacionDTO(4, 3);
		this.transmisorTest.moverSoporteMovil(u);
	}
	// metodos auxiliares
	
	

	private void esperarHilo() {
		while (!this.transmisorTest.isSeRealizoTransmision()) {
			System.out.print("");
		}
	}

	private void inicialize() {
		this.transmisorTest = new TransmisorHumedad(SoporteFactory.crearSoporte(Magnitudes.HUMEDAD));
		this.hiloTest = new Thread(this.transmisorTest);
	}

	private void clear() {
		this.transmisorTest = null;
		this.hiloTest = null;
	}

	private void esperar(int seg) {
		long i = Hora.instanteActual();
		while (Hora.instanteActual() - i < seg * 1000) {
			System.out.print("");
		}
	}

}
