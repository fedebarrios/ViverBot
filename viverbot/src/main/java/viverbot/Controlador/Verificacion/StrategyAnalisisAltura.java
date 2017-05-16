package viverbot.Controlador.Verificacion;

import viverbot.DTO.PlantaDTO;
import viverbot.Interfaces.IAnalisisAltura;
import viverbot.Model.BuscadorEstadoAltura;
import viverbot.Modelo.Magnitudes.Medicion;

public class StrategyAnalisisAltura implements IAnalisisAltura{

	@Override
	public EstadoAltura analizar(Medicion actual, Medicion esperada , PlantaDTO planta) {
		
		double porcentajeCrecimiento = comparar(actual, esperada);
		double diferenciaAltura = diferenciaDeAlturas(esperada, actual);
		EstadoAltura estado = BuscadorEstadoAltura.getInstance().obtenerEstadoPorEspecie(porcentajeCrecimiento, diferenciaAltura, planta);
		return estado;
	}
	
	private double comparar(Medicion actual, Medicion esperada){
		double valorCrecimiento = actual.getValor()*100/esperada.getValor();
		return valorCrecimiento;
	}
	
	private double diferenciaDeAlturas(Medicion optima, Medicion actual){
		double dif = actual.getValor() - optima.getValor();
		return dif;
	}
}
