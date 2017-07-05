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
import viverbot.Controlador.Verificacion.EstadosDeAlturaDisponibles;
import viverbot.DTO.Planta;
import viverbot.Model.BuscadorEstadoAltura;
import viverbot.Modelo.Medicion.MapperEstadoAltura;

public class BuscadorEstadoAlturaTest extends TestCase {
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	CargadorArchivos plugin;
	
	@Test
	public void testBuscadorEfectivamenteCargado() throws Exception
	{
		LectorArchivo lector = new LectorArchivo();
		String lectura = lector.leerArchivo("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		ParserDataArchivos parser = new ParserDataArchivos();
		ArrayList<EstadoAltura> estados = parser.parsearEstados(lectura);
		ArrayList<Double> valores = parser.parsearValores(lectura);
		String codigoEspecie = parser.parsearCodigoEspecie(lectura);
		EstadosDeAlturaDisponibles selector = new EstadosDeAlturaDisponibles(estados, valores);
		BuscadorEstadoAltura buscador = BuscadorEstadoAltura.getInstance();
		MapperEstadoAltura mapper = new MapperEstadoAltura();
		mapper.relacionar(buscador, selector, codigoEspecie);
		assertEquals(buscador.getMap().size(), 1);
		assertTrue(buscador.existeEspecie(codigoEspecie)); //Verifico que la especie cargada esta en el map
		clear();
	}
	
	@Test
	public void testBuscadorDevolviendoUnEstadoAlturaPorPlanta() throws Exception
	{
		LectorArchivo lector = new LectorArchivo();
		String lectura = lector.leerArchivo("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		ParserDataArchivos parser = new ParserDataArchivos();
		ArrayList<EstadoAltura> estados = parser.parsearEstados(lectura);
		ArrayList<Double> valores = parser.parsearValores(lectura);
		String codigoEspecie = parser.parsearCodigoEspecie(lectura);
		EstadosDeAlturaDisponibles selector = new EstadosDeAlturaDisponibles(estados, valores);
		BuscadorEstadoAltura buscador = BuscadorEstadoAltura.getInstance();
		MapperEstadoAltura mapper = new MapperEstadoAltura();
		mapper.relacionar(buscador, selector, codigoEspecie);
		Planta planta = new Planta(codigoEspecie, 4, null, null);
		EstadoAltura guardado = buscador.obtenerEstadoPorEspecie(60, 30, planta);
		assertEquals(guardado.getCmDeDiferencia(), 30.0);
		assertEquals(guardado.getPlanta().getCodigoPlanta(), 4);
		assertEquals(guardado.getEstado(), "Defectuoso");
		assertEquals(buscador.getMap().size(), 1);
		clear();
	}
	
	@Test
	public void testBuscadorLevantarEnBatch() throws Exception{
		ControladorConfiguracionDirectorio conf = new ControladorConfiguracionDirectorio();
		MockFileChooser fileChooser = new MockFileChooser("src/test/java/viverbot/Archivos/EstadosAlturaFiles");
		conf.setFileChooser(fileChooser);
		conf.setOptionPane(new MockOptionPane());
		conf.actionPerformed(new ActionEvent(conf.getVista().getBtnCargarDirectorio(), 1, ""));
		CargadorArchivos plugin = new CargadorArchivos();
		BuscadorEstadoAltura buscador = BuscadorEstadoAltura.getInstance();
		plugin.cargarEstadosBatch(GatewayConfiguracion.getDirectorio(3));
		assertEquals(buscador.getMap().size(), 3);
		clear();
	}
	
	@Test
	public void testBuscadorEspecieNoCargada() throws Exception
	{
		System.setOut(new PrintStream(errContent));
		LectorArchivo lector = new LectorArchivo();
		String lectura = lector.leerArchivo("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		ParserDataArchivos parser = new ParserDataArchivos();
		ArrayList<EstadoAltura> estados = parser.parsearEstados(lectura);
		ArrayList<Double> valores = parser.parsearValores(lectura);
		String codigoEspecie = parser.parsearCodigoEspecie(lectura);
		EstadosDeAlturaDisponibles selector = new EstadosDeAlturaDisponibles(estados, valores);
		BuscadorEstadoAltura buscador = BuscadorEstadoAltura.getInstance();
		MapperEstadoAltura mapper = new MapperEstadoAltura();
		mapper.relacionar(buscador, selector, codigoEspecie);
		Planta planta = new Planta("Pepino", 15, null, null); //Cargue Tomate, y me fijo que Pepino no exista
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
