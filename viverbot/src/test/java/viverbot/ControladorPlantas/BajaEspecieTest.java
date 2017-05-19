package viverbot.ControladorPlantas;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import org.junit.Test;

import viverbot.MockOptionPane;
import viverbot.Controlador.Especies.AltaEspecie_Controller;
import viverbot.Controlador.Especies.ConsultaBajaEspecie_Controller;
import viverbot.DAO.EspecieDAO;
import viverbot.DAO.PlantaDAO;
import viverbot.DTO.Especie;
import viverbot.DTO.Planta;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.Fecha;
import viverbot.Model.Plantas;


public class BajaEspecieTest {
	
	private ConsultaBajaEspecie_Controller controladorEspecies;
	
	public void inicializar(){
		controladorEspecies = new ConsultaBajaEspecie_Controller();
		ArrayList<Especie> especies = new ArrayList<Especie>();
		Especie e1 = new Especie(1, "Marga","Margus","");
		Especie e2 = new Especie(2, "Cebolla","Cebollus","");
		especies.add(e1);
		especies.add(e2);
		EspecieDAO.getInstance().cargarEspecies(especies);
		ArrayList<Planta> plantasTest = new ArrayList<Planta>();
		Planta p1= new Planta(1, 10, new UbicacionDTO(1,5,0), new Fecha(04, 05, 2017));
		plantasTest.add(p1);
		PlantaDAO.getInstance().cargarPlantas(plantasTest);		
	}
	
	@Test
	public void TestBajaValida(){
		inicializar();
		
		assertFalse(controladorEspecies.sePuedeBorrar("Marga"));
		assertTrue(controladorEspecies.sePuedeBorrar("Cebolla"));
		
	} 
	
	@Test
	public void TestActionPerformedCancelar(){
		inicializar();
		controladorEspecies.actionPerformed(new ActionEvent(controladorEspecies.getVista().getBtnCancelar(),1,""));
		assertFalse(controladorEspecies.getVista().isVisible());
	} 
	
	@Test
	public void TestActionPerformedVerDetalle(){
		inicializar();
		controladorEspecies.actionPerformed(new ActionEvent(controladorEspecies.getVista().getBtnVerDetalle(),1,""));
		assertTrue(controladorEspecies.getControladorVerDetalle().getVistaVerDetalle().isVisible());
	}  
	
	@Test
	public void TestActionPerformedBorrar(){
		inicializar();
		ArrayList<Especie> especies = new ArrayList<Especie>();
		Especie e1 = new Especie(155, "Marga","Margus","");
		especies.add(e1);
		EspecieDAO.getInstance().cargarEspecies(especies);
		controladorEspecies.llenarCombo(controladorEspecies.getVista().getComboBox());
		int cantidadInicial = EspecieDAO.getInstance().leer().size();
		controladorEspecies.getVista().getComboBox().setSelectedItem(e1.getNombre());
		controladorEspecies.actionPerformed(new ActionEvent(controladorEspecies.getVista().getBtnBorrar(),1,""));
		int cantidadFinal = EspecieDAO.getInstance().leer().size();
		assertEquals(cantidadInicial -1, cantidadFinal); 
	}  
	
	@Test
	public void TestActionPerformedNoSePuedeBorrar(){
		inicializar();
		ArrayList<Especie> especies = new ArrayList<Especie>();
		Especie e1 = new Especie(155, "Marga","Margus","");
		especies.add(e1);
		EspecieDAO.getInstance().cargarEspecies(especies);
		ArrayList<Planta> plantasTest = new ArrayList<Planta>();
		Planta p1= new Planta(155, 10, new UbicacionDTO(1,5,0), new Fecha(04, 05, 2017));
		plantasTest.add(p1);
		PlantaDAO.getInstance().cargarPlantas(plantasTest);		
		controladorEspecies.setOptionPane(new MockOptionPane());
		controladorEspecies.llenarCombo(controladorEspecies.getVista().getComboBox());
		int cantidadInicial = EspecieDAO.getInstance().leer().size();
		controladorEspecies.getVista().getComboBox().setSelectedItem(e1.getNombre());
		controladorEspecies.actionPerformed(new ActionEvent(controladorEspecies.getVista().getBtnBorrar(),1,""));
		int cantidadFinal = EspecieDAO.getInstance().leer().size();
		assertEquals(cantidadInicial, cantidadFinal); 
	}  
	

}
