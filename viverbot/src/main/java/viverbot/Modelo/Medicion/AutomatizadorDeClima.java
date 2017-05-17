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
			definirEstados();
			estadoVivero.setTemperaturaDiferencia(aire.ejecutar());
			WriterExcel.registrarAutomatizacion(aire);
			System.out.println(estadoVivero.getTemperaturaActual().getValor());
			if (estadoVivero.verificarRango()) {
				tt.cancel();
			}
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
		Integer random;
		if (aire.getPotencia().getClass() == Potencia_0.class) {
			random = (int) (Math.random() * 2 + 22);
			aire.setTemperatura(random.toString());
		}
		if (aire.getEstado().getClass() == Calor.class) {
			if (aire.getPotencia().getClass() == Potencia_1.class) {
				random = (int) (Math.random() * 3 + 22);
				aire.setTemperatura(random.toString());
			}
			if (aire.getPotencia().getClass() == Potencia_2.class) {
				random = (int) (Math.random() * 5 + 22);
				aire.setTemperatura(random.toString());
			}
			if (aire.getPotencia().getClass() == Potencia_3.class) {
				random = (int) (Math.random() * 7 + 22);
				aire.setTemperatura(random.toString());
			}
		}
		if (aire.getEstado().getClass() == Frio.class) {
			if (aire.getPotencia().getClass() == Potencia_1.class) {
				random = (int) (Math.random() * 3 + 20);
				aire.setTemperatura(random.toString());
			}
			if (aire.getPotencia().getClass() == Potencia_2.class) {
				random = (int) (Math.random() * 4 + 18);
				aire.setTemperatura(random.toString());
			}
			if (aire.getPotencia().getClass() == Potencia_3.class) {
				random = (int) (Math.random() * 4 + 16);
				aire.setTemperatura(random.toString());
			}
		}
	}

	public void encender() {
		timer.schedule(tt, 1000, 1000);
		encendido = true;
		aire.setEncendidoAutomatizado(true);
	}

	public void apagar() {
		timer.cancel();
		timer.purge();
		encendido = false;
		aire.setEncendidoAutomatizado(false);
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

}
