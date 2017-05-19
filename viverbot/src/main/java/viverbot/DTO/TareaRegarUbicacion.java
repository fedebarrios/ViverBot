package viverbot.DTO;

public class TareaRegarUbicacion extends Tarea{

	public TareaRegarUbicacion(UbicacionDTO ubicacion, TipoTarea tipoTarea) {
		super(ubicacion, tipoTarea);
	}
	
	@Override
	public void ejecutarTarea() {
		System.out.println("Estoy regando la ubicacion " + ubicacion.getIndice());
	}

}
