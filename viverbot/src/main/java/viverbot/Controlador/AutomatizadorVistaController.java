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
				automatizador.apagarAutomatizador();
			} else {
				automatizador.encenderAutomatizador();
			}
		}

	}

	private void cargarCampos() {
		AireAcondicionado aire = automatizador.getAire();
		vista.getText_temperaturaAmbiente().setText(estadoVivero.getTemperaturaActual().getValor().toString() + " C°");
		vista.getText_rango().setText(estadoVivero.getRangoTemperatura().getMinimo().toString() + " C° | "
				+ estadoVivero.getRangoTemperatura().getMaximo().toString() + " C°");

		if (automatizador.isEncendido()) {
			vista.getText_encendidoAutomatizador().setText("Encendido");
			vista.getText_controlmanual().setText("Apagado");
			vista.getText_estado().setText(aire.getFrioCalorEstado().toString());
			vista.getText_potencia().setText(aire.getPotenciaEstado().toString());
			vista.getText_temperaturaAire().setText("NO AUN");
		} else {
			vista.getText_encendidoAutomatizador().setText("Apagado");
			if (aire.isEncendidoManualmente()) {
				vista.getText_controlmanual().setText("Encendido");
			} else {
				vista.getText_controlmanual().setText("Apagado");
			}
			vista.getText_estado().setText("");
			vista.getText_potencia().setText("");
			vista.getText_temperaturaAire().setText("NO AUN");
		}
	}

	private void mostrar() {
		this.vista.setVisible(true);
	}

}
