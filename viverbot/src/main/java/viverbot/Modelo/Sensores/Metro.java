package viverbot.Modelo.Sensores;

import java.util.Random;


import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class Metro extends InstrumentoMedicion {
	private int cantidadDeMediciones = 0;
	private Random random;

	@Override
	protected Medicion obtenerMedicion() {
		return this.simularMedicion();
	}

	protected Medicion simularMedicion() {
		random = new Random();

		Medicion medicion;
		int probabilidadRomperse = random.nextInt(100);

		if (probabilidadRomperse == 2 || probabilidadRomperse == 5 || probabilidadRomperse == 8) {
			medicion = new Medicion(-1.0, Magnitudes.ALTURA);
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
