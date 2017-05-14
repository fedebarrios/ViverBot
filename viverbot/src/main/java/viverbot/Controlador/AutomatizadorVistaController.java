package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Temperatura;
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
			ControlManualAireVistaController autoController = new ControlManualAireVistaController(automatizador);
		}
		if (e.getSource() == vista.getMenuitem_onOffAutomatizador()) {
			if (automatizador.isEncendidoAutomatizador()) {
				automatizador.apagarAutomatizador();
			} else {
				automatizador.encenderAutomatizador();
			}
		}

	}

	private void cargarCampos() {
		RangoNumerico rango = automatizador.getRango();
		// Aca iria la temperatura ambiente que javi me tiene que dar
		Temperatura temp = automatizador.getTemp();
		this.vista.getText_temperaturaAmbiente().setText(temp.getValor().toString());
		this.vista.getText_rango().setText(rango.getMinimo().toString() + " | " + rango.getMaximo().toString());
		if (automatizador.isEncendidoAutomatizador()) {
			this.vista.getText_encendidoAutomatizador().setText("Encendido");
			AireAcondicionado aire = automatizador.getAire();
			this.vista.getText_estado().setText(aire.getFrioCalorEstado().toString());
			this.vista.getText_potencia().setText(aire.getPotenciaEstado().toString());
			this.vista.getText_temperaturaAire().setText("NO AUN");
		} else {
			this.vista.getText_encendidoAutomatizador().setText("Apagado");
			this.vista.getText_estado().setText("");
			this.vista.getText_potencia().setText("");
			this.vista.getText_temperaturaAire().setText("");
		}
	}

	private void mostrar() {
		this.vista.setVisible(true);
	}

}
