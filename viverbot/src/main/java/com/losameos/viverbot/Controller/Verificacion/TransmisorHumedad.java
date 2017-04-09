package com.losameos.viverbot.Controller.Verificacion;

import java.util.ArrayList;

import com.losameos.viverbot.Model.SoporteMovible;
import com.losameos.viverbot.Model.Ubicacion;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class TransmisorHumedad extends Transmisor {
	private AnalizadorHumedad analizador;
	private ArrayList<Ubicacion> ubicaciones;
	private static Magnitudes m = Magnitudes.HUMEDAD;
	private SoporteMovible soporte;

	public TransmisorHumedad(SoporteMovible soporte) {
		super(soporte.getColector());
		this.soporte = soporte;
		this.analizador = new AnalizadorHumedad();
		this.ubicaciones = new ArrayList<Ubicacion>();
		this.ubicaciones.add(new Ubicacion(10, 10));
	}

	@Override
	protected void Trasnmitir() {
		this.setearTiempoInicio();
		while (true) {
			for (int i = 0; i < this.ubicaciones.size(); i++) {
				if (this.verificarTiempoTranscurrido()) {
					this.soporte.mover(this.ubicaciones.get(i));
					System.out.println("La humedad es: "+ this.colector.tomarMedicion());
					
				} else {
					i--;
				}
			}

		}
	}

}
