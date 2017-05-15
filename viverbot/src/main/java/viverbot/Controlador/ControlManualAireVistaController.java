package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viverbot.Interfaces.IFrioCalor;
import viverbot.Interfaces.IPotencia;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.Calor;
import viverbot.Modelo.Medicion.Frio;
import viverbot.Modelo.Medicion.Potencia_0;
import viverbot.Modelo.Medicion.Potencia_1;
import viverbot.Modelo.Medicion.Potencia_2;
import viverbot.Modelo.Medicion.Potencia_3;
import viverbot.Vista.ControlManualAireVista;

public class ControlManualAireVistaController implements ActionListener {
	private AireAcondicionado aire;
	private ControlManualAireVista vista;

	public ControlManualAireVistaController(AireAcondicionado aire) {
		this.aire = aire;
		this.vista = new ControlManualAireVista(this);
		cargarCampos();
		mostrar();
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
				aire.setFrioCalorEstado((IFrioCalor) vista.getDropdown_friocalor().getSelectedItem());
				aire.setPotenciaEstado((IPotencia) vista.getDropdown_potencia().getSelectedItem());
				aire.encender();
			}
		}
		if (e.getSource() == vista.getBtn_guardar()) {
			aire.setFrioCalorEstado((IFrioCalor) vista.getDropdown_friocalor().getSelectedItem());
			aire.setPotenciaEstado((IPotencia) vista.getDropdown_potencia().getSelectedItem());
		}
	}

	private void cargarCampos() {
		llenarDropDowns();

	}

	private void mostrar() {
		this.vista.setVisible(true);
	}

	@SuppressWarnings("unchecked")
	private void llenarDropDowns() {
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

}
