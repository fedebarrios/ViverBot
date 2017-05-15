package viverbot.Model;

import java.util.ArrayList;
import java.util.List;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.DTO.PlantaDTO;

public class BuscadorEstadoAltura {
	private List<EstadoAltura> estados;
	private static BuscadorEstadoAltura buscador;
	
	public BuscadorEstadoAltura(){
		this.estados = new ArrayList<EstadoAltura>();
	};
	
	public static BuscadorEstadoAltura getInstance(){
		if(buscador == null ){
			buscador = new BuscadorEstadoAltura();
		}
		return buscador;
	}
	
	public EstadoAltura obtenerEstado(double valorCrecimiento, double diferenciaAltura , PlantaDTO planta){
		for (EstadoAltura estado : estados){
			if (valorCrecimiento < estado.getValorMax() && valorCrecimiento < estado.getValorMin()){
				return estado;
			}		
		}
		return null;
	}
	
	public void setEstados (List<EstadoAltura> estados) {
		this.estados = estados;
	}
}
