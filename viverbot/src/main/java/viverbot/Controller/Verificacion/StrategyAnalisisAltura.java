package viverbot.Controller.Verificacion;

import viverbot.DTO.PlantaDTO;
import viverbot.Interfaces.IAnalisisAltura;
import viverbot.Model.Magnitudes.Altura;
import viverbot.Model.Medicion.BuscadorEstadoAltura;

public class StrategyAnalisisAltura implements IAnalisisAltura{

	@Override
	public EstadoAltura analizar(Altura actual, Altura esperada , PlantaDTO planta) {
		
		double porcentajeCrecimiento = comparar(actual, esperada);
		double diferenciaAltura = diferenciaDeAlturas(esperada, actual);
		EstadoAltura estado = BuscadorEstadoAltura.getInstance().obtenerEstado(porcentajeCrecimiento, diferenciaAltura, planta);
		return estado;
	}
	
	private double comparar(Altura actual, Altura esperada){
		double valorCrecimiento = actual.getValor()*100/esperada.getValor();
		return valorCrecimiento;
	}
	
	private double diferenciaDeAlturas(Altura optima, Altura actual){
		double dif = actual.getValor() - optima.getValor();
		return dif;
	}
}
