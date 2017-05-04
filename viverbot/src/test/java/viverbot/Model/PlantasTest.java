package viverbot.Model;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.DAO.PlantaDAO;
import viverbot.DTO.PlantaDTO;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.Fecha;
import viverbot.Model.Plantas;

public class PlantasTest {

	private static Plantas plantas;

	@Test
	public void testAgregarPlantas() {
		inicializar();
		// La cantidad de plantas iniciales son:
		Integer cantidadPlantas = plantas.obtenerPlantas().size();
		assertTrue(cantidadPlantas == 6);

		// Agregaremos una nueva planta
		plantas.agregarPlanta(1, "34,543", new Fecha(10, 10, 1994));
		cantidadPlantas = plantas.obtenerPlantas().size();

		// Ahora la cantidad de plantas se incremento
		assertTrue(cantidadPlantas == 7);
	}
	@Test
	public void testEliminarPlanta() {
		inicializar();
		// La cantidad de plantas iniciales son:
		Integer cantidadPlantas = plantas.obtenerPlantas().size();
		assertTrue(cantidadPlantas == 6);

		// Agregaremos una nueva planta
		plantas.agregarPlanta(1, "34,543", new Fecha(10, 10, 2017));
		
		PlantaDTO plantaPorCrear = new PlantaDTO(1, plantas.obtenerUltimoCodigoPlanta(),new UbicacionDTO(34,543), 
																					new Fecha(10, 10, 2017));
		cantidadPlantas = plantas.obtenerPlantas().size();
		// Ahora la cantidad de plantas se incremento
		assertTrue(cantidadPlantas == 7);
		
		plantas.eliminarPlanta(plantaPorCrear.getCodigoPlanta());
		// Corroboramos que la planta se borro exitosamente
		assertFalse(plantas.obtenerPlantas().contains(plantaPorCrear));
	}
	
	@Test
	public void testObtenerUltimoCodigoPlanta() {
		inicializar();
		// La cantidad de plantas iniciales son:
		Integer cantidadPlantas = plantas.obtenerPlantas().size();
		assertTrue(cantidadPlantas == 6);

		// Agregaremos una nueva planta
		plantas.agregarPlanta(1, "34,543", new Fecha(10, 10, 2017));
		
		PlantaDTO plantaPorCrear = new PlantaDTO(1, plantas.obtenerUltimoCodigoPlanta(),new UbicacionDTO(34,543), 
																					new Fecha(10, 10, 2017));
		cantidadPlantas = plantas.obtenerPlantas().size();
		// Ahora la cantidad de plantas se incremento
		assertTrue(cantidadPlantas == 7);
		int codPlanta = plantas.obtenerUltimoCodigoPlanta();
		PlantaDTO plantaEnPersistencia = plantas.obtenerPlanta(codPlanta);
		// Corroboramos que la planta en cuestion es la misma que se agregó al final
		assertTrue(plantaEnPersistencia.equals(plantaPorCrear));
	}
	
	@Test
	public void testObtenerUbicacion() {
		inicializar();
		
		String ubicacion = "77,88";
		UbicacionDTO ubicacionDTO = new UbicacionDTO(77, 88);
		assertTrue(plantas.obtenerUbicacion(ubicacion).equals(ubicacionDTO));
	}

	private void inicializar() {
		plantas = new Plantas();
		PlantaDAO.plantaDAO = null;
	}
}