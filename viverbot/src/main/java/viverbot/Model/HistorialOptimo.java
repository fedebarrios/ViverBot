package viverbot.Model;

import java.util.List;

import viverbot.DTO.Especie;

public class HistorialOptimo extends HistorialAltura{
	
	private Especie especie;
	
	public HistorialOptimo(List<TuplaAltura> lista, Especie especie){
		super(lista);
		this.especie = especie;
	}

	public Especie getEspecie() {
		return especie;
	}
}
