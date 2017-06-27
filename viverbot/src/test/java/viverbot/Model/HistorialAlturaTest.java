package viverbot.Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import viverbot.Model.HistorialAltura;
import viverbot.Model.RegistroHistorial;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.EmptyMedicion;
import viverbot.Modelo.Magnitudes.Magnitudes;

public class HistorialAlturaTest {
	private HistorialAltura historial ;
	private ArrayList<RegistroHistorial> tuplas;
	
	@Test
	public void BuscarTupla(){
		historial = new HistorialAltura();
		historial.agregarRegistro(1,new Medicion(10.0, Magnitudes.ALTURA));
		historial.agregarRegistro(2,new Medicion(14.0, Magnitudes.ALTURA));
		historial.agregarRegistro(3,new Medicion(16.0, Magnitudes.ALTURA));
		historial.agregarRegistro(4,new Medicion(18.0, Magnitudes.ALTURA));
		
		
		assertTrue(historial.tamaño()==4);
		assertTrue(historial.buscarMedicion(5) instanceof EmptyMedicion);
		assertTrue(historial.buscarMedicion(4).getValor() == 18);
	}
	
	@Test
	public void BuscarMedicionPorDia(){
		historial = new HistorialAltura();
		historial.agregarRegistro(10,new Medicion(25.0, Magnitudes.ALTURA));
		historial.agregarRegistro(20,new Medicion(58.0, Magnitudes.ALTURA));
		historial.agregarRegistro(30,new Medicion(64.0, Magnitudes.ALTURA));
		historial.agregarRegistro(40,new Medicion(69.0, Magnitudes.ALTURA));
		
		
		assertTrue(historial.tamaño()==4);
		historial.agregarRegistro(5,new Medicion(60.0, Magnitudes.ALTURA));
		assertTrue(historial.tamaño()==5);
		historial.borrarTupla(5);
		assertTrue(historial.tamaño()==4);
		
		assertTrue(historial.verificarExistente(20));
		assertFalse(historial.verificarExistente(4));
	}
	
	@Test
	public void retornarDia(){
		historial = new HistorialAltura();
		
		assertEquals(0,historial.diaUltimaMedicion());
	}
}
