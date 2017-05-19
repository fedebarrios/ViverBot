package viverbot.DTO;

public abstract class Tarea {
	protected UbicacionDTO ubicacion;
	protected TipoTarea tipoTarea;
	
	public Tarea(UbicacionDTO ubicacion, TipoTarea tipoTarea) {
		this.ubicacion = ubicacion;
		this.tipoTarea = tipoTarea;
	}

	public UbicacionDTO mostrarUbicacion(){
		return this.ubicacion;
	}
	
	public TipoTarea mostrarTipoTarea(){
		return this.tipoTarea;
	}
	
	public void ejecutarTarea(){
		
	}
}
