package viverbot.Modelo.Medicion;

import java.util.Timer;
import java.util.TimerTask;

import viverbot.Archivos.WriterExcel;
import viverbot.Interfaces.FrioCalor;
import viverbot.Interfaces.Potencia;
import viverbot.Model.EstadoVivero;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;

public class AireAcondicionado {
	private Potencia potencia;
	private FrioCalor estado;
	private TemperaturaAireAcondicionado temp;
	private Timer timer;
	private boolean encendidoManualmente = false;
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
			estadoVivero.setTemperaturaDiferenciaSumar(ejecutar());
			WriterExcel.registrarAutomatizacion(returnThis());
		}
	};

	public Medicion ejecutar() {
		estado.definirEstado(this);
		Double suma = potencia.aplicarPotencia(this).getValor() + temp.getDiferencia().getValor();
		return new Medicion(definirPositivoNegativo(suma), Magnitud.TEMPERATURA);
	}

	private Double definirPositivoNegativo(Double d) {
		if (estado.getClass() == Calor.class) {
			return d;
		} else {
			return d * (-1.0);
		}
	}

	private AireAcondicionado returnThis() {
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
	
	@Override
	public String toString() {
		String estado = "Estado: " + this.estado.toString();
		String potencia = "Potencia: " + this.potencia.toString();
		String temp = "Temperatura: " + this.temp.toString() + " C°";
		return estado + "\n" + potencia + "\n" + temp;
	}

	// ------------------GETTERS Y SETTERS-----------------------

	public boolean isEncendidoManualmente() {
		return encendidoManualmente;
	}

	public Potencia getPotencia() {
		return potencia;
	}

	public FrioCalor getEstado() {
		return estado;
	}

	public void setPotencia(Potencia potenciaEstado) {
		this.potencia = potenciaEstado;
	}

	public void setEstado(FrioCalor frioCalorEstado) {
		this.estado = frioCalorEstado;
	}

	public void setTemperatura(String s) {
		this.temp.definirTemp(s);
	}

	public TemperaturaAireAcondicionado getTemp() {
		return temp;
	}

}
