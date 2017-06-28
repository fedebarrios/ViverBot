package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viverbot.Modelo.Medicion.AutomatizadorDeClima;
import viverbot.Vista.VistaPrincipal;

public class VistaPrincipalController implements ActionListener {
	private VistaPrincipal vista;
	private AutomatizadorDeClima automatizador;
	private AutomatizadorVistaController automatizadorVista;

	public VistaPrincipalController() {
		this.vista = new VistaPrincipal(this);
		this.automatizador = new AutomatizadorDeClima();
		this.automatizadorVista = new AutomatizadorVistaController(automatizador);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getMntmTemperatura()) {
			this.automatizadorVista.mostrar();
		}
	}

	public void actualizarLabelEstado(String estado, String string) {
		this.vista.setLabelEstado(estado);
		this.vista.setLabelTemperatura(string);
	}

	public void mostrar() {
		this.vista.mostrar();
	}

	public VistaPrincipal getVista() {
		return this.vista;
	}

	public AutomatizadorVistaController getAutomatizadorVista() {
		return automatizadorVista;
	}

}
