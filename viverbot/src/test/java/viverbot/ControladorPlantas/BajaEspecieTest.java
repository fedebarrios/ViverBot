package viverbot.ControladorPlantas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import viverbot.Controlador.Especies.AltaEspecie_Controller;
import viverbot.Controlador.Especies.ConsultaBajaEspecie_Controller;
import viverbot.DAO.EspecieDAO;
import viverbot.DAO.PlantaDAO;
import viverbot.DTO.EspecieDTO;
import viverbot.DTO.PlantaDTO;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.Fecha;
import viverbot.Model.Plantas;


public class BajaEspecieTest {
	
	private ConsultaBajaEspecie_Controller controladorEspecies;
	
	@Test
	public void TestBajaValida(){
		controladorEspecies = new ConsultaBajaEspecie_Controller();
		ArrayList<EspecieDTO> especies = new ArrayList<EspecieDTO>();
		EspecieDTO e1 = new EspecieDTO(1, "Marga","Margus","");
		EspecieDTO e2 = new EspecieDTO(2, "Cebolla","Cebollus","");
		especies.add(e1);
		especies.add(e2);
		EspecieDAO.getInstance().cargarEspecies(especies);
		ArrayList<PlantaDTO> plantasTest = new ArrayList<PlantaDTO>();
		PlantaDTO p1= new PlantaDTO(1, 10, new UbicacionDTO(1,5), new Fecha(04, 05, 2017));
		plantasTest.add(p1);
		
		Plantas p = new Plantas();
		PlantaDAO.getInstance().cargarPlantas(plantasTest);
		
		assertFalse(controladorEspecies.sePuedeBorrar("Marga"));
		assertTrue(controladorEspecies.sePuedeBorrar("Cebolla"));
		
	}
	

}
