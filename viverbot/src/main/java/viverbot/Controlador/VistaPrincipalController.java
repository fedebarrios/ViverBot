package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import viverbot.Controlador.Verificacion.PlanificadorAltura;
import viverbot.Model.ControlSeguimientos;
import viverbot.Model.EstadoVivero;
import viverbot.Model.GuardadorAltura;
import viverbot.Model.Plantas;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Medicion.AnalizadorAltura;
import viverbot.Modelo.Medicion.AutomatizadorDeClima;
import viverbot.Modelo.Medicion.ColectorAltura;
import viverbot.Modelo.Medicion.ColectorTemperatura;
import viverbot.Modelo.Medicion.InstrumentoMediator;
import viverbot.Modelo.Medicion.MapperAltura;
import viverbot.Modelo.Monitoreo.MonitorEstado;
import viverbot.Modelo.Sensores.SensorTemperatura;
import viverbot.Modelo.Simulacion.BuildSimuladorTemperaturaEnero;
import viverbot.Modelo.Simulacion.BuildSimuladorTemperaturaJunio;
import viverbot.Modelo.Simulacion.Simulador;
import viverbot.Vista.PrincipalView;

public class VistaPrincipalController implements ActionListener {
	private PrincipalView vista;
	private AutomatizadorDeClima automatizador;

	public VistaPrincipalController() {
		this.vista = new PrincipalView(this);
		this.vista.mostrar();
		this.automatizador = new AutomatizadorDeClima();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// implementar un distpacher y dentro del distpacher commands

		if (e.getSource() == this.vista.getMntmControlarTemperatura()) {
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

				} else {
					simulador = new BuildSimuladorTemperaturaJunio().getSimulador();
				}
				simulador.simular();
				s.setSimulador(simulador);
				ColectorTemperatura t = new ColectorTemperatura(5000, 0, i);
				EstadoVivero estado = EstadoVivero.getInstance();
				t.addObserver(estado);
				t.colectar();
				estado.addObserver(automatizador);
				MonitorEstado monitor = new MonitorEstado(this);
				estado.addObserver(monitor);
			} else {

			}
			// fin de la ventan de opciones

		} else if (e.getSource() == this.vista.getMntmControlarAltura()) {
			ColectorAltura c = new ColectorAltura();
			PlanificadorAltura p = PlanificadorAltura.getInstance();
			AnalizadorAltura a = new AnalizadorAltura(GuardadorAltura.getInstance());
			MapperAltura m = new MapperAltura(a, new Plantas().obtenerPlantas(), ControlSeguimientos.getInstance());
			c.addObserver(m);
			m.addObserver(p);
			c.colectar();
		}
		if (e.getSource() == vista.getMntmTemperatura()) {
			AutomatizadorVistaController automatizadorVista = new AutomatizadorVistaController(automatizador);
		}
	}

	public void actualizarLabelEstado(String estado, Double valor) {
		this.vista.setLabelEstado(estado + " ºC");
		this.vista.setLabelTemperatura(valor + " ºC");
	}
}
