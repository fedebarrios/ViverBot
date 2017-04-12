package com.losameos.viverbot.Controller.Verificacion;

import java.util.ArrayList;

import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.Model.ControlSeguimientos;
import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.Model.SeguimientoAltura;
import com.losameos.viverbot.Model.SoporteFactory;
import com.losameos.viverbot.Model.SoporteMovible;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Medicion.Colector;

public class TransmisorAltura extends Transmisor{
	private AnalizadorAltura analizadorAltura;
	private static Magnitudes m = Magnitudes.ALTURA;
	private ArrayList<PlantaDTO> listadoPlantas;
	private static long inicio = 0;
	private static long frecuenciaDeRepeticion = 5000;
	private SoporteMovible soporte;
	private ControlSeguimientos seguimientos;
	private Plantas plantas;

	public TransmisorAltura() {
		super(new Colector(m));
		plantas = new Plantas();
		analizadorAltura = new AnalizadorAltura();
		listadoPlantas = new ArrayList<PlantaDTO>();
		listadoPlantas.add(plantas.obtenerPlantaEspecifica(1,1));
		seguimientos = ControlSeguimientos.getInstance();
	}
	
	@Override
	protected void Trasnmitir() {
		System.out.println("Empezo la automatizacion");
		this.setearTiempoInicio();
		while (true) {

			if (this.verificarTiempo()) {
				for (int i=0; i<listadoPlantas.size(); i++){
					soporte =  SoporteFactory.crearSoporte(Magnitudes.ALTURA);
					this.soporte.mover(listadoPlantas.get(i).getUbicacion());
					realizarMedicion();
					if (this.valorActual != null) {
						SeguimientoAltura seguimientoBuscado = seguimientos.getSeguimiento(listadoPlantas.get(i));
						if ( seguimientoBuscado!= null){
							this.analizadorAltura.analizarExaustivo(this.valorActual, seguimientoBuscado );
						}
						else{
							System.out.println("No hay un seguimiento asociado a la planta "+ listadoPlantas.get(i).getCodigoPlanta());
						}
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
