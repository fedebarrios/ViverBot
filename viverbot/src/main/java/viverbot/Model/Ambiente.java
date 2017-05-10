package viverbot.Model;

import viverbot.Modelo.Magnitudes.Humedad;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.Temperatura;

public class Ambiente implements Runnable {

	private static Temperatura temperaturaActual = new Temperatura(25.0);;
	private static Medicion humedadActual = new Medicion(10.0, Magnitudes.HUMEDAD);
	private Hora horaActual;
	private static Ambiente ambiente;

	public static Ambiente getInstance() {
		if (ambiente == null) {
			ambiente = new Ambiente();
		}
		return ambiente;
	}

	@Override
	public void run() {

	}

	public Temperatura getTemperatura() {
		return temperaturaActual;

	}

	public Medicion getHumedad() {
		return humedadActual;
	}

	public void setHoraActual(Hora hora) {
		horaActual = hora;
	}

	public void setTemperatura(Temperatura t) {
		temperaturaActual = t;
	}

}
