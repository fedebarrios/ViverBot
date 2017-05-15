package viverbot.Modelo.Medicion;

import java.util.Timer;
import java.util.TimerTask;

import viverbot.Archivos.WriterExcel;
import viverbot.Interfaces.IFrioCalor;
import viverbot.Interfaces.IPotencia;
import viverbot.Model.EstadoVivero;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class AireAcondicionado {
	private IPotencia potenciaEstado;
	private IFrioCalor frioCalorEstado;
	private Timer timer;
	private boolean encendidoManualmente = false;
	private boolean encendidoAutomatizado = false;
	private EstadoVivero estadoVivero;

	public AireAcondicionado() {
		this.potenciaEstado = new Potencia_0();
		this.frioCalorEstado = new Frio();
		this.timer = new Timer();
		this.estadoVivero = EstadoVivero.getInstance();
	}

	private TimerTask tt = new TimerTask() {

		@Override
		public void run() {
			estadoVivero.setTemperaturaDiferencia(ejecutar());
			WriterExcel.registrarAutomatizacion(returnThis());
		}
	};

	public IPotencia getPotenciaEstado() {
		return potenciaEstado;
	}

	public IFrioCalor getFrioCalorEstado() {
		return frioCalorEstado;
	}

	public void setPotenciaEstado(IPotencia potenciaEstado) {
		this.potenciaEstado = potenciaEstado;
	}

	public void setFrioCalorEstado(IFrioCalor frioCalorEstado) {
		this.frioCalorEstado = frioCalorEstado;
	}

	public Medicion ejecutar() {
		frioCalorEstado.definirEstado(this);
		Medicion dif = potenciaPositivaNegativa();
		return dif;
	}

	public AireAcondicionado returnThis() {
		return this;
	}

	public void encender() {
		timer.schedule(tt, 1000, 1000);
		encendidoManualmente = true;
	}

	public void apagar() {
		timer.purge();
		timer.cancel();
		encendidoManualmente = false;
	}

	private Medicion potenciaPositivaNegativa() {
		Medicion ret;
		Double num;
		if (frioCalorEstado.getClass() == Calor.class) {
			ret = new Medicion(potenciaEstado.aplicarPotencia(this).getValor(), Magnitudes.TEMPERATURA);
			return ret;
		} else {
			num = potenciaEstado.aplicarPotencia(this).getValor() * (-1.0);
			ret = new Medicion(num, Magnitudes.TEMPERATURA);
			return ret;
		}
	}

	public boolean isEncendidoAutomatizado() {
		return encendidoAutomatizado;
	}

	public void setEncendidoAutomatizado(boolean encendidoAutomatizado) {
		this.encendidoAutomatizado = encendidoAutomatizado;
	}

	public boolean isEncendidoManualmente() {
		return encendidoManualmente;
	}

}
