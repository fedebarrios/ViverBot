package viverbot;

import viverbot.Model.EstadoVivero;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AireAcondicionado;

public class FakeMain {

	public static void main(String[] args) {
		EstadoVivero estadoVivero = EstadoVivero.getInstance();
		estadoVivero.setTemperaturaColector(new Medicion(30.0, Magnitudes.TEMPERATURA));
		System.out.println(estadoVivero.getTemperaturaActual().getValor());
		AireAcondicionado aire = new AireAcondicionado();
		
		System.out.println(estadoVivero.getTemperaturaActual().getValor());

		estadoVivero.setTemperaturaDiferenciaSumar(aire.ejecutar());
		
		System.out.println(estadoVivero.getTemperaturaActual().getValor());

		estadoVivero.setTemperaturaDiferenciaSumar(aire.ejecutar());
		System.out.println(estadoVivero.getTemperaturaActual().getValor());

		estadoVivero.setTemperaturaDiferenciaSumar(aire.ejecutar());
		System.out.println(estadoVivero.getTemperaturaActual().getValor());

		estadoVivero.setTemperaturaDiferenciaSumar(aire.ejecutar());
		System.out.println(estadoVivero.getTemperaturaActual().getValor());

		estadoVivero.setTemperaturaDiferenciaSumar(aire.ejecutar());
		System.out.println(estadoVivero.getTemperaturaActual().getValor());

		estadoVivero.setTemperaturaDiferenciaSumar(aire.ejecutar());
		System.out.println(estadoVivero.getTemperaturaActual().getValor());

		estadoVivero.setTemperaturaDiferenciaSumar(aire.ejecutar());
		System.out.println(estadoVivero.getTemperaturaActual().getValor());

		estadoVivero.setTemperaturaDiferenciaSumar(aire.ejecutar());
		System.out.println(estadoVivero.getTemperaturaActual().getValor());

		
	}

}
