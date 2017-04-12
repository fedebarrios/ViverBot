package com.losameos.viverbot.Controller.Verificacion;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import static org.junit.matchers.JUnitMatchers.containsString;

import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.Model.Fecha;
import com.losameos.viverbot.Model.HistorialAltura;
import com.losameos.viverbot.Model.SeguimientoAltura;
import com.losameos.viverbot.Model.TuplaAltura;
import com.losameos.viverbot.Model.Magnitudes.Altura;

@SuppressWarnings("deprecation")
public class AnalizadorAlturaTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private AnalizadorAltura analizador;
	private ArrayList<TuplaAltura> tuplasOptimo;
	private ArrayList<TuplaAltura> tuplasVerdadero;
	private HistorialAltura optimo;
	private HistorialAltura verdadero;
	private SeguimientoAltura seguimiento;
	private PlantaDTO planta;
	private Altura alturaDiaria;

	@Test
	public void AnalizadorTest() {
		this.inicialize();
		this.clear();
	}

	@Test
	public void AnalizarPlantaSublimeTest() {
		this.inicialize();
		setearValoresOptimos(new String[] {"40cm", "45cm", "50cm", "55cm", "60cm"});
		setearValoresVerdaderos(new String[] {"70cm", "85cm", "90cm", "105cm"});
		this.alturaDiaria = new Altura("140cm");
		final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -4);
	    Date nacimiento = cal.getTime();
		this.planta = new PlantaDTO(1, 1, null, new Fecha(nacimiento.getDay(),nacimiento.getMonth(),nacimiento.getYear()));
		this.seguimiento = new SeguimientoAltura(planta, optimo, verdadero);
		this.analizador.analizarExaustivo(alturaDiaria, seguimiento);
		assertTrue(this.analizador.estadoPlantaAnalizada.equals("Sublime"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Perfecta"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Normal"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Anormal"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Defectuosa"));
		this.clear();
	}
	
	@Test
	public void AnalizarPlantaPerfectaTest() {
		this.inicialize();
		setearValoresOptimos(new String[] {"40cm", "45cm", "50cm", "55cm", "60cm"});
		setearValoresVerdaderos(new String[] {"50cm", "55cm", "70cm", "75cm"});
		this.alturaDiaria = new Altura("80cm");
		final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -4);
	    Date nacimiento = cal.getTime();
		this.planta = new PlantaDTO(1, 1, null, new Fecha(nacimiento.getDay(),nacimiento.getMonth(),nacimiento.getYear()));
		this.seguimiento = new SeguimientoAltura(planta, optimo, verdadero);
		this.analizador.analizarExaustivo(alturaDiaria, seguimiento);
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Sublime"));
		assertTrue(this.analizador.estadoPlantaAnalizada.equals("Perfecta"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Normal"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Anormal"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Defectuosa"));
		this.clear();
	}
	
	@Test
	public void AnalizarPlantaNormalTest() {
		this.inicialize();
		setearValoresOptimos(new String[] {"40cm", "45cm", "50cm", "55cm", "60cm"});
		setearValoresVerdaderos(new String[] {"41cm", "46cm", "52cm", "55cm"});
		this.alturaDiaria = new Altura("58cm");
		final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -4);
	    Date nacimiento = cal.getTime();
		this.planta = new PlantaDTO(1, 1, null, new Fecha(nacimiento.getDay(),nacimiento.getMonth(),nacimiento.getYear()));
		this.seguimiento = new SeguimientoAltura(planta, optimo, verdadero);
		this.analizador.analizarExaustivo(alturaDiaria, seguimiento);
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Sublime"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Perfecta"));
		assertTrue(this.analizador.estadoPlantaAnalizada.equals("Normal"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Anormal"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Defectuosa"));
		this.clear();
	}
	
	@Test
	public void AnalizarPlantaAnormalTest() {
		this.inicialize();
		setearValoresOptimos(new String[] {"40cm", "45cm", "50cm", "55cm", "60cm"});
		setearValoresVerdaderos(new String[] {"31cm", "36cm", "39cm", "47cm"});
		this.alturaDiaria = new Altura("55cm");
		final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -4);
	    Date nacimiento = cal.getTime();
		this.planta = new PlantaDTO(1, 1, null, new Fecha(nacimiento.getDay(),nacimiento.getMonth(),nacimiento.getYear()));
		this.seguimiento = new SeguimientoAltura(planta, optimo, verdadero);
		this.analizador.analizarExaustivo(alturaDiaria, seguimiento);
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Sublime"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Perfecta"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Normal"));
		assertTrue(this.analizador.estadoPlantaAnalizada.equals("Anormal"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Defectuosa"));
		this.clear();
	}
	
	@Test
	public void AnalizarPlantaDefectuosaTest() {
		this.inicialize();
		setearValoresOptimos(new String[] {"40cm", "45cm", "50cm", "55cm", "60cm"});
		setearValoresVerdaderos(new String[] {"20cm", "25cm", "30cm", "35cm"});
		this.alturaDiaria = new Altura("40cm");
		final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -4);
	    Date nacimiento = cal.getTime();
		this.planta = new PlantaDTO(1, 1, null,new Fecha(nacimiento.getDay(),nacimiento.getMonth(),nacimiento.getYear()));
		this.seguimiento = new SeguimientoAltura(planta, optimo, verdadero);
		this.analizador.analizarExaustivo(alturaDiaria, seguimiento);
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Sublime"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Perfecta"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Normal"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Anormal"));
		assertTrue(this.analizador.estadoPlantaAnalizada.equals("Defectuosa"));
		this.clear();
	}
	
	@Test
	public void AnalizarVerificarAlturaMayorTest() {
		this.inicialize();
		this.tuplasOptimo = new ArrayList<TuplaAltura>();
		setearValoresOptimos(new String[] {"40cm", "45cm", "50cm", "55cm", "60cm"});
		setearValoresVerdaderos(new String[] {"70cm", "85cm", "90cm", "105cm"});
		this.alturaDiaria = new Altura("140cm");
		final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -4);
	    Date nacimiento = cal.getTime();
		this.planta = new PlantaDTO(1, 1, null, new Fecha(nacimiento.getDay(),nacimiento.getMonth(),nacimiento.getYear()));
		this.seguimiento = new SeguimientoAltura(planta, optimo, verdadero);
		this.analizador.analizarExaustivo(alturaDiaria, seguimiento);
		this.analizador.verificarAlturaActual();
		assertThat(outContent.toString(), containsString("La planta esta unos: 80cm por encima de lo optimo"));
		assertTrue(this.analizador.diferenciaAltura.getValor().equals(80.0));
		this.clear();
	}
	
	@Test
	public void AnalizarVerificarAlturaIgualTest() {
		this.inicialize();
		setearValoresOptimos(new String[] {"40cm", "45cm", "50cm", "55cm", "60cm"});
		setearValoresVerdaderos(new String[] {"40cm", "45cm", "50cm", "55cm"});
		this.alturaDiaria = new Altura("60cm");
		final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -4);
	    Date nacimiento = cal.getTime();
		this.planta = new PlantaDTO(1, 1, null, new Fecha(nacimiento.getDay(),nacimiento.getMonth(),nacimiento.getYear()));
		this.seguimiento = new SeguimientoAltura(planta, optimo, verdadero);
		this.analizador.analizarExaustivo(alturaDiaria, seguimiento);
		this.analizador.verificarAlturaActual();
		assertThat(outContent.toString(), containsString("La planta esta exactamente en el valor optimo."));
		assertTrue(this.analizador.diferenciaAltura.getValor().equals(0.0));
		this.clear();
	}
	
	@Test
	public void AnalizarVerificarAlturaNoExistenteTest() {
		this.inicialize();
		setearValoresOptimos(new String[] {"40cm", "45cm", "50cm", "55cm"});
		setearValoresVerdaderos(new String[] {"40cm", "45cm", "50cm", "55cm"});
		this.alturaDiaria = new Altura("60cm");
		final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -4);
	    Date nacimiento = cal.getTime();
		this.planta = new PlantaDTO(1, 1, null, new Fecha(nacimiento.getDay(),nacimiento.getMonth(),nacimiento.getYear()));
		this.seguimiento = new SeguimientoAltura(planta, optimo, verdadero);
		this.analizador.analizarExaustivo(alturaDiaria, seguimiento);
		this.analizador.verificarAlturaActual();
		assertThat(outContent.toString(), containsString("La planta no tiene un optimo en el historial para comparar en el dia de la fecha."));
		assertNull(this.analizador.diferenciaAltura);
		this.clear();
	}
	
	
	private void setearValoresOptimos(String[] valores){
		this.tuplasOptimo = new ArrayList<TuplaAltura>();
		for (int i = 0; i < valores.length; i++){
			this.tuplasOptimo.add(new TuplaAltura(new Altura(valores[i]), i));
		}
		this.optimo = new HistorialAltura(tuplasOptimo);
	}
	
	private void setearValoresVerdaderos(String[] valores){
		this.tuplasVerdadero = new ArrayList<TuplaAltura>();
		for (int i = 0; i < valores.length; i++){
			this.tuplasVerdadero.add(new TuplaAltura(new Altura(valores[i]), i));
		}
		this.verdadero = new HistorialAltura(tuplasVerdadero);
	}

	private void inicialize() {
		this.analizador = new AnalizadorAltura();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	private void clear() {
		this.analizador = null;
		System.setOut(null);
	    System.setErr(null);
	}
}

