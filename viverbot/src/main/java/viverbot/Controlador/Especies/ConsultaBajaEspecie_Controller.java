package viverbot.Controlador.Especies;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import viverbot.DTO.EspecieDTO;
import viverbot.Model.Inventario;
import viverbot.Model.Plantas;
import viverbot.Vista.Auxiliares.DefaultOptionPane;
import viverbot.Vista.Especie.ConsultaBajaEspecie;

public class ConsultaBajaEspecie_Controller implements ActionListener {
	private ConsultaBajaEspecie consultaBajaVista;
	private VerDetallesEspecie_Controller controladorVerDetalle;
	private Inventario inventario;
	private DefaultOptionPane optionPane;

	public ConsultaBajaEspecie_Controller() {
		consultaBajaVista = new ConsultaBajaEspecie(this);
		inventario = new Inventario();
		llenarCombo(consultaBajaVista.getComboBox());
		this.consultaBajaVista.setVisible(true);
		this.optionPane = new DefaultOptionPane();
	}

	@SuppressWarnings("unchecked")
	public void llenarCombo(@SuppressWarnings("rawtypes") JComboBox combo) {
		ArrayList<EspecieDTO> especies = inventario.obtenerEspecies();
		for (int i = 0; i < especies.size(); i++) {
			consultaBajaVista.getComboBox().addItem(especies.get(i).getNombre());
		}
	}
	
	public ConsultaBajaEspecie getVista(){
		return consultaBajaVista;
	}
	
	public VerDetallesEspecie_Controller getControladorVerDetalle(){
		return controladorVerDetalle;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.consultaBajaVista.getBtnCancelar()) {
			this.consultaBajaVista.dispose();
		} else if (e.getSource() == this.consultaBajaVista.getBtnBorrar()) {
			String elementoElegido = this.consultaBajaVista.getComboBox().getSelectedItem().toString();
			boolean sePuedeBorrar = sePuedeBorrar(elementoElegido);
			if(!sePuedeBorrar) { 
				optionPane.showMessageDialog(this.consultaBajaVista, "La especie asociada tiene plantas cargadas");
			} 
			else{
				ArrayList<EspecieDTO> esp = inventario.obtenerEspecies();
				for (int i = 0; i < esp.size(); i++) {
					if (esp.get(i).getNombre().equals(elementoElegido)) {
						this.inventario.borrarEspecie(esp.get(i).getCodEspecie());
					}
				}
				this.consultaBajaVista.getComboBox().removeAllItems();
				llenarCombo(this.consultaBajaVista.getComboBox());
			}
		} else if (e.getSource() == this.consultaBajaVista.getBtnVerDetalle()){
			String elementoElegido = this.consultaBajaVista.getComboBox().getSelectedItem().toString();
			ArrayList<EspecieDTO> especies = inventario.obtenerEspecies();
			for (EspecieDTO esp: especies) {
				if(esp.getNombre().equals(elementoElegido))
					controladorVerDetalle = new VerDetallesEspecie_Controller(esp);
			}
		}
	}

	public boolean sePuedeBorrar(String elementoElegido) {
		ArrayList<EspecieDTO> esp = inventario.obtenerEspecies();
		int codigoEspecie = 0;
		for (int i = 0; i < esp.size(); i++) {
			if (esp.get(i).getNombre().equals(elementoElegido)) {
				codigoEspecie = esp.get(i).getCodEspecie();
			}
		}
		Plantas plantas = new Plantas();
		if(plantas.obtenerPlantas(codigoEspecie).size() == 0){
			return true;
		}
		return false;
	}

	public void setOptionPane(DefaultOptionPane optionPane) {
		this.optionPane = optionPane;
	}
}
