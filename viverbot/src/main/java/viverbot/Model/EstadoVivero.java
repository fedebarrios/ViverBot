package viverbot.Model;

import viverbot.Modelo.Magnitudes.Medicion;

public class EstadoVivero {

	private Medicion temperaturaColector;
	private Medicion temperaturaActual;
	private Medicion temperaturaDiferencia;
	private Medicion humedadActual;
	private Hora horaActual;
	private static EstadoVivero ambiente;

	private EstadoVivero() {

	}

	public static EstadoVivero getInstance() {
		if (ambiente == null) {
			ambiente = new EstadoVivero();
		}
		return ambiente;
	}

	public Medicion getTemperaturaColector() {
		return temperaturaColector;
	}

	public void setTemperaturaColector(Medicion temperaturaColector) {
		this.temperaturaColector = temperaturaColector;
	}

	public Medicion getTemperaturaActual() {
		return temperaturaActual;
	}

	public void setTemperaturaActual(Medicion temperaturaActual) {
		this.temperaturaActual = temperaturaActual;
	}

	public Medicion getTemperaturaDiferencia() {
		return temperaturaDiferencia;
	}

	public void setTemperaturaDiferencia(Medicion temperaturaDiferencia) {
		this.temperaturaDiferencia = temperaturaDiferencia;
	}

	public Medicion getHumedadActual() {
		return humedadActual;
	}

	public void setHumedadActual(Medicion humedadActual) {
		this.humedadActual = humedadActual;
	}

	public Hora getHoraActual() {
		return horaActual;
	}

	public void setHoraActual(Hora horaActual) {
		this.horaActual = horaActual;
	}

}
