package viverbot.Archivos;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.containsString;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import viverbot.DTO.Especie;
import viverbot.Model.ControlHistoriales;
import viverbot.Model.HistorialOptimo;
import viverbot.Model.Inventario;
import viverbot.Model.TuplaAltura;

public class MapperCargadorTest {
	private MapperCargador mapper;
	private Inventario inventario;
	private ControlHistoriales control;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	public void inicialize(){
		clear();
		inventario = new Inventario();
		inventario.agregarEspecie("tomate", "tomatus", "");
		control = ControlHistoriales.getInstance();
		HistorialOptimo historial = new HistorialOptimo(new ArrayList<TuplaAltura>(), inventario.obtenerEspecie(1));
		control.agregarSeguimiento(historial);
		mapper = new MapperCargador(control , inventario);
	}
	
	@Test
	public void mapearHistorialesCreados(){
		inicialize();
		
		List<HistorialOptimo> historiales = new ArrayList<HistorialOptimo>();
		Especie especie1= new Especie(5,"manzana", "manzanus", "");
		Especie especie2= new Especie(6,"tomate", "tomatus", "");
		HistorialOptimo historial1 = new HistorialOptimo(new ArrayList<TuplaAltura>(), especie1);
		HistorialOptimo historial2 = new HistorialOptimo(new ArrayList<TuplaAltura>(), especie2);
		historiales.add(historial1);
		historiales.add(historial2);
		int cantEspeciesAntes = inventario.cantidadEspecies();
		int cantHistorialesAntes = control.cantidadHistoriales();
		mapper.update(null , historiales);
		assertEquals(cantEspeciesAntes+1 , inventario.cantidadEspecies());
		assertEquals(cantHistorialesAntes+1 , control.cantidadHistoriales());
		assertThat("Se cargaron 1 historiales" , containsString(outContent.toString()));
		clear();
	}
	
	@Test
	public void mapearHistorialesRepetidos(){
		
		
		inicialize();
		
		List<HistorialOptimo> historiales = new ArrayList<HistorialOptimo>();
		Especie especie1= new Especie(6,"tomate", "tomatus", "");
		HistorialOptimo historial1 = new HistorialOptimo(new ArrayList<TuplaAltura>(), especie1);
		historiales.add(historial1);
		int cantEspeciesAntes = inventario.cantidadEspecies();
		int cantHistorialesAntes = control.cantidadHistoriales();
		mapper.update(null , historiales);
		assertEquals(cantEspeciesAntes , inventario.cantidadEspecies());
		assertEquals(cantHistorialesAntes , control.cantidadHistoriales());
		assertThat("Se cargaron 0 historiales" , containsString(outContent.toString()));
		
		clear();
	}
	
	@Test
	public void mapearEspecieRepetida(){	
		inicialize();
		
		List<HistorialOptimo> historiales = new ArrayList<HistorialOptimo>();
		Especie especie1= new Especie(6,"tomate", "tomatus", "");
		HistorialOptimo historial1 = new HistorialOptimo(new ArrayList<TuplaAltura>(), especie1);
		historiales.add(historial1);
		int cantEspeciesAntes = inventario.cantidadEspecies();
		mapper.update(null , historiales);
		assertEquals(cantEspeciesAntes , inventario.cantidadEspecies());
		assertThat("Se cargaron 0 historiales" , containsString(outContent.toString()));
		
		clear();
	}

	private void clear() {
		mapper = null;
		inventario = null;
		control = null;
	}

}
