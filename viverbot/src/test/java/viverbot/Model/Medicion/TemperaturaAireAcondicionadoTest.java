package viverbot.Model.Medicion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.TemperaturaAireAcondicionado;

public class TemperaturaAireAcondicionadoTest {
	private TemperaturaAireAcondicionado temp;

	@Test
	public void definirTempTest_16() {
		init();
		assertNotNull(temp);
		temp.definirTemp("16");
		String expectedString = "16";
		Medicion expectedMedicion = new Medicion(0.003, Magnitudes.TEMPERATURA);
		assertEquals(expectedString, temp.toString());
		assertEquals(expectedMedicion.getValor(), temp.getDiferencia().getValor());
	}

	@Test
	public void definirTempTest_17() {
		init();
		assertNotNull(temp);
		temp.definirTemp("17");
		String expectedString = "17";
		Medicion expectedMedicion = new Medicion(0.006, Magnitudes.TEMPERATURA);
		assertEquals(expectedString, temp.toString());
		assertEquals(expectedMedicion.getValor(), temp.getDiferencia().getValor());
	}

	@Test
	public void definirTempTest_18() {
		init();
		assertNotNull(temp);
		temp.definirTemp("18");
		String expectedString = "18";
		Medicion expectedMedicion = new Medicion(0.009, Magnitudes.TEMPERATURA);
		assertEquals(expectedString, temp.toString());
		assertEquals(expectedMedicion.getValor(), temp.getDiferencia().getValor());
	}

	@Test
	public void definirTempTest_19() {
		init();
		assertNotNull(temp);
		temp.definirTemp("19");
		String expectedString = "19";
		Medicion expectedMedicion = new Medicion(0.011, Magnitudes.TEMPERATURA);
		assertEquals(expectedString, temp.toString());
		assertEquals(expectedMedicion.getValor(), temp.getDiferencia().getValor());
	}

	@Test
	public void definirTempTest_20() {
		init();
		assertNotNull(temp);
		temp.definirTemp("20");
		String expectedString = "20";
		Medicion expectedMedicion = new Medicion(0.013, Magnitudes.TEMPERATURA);
		assertEquals(expectedString, temp.toString());
		assertEquals(expectedMedicion.getValor(), temp.getDiferencia().getValor());
	}

	@Test
	public void definirTempTest_21() {
		init();
		assertNotNull(temp);
		temp.definirTemp("21");
		String expectedString = "21";
		Medicion expectedMedicion = new Medicion(0.017, Magnitudes.TEMPERATURA);
		assertEquals(expectedString, temp.toString());
		assertEquals(expectedMedicion.getValor(), temp.getDiferencia().getValor());
	}

	@Test
	public void definirTempTest_22() {
		init();
		assertNotNull(temp);
		temp.definirTemp("22");
		String expectedString = "22";
		Medicion expectedMedicion = new Medicion(0.020, Magnitudes.TEMPERATURA);
		assertEquals(expectedString, temp.toString());
		assertEquals(expectedMedicion.getValor(), temp.getDiferencia().getValor());
	}

	@Test
	public void definirTempTest_23() {
		init();
		assertNotNull(temp);
		temp.definirTemp("23");
		String expectedString = "23";
		Medicion expectedMedicion = new Medicion(0.023, Magnitudes.TEMPERATURA);
		assertEquals(expectedString, temp.toString());
		assertEquals(expectedMedicion.getValor(), temp.getDiferencia().getValor());
	}

	@Test
	public void definirTempTest_24() {
		init();
		assertNotNull(temp);
		temp.definirTemp("24");
		String expectedString = "24";
		Medicion expectedMedicion = new Medicion(0.026, Magnitudes.TEMPERATURA);
		assertEquals(expectedString, temp.toString());
		assertEquals(expectedMedicion.getValor(), temp.getDiferencia().getValor());
	}

	@Test
	public void definirTempTest_25() {
		init();
		assertNotNull(temp);
		temp.definirTemp("25");
		String expectedString = "25";
		Medicion expectedMedicion = new Medicion(0.029, Magnitudes.TEMPERATURA);
		assertEquals(expectedString, temp.toString());
		assertEquals(expectedMedicion.getValor(), temp.getDiferencia().getValor());
	}

	@Test
	public void definirTempTest_26() {
		init();
		assertNotNull(temp);
		temp.definirTemp("26");
		String expectedString = "26";
		Medicion expectedMedicion = new Medicion(0.032, Magnitudes.TEMPERATURA);
		assertEquals(expectedString, temp.toString());
		assertEquals(expectedMedicion.getValor(), temp.getDiferencia().getValor());
	}

	@Test
	public void definirTempTest_27() {
		init();
		assertNotNull(temp);
		temp.definirTemp("27");
		String expectedString = "27";
		Medicion expectedMedicion = new Medicion(0.035, Magnitudes.TEMPERATURA);
		assertEquals(expectedString, temp.toString());
		assertEquals(expectedMedicion.getValor(), temp.getDiferencia().getValor());
	}

	@Test
	public void definirTempTest_28() {
		init();
		assertNotNull(temp);
		temp.definirTemp("28");
		String expectedString = "28";
		Medicion expectedMedicion = new Medicion(0.037, Magnitudes.TEMPERATURA);
		assertEquals(expectedString, temp.toString());
		assertEquals(expectedMedicion.getValor(), temp.getDiferencia().getValor());
	}

	@Test
	public void definirTempTest_29() {
		init();
		assertNotNull(temp);
		temp.definirTemp("29");
		String expectedString = "29";
		Medicion expectedMedicion = new Medicion(0.040, Magnitudes.TEMPERATURA);
		assertEquals(expectedString, temp.toString());
		assertEquals(expectedMedicion.getValor(), temp.getDiferencia().getValor());
	}

	public void init() {
		temp = new TemperaturaAireAcondicionado();
	}

}
