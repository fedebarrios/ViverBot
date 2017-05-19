package viverbot.DTO;

public abstract class Tarea {
	protected UbicacionDTO ubicacion;
	
	public Tarea(UbicacionDTO ubicacion) {
		this.ubicacion = ubicacion;
	}

	public UbicacionDTO mostrarUbicacion(){
		return this.ubicacion;
	}
	
	public void ejecutarTarea(){
		
	}
}
