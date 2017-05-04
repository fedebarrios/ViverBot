package viverbot.Model;

import java.util.ArrayList;

import viverbot.DAO.PlantaDAO;
import viverbot.DTO.PlantaDTO;
import viverbot.DTO.UbicacionDTO;

public class Plantas {

	private PlantaDAO plantaDAO;

	public Plantas() {
		this.plantaDAO = PlantaDAO.getInstance();
	}

	public ArrayList<PlantaDTO> obtenerPlantas(int codEspecie) {
		return plantaDAO.obtenerPlantas(codEspecie);
	}
	
	public PlantaDTO obtenerPlanta(int codPlanta){
		return plantaDAO.obtenerPlanta(codPlanta);
	}
	
	public int obtenerUltimoCodigoPlanta(){
		return plantaDAO.obtenerUltimoCodigo();
	}
	
	public ArrayList<PlantaDTO> obtenerPlantas() {
		return plantaDAO.obtenerPlantas();
	}
	
	public PlantaDTO obtenerPlantaEspecifica( int codPlanta){
		return plantaDAO.obtenerPlantaEspecifica( codPlanta);
	}

	public boolean agregarPlanta(int codEspecie, String ubicacion, Fecha fecha) {
		UbicacionDTO ubicacionDTO = obtenerUbicacion(ubicacion);
		PlantaDTO plantaDTO = new PlantaDTO(codEspecie, obtenerUltimoCodigoPlanta()+1, ubicacionDTO, fecha);
		plantaDAO.agregarPlanta(plantaDTO);
		return false;
	}

	public void eliminarPlanta(int codPlanta) {
		plantaDAO.borrarPlanta(codPlanta);
	}

	public UbicacionDTO obtenerUbicacion(String ubicacion) {
		String fila = "";
		String columna = "";
		char aux;
		boolean filaCompleta = false;
		for (int i = 0; i < ubicacion.length(); i++) {
			aux = ubicacion.charAt(i);
			if (aux != ',') {
				if(!filaCompleta){
					fila += aux;
				}
			} else{
				filaCompleta = true;
				continue;
			}
			if (filaCompleta) {
				columna+= aux;
			}
		}
		return new UbicacionDTO(Integer.parseInt(fila), Integer.parseInt(columna));
	}
	
	public int cantidadPlantas(){
		return plantaDAO.cantidadPlantas();
	}
}
