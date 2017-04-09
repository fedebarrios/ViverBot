package com.losameos.viverbot.Controller.Verificacion;

import java.util.ArrayList;

import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.SoporteMovible;
import com.losameos.viverbot.Model.Ubicacion;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class TransmisorHumedad extends Transmisor {
	private ArrayList<Ubicacion> ubicaciones;
	private static Magnitudes m = Magnitudes.HUMEDAD;
	private SoporteMovible soporte;
	private static Hora horaInicio = new Hora(6, 0, 0);

	public TransmisorHumedad(SoporteMovible soporte) {
		super(soporte.getColector());
		this.soporte = soporte;
		this.ubicaciones = new ArrayList<Ubicacion>();
		this.ubicaciones.add(new Ubicacion(10, 10));
	}

	@Override
	protected void Trasnmitir() {
		while (true) {
			if (this.verificarTiempo()) {
				for (int i = 0; i < this.ubicaciones.size(); i++) {

					this.soporte.mover(this.ubicaciones.get(i));
					System.out.println("La humedad es: " + this.colector.tomarMedicion());

				}
			}

		}
	}

	@Override
	protected boolean verificarTiempo() {
		return Hora.obtenerHoraActual().compareTo(horaInicio) > 0;
	}

}
