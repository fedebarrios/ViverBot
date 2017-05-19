package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import viverbot.Model.EstadoVivero;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.AutomatizadorDeClima;
import viverbot.Vista.AutomatizadorVista;

public class AutomatizadorVistaController implements ActionListener, Observer {
	private AutomatizadorVista vista;
	private AutomatizadorDeClima automatizador;
	private EstadoVivero estadoVivero;
	private ControlManualAireVistaController controlManual;

	public AutomatizadorVistaController(AutomatizadorDeClima automatizadorDeClima) {
		this.automatizador = automatizadorDeClima;
		this.vista = new AutomatizadorVista(this);
		this.estadoVivero = EstadoVivero.getInstance();
		this.controlManual = new ControlManualAireVistaController(automatizador.getAire());
		this.controlManual.addObserver(this);
		cargarCampos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getMenuitem_salir()) {
			vista.dispose();
		} else if (e.getSource() == vista.getMenuitem_configuracionManual()) {
			controlManual.mostrar();
		}
		if (e.getSource() == vista.getMenuitem_onOffAutomatizador()) {
			if (automatizador.isEncendido()) {
				automatizador.apagar();
				vista.getLabel_textestado().setText("");
				vista.getLabel_textpotencia().setText("");
				vista.getLabel_texttemperaturaAire().setText("");
			} else {
				automatizador.encender();
			}
		}

	}

	private void cargarCampos() {
		AireAcondicionado aire = automatizador.getAire();
		Double tempActual = (double) (Math.round(estadoVivero.getTemperaturaActual().getValor() * 1000d) / 1000d);
		vista.getLabel_texttemperaturaAmbiente().setText(tempActual + " C°");
		vista.getLabel_textrango().setText(estadoVivero.getRangoTemperatura().getMinimo().toString() + " C° | "
				+ estadoVivero.getRangoTemperatura().getMaximo().toString() + " C°");

		if (automatizador.isEncendido()) {
			vista.getLabel_textencendidoAutomatizador().setText("Encendido");
			vista.getLabel_textcontrolManual().setText("Apagado");
			vista.getLabel_textestado().setText(aire.getEstado().toString());
			vista.getLabel_textpotencia().setText(aire.getPotencia().toString());
			vista.getLabel_texttemperaturaAire().setText(aire.getTemp().toString());
		} else {
			vista.getLabel_textencendidoAutomatizador().setText("Apagado");
			if (aire.isEncendidoManualmente()) {
				vista.getLabel_textcontrolManual().setText("Encendido");
				vista.getLabel_textestado().setText(aire.getEstado().toString());
				vista.getLabel_textpotencia().setText(aire.getPotencia().toString());
				vista.getLabel_texttemperaturaAire().setText(aire.getTemp().toString());
			} else {
				vista.getLabel_textcontrolManual().setText("Apagado");
				vista.getLabel_textestado().setText("");
				vista.getLabel_textpotencia().setText("");
				vista.getLabel_texttemperaturaAire().setText("");
			}
		}
	}

	public void mostrar() {
		this.vista.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		cargarCampos();
	}

	public AutomatizadorVista getVista() {
		return vista;
	}

}
