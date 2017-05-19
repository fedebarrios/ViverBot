package viverbot.DAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import viverbot.DTO.Planta;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.Fecha;

public class PlantaDAO {

	private ArrayList<Planta> plantas;
	public static PlantaDAO plantaDAO;

	public PlantaDAO() {
		plantas = new ArrayList<Planta>();
		cargarPlantasHarcodeadas();
	}
	
	public void cargarPlantas(List<Planta> plantas){
		this.plantas = (ArrayList<Planta>) plantas;
	}

	private void cargarPlantasHarcodeadas() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				@SuppressWarnings("deprecation")
				Planta p = new Planta(1, i++, new UbicacionDTO(i * j, i * j,(((i*j)+1)*(i*j))-1), new Fecha(02, 05, 2017));
				plantas.add(p);
			} 
		}
	}

	public Planta obtenerPlanta(int codPlanta) {
		int longitud = this.plantas.size();
		for (int i = 0; i < longitud; i++) {
			if (plantas.get(i).getCodigoPlanta() == codPlanta)
				return plantas.get(i);
		}
		return null;
	}

	public ArrayList<Planta> obtenerPlantas(int codEspecie) {
		ArrayList<Planta> aux = new ArrayList<Planta>();
		for (Planta p : plantas) {
			if (p.getCodigo() == codEspecie)
				aux.add(p);
		}
		return aux;
	}

	public int obtenerUltimoCodigo() {
		int longitud = this.plantas.size();
		if(longitud==0){
			return 9949;
		}else{
			return this.plantas.get(longitud-1).getCodigoPlanta();
		}
	}

	public void borrarPlanta(int codPlanta) {
		int indice = 0;
		for (int i = 0; i < plantas.size(); i++) {
			if (plantas.get(i).getCodigoPlanta() == codPlanta)
				indice = i;
		}
		plantas.remove(indice);
	}

	public void agregarPlanta(Planta plantaDTO) {
		this.plantas.add(plantaDTO);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Planta> obtenerPlantas() {
		return (ArrayList<Planta>) this.plantas.clone();
	}

	public static PlantaDAO getInstance(){                        
		if(plantaDAO==null){
			plantaDAO = new PlantaDAO();
		}
		return plantaDAO;
	}

	public Planta obtenerPlantaEspecifica(int codPlanta) {
		for (int i=0; i<plantas.size(); i++){
			if( plantas.get(i).getCodigoPlanta()==codPlanta){
				return plantas.get(i);
			}
		}
		return null;
	}
	
	public int cantidadPlantas(){
		return plantas.size();
	}
}
