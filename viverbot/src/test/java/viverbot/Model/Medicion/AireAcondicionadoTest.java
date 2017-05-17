package viverbot.Model.Medicion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DecimalFormat;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.Calor;
import viverbot.Modelo.Medicion.Frio;
import viverbot.Modelo.Medicion.Potencia_1;
import viverbot.Modelo.Medicion.TemperaturaAireAcondicionado;

public class AireAcondicionadoTest {
	private AireAcondicionado aire;

	@Test
	public void getSetTest() {
		init();
		assertNotNull(aire.getEstado());
		assertNotNull(aire.getPotencia());
		assertNotNull(aire.getTemp());
		assertEquals(new Potencia_1().getClass(), aire.getPotencia().getClass());
		assertEquals(new Calor().getClass(), aire.getEstado().getClass());
		assertEquals(new TemperaturaAireAcondicionado().getClass(), aire.getTemp().getClass());
	}
	
	@Test
	public void ejecutarTest() throws NumberFormatException{
		init();
		Medicion aux = aire.ejecutar();
		Medicion expected = new Medicion(0.026, Magnitudes.TEMPERATURA);
		Double ret = (double) (Math.round(aux.getValor() * 1000d) / 1000d);
		assertNotNull(ret);
		assertEquals(expected.getValor(), ret);
	}
	
	@Test
	public void definirPositivoNegativoTest_calor() throws Exception {
		init();
		Double aux = 0.5;
		Double ret = Whitebox.invokeMethod(aire, "definirPositivoNegativo", 0.5);
		assertNotNull(ret);
		assertEquals(aux, ret);
	}
	
	@Test
	public void definirPositivoNegativoTest_frio() throws Exception {
		init();
		aire.setEstado(new Frio());
		Double aux = -0.5;
		Double ret = Whitebox.invokeMethod(aire, "definirPositivoNegativo", 0.5);
		assertNotNull(ret);
		assertEquals(aux, ret); 
	}
	
	public void init(){
		this.aire = new AireAcondicionado();
		aire.setEstado(new Calor());
		aire.setPotencia(new Potencia_1());
		aire.setTemperatura("22");
	}

}
