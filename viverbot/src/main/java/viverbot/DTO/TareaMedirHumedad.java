package viverbot.DTO;

public class TareaMedirHumedad extends Tarea {

	public TareaMedirHumedad(UbicacionDTO ubicacion, TipoTarea tipoTarea) {
		super(ubicacion, tipoTarea);
	}
	
	@Override
	public void ejecutarTarea() {
		System.out.println("Estoy midiendo la humedad de la ubicacion " + ubicacion.getIndice());
	}

}
