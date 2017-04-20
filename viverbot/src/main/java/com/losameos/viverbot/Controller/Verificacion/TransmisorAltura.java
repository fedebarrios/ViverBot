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

public class TransmisorAltura extends Transmisor{
	private AnalizadorAltura analizadorAltura;
	private static Magnitudes m = Magnitudes.ALTURA;
	private ArrayList<PlantaDTO> listadoPlantas;
	private static long inicio = 0;
	private static long frecuenciaDeRepeticion = 8000;
	private SoporteMovible soporte;
	private ControlSeguimientos seguimientos;
	private Plantas plantas;

	public TransmisorAltura(SoporteMovible soporte) {
		super(soporte.getColector());
		plantas = new Plantas();
		analizadorAltura = new AnalizadorAltura();
		listadoPlantas = new ArrayList<PlantaDTO>();
		listadoPlantas.add(plantas.obtenerPlantaEspecifica(1));
		seguimientos = ControlSeguimientos.getInstance();
	}
	
	@Override
	protected void Trasnmitir() {
		System.out.println("Empezo la automatizacion en el control de la altura:");
		this.setearTiempoInicio();
		while (true) {

			if (this.verificarTiempo()) {
				if(listadoPlantas.size()==0){
					System.out.println("No hay plantas para analizar");
				} 
				else{
					//Por cada planta del listado, pido tomarle la medida y la mando a analizar
					for (int i=0; i<listadoPlantas.size(); i++){
						soporte =  SoporteFactory.crearSoporte(Magnitudes.ALTURA);
						//Le indico al soporte la posicion a la cual moverse
						this.soporte.mover(listadoPlantas.get(i).getUbicacion());
						realizarMedicion();
						//Me fijo si el metro pudo medir
						if (this.valorActual != null) {
							//Busco el seguimiento asociado a la planta en cuestion
							SeguimientoAltura seguimientoBuscado = seguimientos.getSeguimiento(listadoPlantas.get(i));
							if ( seguimientoBuscado!= null){
								//La mando a analizar
								this.analizadorAltura.analizarExaustivo(this.valorActual, seguimientoBuscado, false);
								//Si el estado es defectuoso, le pido al podador que la pode
								if(seguimientoBuscado.getEstado().equals("Defectuosa")){
									if(soporte.getPodador().podar(listadoPlantas.get(i))){
										System.out.println("La planta se ha podado");
										listadoPlantas.remove(i);
									}
									else{
										System.out.println("No se pudo podar la planta");
									}
								}
								
							}
							else{
								System.out.println("No hay un seguimiento asociado a la planta "+ listadoPlantas.get(i).getCodigoPlanta());
							}
						} else {
							System.out.println("El metro se rompio");
						}
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

	public void setListadoPlantas(ArrayList<PlantaDTO> plantasVacias) {
		listadoPlantas = plantasVacias;
		
	}
}
