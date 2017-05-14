package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viverbot.Modelo.Medicion.AutomatizadorDeClima;
import viverbot.Vista.ControlManualAireVista;

public class ControlManualAireVistaController implements ActionListener {
	private AutomatizadorDeClima automatizador;
	private ControlManualAireVista vista;

	public ControlManualAireVistaController(AutomatizadorDeClima automatizador) {
		this.automatizador = automatizador;
		this.vista = new ControlManualAireVista(this);
		cargarCampos();
		mostrar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	private void cargarCampos() {

	}

	private void mostrar() {
		this.vista.setVisible(true);
	}

}
