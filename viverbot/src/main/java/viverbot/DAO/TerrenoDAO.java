package viverbot.DAO;

import viverbot.DTO.UbicacionDTO;
import viverbot.Modelo.Magnitudes.Temperatura;

public class TerrenoDAO {
	
	private UbicacionDTO[][] ubicaciones;
	private static TerrenoDAO terreno;
	private static Temperatura temperatura;
	 
	public void construirTerreno(int cantFilas, int cantColumnas){
		ubicaciones = new UbicacionDTO[cantFilas][cantColumnas];
		for (int i = 0; i < cantFilas; i++) {
			for (int j = 0; j < cantColumnas; j++) {
				UbicacionDTO ubicacion = new UbicacionDTO(i, j);
				ubicaciones[i][j] = ubicacion;
			}
		}
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
	
	public UbicacionDTO[][] mostrarTerreno(){
		return ubicaciones;
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
}
