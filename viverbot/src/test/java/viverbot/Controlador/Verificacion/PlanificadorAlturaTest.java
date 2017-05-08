package viverbot.Controlador.Verificacion;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import viverbot.Controlador.Verificacion.EstadoAlturaAnormal;
import viverbot.Controlador.Verificacion.EstadoAlturaDefectuosa;
import viverbot.Controlador.Verificacion.EstadoAlturaNormal;
import viverbot.Controlador.Verificacion.EstadoAlturaPerfecta;
import viverbot.Controlador.Verificacion.PlanificadorAltura;
import viverbot.DAO.EspecieDAO;
import viverbot.DAO.PlantaDAO;
import viverbot.DTO.EspecieDTO;
import viverbot.DTO.PlantaDTO;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.Fecha;

public class PlanificadorAlturaTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	PlanificadorAltura planificador;
	PlantaDTO p1;
	PlantaDTO p2;
	PlantaDTO p3;
	PlantaDTO p4;
	EstadoAlturaPerfecta esp;
	EstadoAlturaNormal esn;
	EstadoAlturaAnormal esa;
	EstadoAlturaDefectuosa esd;
	EspecieDTO e1;
	EspecieDTO e2;
	SimuladorEscritura si;
	SimuladorEscritura no;
	InputStream inStream;

	@Test
	public void estadoAlturaPerfectaTest() {
		this.inicialize();
		planificador.actuar(esp);
		assertThat(outContent.toString(), containsString("La planta 10 creció demasiado para lo que se esperaba."));
		assertThat(outContent.toString(), containsString("Tiene 200.0 cm de diferencia con lo optimo"));
		this.clear();
	}
	
	@Test
	public void estadoAlturaNormalTest() {
		this.inicialize();
		planificador.actuar(esn);
		assertThat(outContent.toString(), containsString("La planta 11 esta creciendo normalmente entre los valores esperados"));
		this.clear();
	}
	
	@Test
	public void estadoAlturaAnormalTest() {
		this.inicialize();
		planificador.actuar(esa);
		assertThat(outContent.toString(), containsString("esta creciendo menos de lo esperado. Tomar accion lo antes posible."));
		this.clear();
	}

	@Test
	public void estadoAlturaDefectuosaTest() {
		this.inicialize();
		si.escribir();
		planificador.actuar(esd);
		assertThat(outContent.toString(), containsString("La planta 13 tiene un problema de crecimiento."));
		assertThat(outContent.toString(), containsString("Ingrese Si, si desea podar la planta"));
		this.clear();
	}
	
//	@Test
//	public void siPodarTest() {
//		this.inicialize();
//		si.escribir();
//		planificador.actuar(esd);
//		assertThat(outContent.toString(), containsString("Ingrese Si, si desea podar la planta."));
//		assertThat(outContent.toString(), containsString("La planta 13 se ha podado."));
//		this.clear();
//	}
//	
//	@Test
//	public void noPodarTest() {
//		this.inicialize();
//		no.escribir();
//		planificador.actuar(esd);
//		assertThat(outContent.toString(), containsString("Ingrese Si, si desea podar la planta."));
//		assertThat(outContent.toString(), containsString("La planta no se podo."));
//		this.clear();
//	}
	
	@Test
	public void verificarPodadorNoNulo() {
		this.inicialize();
		planificador.actuar(esp);
		assertNotNull(planificador.getSoporte());
		this.clear();
	}

	private void inicialize() {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		ArrayList<EspecieDTO> especies = new ArrayList<EspecieDTO>();
		e1 = new EspecieDTO(1, "Marga","Margus","");
		e2 = new EspecieDTO(2, "Cebolla","Cebollus","");
		especies.add(e1);
		especies.add(e2);
		EspecieDAO.getInstance().cargarEspecies(especies);
		
		ArrayList<PlantaDTO> plantasTest = new ArrayList<PlantaDTO>();
		p1 = new PlantaDTO(1, 10, new UbicacionDTO(1,5), new Fecha(04, 05, 2017));
		p2 = new PlantaDTO(1, 11, new UbicacionDTO(1,6), new Fecha(04, 05, 2017));
		p3 = new PlantaDTO(2, 12, new UbicacionDTO(1,7), new Fecha(04, 05, 2017));
		p4 = new PlantaDTO(2, 13, new UbicacionDTO(1,8), new Fecha(04, 05, 2017));
		
		esp = new EstadoAlturaPerfecta(200.0, p1);
		esn = new EstadoAlturaNormal(150.0, p2);
		esa = new EstadoAlturaAnormal(30.0, p3);
		esd = new EstadoAlturaDefectuosa(-50.0, p4);
		
		plantasTest.add(p1);
		plantasTest.add(p2);
		plantasTest.add(p3);
		plantasTest.add(p4);
		PlantaDAO.getInstance().cargarPlantas(plantasTest);
		
		planificador = PlanificadorAltura.getInstance();
		si = new SimuladorEscritura("Si");
		no = new SimuladorEscritura("no");
		inStream = System.in;
	}

	private void clear() {
		System.setIn(inStream);
	}
}