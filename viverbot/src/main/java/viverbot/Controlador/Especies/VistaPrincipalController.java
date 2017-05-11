package viverbot.Controlador.Especies;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import viverbot.Controlador.Verificacion.PlanificadorAltura;
import viverbot.Controlador.Verificacion.TransmisorHumedad;
import viverbot.Model.ControlSeguimientos;
import viverbot.Model.GuardadorAltura;
import viverbot.Model.Plantas;
import viverbot.Model.SoporteFactory;
import viverbot.Model.SoporteMovible;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Medicion.AnalizadorAltura;
import viverbot.Modelo.Medicion.AnalizadorTemperatura;
import viverbot.Modelo.Medicion.ColectorAltura;
import viverbot.Modelo.Medicion.ColectorTemperatura;
import viverbot.Modelo.Medicion.InstrumentoMediator;
import viverbot.Modelo.Medicion.MapperAltura;
import viverbot.Modelo.Sensores.SensorTemperatura;
import viverbot.Modelo.Simulacion.BuildSimuladorTemperaturaEnero;
import viverbot.Modelo.Simulacion.BuildSimuladorTemperaturaJunio;
import viverbot.Modelo.Simulacion.Simulador;
import viverbot.Vista.Especie.PrincipalView;

public class VistaPrincipalController implements ActionListener {

	private PrincipalView vistaPrincipal;

	public VistaPrincipalController() {
		this.vistaPrincipal = new PrincipalView(this);
		this.vistaPrincipal.mostrar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// implementar un distpacher y dentro del distpacher commands

		if (e.getSource() == this.vistaPrincipal.getMntmControlarTemperatura()) {
			// abstraer en otro objeto
			InstrumentoMediator i = new InstrumentoMediator(Magnitudes.TEMPERATURA);
			SensorTemperatura s = (SensorTemperatura) i.getInstrumentoMedicion();
			Simulador simulador;

			// ventana de opciones
			int confirmado = JOptionPane.showConfirmDialog(null,
					"La medicion de datos de temperatura no esta disponible. Utilizar una simulacion?");
			if (JOptionPane.OK_OPTION == confirmado) {
				int seleccion = JOptionPane.showOptionDialog(null, "Seleccione opcion", "Simulaciones",
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

				AnalizadorTemperatura tr = new AnalizadorTemperatura();
				t.addObserver(tr);
				t.colectar();
			} else {

			}
			// fin de la ventan de opciones

		} else if (e.getSource() == this.vistaPrincipal.getMntmControolarHumedad()) {
			SoporteMovible soporte = SoporteFactory.crearSoporte((TransmisorHumedad.getTipoMagnitud()));
			Thread hiloTransmisor = new Thread(new TransmisorHumedad(soporte));
			hiloTransmisor.start();
		} else if (e.getSource() == this.vistaPrincipal.getMntmControlarAltura()) {
			ColectorAltura c = new ColectorAltura();
			PlanificadorAltura p = PlanificadorAltura.getInstance();
			AnalizadorAltura a = new AnalizadorAltura(GuardadorAltura.getInstance());
			MapperAltura m = new MapperAltura(a, new Plantas().obtenerPlantas(), ControlSeguimientos.getInstance());
			c.addObserver(m);
			m.addObserver(p);
			c.colectar();
		}
	}
}
