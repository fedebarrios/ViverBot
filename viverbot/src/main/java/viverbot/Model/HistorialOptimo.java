package viverbot.Model;

import java.util.List;

import viverbot.Archivos.CalculadorHistorial;
import viverbot.DTO.Especie;

public class HistorialOptimo extends HistorialAltura{
	
	private Especie especie;
	
	public HistorialOptimo(List<TuplaAltura> lista, Especie especie) throws Exception{
		super(lista);
		this.especie = especie;
		if(!CalculadorHistorial.hayInfoValida(lista,especie)){
			throw new Exception("Falta informacion acerca de la especie");
		}
		if(!CalculadorHistorial.calcularDiferencia(lista)){
			throw new Exception("Por favor ingrese un historial mas consistente");
		}
	}

	public Especie getEspecie() {
		return especie;
	}
}
