package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import viverbot.Interfaces.FrioCalor;
import viverbot.Interfaces.Potencia;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.Calor;
import viverbot.Modelo.Medicion.Frio;
import viverbot.Modelo.Medicion.Potencia_0;
import viverbot.Modelo.Medicion.Potencia_1;
import viverbot.Modelo.Medicion.Potencia_2;
import viverbot.Modelo.Medicion.Potencia_3;
import viverbot.Vista.ControlManualAireVista;

public class ControlManualAireVistaController extends Observable implements ActionListener {
	private AireAcondicionado aire;
	private ControlManualAireVista vista;

	public ControlManualAireVistaController(AireAcondicionado aire) {
		this.aire = aire;
		this.vista = new ControlManualAireVista(this);
		cargarCampos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getBtn_cerrar()) {
			vista.dispose();
		}
		if (e.getSource() == vista.getBtn_encenderAire()) {
			if (aire.isEncendidoManualmente()) {
				aire.apagar();
			} else {
				aire.setEstado((FrioCalor) vista.getDropdown_friocalor().getSelectedItem());
				aire.setPotencia((Potencia) vista.getDropdown_potencia().getSelectedItem());
				aire.setTemperatura((String) vista.getDropdown_temperatura().getSelectedItem());
				aire.encender();
				setChanged();
				notifyObservers();
			}
		}
		if (e.getSource() == vista.getBtn_guardar()) {
			aire.setEstado((FrioCalor) vista.getDropdown_friocalor().getSelectedItem());
			aire.setPotencia((Potencia) vista.getDropdown_potencia().getSelectedItem());
			aire.setTemperatura((String) vista.getDropdown_temperatura().getSelectedItem());
		}
	}

	public void mostrar() {
		this.vista.setVisible(true);
	}

	@SuppressWarnings("unchecked")
	private void cargarCampos() {
		vista.getDropdown_friocalor().addItem(new Calor());
		vista.getDropdown_friocalor().addItem(new Frio());
		vista.getDropdown_potencia().addItem(new Potencia_0());
		vista.getDropdown_potencia().addItem(new Potencia_1());
		vista.getDropdown_potencia().addItem(new Potencia_2());
		vista.getDropdown_potencia().addItem(new Potencia_3());
		vista.getDropdown_temperatura().addItem("16");
		vista.getDropdown_temperatura().addItem("17");
		vista.getDropdown_temperatura().addItem("18");
		vista.getDropdown_temperatura().addItem("19");
		vista.getDropdown_temperatura().addItem("20");
		vista.getDropdown_temperatura().addItem("21");
		vista.getDropdown_temperatura().addItem("22");
		vista.getDropdown_temperatura().addItem("23");
		vista.getDropdown_temperatura().addItem("24");
		vista.getDropdown_temperatura().addItem("25");
		vista.getDropdown_temperatura().addItem("26");
		vista.getDropdown_temperatura().addItem("27");
		vista.getDropdown_temperatura().addItem("28");
		vista.getDropdown_temperatura().addItem("29");
	}

	public ControlManualAireVista getVista() {
		return vista;
	}

}
