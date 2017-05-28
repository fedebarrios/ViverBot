package viverbot.Archivos;

import org.junit.Test;

import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import junit.framework.TestCase;
import viverbot.MockFileChooser;
import viverbot.MockOptionPane;
import viverbot.Controlador.ControladorConfiguracionDirectorio;
import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.SelectorEstadosPorValor;
import viverbot.DTO.Planta;
import viverbot.Model.BuscadorEstadoAltura;
import viverbot.Modelo.Medicion.MapperEstadoAltura;

public class BuscadorEstadoAlturaTest extends TestCase {
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	CargadorArchivos plugin;
	
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
		clear();
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
		Planta planta = new Planta(1, 1, null, null);
		EstadoAltura guardado = buscador.obtenerEstadoPorEspecie(60, 30, planta);
		assertEquals(guardado.getCmDeDiferencia(), 30.0);
		assertEquals(guardado.getPlanta().getCodigoPlanta(), 1);
		assertEquals(guardado.getEstado(), "Defectuoso");
		assertEquals(buscador.getMap().size(), 1);
		clear();
	}
	
	@Test
	public void testBuscadorLevantarEnBatch() throws Exception{
		ControladorConfiguracionDirectorio conf = new ControladorConfiguracionDirectorio();
		conf.getVista().setRdDirectorio3(true);
		MockFileChooser fileChooser = new MockFileChooser("src/test/java/viverbot/Archivos/EstadosAlturaFiles");
		conf.setFileChooser(fileChooser);
		conf.setOptionPane(new MockOptionPane());
		conf.actionPerformed(new ActionEvent(conf.getVista().getBtnCargarDirectorio(), 1, ""));
		CargadorArchivos plugin = new CargadorArchivos();
		BuscadorEstadoAltura buscador = BuscadorEstadoAltura.getInstance();
		plugin.cargarEstadosBatch(GatewayConfiguracion.getDirectorio(3));
		assertEquals(buscador.getMap().size(), 3);
		//assertTrue(buscador.getMap().get(1) instanceof SelectorEstadosPorValor);
		clear();
	}
	
	@Test
	public void testBuscadorEspecieNoCargada() throws Exception
	{
		System.setOut(new PrintStream(errContent));
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
		Planta planta = new Planta(16, 15, null, null);
		EstadoAltura guardado = buscador.obtenerEstadoPorEspecie(60, 30, planta);
		assertEquals(guardado, null);
		String msjLog = errContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains("No existe un selector para la especie dada."));
		clear();
	}

	public void clear(){
		BuscadorEstadoAltura.getInstance().cleanMap();
	}
}