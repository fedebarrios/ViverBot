package viverbot.Controlador;

import org.junit.Test;

import junit.framework.TestCase;
import viverbot.Controlador.Especies.VerDetallesEspecie_Controller;
import viverbot.DAO.PlantaDAO;
import viverbot.DTO.Especie;
import viverbot.Model.Plantas;


public class VerDetallesEspecieTest extends TestCase {
	private static Especie especie = null;
	private static VerDetallesEspecie_Controller controlador = null;
	private static Plantas planta = null;
	
	@Test
	public void testInstancia() {
		inicialize();
		assertNotNull(controlador);
		this.clear();

	}
	
	@Test
	public void testCantidadPlantas()
	{
		inicialize();
		especie = new Especie(2,"especie1","prueba","rosa.jpg");
		Integer cantidad = controlador.getPlantas().obtenerPlantas(especie.getCodEspecie()).size();
		assertFalse(cantidad==6);
		clear();
	}
	
	@Test
	//Falla al buscar imagen de especie
	public void testSolicitarSinPlantas()
	{
		//
	}
	
	private void inicialize() {
		planta = new Plantas();
		especie = new Especie(1,"especie1","prueba","rosa.jpg");
		controlador = new VerDetallesEspecie_Controller(especie);
	}

	private void clear() {
		controlador = null;
		especie = null;
	}

}
