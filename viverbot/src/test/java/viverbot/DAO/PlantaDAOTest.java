package viverbot.DAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import viverbot.DTO.Especie;
import viverbot.DTO.Planta;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.Fecha;

public class PlantaDAOTest {
	private PlantaDAO plantaDAO;
	
	private void inicializar(){
		plantaDAO = new PlantaDAO();
	}
	
	@Test
	public void cargarPlantasTest() {
		inicializar();
		List<Planta> plantas = new ArrayList<Planta>();
		plantas.add(new Planta(0,55,new UbicacionDTO(0,0,0), new Fecha(15,06,2017)));
		int cantidadInicial = plantaDAO.obtenerPlantas().size();
		plantaDAO.cargarPlantas(plantas);
		int cantidadFinal = plantaDAO.obtenerPlantas().size();
		assertFalse(cantidadInicial<cantidadFinal);
	}
	
	@Test
	public void obtenerPlantaTest() {
		inicializar();
		List<Planta> plantas = new ArrayList<Planta>();
		Planta planta = new Planta(0,55,new UbicacionDTO(0,0,0), new Fecha(15,06,2017));
		plantas.add(planta);
		plantaDAO.cargarPlantas(plantas);
		Planta plantaObtenida = plantaDAO.obtenerPlanta(planta.getCodigoPlanta());
		assertEquals(planta, plantaObtenida);
	} 
	
	@Test
	public void obtenerPlantaQueNoExisteTest() {
		inicializar();
		Planta plantaObtenida = plantaDAO.obtenerPlanta(999);
		assertEquals(plantaObtenida,null);
	} 
	
	@Test
	public void obtenerPlantasDeEspecieTest() {
		inicializar();
		EspecieDAO especieDAO = EspecieDAO.getInstance();
		Especie especie = new Especie(555, "Aloe Vera", "AloeVeraaaa","recursos/Arbol.jpg");
		especieDAO.agregar(especie);
		List<Planta> plantas = new ArrayList<Planta>();
		Planta planta1 = new Planta(555,55,new UbicacionDTO(0,0,0), new Fecha(15,06,2017));
		Planta planta2 = new Planta(555,56,new UbicacionDTO(0,1,1), new Fecha(15,06,2017));
		Planta planta3 = new Planta(555,57,new UbicacionDTO(0,2,2), new Fecha(15,06,2017));
		plantas.add(planta1);
		plantas.add(planta2);
		plantas.add(planta3);
		plantaDAO.cargarPlantas(plantas);
		List<Planta> plantasObtenidas = plantaDAO.obtenerPlantas(especie.getCodEspecie());
		assertTrue(plantasObtenidas.contains(planta1));
		assertTrue(plantasObtenidas.contains(planta2));
		assertTrue(plantasObtenidas.contains(planta3));
		assertEquals(plantasObtenidas.size(),3);
	} 
	
	@Test
	public void obtenerUltimoCodigoTest() {
		inicializar();
		Planta planta1 = new Planta(555,55,new UbicacionDTO(0,0,0), new Fecha(15,06,2017));
		plantaDAO.agregarPlanta(planta1);
		assertEquals(planta1.getCodigoPlanta(), plantaDAO.obtenerUltimoCodigo());
	} 
	
	@Test
	public void borrarPlantaTest() {
		inicializar();
		Planta planta1 = new Planta(555,55,new UbicacionDTO(0,0,0), new Fecha(15,06,2017));
		plantaDAO.agregarPlanta(planta1);
		plantaDAO.borrarPlanta(planta1.getCodigoPlanta());
		assertEquals(plantaDAO.obtenerPlanta(planta1.getCodigoPlanta()),null);
	} 
	
	@Test
	public void obtenerPlantaEspecificaTest() {
		inicializar();
		Planta planta1 = new Planta(555,55,new UbicacionDTO(0,0,0), new Fecha(15,06,2017));
		plantaDAO.agregarPlanta(planta1);
		assertEquals(plantaDAO.obtenerPlantaEspecifica(planta1.getCodigoPlanta()),planta1);
	} 
	
	@Test
	public void obtenerCantidadPlantasTest() {
		inicializar();
		Planta planta1 = new Planta(555,55,new UbicacionDTO(0,0,0), new Fecha(15,06,2017));
		plantaDAO.agregarPlanta(planta1);
		int cantPlantas = plantaDAO.obtenerPlantas().size();
		assertEquals(plantaDAO.cantidadPlantas(),cantPlantas);
	} 

}
