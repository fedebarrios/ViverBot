package viverbot.Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import viverbot.Model.HistorialAltura;
import viverbot.Model.RegistroHistorial;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.EmptyMedicion;
import viverbot.Modelo.Magnitudes.Magnitud;

public class HistorialAlturaTest {
	private HistorialAltura historial ;
	
	protected void fabricarHistorial() {
		historial = new HistorialAltura();
		historial.agregarRegistro(1,new Medicion(10.0, Magnitud.ALTURA));
		historial.agregarRegistro(2,new Medicion(14.0, Magnitud.ALTURA));
		historial.agregarRegistro(3,new Medicion(16.0, Magnitud.ALTURA));
		historial.agregarRegistro(4,new Medicion(18.0, Magnitud.ALTURA));
	}
	
	@Test
	public void BuscarMedicionEnDiaNoGuardado(){
		fabricarHistorial();
		assertTrue(historial.buscarMedicion(5) instanceof EmptyMedicion);
	}
	
	@Test
	public void BuscarMedicionEnDiaGuardado(){
		fabricarHistorial();
		assertTrue(historial.buscarMedicion(4).getValor() == 18);
	}
	
	@Test
	public void agregarYBorrarRegistro(){
		fabricarHistorial();
		assertTrue(historial.tamaño()==4);
		historial.agregarRegistro(5,new Medicion(60.0, Magnitud.ALTURA));
		assertTrue(historial.tamaño()==5);
		historial.borrarTupla(5);
		assertTrue(historial.tamaño()==4);
	}
	
	@Test
	public void retornarUltimoDiaDeMedicionHistorialVacio(){
		historial = new HistorialAltura();
		assertEquals(0,historial.diaUltimaMedicion());
	}
	
	@Test
	public void retornarUltimoDiaDeMedicion(){
		fabricarHistorial();
		assertEquals(4,historial.diaUltimaMedicion());
	}
	
	@Test
	public void tamañoTest(){
		fabricarHistorial();
		assertTrue(historial.tamaño()==4);
	}
	
	@Test
	public void verificarRegistro(){
		fabricarHistorial();
		assertTrue(historial.verificarRegistro(4));
		assertFalse(historial.verificarRegistro(8));
	}
	
	@Test
	public void agregarRegistroDuplicado(){
		fabricarHistorial();
		historial.agregarRegistro(4, new Medicion(48.0,Magnitud.ALTURA));
		assertEquals(4,historial.tamaño());
		assertEquals(18.0 ,historial.buscarMedicion(4).getValor(),0);
	}
	
	@Test
	public void testMediciones(){
		fabricarHistorial();
		assertEquals(4 , historial.getMediciones().size());
	}
	
	@Test
	public void testEntrySet(){
		fabricarHistorial();
		assertEquals(4 , historial.getEntrySet().size());
	}
}
