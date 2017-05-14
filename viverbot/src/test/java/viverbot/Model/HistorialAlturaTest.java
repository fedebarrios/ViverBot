package viverbot.Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import viverbot.Model.HistorialAltura;
import viverbot.Model.TuplaAltura;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.EmptyMedicion;
import viverbot.Modelo.Magnitudes.Magnitudes;

public class HistorialAlturaTest {
	private HistorialAltura historial ;
	private ArrayList<TuplaAltura> tuplas;
	
	@Test
	public void BuscarTupla(){
		tuplas = new ArrayList<TuplaAltura>();
		tuplas.add(new TuplaAltura(new Medicion(10.0, Magnitudes.ALTURA),1));
		tuplas.add(new TuplaAltura(new Medicion(14.0, Magnitudes.ALTURA),2));
		tuplas.add(new TuplaAltura(new Medicion(16.0, Magnitudes.ALTURA),3));
		tuplas.add(new TuplaAltura(new Medicion(18.0, Magnitudes.ALTURA),4));
		historial = new HistorialAltura(tuplas);
		
		assertTrue(historial.tamaño()==4);
		assertTrue(historial.buscarTupla(5).getAltura() instanceof EmptyMedicion);
		assertTrue(historial.buscarTupla(4).getAltura().getValor() == 18);
	}
	
	@Test
	public void BuscarMedicionPorDia(){
		tuplas = new ArrayList<TuplaAltura>();
		tuplas.add(new TuplaAltura(new Medicion(25.0, Magnitudes.ALTURA),10));
		tuplas.add(new TuplaAltura(new Medicion(58.0, Magnitudes.ALTURA),20));
		tuplas.add(new TuplaAltura(new Medicion(64.0, Magnitudes.ALTURA),30));
		tuplas.add(new TuplaAltura(new Medicion(69.0, Magnitudes.ALTURA),40));
		historial = new HistorialAltura(tuplas);
		
		assertTrue(historial.tamaño()==4);
		TuplaAltura nuevaTupla = new TuplaAltura(new Medicion(60.0, Magnitudes.ALTURA),5);
		historial.agregarTupla(nuevaTupla);
		assertTrue(historial.tamaño()==5);
		historial.borrarTupla(nuevaTupla);
		assertTrue(historial.tamaño()==4);
		
		assertTrue(historial.verificarExistente(20));
		assertFalse(historial.verificarExistente(4));
	}
	
	@Test
	public void retornarDia(){
		tuplas = new ArrayList<TuplaAltura>();
		historial = new HistorialAltura(tuplas);
		
		assertEquals(0,historial.diaUltimaMedicion());
	}
}
