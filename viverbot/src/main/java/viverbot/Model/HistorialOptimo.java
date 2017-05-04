package viverbot.Model;

import java.util.List;

import viverbot.DTO.EspecieDTO;

public class HistorialOptimo extends HistorialAltura{
	
	private EspecieDTO especie;
	
	public HistorialOptimo(List<TuplaAltura> lista, EspecieDTO especie){
		super(lista);
		this.especie = especie;
	}

	public EspecieDTO getEspecie() {
		return especie;
	}
}
