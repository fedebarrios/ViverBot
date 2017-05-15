package viverbot.Model;

import java.util.ArrayList;

import viverbot.DAO.EspecieDAO;
import viverbot.DAO.PlantaDAO;
import viverbot.DTO.EspecieDTO;

public class Inventario {
	private EspecieDAO especieDAO;
	
	public Inventario(){
		this.especieDAO = EspecieDAO.getInstance();
	}
	
	public ArrayList<EspecieDTO> obtenerEspecies(){
		return especieDAO.leer();
	}
	
	public void agregarEspecie(String nombreEspecie, String nombreCientifico, String pathAlmacenado){
		EspecieDTO especieDTO = new EspecieDTO(especieDAO.obtenerUltimoCodigo()+1, nombreEspecie, nombreCientifico, pathAlmacenado);
		especieDAO.agregar(especieDTO);
	}
	
	public void borrarEspecie(int codEspecie){
		especieDAO.borrarEspecie(codEspecie);
	}
	
	public EspecieDTO obtenerEspecie(int codEspecie){
		return especieDAO.obtenerEspecie(codEspecie);
	}
	
	public boolean existeEspecie(EspecieDTO especie){
		return especieDAO.existeEspecie(especie);
	}
}
