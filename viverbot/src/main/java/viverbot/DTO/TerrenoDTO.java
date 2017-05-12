package viverbot.DTO;

import java.util.ArrayList;

import viverbot.Modelo.Magnitudes.Temperatura;

public class TerrenoDTO {
	private UbicacionDTO[][] ubicaciones;
	private Temperatura temperatura;
	private Integer tamañoTerreno;
	
	public TerrenoDTO(UbicacionDTO[][] ubicaciones, Temperatura temperatura) {
		this.ubicaciones = ubicaciones;
		this.temperatura = temperatura;
		this.tamañoTerreno = mostrarTamañoTerreno();
	}
	
	private Integer mostrarTamañoTerreno(){
		int indice=0;
		if(this.ubicaciones!=null){
			for (int i = 0; i < ubicaciones.length; i++) {
				for (int j = 0; j < ubicaciones.length; j++) {
					indice++;
				}
			}
		}
		return indice;
	}
	
	public Integer getTamañoTerreno() {
		return tamañoTerreno;
	}

	public void setTamañoTerreno(Integer tamañoTerreno) {
		this.tamañoTerreno = tamañoTerreno;
	}
	public ArrayList<UbicacionDTO> getListaUbicaciones() {
		ArrayList<UbicacionDTO> listaUbicaciones = new ArrayList<UbicacionDTO>();
		for (int i = 0; i < ubicaciones.length; i++) {
			for (int j = 0; j < ubicaciones.length; j++) {
				listaUbicaciones.add(ubicaciones[i][j]);
			}
		}
		return listaUbicaciones;
	}
	public UbicacionDTO[][] getUbicaciones() {
		return ubicaciones;
	}
	public void setUbicaciones(UbicacionDTO[][] ubicaciones) {
		this.ubicaciones = ubicaciones;
	}
	public Temperatura getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Temperatura temperatura) {
		this.temperatura = temperatura;
	}

}
