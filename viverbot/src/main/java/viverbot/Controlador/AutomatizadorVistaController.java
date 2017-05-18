package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viverbot.Model.EstadoVivero;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.AutomatizadorDeClima;
import viverbot.Vista.AutomatizadorVista;

public class AutomatizadorVistaController implements ActionListener {
	private AutomatizadorVista vista;
	private AutomatizadorDeClima automatizador;
	private EstadoVivero estadoVivero;

	public AutomatizadorVistaController(AutomatizadorDeClima automatizadorDeClima) {
		this.automatizador = automatizadorDeClima;
		this.vista = new AutomatizadorVista(this);
		this.estadoVivero = EstadoVivero.getInstance();
		cargarCampos();
		mostrar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getMenuitem_salir()) {
			vista.dispose();
		} else if (e.getSource() == vista.getMenuitem_configuracionManual()) {
			@SuppressWarnings("unused")
			ControlManualAireVistaController autoController = new ControlManualAireVistaController(
					automatizador.getAire());
		}
		if (e.getSource() == vista.getMenuitem_onOffAutomatizador()) {
			if (automatizador.isEncendido()) {
				automatizador.apagar();
			} else {
				automatizador.encender();
			}
		}

	}

	private void cargarCampos() {
		AireAcondicionado aire = automatizador.getAire();
		vista.getLabel_texttemperaturaAmbiente().setText(estadoVivero.getTemperaturaActual().getValor().toString() + " C°");
		vista.getLabel_textrango().setText(estadoVivero.getRangoTemperatura().getMinimo().toString() + " C° | "
				+ estadoVivero.getRangoTemperatura().getMaximo().toString() + " C°");

		if (automatizador.isEncendido()) {
			vista.getLabel_textencendidoAutomatizador().setText("Encendido");
			vista.getLabel_textcontrolManual().setText("Apagado");
			vista.getLabel_textestado().setText(aire.getEstado().toString());
			vista.getLabel_textpotencia().setText(aire.getPotencia().toString());
			vista.getLabel_texttemperaturaAire().setText("NO AUN");
		} else {
			vista.getLabel_textencendidoAutomatizador().setText("Apagado");
			if (aire.isEncendidoManualmente()) {
				vista.getLabel_textcontrolManual().setText("Encendido");
			} else {
				vista.getLabel_textcontrolManual().setText("Apagado");
			}
		}
	}

	private void mostrar() {
		this.vista.setVisible(true);
	}

}
