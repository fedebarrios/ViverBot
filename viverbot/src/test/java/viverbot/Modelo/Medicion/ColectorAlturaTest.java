package viverbot.Modelo.Medicion;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import viverbot.DTO.Planta;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.Fecha;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.ColectorAltura;


public class ColectorAlturaTest {
	ColectorAltura colector = null;

	@Test
	public void testColectorTemperatura() {
		this.inicialize();
		assertNotNull(this.colector.getMediator());
		assertNotNull(this.colector.getTimer());
		assertNull(this.colector.getValorActual());
		this.clear();
	}

	@Test
	public void testColectar() throws InterruptedException {
		this.inicialize();
		this.colector.colectar();
		this.esperar(2000);
		assertNotNull(this.colector.getValorActual());

		this.clear();
	}
	
	@Test
	public void pedirAlturas(){
		inicialize();
		List<Planta> plantas = new ArrayList<Planta>();
		plantas.add(new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017)));
		plantas.add(new Planta(2, 11, new UbicacionDTO(1,5,1), new Fecha(04, 05, 2017)));
		List<Medicion> mediciones = colector.medir(plantas);
		assertEquals(2 , mediciones.size());
		assertEquals(Magnitudes.ALTURA , mediciones.get(0).getTipo());
	
	}

	private void inicialize() {
		this.colector = new ColectorAltura();
	}
	
	private void esperar(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo);

	}

	private void clear() {
		this.colector.detenerColeccion();
		this.colector = null;
	}
}
