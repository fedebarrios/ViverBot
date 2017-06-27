package viverbot;

import javax.swing.JOptionPane;

import viverbot.Controlador.VistaPrincipalController;
import viverbot.Model.EstadoVivero;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Medicion.Colector;
import viverbot.Modelo.Medicion.InstrumentoMediator;
import viverbot.Modelo.Monitoreo.MonitorEstado;
import viverbot.Modelo.Sensores.SensorTemperatura;
import viverbot.Modelo.Simulacion.Simulador;

public class App {

	public static void main(String[] args) {

		VistaPrincipalController principal = new VistaPrincipalController();
		principal.mostrar();

		// implementar un distpacher y dentro del distpacher commands

		controlarTemperatura(principal);
	}

	public static void controlarTemperatura(VistaPrincipalController principal) {
		EstadoVivero estado = EstadoVivero.getInstance();
		String rangos = "#00,05#02,07#05,10#07,15#10,17#07,15#05,10#02,07#";

		Simulador simulador =  new Simulador(Simulador.inicializarRangos(rangos), 300000, Magnitudes.TEMPERATURA);
		simulador.simular();
		
		InstrumentoMediator i = new InstrumentoMediator(simulador);

		Colector t = new Colector(5000, 0, i);
		t.addObserver(estado);
		t.colectar();
		MonitorEstado monitor = new MonitorEstado();
		estado.addObserver(monitor);
		estado.addObserver(principal.getAutomatizadorVista());
		monitor.addObserver(principal.getVista());

	}
	// fin de la ventan de opciones

}
