package viverbot.Modelo.Medicion;

//esta clase se ocupa de implementar el algoritmo de dikstra para resolver el problema del camino minimo
import java.util.ArrayList;
import java.util.Stack;

import viverbot.DTO.Grafo;
import viverbot.DTO.Tupla;

public class AnalizadorDickstra {
	
	Grafo g;// el analizador siempre esta ligado a un grafo
	ArrayList<Tupla> camino;
	ArrayList<Integer> noVisitados;
	static final Double inf = Double.POSITIVE_INFINITY;
	
	public AnalizadorDickstra(Grafo _grafo)
	{
		g = _grafo;
		
		camino = new ArrayList<Tupla>();
		for(int i = 0; i < g.getVertices(); i++)
		{
			camino.add(new Tupla(inf, null));
		}
		
		noVisitados = new ArrayList<Integer>();
		
		for(Integer i = 0; i < g.getVertices(); i++)
		{
			noVisitados.add(i);
		}
	}
	
	//este es el metodo principal que realiza el dikjstra
	public Stack<Integer> Dickstra(Integer ini, Integer fin)
	{
		Stack<Integer> ret = new Stack<Integer>();
		camino.get(ini).setX(0.0);
		
		while(noVisitados.size() > 0)
		{
			Integer actual = this.nodoAmenorDistaciaTent();
			noVisitados.remove(actual);
			for(Integer elem : noVisitados)
			{
				if(g.isArista(actual, elem))
				{
					Double distancia = DistanciaTent(actual, elem);
					if(camino.get(elem).getX() > distancia)
					{
						camino.get(elem).setX(distancia);
						camino.get(elem).setY(actual);
					}
				}
			}
		}
		this.apilarCamino(fin, ret);

		return ret;
		
	}
	
	
	//toma los nodos estre inicio y fin y los pone en un pila
	private void apilarCamino(Integer fin, Stack<Integer> ret)
	{
		ret.push(fin);
		Integer actual = camino.get(fin).getY();
		
		while(actual != null)
		{
			ret.push(actual);
			actual = camino.get(actual).getY();
		}
		
	}
	
	//devuelve la distancia entre un sierto nodo destino y el nodo inicial
	private Double DistanciaTent(int actual, int destino) {
		
		return camino.get(actual).getX() + g.getArista(actual, destino);
	}
	
	//devuelve el nodo con menor distania tentativa
	private Integer nodoAmenorDistaciaTent() {

		Integer ret = noVisitados.get(0);
		Double distancia = camino.get(ret).getX();
		
		for(Integer num : noVisitados)
		{
			
			if(camino.get(num).getX() < distancia) 
			{
				distancia = camino.get(num).getX();
				ret = num;
			}
		}
		
		return ret;
	}


}
