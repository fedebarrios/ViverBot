package viverbot.DTO;

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
	
	public int getVertices()
	{
		return vertices;
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
