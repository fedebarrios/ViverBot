package viverbot.Controlador.Verificacion;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import viverbot.Archivos.CargadorArchivos;
import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.EstadoAlturaNoComparada;
import viverbot.Controlador.Verificacion.InformadorAltura;
import viverbot.Controlador.Verificacion.Comparador;
import viverbot.Controlador.Verificacion.StrategyMetroDown;
import viverbot.Controlador.Verificacion.StrategySeguimientoNull;
import viverbot.DTO.Planta;
import viverbot.DTO.UbicacionDTO;
import viverbot.Interfaces.AnalisisAltura;
import viverbot.Model.Fecha;
import viverbot.Model.GuardadorAltura;
import viverbot.Modelo.Magnitudes.EmptyMedicion;
import viverbot.Modelo.Magnitudes.Magnitud;
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
		Comparador estrategia = new Comparador(); 
		Planta planta = new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017)); 
		EstadoAltura estadoDevuelto = estrategia.comparar(new Medicion(10.0,Magnitud.ALTURA), new Medicion(20.0,Magnitud.ALTURA), planta);
		assertTrue(estadoDevuelto instanceof EstadoAltura);
		assertEquals(estadoDevuelto.getEstado(), "Defectuoso");
	}
	
	@Test
	public void EstadoNormal() throws Exception{
		inicialize("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains(""));
		Comparador estrategia = new Comparador();
		Planta planta = new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = estrategia.comparar(new Medicion(19.0,Magnitud.ALTURA), new Medicion(20.0,Magnitud.ALTURA), planta);
		assertTrue(estadoDevuelto instanceof EstadoAltura);
		assertEquals(estadoDevuelto.getEstado(), "Normal");
	}
	
	@Test
	public void EstadoAnormal() throws Exception{
		inicialize("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains(""));
		Comparador estrategia = new Comparador();
		Planta planta = new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = estrategia.comparar(new Medicion(16.0,Magnitud.ALTURA), new Medicion(20.0,Magnitud.ALTURA), planta);
		assertTrue(estadoDevuelto instanceof EstadoAltura);
		assertEquals(estadoDevuelto.getEstado(), "Anormal");
	}
	
	@Test
	public void EstadoPerfecto() throws Exception{
		inicialize("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains(""));
		Comparador estrategia = new Comparador();
		Planta planta = new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = estrategia.comparar(new Medicion(50.0,Magnitud.ALTURA), new Medicion(20.0,Magnitud.ALTURA), planta);
		assertTrue(estadoDevuelto instanceof EstadoAltura);
		assertEquals(estadoDevuelto.getEstado(), "Perfecto");
	}
	
	private void inicialize(String archivo) throws Exception{
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		plugin = new CargadorArchivos();
		plugin.cargarEstados(archivo);
	}
	
}
