package viverbot.Model;

import java.util.Observable;
import java.util.Observer;

import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;

public class EstadoVivero extends Observable implements Observer {
	private Medicion temperaturaColector;
	private Medicion temperaturaActual;
	private Medicion temperaturaDiferencia;
	private Medicion humedadActual;
	private Hora horaActual;
	private RangoNumerico rangoTemperatura;
	private static EstadoVivero ambiente;

	public static EstadoVivero getInstance() {
		if (ambiente == null) {
			ambiente = new EstadoVivero();
		}
		return ambiente;
	}

	private EstadoVivero() {
		this.temperaturaActual = new Medicion(0.0, Magnitud.TEMPERATURA);
		this.temperaturaColector = new Medicion(0.0, Magnitud.TEMPERATURA);
		this.temperaturaDiferencia = new Medicion(0.0, Magnitud.TEMPERATURA);
		this.humedadActual = new Medicion(10.0, Magnitud.HUMEDAD);
		this.rangoTemperatura = new RangoNumerico(15.00, 25.00);
	}

	public Medicion getTemperaturaColector() {
		return temperaturaColector;
	}

	public RangoNumerico getRangoTemperatura() {
		return rangoTemperatura;
	}

	public void setRangoTemperatura(RangoNumerico rangoTemperatura) {
		this.rangoTemperatura = rangoTemperatura;
	}

	public void setTemperaturaColector(Medicion t) {
		this.temperaturaColector = t;
		this.actualizar();

	}

	public Medicion getTemperaturaActual() {
		return temperaturaActual;
	}

	public void setTemperaturaActual(Medicion t) {
		this.temperaturaActual = t;
	}

	public Medicion getTemperaturaDiferencia() {
		return temperaturaDiferencia;
	}

	public void setTemperaturaDiferencia(Medicion t) {
		this.temperaturaDiferencia = t;
		this.actualizar();
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

	private void actualizar() {
		this.temperaturaActual = new Medicion(
				this.temperaturaColector.getValor() + this.temperaturaDiferencia.getValor(), Magnitud.TEMPERATURA);
		this.setChanged();
		this.notifyObservers(this.temperaturaActual);
	}

	@Override
	public void update(Observable arg0, Object t) {
		Medicion m = (Medicion) t;
		this.setTemperaturaColector(m);
	}

	public boolean verificarRango() {
		if (temperaturaActual.getValor() <= rangoTemperatura.getMaximo()
				&& temperaturaActual.getValor() >= rangoTemperatura.getMinimo()) {
			return true;
		}
		return false;
	}

	public void setTemperaturaDiferenciaSumar(Medicion m) {
		this.temperaturaDiferencia.setValor(this.temperaturaDiferencia.getValor() + m.getValor());
		this.actualizar();
	}

}
