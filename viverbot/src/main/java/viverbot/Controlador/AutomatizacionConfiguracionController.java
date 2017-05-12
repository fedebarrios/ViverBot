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
		cargarCampos();
		mostrar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.automatizadorConfiguracionVista.getBtn_encenderAutomatizador()){
			if(this.automatizador.isEncendidoAutomatizador() == true){
				this.automatizador.encenderApagarAutomatizador(false);
				System.out.println("El automatizador de clima se ha apagado. Ahora el control el manual.");
			}else {
				this.automatizador.encenderApagarAutomatizador(true);
				System.out.println("El automatizador de clima se ha encendido. El control del microclima ahora es automatico");
			}
		}else if(e.getSource() == this.automatizadorConfiguracionVista.getBtn_encenderAire()){
			if(this.automatizador.isEncendidoAire() == true){
				this.automatizador.encenderApagarManual(false);
				System.out.println("El aire se ha apagado en modo manual.");
			} else {
				this.automatizador.encenderApagarManual(true);
				System.out.println("El aire se ha encendido en modo manual.");
			}
		}
	}
	
	public void cargarCampos() {
		this.automatizadorConfiguracionVista.getText_friocalor().setText(this.automatizador.getAire().getFrioCalorEstado().toString());
		this.automatizadorConfiguracionVista.getText_potencia().setText(this.automatizador.getAire().getPotenciaEstado().toString());
		this.automatizadorConfiguracionVista.getText_temperatura().setText("NO AUN");
	}


	public void mostrar() {
		this.automatizadorConfiguracionVista.setVisible(true);
	}

}
