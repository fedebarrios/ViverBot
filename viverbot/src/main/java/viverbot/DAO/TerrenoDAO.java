package viverbot.DAO;

import java.util.ArrayList;

import viverbot.DTO.UbicacionDTO;
import viverbot.Modelo.Magnitudes.Temperatura;

public class TerrenoDAO {
	
	private UbicacionDTO[][] ubicaciones;
	private static TerrenoDAO terreno;
	private static Temperatura temperatura;
	private int tamanioTerreno;
	 
	public void construirTerreno(int cantFilas, int cantColumnas){
		ubicaciones = generarMatrizIrregularTerreno(cantFilas, cantColumnas);
		tamanioTerreno = cantFilas * cantColumnas;
		int indice = 0;
		for (int i = 0; i < cantFilas; i++) {
			for (int j = 0; j < cantColumnas; j++) {
				UbicacionDTO ubicacion = new UbicacionDTO(i, j, indice);
				ubicaciones[i][j] = ubicacion;
				indice++;
			} 
		}
		tamanioTerreno++;
	}
	
	private UbicacionDTO[][] generarMatrizIrregularTerreno(int cantFilas, int cantColumnas){
		ubicaciones = new UbicacionDTO[cantFilas][];
		for (int i = 0; i < cantFilas; i++) {
			if(i==0){
				ubicaciones[i]=new UbicacionDTO[cantColumnas+1];
				continue;
			}
			ubicaciones[i]=new UbicacionDTO[cantColumnas];
		}
		int indicePosicionDescanso = mostrarTamañoTerreno()-1;
		ubicaciones[0][cantColumnas]= new UbicacionDTO(0, cantColumnas, indicePosicionDescanso);
		return ubicaciones;
	}
	
	public boolean ocuparUbicacion(UbicacionDTO ubicacion){
		int fila = ubicacion.getFila();
		int columna = ubicacion.getColumna();
		if(!ubicaciones[fila][columna].isEstado()){
			ubicaciones[fila][columna].setEstado(true);
			return true;
		}
		else return false;
	}
	
	public boolean desocuparUbicacion(UbicacionDTO ubicacion){
		int fila = ubicacion.getFila();
		int columna = ubicacion.getColumna();
		if(ubicaciones[fila][columna].isEstado()){
			ubicaciones[fila][columna].setEstado(false);
			return true;
		}
		else return false;
	}
	
	public Integer mostrarTamañoTerreno(){
		int indice=1;
		if(this.ubicaciones!=null){
			for (int i = 0; i < ubicaciones.length; i++) {
				for (int j = 0; j < ubicaciones[i].length; j++) {
					if(i==0 && j+1==ubicaciones[i].length){
						
					}else{
						indice++;
					}
				}
			}
		}
		return indice;
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
	
	public UbicacionDTO[][] getUbicaciones(){
		return ubicaciones;
	}
	
	public UbicacionDTO mostrarUbicacionDescanso(){
		int primerFila = 0;
		int columnaDescanso = ubicaciones[primerFila].length;
		return ubicaciones[primerFila][columnaDescanso];
	}
	
	public static void setTemperatura(Temperatura t){
		temperatura = t;
	}
	
	public static TerrenoDAO getInstance(){
		if(terreno==null){
			terreno = new TerrenoDAO();
		}
		return terreno;
	}
	
	public int getTamanioTerreno(){
		return tamanioTerreno;
	}
}
