package viverbot.DAO;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.DTO.Planta;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.Fecha;

public class PlantaTest {

	@Test
	public void testEquals(){
		Planta planta1 = new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017));
		assertFalse(planta1.equals(null));
		assertFalse(planta1.equals(new Planta(4, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017))));
		assertFalse(planta1.equals(new Planta(1, 10, new UbicacionDTO(1,5,4), null)));
		assertFalse(planta1.equals(new Fecha(14,15,2009)));
		assertTrue(planta1.equals(planta1));
		assertFalse(planta1.equals(new Planta(1, 14, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017))));
		assertFalse(planta1.equals(new Planta(1, 10, new UbicacionDTO(1,4,4), new Fecha(04, 05, 2017))));
		assertTrue(planta1.equals(new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017))));
		
		Planta planta2 = new Planta(1, 10, new UbicacionDTO(1,5,4), null);
		assertFalse(planta2.equals(new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017))));
		
		Planta planta3 = new Planta(1, 10, null,new Fecha(04, 05, 2017));
		assertFalse(planta3.equals(new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017))));
	}
	
	@Test
	public void testGetters(){
		Planta planta1 = new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017));
		assertEquals(1,planta1.getCodigo().intValue());
		assertEquals(10,planta1.getCodigoPlanta());
		assertEquals(1, planta1.getUbicacion().getFila().intValue());
		assertEquals(05, planta1.getFechaPlanta().getMes());
	}
}
