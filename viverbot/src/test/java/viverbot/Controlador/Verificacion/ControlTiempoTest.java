package viverbot.Controlador.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Controlador.Verificacion.ControlTiempo;
import viverbot.Model.Estacion;
import viverbot.Model.Fecha;
import viverbot.Model.Hora;

public class ControlTiempoTest {

	private ControlTiempo controlTiempoTest=null;

	@Test
	public void ValidaRiegoTempTest() {
		this.inicialize(Fecha.obtenerFechaActual(),Hora.obtenerHoraActual());
		assertTrue(this.controlTiempoTest != null);
		this.clear();

	}

	@Test
	public void AnalizarVeranoTest() {
		Fecha f=new Fecha(16,01,1986);
		Hora h=new Hora(15,00,00);
		this.inicialize(f,h);
		assertTrue(controlTiempoTest.esVerano());
		
	}	
	
	@Test
	public void AnalizarInviernoTest() {
		Fecha f=new Fecha(16,07,1986);
		Hora h=new Hora(22,00,00);
		this.inicialize(f,h);
		assertTrue(controlTiempoTest.esInvierno());
	}



	

	@Test
	public void AnalizarDiaTest() {
		Fecha f=new Fecha(16,01,1986);
		Hora h=new Hora(15,00,00);
		this.inicialize(f,h);
		assertTrue(controlTiempoTest.esDeDia());
	}

	
	@Test
	public void AnalizarNocheTest() {
		Fecha f=new Fecha(16,01,1986);
		Hora h=new Hora(22,00,00);
		this.inicialize(f,h);
		assertFalse(controlTiempoTest.esDeDia());
	}




	
	

	// metodos auxiliares

	private void inicialize(Fecha f, Hora h) {
		controlTiempoTest=new ControlTiempo(f,h);
	}
	
	private void clear() {
		this.controlTiempoTest = null;
	}
}
