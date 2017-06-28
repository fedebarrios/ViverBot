package viverbot.Archivos;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import viverbot.Model.HistorialAltura;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;

public class CalculadoHistorialTest {
	
	@Test
	public void CalculadorTestSatisfactorio(){
		HistorialAltura h = fabricarHistorialSatisfactorio();
		assertTrue(CalculadorHistorial.calcularDiferencia(h));
	}

	protected HistorialAltura fabricarHistorialSatisfactorio() {
		int[] dias = {1,2,3};
		double[] alturas = {1.05,1.10,1.15};
		HistorialAltura h = new HistorialAltura();
		for(int i = 0 ; i<3 ; i++){
			h.agregarRegistro(dias[i] , new Medicion (alturas[i],Magnitud.ALTURA));
		}
		return h;
	}
	
	@Test
	public void CalculadorTestFallaEnAltura(){
		HistorialAltura h = fabricarHistorialFallaAltura();
		assertFalse(CalculadorHistorial.calcularDiferencia(h));
	}

	protected HistorialAltura fabricarHistorialFallaAltura() {
		int[] dias = {1,2,3};
		double[] alturas = {1.05,1.35,1.85};
		HistorialAltura h = new HistorialAltura();
		for(int i = 0 ; i<3 ; i++){
			h.agregarRegistro(dias[i] , new Medicion (alturas[i],Magnitud.ALTURA));
		}
		return h;
	}
	
	@Test
	public void CalculadorTestFallaDia(){
		HistorialAltura h = fabricarHistorialFallaDia();
		assertFalse(CalculadorHistorial.calcularDiferencia(h));
	}

	protected HistorialAltura fabricarHistorialFallaDia() {
		int[] dias = {1,7,13};
		double[] alturas = {1.05,1.10,1.15};
		HistorialAltura h = new HistorialAltura();
		for(int i = 0 ; i<3 ; i++){
			h.agregarRegistro(dias[i] , new Medicion (alturas[i],Magnitud.ALTURA));
		}
		return h;
	}		
}
