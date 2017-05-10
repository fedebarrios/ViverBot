package viverbot.DTO;

public class Arista {
	
	private UbicacionDTO ubicacionA, ubicacionB;
	private double distancia;
	
	public Arista(UbicacionDTO ubicacionA, UbicacionDTO ubicacionB, double distancia)
	{
		this.ubicacionA = ubicacionA;
		this.ubicacionB = ubicacionB;
		this.distancia = distancia;
	}

	public UbicacionDTO getUbicacionA() 
	{
		return ubicacionA;
	}

	public UbicacionDTO getUbicacionB() 
	{
		return ubicacionB;
	}
	
	public double getDistancia() 
	{
		return distancia;
	}
}
