package viverbot.Controlador.Verificacion;

import viverbot.DTO.Planta;
import viverbot.Interfaces.AnalisisAltura;
import viverbot.Model.BuscadorEstadoAltura;
import viverbot.Modelo.Magnitudes.Medicion;

public class Comparador {

public EstadoAltura comparar(Medicion actual, Medicion esperada, Planta p) {
		
		double porcentajeCrecimiento = sacarPorcentaje(actual, esperada);
		double diferenciaAltura = diferenciaDeAlturas(esperada, actual);
		EstadoAltura estado = BuscadorEstadoAltura.getInstance().obtenerEstadoPorEspecie(porcentajeCrecimiento, diferenciaAltura, p);
		return estado;
	}
	
	private double sacarPorcentaje(Medicion actual, Medicion esperada){
		double valorCrecimiento = actual.getValor()*100/esperada.getValor();
		return valorCrecimiento;
	}
	
	private double diferenciaDeAlturas(Medicion optima, Medicion actual){
		double dif = actual.getValor() - optima.getValor();
		return dif;
	}
}
