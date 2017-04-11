package com.losameos.viverbot.DAO;

import java.sql.Date;
import java.util.ArrayList;
import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.DTO.UbicacionDTO;

public class PlantaDAO {

	private ArrayList<PlantaDTO> plantas;

	public PlantaDAO() {
		plantas = new ArrayList<PlantaDTO>();
		inicializar();
	}

	private void inicializar() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				@SuppressWarnings("deprecation")
				PlantaDTO p = new PlantaDTO(1, i++, new UbicacionDTO(i * j, i * j), new Date(10, 10, 2017));
				plantas.add(p);
			}
		}
	}

	public PlantaDTO obtenerPlanta(int codPlanta) {
		int longitud = this.plantas.size();
		for (int i = 0; i < longitud; i++) {
			if (plantas.get(i).getCodigoPlanta() == codPlanta)
				return plantas.get(i);
		}
		return null;
	}

	public ArrayList<PlantaDTO> obtenerPlantas(int codEspecie) {
		ArrayList<PlantaDTO> aux = new ArrayList<PlantaDTO>();
		for (PlantaDTO p : plantas) {
			if (p.getCodigo() == codEspecie)
				aux.add(p);
		}
		return aux;
	}

	public int obtenerUltimoCodigo() {
		int longitud = this.plantas.size();
		return this.plantas.get(longitud).getCodigoPlanta();
	}

	public void borrarPlanta(int codPlanta) {
		int indice = 0;
		for (int i = 0; i < plantas.size(); i++) {
			if (plantas.get(i).getCodigoPlanta() == codPlanta)
				indice = i;
		}
		plantas.remove(indice);
	}

	public void agregarPlanta(PlantaDTO plantaDTO) {
		this.plantas.add(plantaDTO);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<PlantaDTO> obtenerPlantas() {
		return (ArrayList<PlantaDTO>) this.plantas.clone();
	}
}
