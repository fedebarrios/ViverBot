package viverbot.Model.Medicion;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.EstadoAlturaPerfecta;
import viverbot.DTO.Especie;
import viverbot.DTO.Planta;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.ManagerSeguimientos;
import viverbot.Model.Fecha;
import viverbot.Model.GuardadorAltura;
import viverbot.Model.HistorialOptimo;
import viverbot.Model.RegistroHistorial;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AnalizadorAltura;
import viverbot.Modelo.Medicion.MapperAltura;

public class MapperAlturaTest {
	MapperAltura mapper;
	AnalizadorAltura analizador;
	ManagerSeguimientos control;
	List<Planta> plantas;
	
	@Test
	public void MapearAlturas() throws Exception{
		inicializar();
		ArrayList<Medicion> alturas = new ArrayList<Medicion>();
		alturas.add(new Medicion(24.0, Magnitud.ALTURA));
		List<EstadoAltura> estadosDevueltos = mapper.relacionar(alturas);
		assertEquals(1, estadosDevueltos.size());
	}
	
//	@Test
//	public void EstadoPerfectoDevuelto(){
//		inicializar();
//		ArrayList<Medicion> alturas = new ArrayList<Medicion>();
//		alturas.add(new Medicion(240.0, Magnitudes.ALTURA));
//		List<EstadoAltura> estadosDevueltos = mapper.relacionar(alturas);
//		assertTrue(estadosDevueltos.get(0) instanceof EstadoAlturaPerfecta);
//	}
	
	public void inicializar() throws Exception{
		plantas = new ArrayList<Planta>();
		analizador = new AnalizadorAltura(GuardadorAltura.getInstance());
		control = ManagerSeguimientos.getInstance();
		mapper = new MapperAltura(analizador, plantas, control);
		
		Especie especie1 = new Especie(60 , "tomates" , "tomatus" , "");
		Planta planta1 = new Planta(60, 22, new UbicacionDTO(5,4,19), new Fecha(5, 5, 2017));
		plantas.add(planta1);
		
		ArrayList <RegistroHistorial> tuplas1 = new ArrayList<RegistroHistorial>();
		tuplas1.add(new RegistroHistorial(new Medicion(30.0, Magnitud.ALTURA), 5));
		Map<Integer,Medicion> mapa = new HashMap<Integer,Medicion>();
		HistorialOptimo historialOptimo1 = new HistorialOptimo(mapa, especie1);
		control.agregarSeguimiento(planta1, historialOptimo1);
	}
}
