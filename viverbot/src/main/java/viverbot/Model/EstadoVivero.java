package viverbot.Model;

import viverbot.Modelo.Magnitudes.Humedad;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.Temperatura;

public class EstadoVivero {

	private  Medicion temperaturaColector;
	private  Medicion temperaturaActual;
	private  Medicion temperaturaDiferencia;
	private  Medicion humedadActual;
	private Hora horaActual;
	private static EstadoVivero ambiente;

	public static EstadoVivero getInstance() {
		if (ambiente == null) {
			ambiente = new EstadoVivero();
		}
		return ambiente;
	}

	

	public Medicion getTemperatura() {
		
		
		return temperaturaActual;

	}

	public Medicion getHumedad() {
		return humedadActual;
	}

	public void setHoraActual(Hora hora) {
		horaActual = hora;
	}

	public void setTemperatura(Medicion t) {
		temperaturaActual = t;
	}

}
