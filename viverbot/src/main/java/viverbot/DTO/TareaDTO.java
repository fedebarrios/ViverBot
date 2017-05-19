package viverbot.DTO;

public class TareaDTO {
	private UbicacionDTO ubicacion;
	private TipoTarea tipoTarea;
	
	public TareaDTO(UbicacionDTO ubicacion, TipoTarea tipoTarea) {
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
