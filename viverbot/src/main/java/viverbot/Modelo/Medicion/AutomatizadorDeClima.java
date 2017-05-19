package viverbot.Modelo.Medicion;

import java.util.Timer;
import java.util.TimerTask;

import viverbot.Archivos.WriterExcel;
import viverbot.Model.EstadoVivero;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Medicion;

public class AutomatizadorDeClima {
	private AireAcondicionado aire = new AireAcondicionado();
	private Timer timer;
	private boolean encendido = false;
	private EstadoVivero estadoVivero;

	public AutomatizadorDeClima() {
		this.timer = new Timer();
		this.estadoVivero = EstadoVivero.getInstance();
	}

	private TimerTask tt = new TimerTask() {

		@Override
		public void run() {
			if (estadoVivero.verificarRango()) {
				tt.cancel();
			}
			definirEstados();
			estadoVivero.setTemperaturaDiferenciaSumar(aire.ejecutar());
			WriterExcel.registrarAutomatizacion(aire);
		}
	};

	private void definirEstados() {
		definirFrioCalor();
		definirPotencia();
		definirTemperatura();
	}

	private void definirFrioCalor() {
		if (getTemp().getValor() > getRango().getMaximo()) {
			aire.setEstado(new Frio());
		} else
			aire.setEstado(new Calor());
	}

	private void definirPotencia() {
		if (getTemp().getValor() - getRango().getMaximo() <= 1.0
				|| getRango().getMinimo() - getTemp().getValor() <= 1.0) {
			aire.setPotencia(new Potencia_0());
		}
		if (getTemp().getValor() - getRango().getMaximo() > 1.0 && getTemp().getValor() - getRango().getMaximo() <= 2.5
				|| getRango().getMinimo() - getTemp().getValor() > 1.0
						&& getRango().getMinimo() - getTemp().getValor() <= 2.5) {
			aire.setPotencia(new Potencia_1());
		}
		if (getTemp().getValor() - getRango().getMaximo() > 2.5 && getTemp().getValor() - getRango().getMaximo() <= 4.0
				|| getRango().getMinimo() - getTemp().getValor() > 2.5
						&& getRango().getMinimo() - getTemp().getValor() <= 4.0) {
			aire.setPotencia(new Potencia_2());
		}
		if (getTemp().getValor() - getRango().getMaximo() > 4.0
				|| getRango().getMinimo() - getTemp().getValor() > 4.0) {
			aire.setPotencia(new Potencia_3());
		}
	}

	private void definirTemperatura() {
		if (aire.getEstado().getClass() == Calor.class) {
			if (aire.getPotencia().getClass() == Potencia_0.class) {
				if (getRango().getMinimo() - getTemp().getValor() <= 0.5) {
					aire.setTemperatura("22");
				}
				if (getRango().getMinimo() - getTemp().getValor() <= 1.0
						&& getRango().getMinimo() - getTemp().getValor() > 0.5) {
					aire.setTemperatura("23");
				}
			}
			if (aire.getPotencia().getClass() == Potencia_1.class) {
				if (getRango().getMinimo() - getTemp().getValor() <= 1.5
						&& getRango().getMinimo() - getTemp().getValor() > 1.0) {
					aire.setTemperatura("24");
				}
				if (getRango().getMinimo() - getTemp().getValor() <= 2.0
						&& getRango().getMinimo() - getTemp().getValor() > 1.5) {
					aire.setTemperatura("25");
				}
			}
			if (aire.getPotencia().getClass() == Potencia_2.class) {
				if (getRango().getMinimo() - getTemp().getValor() <= 2.5
						&& getRango().getMinimo() - getTemp().getValor() > 2.0) {
					aire.setTemperatura("26");
				}
				if (getRango().getMinimo() - getTemp().getValor() <= 3.0
						&& getRango().getMinimo() - getTemp().getValor() > 2.5) {
					aire.setTemperatura("27");
				}
			}
			if (aire.getPotencia().getClass() == Potencia_3.class) {
				if (getRango().getMinimo() - getTemp().getValor() <= 3.5
						&& getRango().getMinimo() - getTemp().getValor() > 3.0) {
					aire.setTemperatura("28");
				}
				if (getRango().getMinimo() - getTemp().getValor() > 3.5) {
					aire.setTemperatura("29");
				}
			}
		}
		if (aire.getEstado().getClass() == Frio.class) {
			if (aire.getPotencia().getClass() == Potencia_0.class) {
				if (getTemp().getValor() - getRango().getMaximo() <= 0.5) {
					aire.setTemperatura("24");
				}
				if (getTemp().getValor() - getRango().getMaximo() <= 1.0
						&& getTemp().getValor() - getRango().getMaximo() > 0.5) {
					aire.setTemperatura("23");
				}
			}
			if (aire.getPotencia().getClass() == Potencia_1.class) {
				if (getTemp().getValor() - getRango().getMaximo() <= 1.5
						&& getTemp().getValor() - getRango().getMaximo() > 1.0) {
					aire.setTemperatura("22");
				}
				if (getTemp().getValor() - getRango().getMaximo() <= 2.0
						&& getTemp().getValor() - getRango().getMaximo() > 1.5) {
					aire.setTemperatura("21");
				}
			}
			if (aire.getPotencia().getClass() == Potencia_2.class) {
				if (getTemp().getValor() - getRango().getMaximo() <= 2.5
						&& getTemp().getValor() - getRango().getMaximo() > 2.0) {
					aire.setTemperatura("20");
				}
				if (getTemp().getValor() - getRango().getMaximo() <= 3.0
						&& getTemp().getValor() - getRango().getMaximo() > 2.5) {
					aire.setTemperatura("19");
				}
			}
			if (aire.getPotencia().getClass() == Potencia_3.class) {
				if (getTemp().getValor() - getRango().getMaximo() <= 3.5
						&& getTemp().getValor() - getRango().getMaximo() > 3.0) {
					aire.setTemperatura("18");
				}
				if (getTemp().getValor() - getRango().getMaximo() <= 4.0
						&& getTemp().getValor() - getRango().getMaximo() > 3.5) {
					aire.setTemperatura("17");
				}
				if (getTemp().getValor() - getRango().getMaximo() > 4.0) {
					aire.setTemperatura("16");
				}
			}
		}
	}

	public void encender() {
		timer.schedule(tt, 1000, 1000);
		encendido = true;
	}

	public void apagar() {
		timer.cancel();
		timer.purge();
		encendido = false;
	}

	// -------------------------GETTERS Y SETTERS----------------------

	public AireAcondicionado getAire() {
		return aire;
	}

	public boolean isEncendido() {
		return encendido;
	}

	private Medicion getTemp() {
		return this.estadoVivero.getTemperaturaActual();
	}

	private RangoNumerico getRango() {
		return this.estadoVivero.getRangoTemperatura();
	}

	public EstadoVivero getEstadoVivero() {
		return estadoVivero;
	}

}
