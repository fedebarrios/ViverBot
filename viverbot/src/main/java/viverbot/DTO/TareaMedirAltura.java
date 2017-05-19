package viverbot.DTO;

public class TareaMedirAltura extends Tarea{

	public TareaMedirAltura(UbicacionDTO ubicacion, TipoTarea tipoTarea) {
		super(ubicacion, tipoTarea);
	}
	
	@Override
	public void ejecutarTarea() {
		System.out.println("Estoy midiendo la altura de la ubicacion " + ubicacion.getIndice());
	}

}
