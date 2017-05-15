package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.AutomatizadorDeClima;
import viverbot.Vista.AutomatizadorVista;

public class AutomatizadorVistaController implements ActionListener {
	private AutomatizadorVista vista;
	private AutomatizadorDeClima automatizador;

	public AutomatizadorVistaController(AutomatizadorDeClima automatizadorDeClima) {
		this.automatizador = automatizadorDeClima;
		this.vista = new AutomatizadorVista(this);
		cargarCampos();
		mostrar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getMenuitem_salir()) {
			vista.dispose();
		} else if (e.getSource() == vista.getMenuitem_configuracionManual()) {
			@SuppressWarnings("unused")
			ControlManualAireVistaController autoController = new ControlManualAireVistaController(automatizador.getAire());
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

		// Aca iria la temperatura ambiente que javi me tiene que dar
		Medicion temp = automatizador.getTemp();
		vista.getText_temperaturaAmbiente().setText(temp.getValor().toString() + " C°");

		// Aca iria el rango que javi me tiene que dar
		RangoNumerico rango = automatizador.getRango();
		vista.getText_rango().setText(rango.getMinimo().toString() + " C° | " + rango.getMaximo().toString() + " C°");

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
