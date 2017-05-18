package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viverbot.Controlador.Verificacion.PlanificadorAltura;
import viverbot.Model.ControlSeguimientos;
import viverbot.Model.GuardadorAltura;
import viverbot.Model.Plantas;
import viverbot.Modelo.Medicion.AnalizadorAltura;
import viverbot.Modelo.Medicion.AutomatizadorDeClima;
import viverbot.Modelo.Medicion.ColectorAltura;
import viverbot.Modelo.Medicion.MapperAltura;
import viverbot.Vista.VistaPrincipal;

public class VistaPrincipalController implements ActionListener {
	private VistaPrincipal vista;
	private AutomatizadorDeClima automatizador;

	
	public VistaPrincipalController() {
		this.vista = new VistaPrincipal(this);
		this.automatizador = new AutomatizadorDeClima();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vista.getMntmControlarAltura()) {
			ColectorAltura c = new ColectorAltura();
			PlanificadorAltura p = PlanificadorAltura.getInstance();
			AnalizadorAltura a = new AnalizadorAltura(GuardadorAltura.getInstance());
			MapperAltura m = new MapperAltura(a, new Plantas().obtenerPlantas(), ControlSeguimientos.getInstance());
			c.addObserver(m);
			m.addObserver(p);
			c.colectar();
		}
		if (e.getSource() == vista.getMntmTemperatura()) {
			AutomatizadorVistaController automatizadorVista = new AutomatizadorVistaController(automatizador);
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
}
