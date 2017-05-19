package viverbot.Archivos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import viverbot.Model.HistorialAltura;
import viverbot.Model.TuplaAltura;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class CalculadoHistorialTest {
	
	@Test
	public void CalculadorTestSatisfactorio(){
		int[] dias = {1,2,3};
		double[] alturas = {1.05,1.10,1.15};
		ArrayList<TuplaAltura> t = new ArrayList<TuplaAltura>();
		for(int i = 0 ; i<3 ; i++){
			t.add(new TuplaAltura( new Medicion (alturas[i],Magnitudes.ALTURA), dias[i]));
		}
		HistorialAltura h = new HistorialAltura(t);
		assertTrue(CalculadorHistorial.calcularDiferencia(h));
	}
	
	@Test
	public void CalculadorTestFallaEnDias(){
		int[] dias = {1,2,3};
		double[] alturas = {1.05,1.25,1.35};
		ArrayList<TuplaAltura> t = new ArrayList<TuplaAltura>();
		for(int i = 0 ; i<3 ; i++){
			t.add(new TuplaAltura( new Medicion (alturas[i],Magnitudes.ALTURA), dias[i]));
		}
		HistorialAltura h = new HistorialAltura(t);
		assertFalse(CalculadorHistorial.calcularDiferencia(h));
	}
	
	@Test
	public void CalculadorTestFallaDia(){
		int[] dias = {1,7,13};
		double[] alturas = {1.05,1.10,1.15};
		ArrayList<TuplaAltura> t = new ArrayList<TuplaAltura>();
		for(int i = 0 ; i<3 ; i++){
			t.add(new TuplaAltura( new Medicion (alturas[i],Magnitudes.ALTURA), dias[i]));
		}
		HistorialAltura h = new HistorialAltura(t);
		assertFalse(CalculadorHistorial.calcularDiferencia(h));
	}	
}
