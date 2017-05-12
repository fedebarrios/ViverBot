package viverbot.Model.Medicion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.AutomatizadorDeClima;
import viverbot.Modelo.Medicion.Calor;
import viverbot.Modelo.Medicion.Frio;
import viverbot.Modelo.Medicion.Potencia_0;
import viverbot.Modelo.Medicion.Potencia_1;
import viverbot.Modelo.Medicion.Potencia_2;
import viverbot.Modelo.Medicion.Potencia_3;

public class AutomatizadorDeClimaTest {

	@Test
	public void verificarRango_recibeRangoValido_devuelveTrue() throws Exception {
		Temperatura tempValida = new Temperatura(18.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizadorDeClima automatizadorValido = new AutomatizadorDeClima(tempValida, rango);
		boolean type = Whitebox.invokeMethod(automatizadorValido, "verificarRango");
		assertTrue(type);
	}

	@Test
	public void verificarRango_recibeRangoInvalido_devuelveFalse() throws Exception {
		Temperatura tempInvalida = new Temperatura(25.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizadorDeClima automatizadorInvalido = new AutomatizadorDeClima(tempInvalida, rango);
		boolean type = Whitebox.invokeMethod(automatizadorInvalido, "verificarRango");
		assertFalse(type);
	}
	
	@Test
	public void definirEstados_recibeFrioPotencia0() throws Exception {
		Temperatura temp = new Temperatura(21.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizadorDeClima automatizacion = new AutomatizadorDeClima(temp, rango);
		Whitebox.invokeMethod(automatizacion, "definirEstados");
		AireAcondicionado aire = Whitebox.invokeMethod(automatizacion, "getAire");
		assertNotNull(aire);
		assertEquals(new Frio().getClass(), aire.getFrioCalorEstado().getClass());
		assertEquals(new Potencia_0().getClass(), aire.getPotenciaEstado().getClass());
	}
	
	@Test
	public void definirEstados_recibeFrioPotencia1() throws Exception {
		Temperatura temp = new Temperatura(22.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizadorDeClima automatizacion = new AutomatizadorDeClima(temp, rango);
		Whitebox.invokeMethod(automatizacion, "definirEstados");
		AireAcondicionado aire = Whitebox.invokeMethod(automatizacion, "getAire");
		assertNotNull(aire);
		assertEquals(new Frio().getClass(), aire.getFrioCalorEstado().getClass());
		assertEquals(new Potencia_1().getClass(), aire.getPotenciaEstado().getClass());
	}
	
	@Test
	public void definirEstados_recibeFrioPotencia2() throws Exception {
		Temperatura temp = new Temperatura(24.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizadorDeClima automatizacion = new AutomatizadorDeClima(temp, rango);
		Whitebox.invokeMethod(automatizacion, "definirEstados");
		AireAcondicionado aire = Whitebox.invokeMethod(automatizacion, "getAire");
		assertNotNull(aire);
		assertEquals(new Frio().getClass(), aire.getFrioCalorEstado().getClass());
		assertEquals(new Potencia_2().getClass(), aire.getPotenciaEstado().getClass());
	}
	
	@Test
	public void definirEstados_recibeFrioPotencia3() throws Exception {
		Temperatura temp = new Temperatura(25.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizadorDeClima automatizacion = new AutomatizadorDeClima(temp, rango);
		Whitebox.invokeMethod(automatizacion, "definirEstados");
		AireAcondicionado aire = Whitebox.invokeMethod(automatizacion, "getAire");
		assertNotNull(aire);
		assertEquals(new Frio().getClass(), aire.getFrioCalorEstado().getClass());
		assertEquals(new Potencia_3().getClass(), aire.getPotenciaEstado().getClass());
	}
	
	@Test
	public void definirEstados_recibeCalorPotencia0() throws Exception {
		Temperatura temp = new Temperatura(14.5);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizadorDeClima automatizacion = new AutomatizadorDeClima(temp, rango);
		Whitebox.invokeMethod(automatizacion, "definirEstados");
		AireAcondicionado aire = Whitebox.invokeMethod(automatizacion, "getAire");
		assertNotNull(aire);
		assertEquals(new Calor().getClass(), aire.getFrioCalorEstado().getClass());
		assertEquals(new Potencia_0().getClass(), aire.getPotenciaEstado().getClass());
	}
	
	@Test
	public void definirEstados_recibeCalorPotencia1() throws Exception {
		Temperatura temp = new Temperatura(13.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizadorDeClima automatizacion = new AutomatizadorDeClima(temp, rango);
		Whitebox.invokeMethod(automatizacion, "definirEstados");
		AireAcondicionado aire = Whitebox.invokeMethod(automatizacion, "getAire");
		assertNotNull(aire);
		assertEquals(new Calor().getClass(), aire.getFrioCalorEstado().getClass());
		assertEquals(new Potencia_1().getClass(), aire.getPotenciaEstado().getClass());
	}
	
	@Test
	public void definirEstados_recibeCalorPotencia2() throws Exception {
		Temperatura temp = new Temperatura(11.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizadorDeClima automatizacion = new AutomatizadorDeClima(temp, rango);
		Whitebox.invokeMethod(automatizacion, "definirEstados");
		AireAcondicionado aire = Whitebox.invokeMethod(automatizacion, "getAire");
		assertNotNull(aire);
		assertEquals(new Calor().getClass(), aire.getFrioCalorEstado().getClass());
		assertEquals(new Potencia_2().getClass(), aire.getPotenciaEstado().getClass());
	}
	
	@Test
	public void definirEstados_recibeCalorPotencia3() throws Exception {
		Temperatura temp = new Temperatura(10.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizadorDeClima automatizacion = new AutomatizadorDeClima(temp, rango);
		Whitebox.invokeMethod(automatizacion, "definirEstados");
		AireAcondicionado aire = Whitebox.invokeMethod(automatizacion, "getAire");
		assertNotNull(aire);
		assertEquals(new Calor().getClass(), aire.getFrioCalorEstado().getClass());
		assertEquals(new Potencia_3().getClass(), aire.getPotenciaEstado().getClass());
	}

}
