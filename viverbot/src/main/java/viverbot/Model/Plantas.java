package viverbot.Model;

import java.util.ArrayList;

import viverbot.DAO.PlantaDAO;
import viverbot.DTO.Planta;
import viverbot.DTO.UbicacionDTO;

public class Plantas {

	private PlantaDAO plantaDAO;

	public Plantas() {
		this.plantaDAO = PlantaDAO.getInstance();
	}

	public ArrayList<Planta> obtenerPlantas(int codEspecie) {
		return plantaDAO.obtenerPlantas(codEspecie);
	}

	public Planta obtenerPlanta(int codPlanta) {
		return plantaDAO.obtenerPlanta(codPlanta);
	}

	public int obtenerUltimoCodigoPlanta() {
		return plantaDAO.obtenerUltimoCodigo();
	}

	public ArrayList<Planta> obtenerPlantas() {
		return plantaDAO.obtenerPlantas();
	}

	public Planta obtenerPlantaEspecifica(int codPlanta) {
		return plantaDAO.obtenerPlantaEspecifica(codPlanta);
	}

	public boolean agregarPlanta(int codEspecie, String ubicacion, Fecha fecha) {
		UbicacionDTO ubicacionDTO = obtenerUbicacion(ubicacion);
		Planta plantaDTO = new Planta(codEspecie, obtenerUltimoCodigoPlanta() + 1, ubicacionDTO, fecha);
		plantaDAO.agregarPlanta(plantaDTO);
		return false;
	}

	public void eliminarPlanta(int codPlanta) {
		plantaDAO.borrarPlanta(codPlanta);
	}

//	public UbicacionDTO obtenerUbicacion(String ubicacion) {
//		String fila = "";
//		String columna = "";
//		String indice = "";
//		char aux;
//		boolean filaCompleta = false;
//		boolean columnaCompleta = false;
//		for (int i = 0; i < ubicacion.length(); i++) {
//			aux = ubicacion.charAt(i);
//			if (aux != ',') {
//				if (!filaCompleta) {
//					fila += aux;
//				} else if (!columnaCompleta) {
//					columna += aux;
//				} else {
//					indice += aux;
//				}
//
//			} else {
//				filaCompleta = true;
//			}
//			if (filaCompleta && !columnaCompleta && aux != ',') {
//				columna += aux;
//			}
//			if (filaCompleta && aux == ',') {
//				columnaCompleta = true;
//				System.out.println("algo");
//			}
//			if (columnaCompleta && aux != ',') {
//				indice += aux;
//			}
//		}
//		System.out.println("-.-------------");
//		System.out.println(fila);
//		System.out.println(columna);
//		System.out.println(indice);
//		System.out.println("---------------");
//		return new UbicacionDTO(Integer.parseInt(fila), Integer.parseInt(columna), Integer.parseInt(indice));
//	}

	public UbicacionDTO obtenerUbicacion(String ubicacion) {
		String fila = "";
		String columna = "";
		String indice = "";
		ArrayList<String> arreglo = new ArrayList<String>();
		int indiceX = 0;
		char aux;
		boolean filaCompleta = false;
		boolean columnaCompleta = false;
		for (int i = 0; i < ubicacion.length(); i++) {
			aux = ubicacion.charAt(i);
			if (aux != ',') {
				fila += aux;
			} else {
				arreglo.add(fila.toString());
				fila="";
			}
		}
		arreglo.add(fila.toString());
		fila=arreglo.get(0);
		columna=arreglo.get(1);
		indice=arreglo.get(2);
		return new UbicacionDTO(Integer.parseInt(fila), Integer.parseInt(columna), Integer.parseInt(indice));
	}

	public int cantidadPlantas() {
		return plantaDAO.cantidadPlantas();
	}
}
