package com.losameos.viverbot.Controller.Verificacion;

import java.util.ArrayList;

import com.losameos.viverbot.Model.Ubicacion;
import com.losameos.viverbot.Model.Magnitudes.Humedad;
import com.losameos.viverbot.Model.Medicion.ColectorHumedad;

public class TransmisorHumedad extends Transmisor {
	private AnalizadorHumedad analizador;
	ArrayList<Ubicacion> ubicaciones;

	public TransmisorHumedad() {
		super(new ColectorHumedad());
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
					((ColectorHumedad) this.colector).mover(this.ubicaciones.get(i));
					realizarMedicion();
					if (this.valorActual != null) {
						this.analizador.analizar((Humedad) this.valorActual, this.ubicaciones.get(i));
						this.setearTiempoInicio();
					}
				} else {
					i--;
				}
			}

		}
	}

}
