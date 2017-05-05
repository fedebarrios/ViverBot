package viverbot.Controller.Verificacion;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import viverbot.Controlador.Verificacion.PlanificadorAltura;
import viverbot.DAO.EspecieDAO;
import viverbot.DAO.PlantaDAO;
import viverbot.DTO.EspecieDTO;
import viverbot.DTO.PlantaDTO;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.ControlSeguimientos;
import viverbot.Model.Fecha;
import viverbot.Model.GuardadorAltura;
import viverbot.Model.HistorialOptimo;
import viverbot.Model.Plantas;
import viverbot.Model.TuplaAltura;
import viverbot.Modelo.Magnitudes.Altura;
import viverbot.Modelo.Medicion.AnalizadorAltura;
import viverbot.Modelo.Medicion.MapperAltura;
import viverbot.Modelo.Medicion.TransmisorAltura;

public class TransmisorAlturaTest {
	ArrayList<Altura> alturas;
	PlanificadorAltura planificador;
	AnalizadorAltura analizador ;
	MapperAltura mapper ;
	TransmisorAltura trasnmisorTest;
	ControlSeguimientos c ;
	PlantaDTO p1;
	EspecieDTO e1;
	EspecieDTO e2;

	@Test
	public void transmisorTest() {
		this.inicialize();
		assertNotNull(this.trasnmisorTest.getMapper());
		this.clear();
	}

	@Test
	public void transmitirTest() {
		this.inicialize();
		this.trasnmisorTest.Transmitir(alturas);
		assertTrue(c.seguimientos.size() == 1);
		assertTrue(alturas.size() == this.trasnmisorTest.getMapper().cantidadPlantas());
		
		ArrayList<TuplaAltura> tuplas2 = new ArrayList<TuplaAltura>();
		tuplas2.add(new TuplaAltura(new Altura(25,"cm"),1));
		tuplas2.add(new TuplaAltura(new Altura(58,"cm"),2));
		tuplas2.add(new TuplaAltura(new Altura(64,"cm"),3));
		tuplas2.add(new TuplaAltura(new Altura(69,"cm"),4));
		HistorialOptimo ho1 = new HistorialOptimo(tuplas2 , e2);
		c.agregarSeguimiento(p1, ho1);
		assertTrue(c.seguimientos.size() == 1);
		this.clear();
		
		/*Me haces que capte que imprimio
		La planta 10 creció demasiado para lo que se esperaba.
		Tiene 205.0 cm de diferencia con lo optimo*/
	}

	private void inicialize() {
		Altura a1 =  new Altura(230,"cm");
		alturas = new ArrayList<Altura>();
		alturas.add(a1);
		
		ArrayList<EspecieDTO> especies = new ArrayList<EspecieDTO>();
		e1 = new EspecieDTO(1, "Marga","Margus","");
		e2 = new EspecieDTO(2, "Cebolla","Cebollus","");
		especies.add(e1);
		especies.add(e2);
		EspecieDAO.getInstance().cargarEspecies(especies);
		
		ArrayList<PlantaDTO> plantasTest = new ArrayList<PlantaDTO>();
		p1= new PlantaDTO(1, 10, new UbicacionDTO(1,5), new Fecha(04, 05, 2017));
		plantasTest.add(p1);
		
		Plantas p = new Plantas();
		PlantaDAO.getInstance().cargarPlantas(plantasTest);
		
		c = ControlSeguimientos.getInstance();
		ArrayList<TuplaAltura> tuplas = new ArrayList<TuplaAltura>();
		tuplas.add(new TuplaAltura(new Altura(25,"cm"),1));
		tuplas.add(new TuplaAltura(new Altura(58,"cm"),2));
		tuplas.add(new TuplaAltura(new Altura(64,"cm"),3));
		tuplas.add(new TuplaAltura(new Altura(69,"cm"),4));
		HistorialOptimo ho1 = new HistorialOptimo(tuplas , e1);
		c.agregarSeguimiento(p1, ho1);
		
		planificador = PlanificadorAltura.getInstance();
		analizador = new AnalizadorAltura(planificador, GuardadorAltura.getInstance());
		mapper = new MapperAltura(analizador, p.obtenerPlantas() , c);
		this.trasnmisorTest = new TransmisorAltura(mapper);
	}

	private void clear() {
		this.trasnmisorTest = null;
	}
}