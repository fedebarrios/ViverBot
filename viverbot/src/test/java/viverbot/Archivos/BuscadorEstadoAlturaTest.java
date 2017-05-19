package viverbot.Archivos;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import junit.framework.TestCase;
import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.SelectorEstadosPorValor;
import viverbot.DTO.PlantaDTO;
import viverbot.Model.BuscadorEstadoAltura;
import viverbot.Modelo.Medicion.MapperEstadoAltura;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class BuscadorEstadoAlturaTest extends TestCase {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	PluginArchivos plugin;
	
	@Test
	public void testBuscadorEfectivamenteCargado() throws Exception
	{
		LectorTxt lector = new LectorTxt();
		String lectura = lector.leerTxt("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		ParserDataArchivos parser = new ParserDataArchivos();
		ArrayList<EstadoAltura> estados = parser.parsearEstados(lectura);
		ArrayList<Double> valores = parser.parsearValores(lectura);
		Integer codigoEspecie = parser.parsearCodigoEspecie(lectura);
		SelectorEstadosPorValor selector = new SelectorEstadosPorValor(estados, valores);
		BuscadorEstadoAltura buscador = BuscadorEstadoAltura.getInstance();
		MapperEstadoAltura mapper = new MapperEstadoAltura();
		mapper.relacionar(buscador, selector, codigoEspecie);
		assertEquals(buscador.getMap().size(), 1);
	}
	
	@Test
	public void testBuscadorDevolviendoUnEstadoAlturaPorPlanta() throws Exception
	{
		LectorTxt lector = new LectorTxt();
		String lectura = lector.leerTxt("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		ParserDataArchivos parser = new ParserDataArchivos();
		ArrayList<EstadoAltura> estados = parser.parsearEstados(lectura);
		ArrayList<Double> valores = parser.parsearValores(lectura);
		Integer codigoEspecie = parser.parsearCodigoEspecie(lectura);
		SelectorEstadosPorValor selector = new SelectorEstadosPorValor(estados, valores);
		BuscadorEstadoAltura buscador = BuscadorEstadoAltura.getInstance();
		MapperEstadoAltura mapper = new MapperEstadoAltura();
		mapper.relacionar(buscador, selector, codigoEspecie);
		PlantaDTO planta = new PlantaDTO(1, 1, null, null);
		EstadoAltura guardado = buscador.obtenerEstadoPorEspecie(60, 30, planta);
		assertEquals(guardado.getCmDeDiferencia(), 30.0);
		assertEquals(guardado.getPlanta().getCodigoPlanta(), 1);
		assertEquals(guardado.getEstado(), "Defectuoso");
		assertEquals(buscador.getMap().size(), 1);
	}

}
