package viverbot.Model.Medicion;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.EstadoAlturaPerfecta;
import viverbot.DTO.Especie;
import viverbot.DTO.Planta;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.ControlSeguimientos;
import viverbot.Model.Fecha;
import viverbot.Model.GuardadorAltura;
import viverbot.Model.HistorialOptimo;
import viverbot.Model.TuplaAltura;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AnalizadorAltura;
import viverbot.Modelo.Medicion.MapperAltura;

public class MapperAlturaTest {
	MapperAltura mapper;
	AnalizadorAltura analizador;
	ControlSeguimientos control;
	List<Planta> plantas;
	
	@Test
	public void MapearAlturas() throws Exception{
		inicializar();
		ArrayList<Medicion> alturas = new ArrayList<Medicion>();
		alturas.add(new Medicion(24.0, Magnitudes.ALTURA));
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
		control = ControlSeguimientos.getInstance();
		mapper = new MapperAltura(analizador, plantas, control);
		
		Especie especie1 = new Especie(60 , "tomates" , "tomatus" , "");
		Planta planta1 = new Planta(60, 22, new UbicacionDTO(5,4,19), new Fecha(5, 5, 2017));
		plantas.add(planta1);
		
		ArrayList <TuplaAltura> tuplas1 = new ArrayList<TuplaAltura>();
		tuplas1.add(new TuplaAltura(new Medicion(30.0, Magnitudes.ALTURA), 5));
		HistorialOptimo historialOptimo1 = new HistorialOptimo(tuplas1 , especie1);
		control.agregarSeguimiento(planta1, historialOptimo1);
	}
}
