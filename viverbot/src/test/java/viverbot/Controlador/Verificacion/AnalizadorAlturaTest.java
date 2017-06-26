package viverbot.Controlador.Verificacion;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import viverbot.Archivos.CargadorArchivos;
import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.EstadoAlturaNoComparada;
import viverbot.Controlador.Verificacion.InformadorAltura;
import viverbot.Controlador.Verificacion.StrategyAnalisisAltura;
import viverbot.Controlador.Verificacion.StrategyMetroDown;
import viverbot.Controlador.Verificacion.StrategySeguimientoNull;
import viverbot.DTO.Planta;
import viverbot.DTO.UbicacionDTO;
import viverbot.Interfaces.AnalisisAltura;
import viverbot.Model.Fecha;
import viverbot.Model.GuardadorAltura;
import viverbot.Modelo.Magnitudes.EmptyMedicion;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AnalizadorAltura;

public class AnalizadorAlturaTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	CargadorArchivos plugin;
	
	@Test
	public void EstadoDefectuoso() throws Exception{
		inicialize("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains(""));
		StrategyAnalisisAltura estrategia = new StrategyAnalisisAltura();
		Planta planta = new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017)); 
		EstadoAltura estadoDevuelto = estrategia.analizar(new Medicion(10.0,Magnitudes.ALTURA), new Medicion(20.0,Magnitudes.ALTURA), planta);
		assertTrue(estadoDevuelto instanceof EstadoAltura);
		assertEquals(estadoDevuelto.getEstado(), "Defectuoso");
	}
	
	@Test
	public void EstadoNormal() throws Exception{
		inicialize("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains(""));
		StrategyAnalisisAltura estrategia = new StrategyAnalisisAltura();
		Planta planta = new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = estrategia.analizar(new Medicion(19.0,Magnitudes.ALTURA), new Medicion(20.0,Magnitudes.ALTURA), planta);
		assertTrue(estadoDevuelto instanceof EstadoAltura);
		assertEquals(estadoDevuelto.getEstado(), "Normal");
	}
	
	@Test
	public void EstadoAnormal() throws Exception{
		inicialize("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains(""));
		StrategyAnalisisAltura estrategia = new StrategyAnalisisAltura();
		Planta planta = new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = estrategia.analizar(new Medicion(16.0,Magnitudes.ALTURA), new Medicion(20.0,Magnitudes.ALTURA), planta);
		assertTrue(estadoDevuelto instanceof EstadoAltura);
		assertEquals(estadoDevuelto.getEstado(), "Anormal");
	}
	
	@Test
	public void EstadoPerfecto() throws Exception{
		inicialize("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains(""));
		StrategyAnalisisAltura estrategia = new StrategyAnalisisAltura();
		Planta planta = new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = estrategia.analizar(new Medicion(50.0,Magnitudes.ALTURA), new Medicion(20.0,Magnitudes.ALTURA), planta);
		assertTrue(estadoDevuelto instanceof EstadoAltura);
		assertEquals(estadoDevuelto.getEstado(), "Perfecto");
	}
	
	@Test
	public void EstrategiaMetroRoto(){
		InformadorAltura planificador = InformadorAltura.getInstance();
		AnalizadorAltura analizador = new AnalizadorAltura(GuardadorAltura.getInstance());
		AnalisisAltura estrategia = analizador.getStrategy(new Medicion(-10.0,Magnitudes.ALTURA), new Medicion(4.0,Magnitudes.ALTURA));
		assertTrue(estrategia instanceof StrategyMetroDown);
	}
	
	@Test
	public void EstadoNoComparada(){
		StrategyMetroDown estrategiaMetro = new StrategyMetroDown();
		Planta planta = new Planta(1, 10, new UbicacionDTO(1,5,9), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = estrategiaMetro.analizar(new Medicion(-5.0,Magnitudes.ALTURA), new Medicion(20.0,Magnitudes.ALTURA), planta);
		assertTrue(estadoDevuelto instanceof EstadoAlturaNoComparada);
	}
	
	@Test
	public void EstadoNoComparada2(){
		StrategySeguimientoNull estrategiaSeguimiento = new StrategySeguimientoNull();
		Planta planta = new Planta(1, 10, new UbicacionDTO(1,5,9), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = estrategiaSeguimiento.analizar(new Medicion(45.0,Magnitudes.ALTURA), new EmptyMedicion(), planta);
		assertTrue(estadoDevuelto instanceof EstadoAlturaNoComparada);
	}
	
	@Test
	public void EstrategiaNadaContraQueComparar(){
		InformadorAltura planificador = InformadorAltura.getInstance();
		AnalizadorAltura analizador = new AnalizadorAltura(GuardadorAltura.getInstance());
		AnalisisAltura estrategia = analizador.getStrategy(new Medicion(4.0,Magnitudes.ALTURA), new EmptyMedicion());
		assertTrue(estrategia instanceof StrategySeguimientoNull);
	}
	
	@Test
	public void EstrategiaSePuedeAnalizar(){
		InformadorAltura planificador = InformadorAltura.getInstance();
		AnalizadorAltura analizador = new AnalizadorAltura(GuardadorAltura.getInstance());
		AnalisisAltura estrategia = analizador.getStrategy(new Medicion(10.0,Magnitudes.ALTURA), new Medicion(4.0,Magnitudes.ALTURA));
		assertTrue(estrategia instanceof StrategyAnalisisAltura);
	}
	
	private void inicialize(String archivo) throws Exception{
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		plugin = new CargadorArchivos();
		plugin.cargarEstados(archivo);
	}
	
}
