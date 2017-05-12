package viverbot.Archivos;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import viverbot.DTO.EspecieDTO;
import viverbot.Model.HistorialOptimo;
import viverbot.Model.TuplaAltura;
import viverbot.Modelo.Magnitudes.EmptyMedicion;

public class ParserTest {
	
	@Test
	public void ParserEspecie(){
		ParserEspecie parser = new ParserEspecie();
		String datos = "etomate:tomatus";
		EspecieDTO especie = parser.parsear(datos);
		assertEquals("tomate",especie.getNombre());
		assertEquals("tomatus",especie.getNombreCientifico());
	}
	
	@Test
	public void ParserTuplaAltura(){
		ParserHistorial parser = new ParserHistorial();
		String datos = "h14:2.05";
		TuplaAltura tupla = parser.parsear(datos);
		assertEquals(14,tupla.getDiaDeVida());
		assertTrue( 2.05 == tupla.getAltura().getValor());
	}
	
	@Test
	public void MediatorTest(){
		MediatorParser mediator = new MediatorParser();
		ArrayList<String> datos = new ArrayList<String>();
		datos.add("h1:1.54");
		datos.add("h3:1.65");
		datos.add("ecebolla:cebollus");
		HistorialOptimo historial = mediator.parsearHistorialEspecie(datos);
		assertEquals("cebolla",historial.getEspecie().getNombre());
		assertEquals("cebollus",historial.getEspecie().getNombreCientifico());
		assertTrue(1.54 == historial.buscarTupla(1).getAltura().getValor());
		assertTrue(1.65 == historial.buscarTupla(3).getAltura().getValor());
		assertTrue(historial.buscarTupla(4).getAltura() instanceof EmptyMedicion);
	}
}
