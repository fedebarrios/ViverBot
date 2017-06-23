package viverbot.Archivos;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import viverbot.Model.HistorialAltura;
import viverbot.Model.TuplaAltura;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class CalculadoHistorialTest {
	
	@Test
	public void CalculadorTestSatisfactorio(){
		HistorialAltura h = new HistorialAltura(fabricarHistorialSatisfactorio());
		assertTrue(CalculadorHistorial.calcularDiferencia(h.getTuplas()));
	}

	protected ArrayList<TuplaAltura> fabricarHistorialSatisfactorio() {
		int[] dias = {1,2,3};
		double[] alturas = {1.05,1.10,1.15};
		ArrayList<TuplaAltura> t = new ArrayList<TuplaAltura>();
		for(int i = 0 ; i<3 ; i++){
			t.add(new TuplaAltura( new Medicion (alturas[i],Magnitudes.ALTURA), dias[i]));
		}
		return t;
	}
	
	@Test
	public void CalculadorTestFallaEnAltura(){
		HistorialAltura h = new HistorialAltura(fabricarHistorialFallaAltura());
		assertFalse(CalculadorHistorial.calcularDiferencia(h.getTuplas()));
	}

	protected ArrayList<TuplaAltura> fabricarHistorialFallaAltura() {
		int[] dias = {1,2,3};
		double[] alturas = {1.05,1.35,1.85};
		ArrayList<TuplaAltura> t = new ArrayList<TuplaAltura>();
		for(int i = 0 ; i<3 ; i++){
			t.add(new TuplaAltura( new Medicion (alturas[i],Magnitudes.ALTURA), dias[i]));
		}
		return t;
	}
	
	@Test
	public void CalculadorTestFallaDia(){
		HistorialAltura h = new HistorialAltura(fabricarHistorialFallaDia());
		assertFalse(CalculadorHistorial.calcularDiferencia(h.getTuplas()));
	}

	protected ArrayList<TuplaAltura> fabricarHistorialFallaDia() {
		int[] dias = {1,7,13};
		double[] alturas = {1.05,1.10,1.15};
		ArrayList<TuplaAltura> t = new ArrayList<TuplaAltura>();
		for(int i = 0 ; i<3 ; i++){
			t.add(new TuplaAltura( new Medicion (alturas[i],Magnitudes.ALTURA), dias[i]));
		}
		return t;
	}	
	
	@Test
	public void CalculadorInfoRepetida(){
		HistorialAltura h = new HistorialAltura(fabricarHistorialInfoRepetida());
		assertFalse(CalculadorHistorial.calcularDiferencia(h.getTuplas()));
	}

	protected ArrayList<TuplaAltura> fabricarHistorialInfoRepetida() {
		int[] dias = {7,8,7};
		double[] alturas = {1.05,1.10,1.15};
		ArrayList<TuplaAltura> t = new ArrayList<TuplaAltura>();
		for(int i = 0 ; i<3 ; i++){
			t.add(new TuplaAltura( new Medicion (alturas[i],Magnitudes.ALTURA), dias[i]));
		}
		return t;
	}	
}
