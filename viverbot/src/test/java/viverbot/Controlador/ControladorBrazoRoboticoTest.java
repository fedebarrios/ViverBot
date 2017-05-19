package viverbot.Controlador;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.GeneradorTareas;
import viverbot.DAO.ColaTareas;
import viverbot.DAO.TerrenoDAO;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.ControladorBrazoRobotico;

public class ControladorBrazoRoboticoTest {
	
	private TerrenoDAO _terreno;
	private ColaTareas _cola;
	private ControladorBrazoRobotico _controlador;
	
	private void inicializar(){
		_terreno = TerrenoDAO.obtenerInstancia();
		_terreno.construirTerreno(4, 4);
		_cola = ColaTareas.getInstance();
		_cola.reiniciarContadorTareasResueltas();
		_controlador = new ControladorBrazoRobotico(_cola);
	}
	
	private UbicacionDTO crearUbicacionAleatoria(){
		UbicacionDTO ubicacion = new UbicacionDTO(1,1,5);
		ubicacion.setEjeX(1.5);
		ubicacion.setEjeY(1.5);
		return ubicacion;
	}
	
	@Test
	public void moverBrazoTest() {
		inicializar();
		UbicacionDTO ubicacionOrigen = crearUbicacionAleatoria();
		_controlador.moverBrazo(ubicacionOrigen);
		
		UbicacionDTO ubicacionFinal = _controlador.mostrarUbicacionActualDelBrazo();
		assertEquals(ubicacionOrigen,ubicacionFinal);
	}
	
	@Test
	public void mostrarUbicacionActualBrazoTest() {
		inicializar();
		UbicacionDTO ubicacionDescanso = _terreno.mostrarUbicacionDescanso();
		UbicacionDTO ubicacionActual = _controlador.mostrarUbicacionActualDelBrazo();
		assertEquals(ubicacionDescanso,ubicacionActual);
	}
	
	@Test
	public void volverBrazoAUbicacionDescanso() {
		inicializar();
		UbicacionDTO ubicacionDescanso = _terreno.mostrarUbicacionDescanso();
		
		GeneradorTareas generador = new GeneradorTareas();
		generador.generarTareas();
		
		UbicacionDTO ubicacionActual = _controlador.mostrarUbicacionActualDelBrazo();
		assertEquals(ubicacionDescanso,ubicacionActual);
	}

}
