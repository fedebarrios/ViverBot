package viverbot.Model;

import java.util.Map;

import viverbot.Archivos.CalculadorHistorial;
import viverbot.DTO.Especie;
import viverbot.Modelo.Magnitudes.Medicion;

public class HistorialOptimo extends HistorialAltura{
	
	private Especie especie;
	
	public HistorialOptimo(Map<Integer,Medicion> mapa, Especie especie) throws Exception{
		super();
		this.historial = mapa;
		this.especie = especie;
		if(!CalculadorHistorial.hayInfoValida(this,especie)){
			throw new Exception("Falta informacion acerca de la especie");
		}
		if(!CalculadorHistorial.calcularDiferencia(this)){
			throw new Exception("Por favor ingrese un historial mas consistente");
		}
	}

	public Especie getEspecie() {
		return especie;
	}
	
	public void setEspecie(Especie e){
		this.especie = e;
	}
}
