package com.losameos.viverbot.Model.Medicion;

import com.losameos.viverbot.Model.Fecha;
import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class AutomatizacionDeClimaState extends Thread {
	private Temperatura temp;
	private RangoNumerico rango;
	private AireAcondicionadoState aireAcondicionado;
	private long inicio = 0;
	private final long frecuenciaDeAutomatizacion = 1000;
	private long frecuenciaDeControl;

	public AutomatizacionDeClimaState(Temperatura temp, RangoNumerico rango, long frecuenciaDeControl) {
		this.temp = temp;
		this.rango = rango;
		this.frecuenciaDeControl = frecuenciaDeControl;
		this.aireAcondicionado = new AireAcondicionadoState();
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
	
	private void frioState(){
		this.aireAcondicionado.frioState();
	}
	
	private void calorState(){
		this.aireAcondicionado.calorState();
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
					if (temp.getValor() > rango.getMaximo()) {
						frioState();
						this.aireAcondicionado.estableceCalculadorDePotencia(this.temp, this.rango);
						this.aireAcondicionado.setFechaDeInicio(Fecha.obtenerFechaActual());
						this.aireAcondicionado.setHoraDeInicio(Hora.obtenerHoraActual());
						boolean ret = true;
						while (ret) {
							if (verificarTiempoDeAutomatizacion()) {
								System.out.println("hay que bajarla");
								this.aireAcondicionado.interferirTemperatura(this.temp);
								System.out.println(this.temp.getValor());
								setInicio();
								if (verificarRango()) {
									ret = false;
									this.aireAcondicionado.setFechaDeFin(Fecha.obtenerFechaActual());
									this.aireAcondicionado.setHoraDeFin(Hora.obtenerHoraActual());
								}
							}
						}
					} else {
						calorState();
						this.aireAcondicionado.estableceCalculadorDePotencia(this.temp, this.rango);
						this.aireAcondicionado.setFechaDeInicio(Fecha.obtenerFechaActual());
						this.aireAcondicionado.setHoraDeInicio(Hora.obtenerHoraActual());
						boolean ret1 = true;
						while (ret1) {
							if (verificarTiempoDeAutomatizacion()) {
								System.out.println("hay que subirla");
								this.aireAcondicionado.interferirTemperatura(this.temp);
								System.out.println(this.temp.getValor());
								setInicio();
								if (verificarRango()) {
									ret1 = false;
									this.aireAcondicionado.setFechaDeFin(Fecha.obtenerFechaActual());
									this.aireAcondicionado.setHoraDeFin(Hora.obtenerHoraActual());
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

		Temperatura temp = new Temperatura(25.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizacionDeClimaState automatizacion = new AutomatizacionDeClimaState(temp, rango, 3000);
		automatizacion.start();

	}

}
