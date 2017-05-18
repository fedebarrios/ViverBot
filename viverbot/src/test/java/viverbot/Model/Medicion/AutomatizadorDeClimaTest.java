package viverbot.Model.Medicion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

import viverbot.Model.EstadoVivero;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.AutomatizadorDeClima;
import viverbot.Modelo.Medicion.Calor;
import viverbot.Modelo.Medicion.Frio;
import viverbot.Modelo.Medicion.Potencia_0;
import viverbot.Modelo.Medicion.Potencia_1;
import viverbot.Modelo.Medicion.Potencia_2;
import viverbot.Modelo.Medicion.Potencia_3;

public class AutomatizadorDeClimaTest {
	private AutomatizadorDeClima automatizador;
	private AireAcondicionado aire;
	private EstadoVivero estado;

	@Test
	public void definirEstadosTest_frio() throws Exception {
		init();
		estado.setTemperaturaColector(new Medicion(30.0, Magnitudes.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirFrioCalor");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Frio().getClass(), aire.getEstado().getClass());
	}
	
	@Test
	public void definirEstadosTest_calor() throws Exception {
		init();
		estado.setTemperaturaColector(new Medicion(10.0, Magnitudes.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirFrioCalor");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Calor().getClass(), aire.getEstado().getClass());
	}
	
	@Test
	public void definirPotenciaTest_potencia0_arriba() throws Exception{
		init();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		estado.setTemperaturaColector(new Medicion(21.0, Magnitudes.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirPotencia");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Potencia_0().getClass(), aire.getPotencia().getClass());
	}
	
	@Test
	public void definirPotenciaTest_potencia0_abajo() throws Exception{
		init();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		estado.setTemperaturaColector(new Medicion(14.0, Magnitudes.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirPotencia");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Potencia_0().getClass(), aire.getPotencia().getClass());
	}
	
	@Test
	public void definirPotenciaTest_potencia1_arriba() throws Exception{
		init();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		estado.setTemperaturaColector(new Medicion(21.5, Magnitudes.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirPotencia");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Potencia_1().getClass(), aire.getPotencia().getClass());
	}
	
	@Test
	public void definirPotenciaTest_potencia1_abajo() throws Exception{
		init();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		estado.setTemperaturaColector(new Medicion(13.5, Magnitudes.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirPotencia");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Potencia_1().getClass(), aire.getPotencia().getClass());
	}
	
	@Test
	public void definirPotenciaTest_potencia2_arriba() throws Exception{
		init();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		estado.setTemperaturaColector(new Medicion(22.7, Magnitudes.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirPotencia");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Potencia_2().getClass(), aire.getPotencia().getClass());
	}
	
	@Test
	public void definirPotenciaTest_potencia2_abajo() throws Exception{
		init();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		estado.setTemperaturaColector(new Medicion(12.3, Magnitudes.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirPotencia");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Potencia_2().getClass(), aire.getPotencia().getClass());
	}
	
	@Test
	public void definirPotenciaTest_potencia3_arriba() throws Exception{
		init();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		estado.setTemperaturaColector(new Medicion(25.0, Magnitudes.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirPotencia");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Potencia_3().getClass(), aire.getPotencia().getClass());
	}
	
	@Test
	public void definirPotenciaTest_potencia3_abajo() throws Exception{
		init();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		estado.setTemperaturaColector(new Medicion(10.0, Magnitudes.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirPotencia");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Potencia_3().getClass(), aire.getPotencia().getClass());
	}
	
	@Test
	public void encenderTest(){
		init();
		automatizador.encender();
	}
	
	@Test
	public void apagarTest(){
		init();
		automatizador.apagar();
	}

	public void init() {
		automatizador = new AutomatizadorDeClima();
		aire = automatizador.getAire();
		estado = automatizador.getEstadoVivero();
	}

}
