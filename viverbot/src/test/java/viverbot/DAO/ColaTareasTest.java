package viverbot.DAO;

import static org.junit.Assert.*;
import org.junit.Test;
import viverbot.GeneradorTareas;
import viverbot.DTO.TareaMedirHumedad;
import viverbot.DTO.UbicacionDTO;

public class ColaTareasTest {
	private TerrenoDAO _terreno;
	private ColaTareas _cola;
	
	private void inicializar(){
		_terreno = TerrenoDAO.obtenerInstancia();
		_terreno.construirTerreno(4, 4);
		_cola = ColaTareas.getInstance();
		_cola.reiniciarContadorTareasResueltas();
	}
	
	private UbicacionDTO crearUbicacionAleatoria(){
		UbicacionDTO ubicacion = new UbicacionDTO(1,1,5);
		ubicacion.setEjeX(1.5);
		ubicacion.setEjeY(1.5);
		return ubicacion;
	}
	
	@Test
	public void testAgregarTarea() {
		inicializar();
		UbicacionDTO ubicacion = crearUbicacionAleatoria();
		int cantTareasIniciales = _cola.mostrarCantidadDeTareasResueltas();
		assertTrue(cantTareasIniciales==0);
		_cola.agregarTarea(new TareaMedirHumedad(ubicacion));
		int cantTareasFinales = _cola.mostrarCantidadDeTareasResueltas();
		assertTrue(cantTareasIniciales<cantTareasFinales);
	}
	
	@Test
	public void testEstresAgregarTareas() {
		inicializar();
		int cantTareasResueltasIniciales = _cola.mostrarCantidadDeTareasResueltas();
		GeneradorTareas generador = new GeneradorTareas();
		generador.generarTareas();
		int cantTareasResueltasFinales = _cola.mostrarCantidadDeTareasResueltas();
		assertEquals(cantTareasResueltasFinales, 48);
		assertTrue(cantTareasResueltasIniciales<cantTareasResueltasFinales);
	}
	
	

}
