package viverbot.Model.Medicion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

import viverbot.Model.EstadoVivero;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitud;
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
		estado.setTemperaturaColector(new Medicion(30.0, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirFrioCalor");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Frio().getClass(), aire.getEstado().getClass());
		clear();
	}

	@Test
	public void definirEstadosTest_calor() throws Exception {
		init();
		estado.setTemperaturaColector(new Medicion(10.0, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirFrioCalor");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Calor().getClass(), aire.getEstado().getClass());
		clear();
	}

	@Test
	public void definirPotenciaTest_potencia0_arriba() throws Exception {
		init();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		estado.setTemperaturaColector(new Medicion(21.0, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirPotencia");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Potencia_0().getClass(), aire.getPotencia().getClass());
		clear();
	}

	@Test
	public void definirPotenciaTest_potencia0_abajo() throws Exception {
		init();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		estado.setTemperaturaColector(new Medicion(14.0, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirPotencia");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Potencia_0().getClass(), aire.getPotencia().getClass());
		clear();
	}

	@Test
	public void definirPotenciaTest_potencia1_arriba() throws Exception {
		init();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		estado.setTemperaturaColector(new Medicion(21.5, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirPotencia");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Potencia_1().getClass(), aire.getPotencia().getClass());
		clear();
	}

	@Test
	public void definirPotenciaTest_potencia1_abajo() throws Exception {
		init();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		estado.setTemperaturaColector(new Medicion(13.5, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirPotencia");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Potencia_1().getClass(), aire.getPotencia().getClass());
		clear();
	}

	@Test
	public void definirPotenciaTest_potencia2_arriba() throws Exception {
		init();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		estado.setTemperaturaColector(new Medicion(22.7, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirPotencia");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Potencia_2().getClass(), aire.getPotencia().getClass());
		clear();
	}

	@Test
	public void definirPotenciaTest_potencia2_abajo() throws Exception {
		init();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		estado.setTemperaturaColector(new Medicion(12.3, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirPotencia");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Potencia_2().getClass(), aire.getPotencia().getClass());
		clear();
	}

	@Test
	public void definirPotenciaTest_potencia3_arriba() throws Exception {
		init();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		estado.setTemperaturaColector(new Medicion(25.0, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirPotencia");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Potencia_3().getClass(), aire.getPotencia().getClass());
		clear();
	}

	@Test
	public void definirPotenciaTest_potencia3_abajo() throws Exception {
		init();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		estado.setTemperaturaColector(new Medicion(10.0, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirPotencia");
		assertNotNull(aire);
		assertNotNull(estado);
		assertEquals(new Potencia_3().getClass(), aire.getPotencia().getClass());
		clear();
	}

	@Test
	public void definirTemperaturaTest_calor_potencia0_22() throws Exception {
		init();
		aire.setEstado(new Calor());
		aire.setPotencia(new Potencia_0());
		estado.setTemperaturaColector(new Medicion(14.5, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("22", aire.getTemp().toString());
		clear();
	}

	@Test
	public void definirTemperaturaTest_calor_potencia0_23() throws Exception {
		init();
		aire.setEstado(new Calor());
		aire.setPotencia(new Potencia_0());
		estado.setTemperaturaColector(new Medicion(14.0, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("23", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void definirTemperaturaTest_calor_potencia1_24() throws Exception {
		init();
		aire.setEstado(new Calor());
		aire.setPotencia(new Potencia_1());
		estado.setTemperaturaColector(new Medicion(13.5, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("24", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void definirTemperaturaTest_calor_potencia1_25() throws Exception {
		init();
		aire.setEstado(new Calor());
		aire.setPotencia(new Potencia_1());
		estado.setTemperaturaColector(new Medicion(13.0, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("25", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void definirTemperaturaTest_calor_potencia2_26() throws Exception {
		init();
		aire.setEstado(new Calor());
		aire.setPotencia(new Potencia_2());
		estado.setTemperaturaColector(new Medicion(12.5, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("26", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void definirTemperaturaTest_calor_potencia2_27() throws Exception {
		init();
		aire.setEstado(new Calor());
		aire.setPotencia(new Potencia_2());
		estado.setTemperaturaColector(new Medicion(12.0, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("27", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void definirTemperaturaTest_calor_potencia3_28() throws Exception {
		init();
		aire.setEstado(new Calor());
		aire.setPotencia(new Potencia_3());
		estado.setTemperaturaColector(new Medicion(11.5, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("28", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void definirTemperaturaTest_calor_potencia3_29() throws Exception {
		init();
		aire.setEstado(new Calor());
		aire.setPotencia(new Potencia_3());
		estado.setTemperaturaColector(new Medicion(11.0, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("29", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void definirTemperaturaTest_frio_potencia0_24() throws Exception {
		init();
		aire.setEstado(new Frio());
		aire.setPotencia(new Potencia_0());
		estado.setTemperaturaColector(new Medicion(25.5, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("24", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void definirTemperaturaTest_frio_potencia0_23() throws Exception {
		init();
		aire.setEstado(new Frio());
		aire.setPotencia(new Potencia_0());
		estado.setTemperaturaColector(new Medicion(26.0, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("23", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void definirTemperaturaTest_frio_potencia1_22() throws Exception {
		init();
		aire.setEstado(new Frio());
		aire.setPotencia(new Potencia_1());
		estado.setTemperaturaColector(new Medicion(26.5, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("22", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void definirTemperaturaTest_frio_potencia1_21() throws Exception {
		init();
		aire.setEstado(new Frio());
		aire.setPotencia(new Potencia_1());
		estado.setTemperaturaColector(new Medicion(27.0, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("21", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void definirTemperaturaTest_frio_potencia2_20() throws Exception {
		init();
		aire.setEstado(new Frio());
		aire.setPotencia(new Potencia_2());
		estado.setTemperaturaColector(new Medicion(27.5, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("20", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void definirTemperaturaTest_frio_potencia2_19() throws Exception {
		init();
		aire.setEstado(new Frio());
		aire.setPotencia(new Potencia_2());
		estado.setTemperaturaColector(new Medicion(28.0, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("19", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void definirTemperaturaTest_frio_potencia3_18() throws Exception {
		init();
		aire.setEstado(new Frio());
		aire.setPotencia(new Potencia_3());
		estado.setTemperaturaColector(new Medicion(28.5, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("18", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void definirTemperaturaTest_frio_potencia3_17() throws Exception {
		init();
		aire.setEstado(new Frio());
		aire.setPotencia(new Potencia_3());
		estado.setTemperaturaColector(new Medicion(29.0, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("17", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void definirTemperaturaTest_frio_potencia3_16() throws Exception {
		init();
		aire.setEstado(new Frio());
		aire.setPotencia(new Potencia_3());
		estado.setTemperaturaColector(new Medicion(29.5, Magnitud.TEMPERATURA));
		Whitebox.invokeMethod(automatizador, "definirTemperatura");
		assertEquals("16", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void encenderTest() {
		init();
		automatizador.encender();
		clear();
	}

	@Test
	public void apagarTest() {
		init();
		automatizador.apagar();
		clear();
	}

	public void init() {
		automatizador = new AutomatizadorDeClima();
		aire = automatizador.getAire();
		estado = automatizador.getEstadoVivero();
		estado.setRangoTemperatura(new RangoNumerico(15.0, 25.0));
	}
	
	public void clear(){
		this.aire = null;
		this.automatizador = null;
	}

}
