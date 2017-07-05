package viverbot.DAO;

import java.util.ArrayList;
import java.util.List;

import viverbot.DTO.Especie;

public class EspecieDAO {
	
	private ArrayList<Especie> especies ;
	public static EspecieDAO especieDAO;
	
	public EspecieDAO() {
		this.especies = new ArrayList<Especie>();
	}
	
	public void cargarEspeciesHarcodeadas(){
		this.especies.add(new Especie(1, "Rosa","Rosus",""));
		this.especies.add(new Especie(2, "Margarita","Margaritus",""));
		this.especies.add(new Especie(3, "Amapola","Amapolus",""));
	}
	
	public void cargarEspecies(List<Especie> especies){
		this.especies = (ArrayList<Especie>) especies;
	}
	
	public void agregar(Especie especie){
		this.especies.add(especie);
	}
	
	public ArrayList<Especie> leer() {
		return especies;
	}
	
	public void borrarEspecie(int codEspecie){
		int indice=0;
		for( int i = 0; i< especies.size() ; i++){
			if (especies.get(i).getCodEspecie()==codEspecie) indice=i;
		}
		especies.remove(indice);
	}
	
	public int obtenerUltimoCodigo(){
		int longitud = this.especies.size();
		if(longitud!=0) return this.especies.get(longitud-1).getCodEspecie();
		return longitud;
	}
	
	public Especie obtenerEspecie(int codEspecie){
		int longitud = this.especies.size();
		for(int i=0; i<longitud; i++){
			if(especies.get(i).getCodEspecie()==codEspecie) return especies.get(i);
		}
		return null;
	}
	
	public Especie obtenerEspeciePorNombre(String nombre){
		int longitud = this.especies.size();
		for(int i=0; i<longitud; i++){
			if(especies.get(i).getNombre().equals(nombre)) return especies.get(i);
		}
		return null;
	}
	
	public static EspecieDAO getInstance(){                        
		if(especieDAO==null){
			especieDAO = new EspecieDAO();
		}
		return especieDAO;
	}

	public boolean existeEspecie(Especie especie) {
		for(Especie e : especies){
			if(e.equals(especie)){
				return true;
			}
		}
		return false;
	}
}
