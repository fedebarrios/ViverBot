package viverbot.Modelo.Medicion;

import java.util.ArrayList;
import java.util.Stack;
import viverbot.DAO.TerrenoDAO;
import viverbot.DTO.Arista;
import viverbot.DTO.Grafo;
import viverbot.DTO.UbicacionDTO;
 
public class AnalizadorCaminoMinimo {

	private Grafo g;
	private TerrenoDAO terreno;

	public AnalizadorCaminoMinimo() {
		this.terreno = TerrenoDAO.getInstance();
		g = this.generarGrafo(terreno.getTamanioTerreno(), generarAristas(terreno.getUbicaciones()));
	}

	public ArrayList<Arista> generarAristas(UbicacionDTO[][] ubicaciones) {
		ArrayList<Arista> listaAristas = new ArrayList<Arista>();
		int auxI = 0;
		int auxJ = 0;
		for (int i = 0; i < ubicaciones.length; i++) {
			for (int j = 0; j < ubicaciones[i].length; j++) {
				if(i==0 && j+1==ubicaciones[i].length){
					//Es la ubicacion de descanso
				}else{
					auxI = i + 1;
					auxJ = j + 1;
					if (auxI < ubicaciones.length) {
						listaAristas.add(new Arista(ubicaciones[i][j], ubicaciones[auxI][j], 1));
					}
					if (auxJ < ubicaciones[i].length) {
						listaAristas.add(new Arista(ubicaciones[i][j], ubicaciones[i][auxJ], 1));
					}
				}
			}
		}
		return listaAristas;
	}

	// devuelve una lista de las aristas por q componen el camino minimo
	public ArrayList<Arista> caminoMinimo(int inicio, int fin) {
		if (inicio == fin) { 
			return null;
		}

		Stack<Integer> camino = this.calcularCamino(inicio, fin);
		return this.generarAristas(camino);
	}

	// aplica e algoritmo de dikstra a el grafo
	private Stack<Integer> calcularCamino(int inicio, int fin) {
		AnalizadorDickstra dickstra = new AnalizadorDickstra(g);
		return dickstra.Dickstra(inicio, fin);
	}

	// devuelve un grafo generado a partir de las aristas de base de datos
	private Grafo generarGrafo(int n, ArrayList<Arista> listaAristas) {
		Grafo g = new Grafo(n);

		for (Arista arista : listaAristas) {
	//		System.out.println(arista.getUbicacionA().getIndice()+" " +" " +arista.getUbicacionB().getIndice());
			g.agregarArista(arista.getUbicacionA().getIndice(), arista.getUbicacionB().getIndice(),
					arista.getDistancia());
			
		}

		return g;

	}

	// devulve una lista de las aristas indicadas por la Pila
	private ArrayList<Arista> generarAristas(Stack<Integer> camino) {

		int origen = camino.pop();
		ArrayList<Arista> ret = new ArrayList<Arista>();
		ArrayList<UbicacionDTO> ubicaciones = terreno.getListaUbicaciones();

		while (camino.size() > 0) {
			int destino = camino.pop();
			double distancia = 1;
			Arista aux = new Arista(ubicaciones.get(origen), ubicaciones.get(destino), distancia);
			ret.add(aux);
			origen = destino;
		}
		return ret;
	}
}
