package viverbot.Modelo.Medicion;

import java.util.Timer;
import java.util.TimerTask;

import viverbot.Archivos.WriterExcel;
import viverbot.Interfaces.IFrioCalor;
import viverbot.Interfaces.IPotencia;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class AireAcondicionado {
	private IPotencia potenciaEstado;
	private IFrioCalor frioCalorEstado;
	private Timer timer;
	private boolean encendido = false;

	public AireAcondicionado() {
		this.potenciaEstado = new Potencia_0();
		this.frioCalorEstado = new Frio();
	}

	private TimerTask tt = new TimerTask() {

		@Override
		public void run() {
			// Aca le doy a javi la diferencia de la temperatura
			// modificar el metodo ejecutar() para devuelva la diferencia
			ejecutar();
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

	public void ejecutar() {
		frioCalorEstado.definirEstado(this);
		potenciaPositivaNegativa();
	}

	public AireAcondicionado returnThis() {
		return this;
	}

	public void encenderAutomatizador() {
		timer.schedule(tt, 1000, 1000);
		encendido = true;
	}

	public void apagarAutomatizador() {
		timer.purge();
		timer.cancel();
		encendido = false;
	}

	public boolean isEncendido() {
		return encendido;
	}
	
	private Medicion potenciaPositivaNegativa(){
		Medicion ret;
		Double num;
		if(frioCalorEstado.getClass() == Calor.class){
			ret = new Medicion(potenciaEstado.aplicarPotencia(this).getValor(), Magnitudes.TEMPERATURA);
			return ret;
		}else {
			num = potenciaEstado.aplicarPotencia(this).getValor() * (-1.0);
			ret = new Medicion(num, Magnitudes.TEMPERATURA);
			return ret;
		}
	}

}
