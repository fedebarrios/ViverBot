package viverbot.Modelo.Medicion;

import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import viverbot.Archivos.WriterExcel;
import viverbot.Model.EstadoVivero;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Medicion;

public class AutomatizadorDeClima implements Observer{
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
			System.out.println(getTemp().getValor());
			if (verificarRango()) {
				tt.cancel();
			}
		}
	};

	private boolean verificarRango() {
		if (getTemp().getValor() <= getRango().getMaximo() && getTemp().getValor() >= getRango().getMinimo()) {
			return true;
		}
		return false;
	}

	private void definirEstados() {
		definirFrioCalor();
		definirPotencia();
	}

	private void definirFrioCalor() {
		if (getTemp().getValor() > getRango().getMaximo()) {
			aire.setFrioCalorEstado(new Frio());
		} else
			aire.setFrioCalorEstado(new Calor());
	}

	private void definirPotencia() {
		if (getTemp().getValor() - getRango().getMaximo() <= 1.0 || getRango().getMinimo() - getTemp().getValor() <= 1.0) {
			aire.setPotenciaEstado(new Potencia_0());
		}
		if (getTemp().getValor() - getRango().getMaximo() > 1.0 && getTemp().getValor() - getRango().getMaximo() <= 2.5
				|| getRango().getMinimo() - getTemp().getValor() > 1.0 && getRango().getMinimo() - getTemp().getValor() <= 2.5) {
			aire.setPotenciaEstado(new Potencia_1());
		}
		if (getTemp().getValor() - getRango().getMaximo() > 2.5 && getTemp().getValor() - getRango().getMaximo() <= 4.0
				|| getRango().getMinimo() - getTemp().getValor() > 2.5 && getRango().getMinimo() - getTemp().getValor() <= 4.0) {
			aire.setPotenciaEstado(new Potencia_2());
		}
		if (getTemp().getValor() - getRango().getMaximo() > 4.0 || getRango().getMinimo() - getTemp().getValor() > 4.0) {
			aire.setPotenciaEstado(new Potencia_3());
		}
	}

	public void encenderAutomatizador() {
		timer.schedule(tt, 1000, 1000);
		encendido = true;
		aire.setEncendidoAutomatizado(true);
	}

	public void apagarAutomatizador() {
		timer.cancel();
		timer.purge();
		encendido = false;
		aire.setEncendidoAutomatizado(false);
	}

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

	@SuppressWarnings("unused")
	@Override
	public void update(Observable arg0, Object arg1) {
		Medicion temp = (Medicion) arg1;
	}

}
