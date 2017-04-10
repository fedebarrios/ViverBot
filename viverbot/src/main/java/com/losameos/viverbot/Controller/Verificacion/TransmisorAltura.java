package com.losameos.viverbot.Controller.Verificacion;

import java.util.ArrayList;

import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.Model.SoporteFactory;
import com.losameos.viverbot.Model.SoporteMovible;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.Colector;

public class TransmisorAltura extends Transmisor{
	private AnalizadorAltura analizadorAltura;
	private static Magnitudes m = Magnitudes.ALTURA;
	private ArrayList<PlantaDTO> plantas;
	private static long inicio = 0;
	private static long frecuenciaDeRepeticion = 3000;
	private SoporteMovible soporte;

	public TransmisorAltura() {
		super(new Colector(m));
		analizadorAltura = new AnalizadorAltura();
		plantas = new Plantas().obtenerPlantas();
	}
	
	@Override
	protected void Trasnmitir() {
		System.out.println("Empezo la automatizacion jeje");
		this.setearTiempoInicio();
		while (true) {

			if (this.verificarTiempo()) {
				for (int i=0; i<plantas.size(); i++){
					soporte =  SoporteFactory.crearSoporte(Magnitudes.ALTURA);
					this.soporte.mover(plantas.get(i).getUbicacion());
					realizarMedicion();
					if (this.valorActual != null) {
						this.analizadorAltura.analizar(this.valorActual, plantas.get(i));
					} else {
						System.out.println("El metro se rompio");
					}
				}
				this.setearTiempoInicio();
			}
		}
	}
	
	@Override
	protected boolean verificarTiempo() {

		return Hora.tiempoTranscurrido(inicio) >= frecuenciaDeRepeticion;

	}

	protected void setearTiempoInicio() {
		inicio = Hora.instanteActual();
	}

	public static Magnitudes getTipoMagnitud(){
		return m;
	}
}
