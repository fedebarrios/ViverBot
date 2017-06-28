package viverbot.Model.Medicion;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.DTO.Especie;
import viverbot.DTO.Planta;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.ManagerSeguimientos;
import viverbot.Model.Fecha;
import viverbot.Model.HistorialOptimo;
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
	public void MapearAlturasSatisfactoriamente() throws Exception{
		inicializar();
		ArrayList<Medicion> alturas = new ArrayList<Medicion>();
		alturas.add(new Medicion(24.0, Magnitud.ALTURA));
		List<EstadoAltura> estadosDevueltos = mapper.relacionar(alturas);
		assertEquals(1, estadosDevueltos.size());
	}
	
	public void inicializar() throws Exception{
		plantas = new ArrayList<Planta>();
		analizador = new AnalizadorAltura();
		control = ManagerSeguimientos.getInstance();
		
		Especie especie1 = new Especie(60 , "tomates" , "tomatus" , "");
		Planta planta1 = new Planta(60, 22, new UbicacionDTO(5,4,19), new Fecha(22, 6, 2017));
		plantas.add(planta1);
		
		Map<Integer,Medicion> mapa = new HashMap<Integer,Medicion>();
		mapa.put(Fecha.diasEntreDosFechas(new Fecha(28, 6, 2017), new Fecha(22, 6, 2017)),new Medicion(30.0, Magnitud.ALTURA));

		HistorialOptimo historialOptimo1 = new HistorialOptimo(mapa, especie1);
		control.agregarSeguimiento(planta1, historialOptimo1);
		
		mapper = new MapperAltura(analizador, plantas, control);
	}
}