package viverbot.Vista.Especie;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viverbot.Controlador.Especies.ConsultaBajaEspecie_Controller;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ConsultaBajaEspecie extends JFrame{

	private JPanel contentPane;
	private JComboBox comboBox;
	private JButton btnCancelar;
	private JButton btnBorrar;	
	private JButton btnVerDetalle;
	
	@SuppressWarnings("rawtypes")
	public ConsultaBajaEspecie(ConsultaBajaEspecie_Controller controlador){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 200);
		setTitle("Consulta y Baja de Especie");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 40, 176, 20);
		contentPane.add(comboBox);
		
		JLabel lblSeleccioneUnaEspecie = new JLabel("Seleccione una especie");
		lblSeleccioneUnaEspecie.setBounds(10, 15, 176, 14);
		contentPane.add(lblSeleccioneUnaEspecie);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(137, 127, 89, 23);
		contentPane.add(btnBorrar);
		btnBorrar.addActionListener(controlador);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(235, 127, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(controlador);
		
		btnVerDetalle = new JButton("Ver Detalle");
		btnVerDetalle.setBounds(10, 127, 116, 23);
		contentPane.add(btnVerDetalle);
		btnVerDetalle.addActionListener(controlador);
	}
	
	@SuppressWarnings("rawtypes")
	public JComboBox getComboBox() {
		return comboBox;
	}

	@SuppressWarnings("rawtypes")
	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public JButton getBtnVerDetalle() {
		return btnVerDetalle;
	}

	public void setBtnVerDetalle(JButton btnVerDetalle) {
		this.btnVerDetalle = btnVerDetalle;
	}
}
