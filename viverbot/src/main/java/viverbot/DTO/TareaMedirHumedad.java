package viverbot.DTO;

public class TareaMedirHumedad extends Tarea {

	public TareaMedirHumedad(UbicacionDTO ubicacion) {
		super(ubicacion);
	}
	
	@Override
	public void ejecutarTarea() {
		System.out.println("Estoy midiendo la humedad de la ubicacion " + ubicacion.getIndice());
	}

}
