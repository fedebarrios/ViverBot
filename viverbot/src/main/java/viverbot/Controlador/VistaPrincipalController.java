package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viverbot.Controlador.Verificacion.InformadorAltura;
import viverbot.Model.ManagerSeguimientos;
import viverbot.Model.GuardadorAltura;
import viverbot.Model.Plantas;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Medicion.AnalizadorAltura;
import viverbot.Modelo.Medicion.AutomatizadorDeClima;
import viverbot.Modelo.Medicion.ColectorAltura;
import viverbot.Modelo.Medicion.InstrumentoMediator;
import viverbot.Modelo.Medicion.MapperAltura;
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

		if (e.getSource() == this.vista.getMntmControlarAltura()) {
			InstrumentoMediator mediator =  new InstrumentoMediator(Magnitud.ALTURA);
			ColectorAltura c = new ColectorAltura(mediator);
			InformadorAltura p = InformadorAltura.getInstance();
			AnalizadorAltura a = new AnalizadorAltura();
			MapperAltura m = new MapperAltura(a, new Plantas().obtenerPlantas(), ManagerSeguimientos.getInstance());
			c.addObserver(m);
			m.addObserver(p);
			c.colectar();
		}
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
