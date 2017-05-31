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
		String datos = "Especie:(tomate,tomatus)";
		Especie especie = ParserEspecie.parsearEspecie(datos);
		assertEquals("tomate",especie.getNombre());
		assertEquals("tomatus",especie.getNombreCientifico());
	}
	
	@Test
	public void ParserMalFormato(){
		String datos = "Esp:(tomate,tomatus)";
		Especie especie = ParserEspecie.parsearEspecie(datos);
		assertNull(especie);
	}
	
	@Test
	public void ParserSinInfo(){
		String datos = "";
		Especie especie = ParserEspecie.parsearEspecie(datos);
		assertNull(especie);
	}
	
	@Test
	public void ParserInfoExcesiva() throws Exception{
		String datos = "Especie:(tomate,tomatus,tomatina)";
		Especie especie = ParserEspecie.parsearEspecie(datos);
		assertNull(especie);	
	}
	
	@Test
	public void ParserListaTuplaAlturaExitosa() throws Exception{
		String datos = "Dia:(4:6.51cm)";
		TuplaAltura tupla = ParserHistorial.parsearTuplaAltura(datos);
		assertEquals(4,tupla.getDiaDeVida());
		assertEquals( 6.51 , tupla.getAltura().getValor() , 0);
	}
	
	@Test
	public void ParserListaTuplaAlturaFallida() throws Exception{
		String datos = "D(-4:-6.51cm)";
		TuplaAltura tupla = ParserHistorial.parsearTuplaAltura(datos);
		assertNull(tupla);
	}
	
	@Test
	public void MediatorTest() throws Exception{
		ParserDataArchivos mediator = new ParserDataArchivos();
		String datos = "src/test/java/viverbot/Archivos/Historial.txt" ;
		HistorialOptimo historial = mediator.parsearHistorialEspecie(datos);
		assertEquals("zanahoria",historial.getEspecie().getNombre());
		assertEquals("zanahorius",historial.getEspecie().getNombreCientifico());
		assertEquals(2.4 , historial.buscarTupla(1).getAltura().getValor(), 0);
		assertEquals(2.50 , historial.buscarTupla(3).getAltura().getValor(), 0);
		assertTrue(historial.buscarTupla(5).getAltura() instanceof EmptyMedicion);
	}
}
