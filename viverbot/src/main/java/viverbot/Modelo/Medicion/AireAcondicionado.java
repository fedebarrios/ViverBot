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
	private IPotencia potencia;
	private IFrioCalor estado;
	private TemperaturaAireAcondicionado temp;
	private Timer timer;
	private boolean encendidoManualmente = false;
	private boolean encendidoAutomatizado = false;
	private EstadoVivero estadoVivero;

	public AireAcondicionado() {
		this.potencia = new Potencia_0();
		this.estado = new Frio();
		this.temp = new TemperaturaAireAcondicionado();
		this.timer = new Timer();
		this.estadoVivero = EstadoVivero.getInstance();
	}

	private TimerTask tt = new TimerTask() {

		@Override
		public void run() {
			estadoVivero.setTemperaturaDiferencia(ejecutar());
			WriterExcel.registrarAutomatizacion(returnThis());
			System.out.println(estadoVivero.getTemperaturaActual().getValor());
		}
	};

	public IPotencia getPotenciaEstado() {
		return potencia;
	}

	public IFrioCalor getFrioCalorEstado() {
		return estado;
	}

	public void setPotenciaEstado(IPotencia potenciaEstado) {
		this.potencia = potenciaEstado;
	}

	public void setFrioCalorEstado(IFrioCalor frioCalorEstado) {
		this.estado = frioCalorEstado;
	}
	
	public void setTemperaturaAireAcondicionado(String s){
		this.temp.definirTemp(s);
	}

	public Medicion ejecutar() {
		estado.definirEstado(this);
		Double suma = potencia.aplicarPotencia(this).getValor() + temp.getDiferencia().getValor();
		return new Medicion(definirPositivoNegativo(suma), Magnitudes.TEMPERATURA);
	}

	public AireAcondicionado returnThis() {
		return this;
	}

	public void encender() {
		timer.schedule(tt, 1000, 1000);
		encendidoManualmente = true;
	}

	public void apagar() {
		timer.cancel();
		timer.purge();
		encendidoManualmente = false;
	}

	private Double definirPositivoNegativo(Double d) {
		if (estado.getClass() == Calor.class) {
			return d;
		} else {
			return d * (-1.0);
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

	public EstadoVivero getEstadoVivero() {
		return estadoVivero;
	}

	public void setEstadoVivero(EstadoVivero estadoVivero) {
		this.estadoVivero = estadoVivero;
	}
	
	

}
