package viverbot.DAO;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.DTO.UbicacionDTO;
import viverbot.Model.Ubicacion;

public class TerrenoDAOTest {
	
	private TerrenoDAO terreno;
	
	public void inicializar(){
		terreno = TerrenoDAO.getInstance();
	}
	
	@Test
	public void construirTerrenoTest() {
		inicializar();
		terreno.construirTerreno(3, 3);
		UbicacionDTO[][] ubicaciones = terreno.mostrarTerreno();
		for (int i = 0; i < ubicaciones.length; i++) {
			for (int j = 0; j < ubicaciones[i].length; j++) {
				assertFalse(ubicaciones[i][j]==null);
			}
		}
	}
	
	@Test
	public void ocuparUbicacionTest() {
		inicializar();
		terreno.construirTerreno(3, 3);
		terreno.ocuparUbicacion(new UbicacionDTO(0,0));
		assertTrue(terreno.mostrarTerreno()[0][0].isEstado());
	}
	
	@Test
	public void ocuparUbicacionYaOcupadaTest() {
		inicializar();
		terreno.construirTerreno(3, 3);
		terreno.ocuparUbicacion(new UbicacionDTO(0,0));
		assertFalse(terreno.ocuparUbicacion(new UbicacionDTO(0,0)));
		assertTrue(terreno.mostrarTerreno()[0][0].isEstado());
	}
	
	@Test
	public void desocuparUbicacionTest() {
		inicializar();
		terreno.construirTerreno(3, 3);
		terreno.ocuparUbicacion(new UbicacionDTO(0,0));
		terreno.desocuparUbicacion(new UbicacionDTO(0,0));
		assertFalse(terreno.mostrarTerreno()[0][0].isEstado());
	}
	
	@Test
	public void desocuparUbicacionYaDesocupadaTest() {
		inicializar();
		terreno.construirTerreno(3, 3);
		terreno.ocuparUbicacion(new UbicacionDTO(0,0));
		terreno.desocuparUbicacion(new UbicacionDTO(0,0));
		assertFalse(terreno.desocuparUbicacion(new UbicacionDTO(0,0)));
	}

}
