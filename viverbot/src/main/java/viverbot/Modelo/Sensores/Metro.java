package viverbot.Modelo.Sensores;

import java.util.Random;

import viverbot.Modelo.Magnitudes.EmptyMedicion;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class Metro implements Medir {
	private int cantidadDeMediciones = 0;
	private Random random;

	@Override
	public Medicion getMedicion() {
		try {
			return this.simularMedicion();
		} catch (Exception e) {
			return new EmptyMedicion();
		}
	}

	protected Medicion simularMedicion() throws Exception {
		random = new Random();

		Medicion medicion;
		int probabilidadRomperse = random.nextInt(100);

		if (probabilidadRomperse == 2 || probabilidadRomperse == 5 || probabilidadRomperse == 8) {
			throw new Exception("El metro se averio");
		} else {
			cantidadDeMediciones++;
			if (cantidadDeMediciones < 3) {
				medicion = new Medicion(random.nextDouble() * 25 + 100, Magnitudes.ALTURA);
			} else if (cantidadDeMediciones < 5) {
				medicion = new Medicion(random.nextDouble() * 30 + 120, Magnitudes.ALTURA);
			} else if (cantidadDeMediciones < 8) {
				medicion = new Medicion(random.nextDouble() * 40 + 110, Magnitudes.ALTURA);
			} else {
				medicion = new Medicion(random.nextDouble() * 25 + 100, Magnitudes.ALTURA);
			}
		}
		return medicion;
	}
	
	protected Medicion simularMedicion(int probabilidadRomperse) throws Exception {
		random = new Random();

		Medicion medicion;
		if (probabilidadRomperse == 2 || probabilidadRomperse == 5 || probabilidadRomperse == 8) {
			throw new Exception("El metro se averio");
		} else {
			cantidadDeMediciones++;
			if (cantidadDeMediciones < 3) {
				medicion = new Medicion(random.nextDouble() * 25 + 100, Magnitudes.ALTURA);
			} else if (cantidadDeMediciones < 5) {
				medicion = new Medicion(random.nextDouble() * 30 + 120, Magnitudes.ALTURA);
			} else if (cantidadDeMediciones < 8) {
				medicion = new Medicion(random.nextDouble() * 40 + 110, Magnitudes.ALTURA);
			} else {
				medicion = new Medicion(random.nextDouble() * 25 + 100, Magnitudes.ALTURA);
			}
		}
		return medicion;
	}
}
