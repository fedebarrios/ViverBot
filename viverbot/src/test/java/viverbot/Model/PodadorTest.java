package viverbot.Model;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.MockOptionPane;
import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.InformadorAltura;
import viverbot.DTO.Planta;
import viverbot.Model.Fecha;
import viverbot.Model.Plantas;
import viverbot.Model.Cosechador;

public class PodadorTest {
	
	@Test
	public void NoCosechar(){
		InformadorAltura i = InformadorAltura.getInstance();
		MockOptionPane op = new MockOptionPane();
		op.setOptionElegida(1);
		i.setOptionPane(op);
		EstadoAltura e = new EstadoAltura();
		e.setEstado("Defectuosa");
		Plantas p = new Plantas();
		int cantidadPlantasAntes = p.cantidadPlantas();
		e.setPlanta(p.obtenerPlanta(2));
		i.actuar(e);
		assertEquals(cantidadPlantasAntes, p.cantidadPlantas() );
	}
	
	@Test
	public void SiCosechar(){
		InformadorAltura i = InformadorAltura.getInstance();
		MockOptionPane op = new MockOptionPane();
		op.setOptionElegida(0);
		i.setOptionPane(op);
		EstadoAltura e = new EstadoAltura();
		e.setEstado("Defectuosa");
		Plantas p = new Plantas();
		int cantidadPlantasAntes = p.cantidadPlantas();
		e.setPlanta(p.obtenerPlanta(2));
		i.actuar(e);
		assertEquals(cantidadPlantasAntes-1, p.cantidadPlantas() );

	}
	
	@Test
	public void ProbarCosechador(){
		Cosechador podador = Cosechador.getInstance();
		assertNotNull(podador);
		
		Planta plantaInexistente = new Planta(60, 50, null,  new Fecha(14,1,2014));
		Planta plantaExistente = new Plantas().obtenerPlanta(0);
		assertFalse(podador.podar(plantaInexistente));
		assertTrue(podador.podar(plantaExistente));
	}	
}
