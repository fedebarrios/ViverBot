package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viverbot.Modelo.Medicion.AutomatizadorDeClima;
import viverbot.Vista.AutomatizacionConfiguracionVista;

public class AutomatizacionConfiguracionController implements ActionListener {
	private AutomatizadorDeClima automatizador;
	private AutomatizacionConfiguracionVista automatizadorConfiguracionVista;

	public AutomatizacionConfiguracionController(AutomatizadorDeClima automatizador) {
		this.automatizador = automatizador;
		this.automatizadorConfiguracionVista = new AutomatizacionConfiguracionVista(this);
		mostrar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.automatizadorConfiguracionVista.getBtn_encenderAutomatizador()){
			if(this.automatizador.isEncendido()){
				this.automatizador.encenderApagarAutomatizador(false);
				System.out.println("El automatizador de clima se ha apagado. Ahora el control el manual.");
			}else {
				this.automatizador.encenderApagarAutomatizador(true);
				System.out.println("El automatizador de clima se ha encendido. El control del microclima ahora es automatico");
			}
		}
	}

	public void mostrar() {
		this.automatizadorConfiguracionVista.setVisible(true);
	}

}
