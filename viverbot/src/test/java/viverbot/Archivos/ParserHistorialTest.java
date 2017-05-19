package viverbot.Archivos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import viverbot.DTO.Especie;
import viverbot.Model.HistorialOptimo;
import viverbot.Model.TuplaAltura;
import viverbot.Modelo.Magnitudes.EmptyMedicion;

public class ParserHistorialTest {
	
	@Test
	public void ParserEspecie() throws Exception{
		ParserEspecie parser = new ParserEspecie();
		String datos = "Especie:(tomate,tomatus)";
		Especie especie = parser.parsear(datos);
		assertEquals("tomate",especie.getNombre());
		assertEquals("tomatus",especie.getNombreCientifico());
	}
	
	@SuppressWarnings("unused")
	@Test (expected = Exception.class)
	public void ParserMalFormato() throws Exception{
		ParserEspecie parser = new ParserEspecie();
		String datos = "Esp:(tomate,tomatus)";
		Especie especie = parser.parsear(datos);
	}
	
	@SuppressWarnings("unused")
	@Test (expected = Exception.class)
	public void ParserSinInfo() throws Exception{
		ParserEspecie parser = new ParserEspecie();
		String datos = "";
		Especie especie = parser.parsear(datos);
	}
	
	@SuppressWarnings("unused")
	@Test (expected = Exception.class)
	public void ParserInfoExcesiva() throws Exception{
		ParserEspecie parser = new ParserEspecie();
		String datos = "Especie:(tomate,tomatus,tomatina)";
		Especie especie = parser.parsear(datos);
	}
	
	@Test
	public void ParserListaTuplaAlturaExitosa() throws Exception{
		ParserHistorial parser = new ParserHistorial();
		String datos = "Dia:(4:6.51cm)";
		List<TuplaAltura> tuplas = parser.parsear(datos);
		assertEquals(4,tuplas.get(0).getDiaDeVida());
		assertEquals( 6.51 , tuplas.get(0).getAltura().getValor() , 0);
	}
	
	@SuppressWarnings("unused")
	@Test (expected = Exception.class)
	public void ParserListaTuplaAlturaFallida() throws Exception{
		ParserHistorial parser = new ParserHistorial();
		String datos = "D(-4:-6.51cm)";
		List<TuplaAltura> tuplas = parser.parsear(datos);
	}
	
	@Test
	public void MediatorTest() throws Exception{
		ParserDataArchivos mediator = new ParserDataArchivos();
		String datos = "Dia:(4:6.51cm)" +"Comentario"+ "Dia:(6:8.41cm)" + "InfoSinImportancia" +"Especie:(cebolla,cebollus)" ;
		HistorialOptimo historial = mediator.parsearHistorialEspecie(datos);
		assertEquals("cebolla",historial.getEspecie().getNombre());
		assertEquals("cebollus",historial.getEspecie().getNombreCientifico());
		assertEquals(6.51 , historial.buscarTupla(4).getAltura().getValor(), 0);
		assertEquals(8.41 , historial.buscarTupla(6).getAltura().getValor(), 0);
		assertTrue(historial.buscarTupla(2).getAltura() instanceof EmptyMedicion);
	}
}
