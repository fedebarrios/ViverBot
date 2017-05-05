package viverbot.Modelo.Medicion;

import java.util.Observable;
import java.util.Observer;

import viverbot.Modelo.Magnitudes.Magnitud;

public class TransmisorTemperatura implements Observer {

	private AnalizadorTemperatura analizador;

	public TransmisorTemperatura() {
		this.analizador = new AnalizadorTemperatura();

	}

	@Override
	public void update(Observable o, Object temp) {
		this.Transmitir((Magnitud) temp);
	}

	public void Transmitir(Magnitud temp) {
		this.analizador.analizar(temp);

	}

	

	public AnalizadorTemperatura getAnalizador() {
		return this.analizador;
	}
}
