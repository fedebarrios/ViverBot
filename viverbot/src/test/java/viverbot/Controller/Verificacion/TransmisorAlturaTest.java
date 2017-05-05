package viverbot.Controller.Verificacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import viverbot.Controlador.Verificacion.PlanificadorAltura;
import viverbot.DTO.PlantaDTO;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.ControlSeguimientos;
import viverbot.Model.Fecha;
import viverbot.Model.GuardadorAltura;
import viverbot.Model.Plantas;
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

	@Test
	public void transmisorTest() throws Exception {
		this.inicialize();
		assertNotNull(this.trasnmisorTest.getMapper());
		this.clear();
	}

	@Test
	public void transmitirTest() throws Exception {
		this.inicialize();
		this.trasnmisorTest.Transmitir(alturas);
		assertTrue(alturas.size() == this.trasnmisorTest.getMapper().cantidadPlantas());
		this.clear();
	}

	private void inicialize() throws Exception {
		Altura a1 =  new Altura(230,"cm");
		Altura a2 =  new Altura(300,"cm");
		Altura a3=  new Altura(471,"cm");
		Altura a4=  new Altura(471,"cm");
		Altura a5=  new Altura(471,"cm");
		Altura a6=  new Altura(471,"cm");
		alturas = new ArrayList<Altura>();
		alturas.add(a1);
		alturas.add(a2);
		alturas.add(a3);
		alturas.add(a4);
		alturas.add(a5);
		alturas.add(a6);
		
		Plantas plantas = new Plantas();
		
		
		planificador = PlanificadorAltura.getInstance();
		analizador = new AnalizadorAltura(planificador, GuardadorAltura.getInstance());
		mapper = new MapperAltura(analizador, new Plantas().obtenerPlantas() , ControlSeguimientos.getInstance());
		this.trasnmisorTest = new TransmisorAltura(mapper);
		ControlSeguimientos.getInstance().cargarSeguimientosHardcodeados();
	}

	private void clear() {
		this.trasnmisorTest = null;
	}
}