package viverbot.Controlador.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Archivos.CargadorArchivos;
import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.DTO.Planta;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.Fecha;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AnalizadorAltura;

public class AnalizadorAlturaTest {
	CargadorArchivos plugin;
	
	@Test
	public void EstadoDefectuoso() throws Exception{
		levantarEstados("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		AnalizadorAltura analizador = new AnalizadorAltura();
		Planta planta = new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017)); 
		EstadoAltura estadoDevuelto = analizador.analizar(new Medicion(10.0,Magnitud.ALTURA), new Medicion(20.0,Magnitud.ALTURA), planta);
		assertTrue(estadoDevuelto instanceof EstadoAltura);
		assertEquals(estadoDevuelto.getEstado(), "Defectuoso");
	}
	
	@Test
	public void EstadoNormal() throws Exception{
		levantarEstados("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		AnalizadorAltura analizador = new AnalizadorAltura();
		Planta planta = new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = analizador.analizar(new Medicion(19.0,Magnitud.ALTURA), new Medicion(20.0,Magnitud.ALTURA), planta);
		assertTrue(estadoDevuelto instanceof EstadoAltura);
		assertEquals(estadoDevuelto.getEstado(), "Normal");
	}
	
	@Test
	public void EstadoAnormal() throws Exception{
		levantarEstados("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		AnalizadorAltura analizador = new AnalizadorAltura();
		Planta planta = new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = analizador.analizar(new Medicion(16.0,Magnitud.ALTURA), new Medicion(20.0,Magnitud.ALTURA), planta);
		assertTrue(estadoDevuelto instanceof EstadoAltura);
		assertEquals(estadoDevuelto.getEstado(), "Anormal");
	}
	
	@Test
	public void EstadoPerfecto() throws Exception{
		levantarEstados("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		AnalizadorAltura analizador = new AnalizadorAltura();
		Planta planta = new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = analizador.analizar(new Medicion(50.0,Magnitud.ALTURA), new Medicion(20.0,Magnitud.ALTURA), planta);
		assertTrue(estadoDevuelto instanceof EstadoAltura);
		assertEquals(estadoDevuelto.getEstado(), "Perfecto");
	}
	
	private void levantarEstados(String archivo) throws Exception{
		plugin = new CargadorArchivos();
		plugin.cargarEstados(archivo);
	}
	
}
