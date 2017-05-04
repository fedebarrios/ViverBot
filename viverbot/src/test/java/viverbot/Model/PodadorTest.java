package viverbot.Model;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.DTO.PlantaDTO;
import viverbot.Model.Fecha;
import viverbot.Model.Plantas;
import viverbot.Model.Podador;

public class PodadorTest {
	
	@Test
	public void PodadorTest(){
		Podador podador = Podador.getInstance();
		assertNotNull(podador);
		
		PlantaDTO plantaInexistente = new PlantaDTO(60, 50, null,  new Fecha(14,1,2014));
		PlantaDTO plantaExistente = new Plantas().obtenerPlanta(0);
		assertFalse(podador.podar(plantaInexistente));
		assertTrue(podador.podar(plantaExistente));
	}
	
}
