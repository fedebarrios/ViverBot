package viverbot.Archivos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import viverbot.DTO.Especie;
import viverbot.Model.ControlHistoriales;
import viverbot.Model.HistorialOptimo;
import viverbot.Model.Inventario;
import viverbot.Model.RegistroHistorial;
import viverbot.Modelo.Magnitudes.Medicion;

public class MapperCargadorTest {
	private MapperCargador mapper;
	private Inventario inventario;
	private ControlHistoriales control;
	
	public void setearInfoNecesaria() throws Exception{
		clear();
		inventario = new Inventario();
		inventario.agregarEspecie("tomate", "tomatus", "");
		control = ControlHistoriales.getInstance();
		Map<Integer,Medicion> mapa = new HashMap<Integer,Medicion>();
		HistorialOptimo historial = new HistorialOptimo( mapa ,inventario.obtenerEspecie(1));
		control.agregarSeguimiento(historial);
		mapper = new MapperCargador(control , inventario);
	}
	
	@Test
	public void mapearHistorialesCreados() throws Exception{
		setearInfoNecesaria();
		
		List<HistorialOptimo> historiales = new ArrayList<HistorialOptimo>();
		Especie especie1= new Especie(5,"manzana", "manzanus", "");
		Especie especie2= new Especie(6,"tomate", "tomatus", "");
		Map<Integer,Medicion> mapa = new HashMap<Integer,Medicion>();
		HistorialOptimo historial1 = new HistorialOptimo(mapa, especie1);
		HistorialOptimo historial2 = new HistorialOptimo(mapa, especie2);
		historiales.add(historial1);
		historiales.add(historial2);
		int cantEspeciesAntes = inventario.cantidadEspecies();
		int cantHistorialesAntes = control.cantidadHistoriales();
		mapper.update(null , historiales);
		
		//solo se pudo cargar el historial de la manzana, ya existia el del tomate.
		assertEquals(cantEspeciesAntes+1 , inventario.cantidadEspecies());
		assertEquals(cantHistorialesAntes+1 , control.cantidadHistoriales());
		clear();
	}
	
	
	@Test
	public void mapearEspecieRepetida() throws Exception{	
		setearInfoNecesaria();
		
		List<HistorialOptimo> historiales = new ArrayList<HistorialOptimo>();
		Especie especie1= new Especie(6,"tomate", "tomatus", "");
		Map<Integer,Medicion> mapa = new HashMap<Integer,Medicion>();
		HistorialOptimo historial1 = new HistorialOptimo(mapa , especie1);
		historiales.add(historial1);
		int cantEspeciesAntes = inventario.cantidadEspecies();
		mapper.update(null , historiales);
		assertEquals(cantEspeciesAntes , inventario.cantidadEspecies());
		
		clear();
	}

	private void clear() {
		mapper = null;
		inventario = null;
		control = null;
	}

}
