package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.AutomatizadorDeClima;
import viverbot.Vista.AutomatizacionVista;

public class AutomatizacionVistaController implements ActionListener {
	private AutomatizacionVista automatizacionVista;
	private AutomatizadorDeClima automatizacionDeClima;

	public AutomatizacionVistaController(AutomatizadorDeClima automatizadorDeClima) {
		this.automatizacionDeClima = automatizadorDeClima;
		this.automatizacionVista = new AutomatizacionVista(this);
		cargarCampos();
		mostrar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.automatizacionVista.getMenuitem_salir()) {
			this.automatizacionVista.dispose();
		}

	}

	public void cargarCampos() {
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		this.automatizacionVista.getText_rango()
				.setText(rango.getMinimo().toString() + " | " + rango.getMaximo().toString());
		if (this.automatizacionDeClima.isEncendido()) {
			this.automatizacionVista.getText_encendido().setText("Encendido");
		} else {
			this.automatizacionVista.getText_encendido().setText("Apagado");
		}
		AireAcondicionado aire = this.automatizacionDeClima.getAire();
		this.automatizacionVista.getText_estado().setText(aire.getFrioCalorEstado().toString());
		// continuar aca, retorna null!!!
	}

	public void mostrar() {
		this.automatizacionVista.setVisible(true);
	}
}
