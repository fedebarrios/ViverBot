package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.AutomatizadorDeClima;
import viverbot.Vista.AutomatizacionVista;

public class AutomatizacionController implements ActionListener {
	private AutomatizacionVista automatizacionVista;
	private AutomatizadorDeClima automatizacionDeClima;

	public AutomatizacionController(AutomatizadorDeClima automatizadorDeClima) {
		this.automatizacionDeClima = automatizadorDeClima;
		this.automatizacionVista = new AutomatizacionVista(this);
		cargarCampos();
		mostrar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.automatizacionVista.getMenuitem_salir()) {
			this.automatizacionVista.dispose();
		} else if (e.getSource() == this.automatizacionVista.getMenuitem_configuracion()){
			AutomatizacionConfiguracionController autoController = new AutomatizacionConfiguracionController(this.automatizacionDeClima);
		}

	}

	public void cargarCampos() {
		RangoNumerico rango = this.automatizacionDeClima.getRango();
		Temperatura temp = this.automatizacionDeClima.getTemp();
		this.automatizacionVista.getText_temperaturaAmbiente().setText(temp.getValor().toString());
		this.automatizacionVista.getText_rango()
				.setText(rango.getMinimo().toString() + " | " + rango.getMaximo().toString());
		if (this.automatizacionDeClima.isEncendido()) {
			this.automatizacionVista.getText_encendido().setText("Encendido");
			AireAcondicionado aire = this.automatizacionDeClima.getAire();
			this.automatizacionVista.getText_estado().setText(aire.getFrioCalorEstado().toString());
			this.automatizacionVista.getText_potencia().setText(aire.getPotenciaEstado().toString());
			this.automatizacionVista.getText_temperaturaAire().setText("NO AUN");
		} else {
			this.automatizacionVista.getText_encendido().setText("Apagado");
			this.automatizacionVista.getText_estado().setText("");
			this.automatizacionVista.getText_potencia().setText("");
			this.automatizacionVista.getText_temperaturaAire().setText("");
		}

	}

	public void mostrar() {
		this.automatizacionVista.setVisible(true);
	}
}
