package com.losameos.viverbot.Controller.Verificacion;

import java.util.ArrayList;

import com.losameos.viverbot.DTO.UbicacionDTO;
import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.SoporteMovible;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class TransmisorHumedad extends Transmisor {
	private ArrayList<UbicacionDTO> ubicaciones;
	private static Magnitudes m = Magnitudes.HUMEDAD;
	private SoporteMovible soporte;
	private static Hora horaInicio = new Hora(6, 0, 0);

	public TransmisorHumedad(SoporteMovible soporte) {
		super(soporte.getColector());
		this.soporte = soporte;
		this.ubicaciones = new ArrayList<UbicacionDTO>();
		this.ubicaciones.add(new UbicacionDTO(10, 10));
	}

	@Override
	protected void Trasnmitir() {
		while (true) {
			if (this.verificarTiempo()) {
				for (int i = 0; i < this.ubicaciones.size(); i++) {

					this.soporte.mover(this.ubicaciones.get(i));
					System.out.println("La humedad es: " + this.colector.tomarMedicion().getValor());

				}
			}

		}
	}

	@Override
	protected boolean verificarTiempo() {
		return Hora.obtenerHoraActual().compareTo(horaInicio) > 0;
	}
	
	public static Magnitudes getTipoMagnitud(){
		return m;
	}

}
