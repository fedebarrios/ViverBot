package viverbot.Archivos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import viverbot.DTO.EspecieDTO;
import viverbot.Model.ControlHistoriales;
import viverbot.Model.HistorialOptimo;
import viverbot.Model.Inventario;
import viverbot.Model.TuplaAltura;

public class MapperCargadorTest {
	MapperCargador mapper;
	
	public void inicialize(ControlHistoriales c, Inventario i){
		mapper = new MapperCargador(c , i);
	}
	
	@Test
	public void mappear(){
		Inventario inventario = new Inventario();
		inventario.agregarEspecie("tomate", "tomatus", "");
		ControlHistoriales control = ControlHistoriales.getInstance();
		HistorialOptimo historial = new HistorialOptimo(new ArrayList<TuplaAltura>(), inventario.obtenerEspecie(1));
		control.agregarSeguimiento(historial);
		
		inicialize(control, inventario);
		
		List<HistorialOptimo> historiales = new ArrayList<HistorialOptimo>();
		EspecieDTO especie1= new EspecieDTO(5,"manzana", "manzanus", "");
		EspecieDTO especie2= new EspecieDTO(6,"tomate", "tomatus", "");
		HistorialOptimo historial1 = new HistorialOptimo(new ArrayList<TuplaAltura>(), especie1);
		HistorialOptimo historial2 = new HistorialOptimo(new ArrayList<TuplaAltura>(), especie2);
		historiales.add(historial1);
		historiales.add(historial2);
		assertEquals(1 , mapper.cargar(historiales));
	}

}
