package viverbot;

import javax.swing.JOptionPane;

import viverbot.Controlador.VistaPrincipalController;
import viverbot.Model.EstadoVivero;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Medicion.ColectorTemperatura;
import viverbot.Modelo.Medicion.InstrumentoMediator;
import viverbot.Modelo.Monitoreo.MonitorEstado;
import viverbot.Modelo.Sensores.SensorTemperatura;
import viverbot.Modelo.Simulacion.BuildSimuladorTemperaturaEnero;
import viverbot.Modelo.Simulacion.BuildSimuladorTemperaturaJunio;
import viverbot.Modelo.Simulacion.Simulador;

public class App {

	public static void main(String[] args) {

		VistaPrincipalController principal = new VistaPrincipalController();
		principal.mostrar();

		// implementar un distpacher y dentro del distpacher commands

		controlarTemperatura(principal);
	}

	public static void controlarTemperatura(VistaPrincipalController principal) {
		String sensorOperando = "El sensor de temperatura esta operando correctamente";
		String sensorInoperando = "El sensor de temperatura esta inactivo. Ejecutando simullacion de ";
		EstadoVivero estado = EstadoVivero.getInstance();

		// abstraer en otro objeto
		InstrumentoMediator i = new InstrumentoMediator(Magnitudes.TEMPERATURA);
		SensorTemperatura s = (SensorTemperatura) i.getInstrumentoMedicion();
		Simulador simulador;

		// ventana de opciones
		int confirmado = JOptionPane.showConfirmDialog(null,
				"La medición de datos de temperatura no esta disponible. Utilizar una simulación?", "Seleccione",
				JOptionPane.OK_CANCEL_OPTION);
		if (JOptionPane.OK_OPTION == confirmado) {
			int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Simulaciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					new Object[] { "Enero", "Junio" }, "opcion 1");
			if (seleccion == 0) {
				simulador = new BuildSimuladorTemperaturaEnero().getSimulador();
				principal.getVista().setLabelEstadoSensor(sensorInoperando + "Enero");

			} else {
				simulador = new BuildSimuladorTemperaturaJunio().getSimulador();
				principal.getVista().setLabelEstadoSensor(sensorInoperando + "Junio");

			}
			simulador.simular();
			s.setSimulador(simulador);
			ColectorTemperatura t = new ColectorTemperatura(5000, 0, i);
			t.addObserver(estado);
			t.colectar();
			// estado.addObserver(automatizador);
			MonitorEstado monitor = new MonitorEstado(principal);
			estado.addObserver(monitor);
		}
		// fin de la ventan de opciones
	}
}
