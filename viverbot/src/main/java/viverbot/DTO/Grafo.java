package viverbot.DTO;

import java.util.ArrayList;

public class Grafo {
	
	private Double[][] _A;
	private int vertices;
	
	public Grafo(Integer tamanio)
	{
		_A = new Double[tamanio][tamanio];
		vertices = tamanio;
		for(int i = 0; i < vertices;i++)
		{
			for(int j = 0; j < vertices;j++)
			{
			_A[i][j] = -1.0;
			}
		}
	}
	
	public void agregarArista(int i , int j, double peso)
	{
		_A[i][j]= peso;
		_A[j][i]= peso;

	}
	
	public void borrarArista(int i, int j)
	{
		_A[i][j]= -1.0; // en vez de -1 va infinitoo
		_A[j][i]= -1.0; // en vez de -1 va infinitoo

	}
	
	public int getVertices()
	{
		return vertices;
	}
	

	
	public ArrayList<Integer> listaVecinos(int i)
	{
		ArrayList<Integer> aux= new ArrayList<Integer>();
		for(int j=0; j<getVertices(); j++)
		{
			if(isArista(i,j))
			{
				aux.add(j);
			}
		}
		return aux;
	}
	
	
	public boolean isArista(int i , int j)
	{
		return _A[i][j] >=0;
	}

	public double getArista(int i , int j)
	{
		return _A[i][j];
	}
}
