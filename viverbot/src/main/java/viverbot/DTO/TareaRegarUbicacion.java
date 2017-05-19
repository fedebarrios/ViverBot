package viverbot.DTO;

public class TareaRegarUbicacion extends Tarea{

	public TareaRegarUbicacion(UbicacionDTO ubicacion) {
		super(ubicacion);
	}
	
	@Override
	public void ejecutarTarea() {
		System.out.println("Estoy regando la ubicacion " + ubicacion.getIndice());
	}

}
