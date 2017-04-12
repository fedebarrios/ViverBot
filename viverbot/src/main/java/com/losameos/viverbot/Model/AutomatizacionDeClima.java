package com.losameos.viverbot.Model;

import com.losameos.viverbot.Controller.AireAcondicionadoController;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class AutomatizacionDeClima extends Thread {
	private Temperatura temp;
	private RangoNumerico rango;
	private AireAcondicionadoController aireAcondicionado;
	private long inicio = 0;
	private long frecuenciaDeAutomatizacion = 1000;
	private long frecuenciaDeControl;

	public AutomatizacionDeClima(Temperatura temp, RangoNumerico rango, long frecuenciaDeControl) {
		this.temp = temp;
		this.rango = rango;
		this.frecuenciaDeControl = frecuenciaDeControl;
		this.aireAcondicionado = new AireAcondicionadoController();
	}

	private boolean verificarTiempoDeAutomatizacion() {
		return Hora.tiempoTranscurrido(inicio) >= this.frecuenciaDeAutomatizacion;
	}

	private boolean verificarTiempoDeControl() {
		return Hora.tiempoTranscurrido(inicio) >= this.frecuenciaDeControl;
	}

	private void setInicio() {
		this.inicio = Hora.instanteActual();
	}

	private boolean verificarRango() {
		return this.temp.getValor() >= this.rango.getMinimo() && this.temp.getValor() <= this.rango.getMaximo();
	}

	private void bajarTemperatura() {
		if (this.aireAcondicionado.getPotencia() == Potencia.POTENCIA0) {
			this.temp.setValor(this.temp.getValor() - 0.5);
		}
		if (this.aireAcondicionado.getPotencia() == Potencia.POTENCIA1) {
			this.temp.setValor(this.temp.getValor() - 1.0);
		}
		if (this.aireAcondicionado.getPotencia() == Potencia.POTENCIA2) {
			this.temp.setValor(this.temp.getValor() - 2.0);
		}
		if (this.aireAcondicionado.getPotencia() == Potencia.POTENCIA3) {
			this.temp.setValor(this.temp.getValor() - 3.0);
		}
	}

	private void subirTemperatura() {
		if (this.aireAcondicionado.getPotencia() == Potencia.POTENCIA0) {
			this.temp.setValor(this.temp.getValor() + 0.5);
		}
		if (this.aireAcondicionado.getPotencia() == Potencia.POTENCIA1) {
			this.temp.setValor(this.temp.getValor() + 1.0);
		}
		if (this.aireAcondicionado.getPotencia() == Potencia.POTENCIA2) {
			this.temp.setValor(this.temp.getValor() + 2.0);
		}
		if (this.aireAcondicionado.getPotencia() == Potencia.POTENCIA3) {
			this.temp.setValor(this.temp.getValor() + 3.0);
		}
	}

	@Override
	public void run() {
		setInicio();
		System.out.println("El rango es entre " + rango.getMinimo() + " y " + rango.getMaximo());
		System.out.println("La temperatura es de " + temp.getValor());

		while (true) {
			if (verificarTiempoDeControl()) {
				if (!verificarRango()) {
					System.out.println("la temperatura no se encuentra dentro del rango establecido.");
					aireAcondicionado.encenderAireAcondicionado();
					if (temp.getValor() > rango.getMaximo()) {
						boolean ret = true;
						while (ret) {
							if (verificarTiempoDeAutomatizacion()) {
								System.out.println("hay que bajarla");
								bajarTemperatura();
								System.out.println(this.temp.getValor());
								setInicio();
								if (verificarRango()) {
									ret = false;
									aireAcondicionado.apagarAireAcondicionado();
								}
							}
						}
					} else {
						aireAcondicionado.cambiarFrioCalor();
						boolean ret1 = true;
						while (ret1) {
							if (verificarTiempoDeAutomatizacion()) {
								System.out.println("hay que subirla");
								subirTemperatura();
								System.out.println(this.temp.getValor());
								setInicio();
								if (verificarRango()) {
									ret1 = false;
									aireAcondicionado.apagarAireAcondicionado();
								}
							}
						}
					}
				} else {
					System.out.println("La temperatura se encuentra dentro del rango establecido.");
					this.temp.setValor(25.0);
					setInicio();
				}
			}
		}
	}

	public static void main(String[] args) {

		Temperatura temp = new Temperatura(10.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizacionDeClima automatizacion = new AutomatizacionDeClima(temp, rango, 1000);
		automatizacion.start();

	}

}
