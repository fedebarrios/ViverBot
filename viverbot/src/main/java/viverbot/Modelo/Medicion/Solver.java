package viverbot.Modelo.Medicion;

import java.util.ArrayList;
import java.util.Stack;

import viverbot.DTO.Arista;
import viverbot.DTO.Grafo;

public class Solver {
	
	Grafo g;
	
	public Solver()
	{
		g = this.generarGrafo(gestorBaseDatos.getCantidadLocalidades(), gestorBaseDatos.getAristas());
	}
	
	//devuelve una lista de las aristas por q componen el camino minimo
	public ArrayList<Arista> caminoMinimo(int inicio, int fin)
	{
		if(inicio==fin)
		{
			return null;
		}
		
		Stack<Integer> camino = this.calcularCamino(inicio, fin);
		return this.generarAristas(camino);
		
		
	}
	
	//aplica e algoritmo de dikstra a el grafo
	private Stack<Integer> calcularCamino(int inicio, int fin)
	{
		AnalizadorDickstra dickstra = new AnalizadorDickstra(g);
		return dickstra.Dickstra(inicio, fin);
	}

	//devuelve un grafo generado a partir de las aristas de base de datos
	private Grafo generarGrafo(int n, ArrayList<Arista> listaAristas)
	{
		Grafo g = new Grafo(n);
		
		for(Arista arista: listaAristas){
			g.agregarArista(arista.getUbicacionA(), arista.getUbicacionB(), arista.getDistancia());
		}
				
		return g;
			
	}
	
	//devulve una lista de las aristas indicadas por la Pila
	private ArrayList<Arista> generarAristas(Stack<Integer> camino){

		
		int origen = camino.pop();
		ArrayList<Arista> ret = new ArrayList<Arista>();
		ArrayList<Localidad> localidades = gestorBaseDatos. getLocalidades();

		while(camino.size() > 0)
		{
			int destino = camino.pop();
			double distancia = gestorBaseDatos.mostrarDistancia(localidades.get(origen), localidades.get(destino));
			Arista aux = new Arista(localidades.get(origen), localidades.get(destino), distancia);
			ret.add(aux);
			origen = destino;
		}
		return ret;
	}
	
	
	//devukve la sitania total del camino minimo entre dos nodos
	public Double  distanciaTotal(int inicio, int fin)
	{
		if(inicio==fin)
		{
			return 0.0;
		}
		
		Stack<Integer> camino = this.calcularCamino(inicio, fin);
		return this.calcularDistancia(camino);
		
	}

	//calcula la distacia total del camino minimo entre dos nodos
	private Double calcularDistancia(Stack<Integer> camino) {
		
		Double ret = 0.0;
		int origen = camino.pop();
		
		while(camino.size() > 0)
		{
			int destino = camino.pop();
			ret = ret + g.getArista(origen, destino);
			origen = destino;
			
		}
		
		return ret;
		
	}
}
