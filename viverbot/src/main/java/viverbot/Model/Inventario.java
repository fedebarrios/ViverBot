package viverbot.Model;

import java.util.ArrayList;

import viverbot.DAO.EspecieDAO;
import viverbot.DTO.Especie;

public class Inventario {
	private EspecieDAO especieDAO;
	
	public Inventario(){
		this.especieDAO = EspecieDAO.getInstance();
	}
	
	public ArrayList<Especie> obtenerEspecies(){
		return especieDAO.leer();
	}
	
	public void agregarEspecie(String nombreEspecie, String nombreCientifico, String pathAlmacenado){
		Especie especieDTO = new Especie(especieDAO.obtenerUltimoCodigo()+1, nombreEspecie, nombreCientifico, pathAlmacenado);
		if(!existeEspecie(especieDTO)){
			especieDAO.agregar(especieDTO);	
		}
	}
	
	public void borrarEspecie(int codEspecie){
		especieDAO.borrarEspecie(codEspecie);
	}
	
	public Especie obtenerEspecie(int codEspecie){
		return especieDAO.obtenerEspecie(codEspecie);
	}
	
	public boolean existeEspecie(Especie especie){
		return especieDAO.existeEspecie(especie);
	}

	public int cantidadEspecies() {
		return especieDAO.leer().size();
	}
	
	public void cargarEspeciesHarcodeadas(){
		especieDAO.cargarEspeciesHarcodeadas();
	}
}
