package com.losameos.viverbot.Controller.Verificacion;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.Model.HistorialAltura;
import com.losameos.viverbot.Model.SeguimientoAltura;
import com.losameos.viverbot.Model.TuplaAltura;
import com.losameos.viverbot.Model.Magnitudes.Altura;

public class AnalizadorAlturaTest {

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
		this.tuplasOptimo = new ArrayList<TuplaAltura>();
		// ya que en todos los casos usas la misma entrada de datos encapsula eso en un metodo
		//setearValores();
		//me asusta que la altura se pase en string :'v
		this.tuplasOptimo.add(new TuplaAltura(new Altura("40cm"), 1));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("45cm"), 2));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("50cm"), 3));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("55cm"), 4));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("60cm"), 4));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("65cm"), 5));
		this.tuplasVerdadero = new ArrayList<TuplaAltura>();
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("70cm"), 1));
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("85cm"), 2));
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("90cm"), 3));
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("105cm"), 4));
		this.optimo = new HistorialAltura(tuplasOptimo);
		this.verdadero = new HistorialAltura(tuplasVerdadero);
		this.alturaDiaria = new Altura("140cm");
		final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -4);
	    Date nacimiento = cal.getTime();
		this.planta = new PlantaDTO(1, 1, null, new java.sql.Date(nacimiento.getTime()));
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
		this.tuplasOptimo = new ArrayList<TuplaAltura>();
		this.tuplasOptimo.add(new TuplaAltura(new Altura("40cm"), 1));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("45cm"), 2));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("50cm"), 3));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("55cm"), 4));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("60cm"), 4));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("65cm"), 5));
		this.tuplasVerdadero = new ArrayList<TuplaAltura>();
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("50cm"), 1));
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("55cm"), 2));
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("70cm"), 3));
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("75cm"), 4));
		this.optimo = new HistorialAltura(tuplasOptimo);
		this.verdadero = new HistorialAltura(tuplasVerdadero);
		this.alturaDiaria = new Altura("80cm");
		final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -4);
	    Date nacimiento = cal.getTime();
		this.planta = new PlantaDTO(1, 1, null, new java.sql.Date(nacimiento.getTime()));
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
		this.tuplasOptimo = new ArrayList<TuplaAltura>();
		this.tuplasOptimo.add(new TuplaAltura(new Altura("40cm"), 1));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("45cm"), 2));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("50cm"), 3));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("55cm"), 4));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("60cm"), 4));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("65cm"), 5));
		this.tuplasVerdadero = new ArrayList<TuplaAltura>();
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("41cm"), 1));
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("46cm"), 2));
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("52cm"), 3));
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("55cm"), 4));
		this.optimo = new HistorialAltura(tuplasOptimo);
		this.verdadero = new HistorialAltura(tuplasVerdadero);
		this.alturaDiaria = new Altura("58cm");
		final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -4);
	    Date nacimiento = cal.getTime();
		this.planta = new PlantaDTO(1, 1, null, new java.sql.Date(nacimiento.getTime()));
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
		this.tuplasOptimo = new ArrayList<TuplaAltura>();
		this.tuplasOptimo.add(new TuplaAltura(new Altura("40cm"), 1));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("45cm"), 2));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("50cm"), 3));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("55cm"), 4));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("60cm"), 4));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("65cm"), 5));
		this.tuplasVerdadero = new ArrayList<TuplaAltura>();
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("31cm"), 1));
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("36cm"), 2));
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("39cm"), 3));
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("47cm"), 4));
		this.optimo = new HistorialAltura(tuplasOptimo);
		this.verdadero = new HistorialAltura(tuplasVerdadero);
		this.alturaDiaria = new Altura("55cm");
		final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -4);
	    Date nacimiento = cal.getTime();
		this.planta = new PlantaDTO(1, 1, null, new java.sql.Date(nacimiento.getTime()));
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
		this.tuplasOptimo = new ArrayList<TuplaAltura>();
		this.tuplasOptimo.add(new TuplaAltura(new Altura("40cm"), 1));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("45cm"), 2));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("50cm"), 3));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("55cm"), 4));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("60cm"), 4));
		this.tuplasOptimo.add(new TuplaAltura(new Altura("65cm"), 5));
		this.tuplasVerdadero = new ArrayList<TuplaAltura>();
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("20cm"), 1));
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("25cm"), 2));
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("30cm"), 3));
		this.tuplasVerdadero.add(new TuplaAltura(new Altura("35cm"), 4));
		this.optimo = new HistorialAltura(tuplasOptimo);
		this.verdadero = new HistorialAltura(tuplasVerdadero);
		this.alturaDiaria = new Altura("40cm");
		final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -4);
	    Date nacimiento = cal.getTime();
		this.planta = new PlantaDTO(1, 1, null, new java.sql.Date(nacimiento.getTime()));
		this.seguimiento = new SeguimientoAltura(planta, optimo, verdadero);
		this.analizador.analizarExaustivo(alturaDiaria, seguimiento);
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Sublime"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Perfecta"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Normal"));
		assertFalse(this.analizador.estadoPlantaAnalizada.equals("Anormal"));
		assertTrue(this.analizador.estadoPlantaAnalizada.equals("Defectuosa"));
		this.clear();
	}

	private void inicialize() {
		this.analizador = new AnalizadorAltura();

	}

	private void clear() {
		this.analizador = null;
	}
}

