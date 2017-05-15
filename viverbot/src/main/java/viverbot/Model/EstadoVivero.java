package viverbot.Model;

import java.util.Observable;
import java.util.Observer;

import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class EstadoVivero extends Observable implements Observer  {

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

	public EstadoVivero() {
		this.temperaturaActual = new Medicion(0.0, Magnitudes.TEMPERATURA);
		this.temperaturaColector = new Medicion(0.0, Magnitudes.TEMPERATURA);
		this.temperaturaDiferencia = new Medicion(0.0, Magnitudes.TEMPERATURA);
		this.humedadActual = new Medicion(10.0, Magnitudes.HUMEDAD);
		this.rangoTemperatura =  new RangoNumerico(10.00, 30.00);
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
		this.actualizar(t);

	}

	public Medicion getTemperaturaActual() {
		return temperaturaActual;
	}

	public void setTemperaturaActual(Medicion t) {
		this.temperaturaActual = t;
		this.actualizar(t);
	}

	public Medicion getTemperaturaDiferencia() {
		return temperaturaDiferencia;
	}

	public void setTemperaturaDiferencia(Medicion t) {
		this.temperaturaDiferencia = t;
		this.actualizar(t);
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
	
	public Medicion actualizar(Medicion t){
		this.temperaturaActual =  new Medicion(this.temperaturaColector.getValor() + this.temperaturaDiferencia.getValor(), Magnitudes.TEMPERATURA);
		this.setChanged();
		this.notifyObservers(this.temperaturaActual);
		return this.temperaturaActual;
	}

	@Override
	public void update(Observable arg0, Object t) {
		Medicion m =  (Medicion) t;
		this.setTemperaturaColector(m);
		
	}

}
