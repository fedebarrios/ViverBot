package viverbot.Vista.Plantas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viverbot.Controlador.Plantas.Controlador_BajaPlanta;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Vista_BajaPlanta extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cmbPlantas;
	private JButton btnCancelar;
	private JButton btnBorrar;
	
	public Vista_BajaPlanta(Controlador_BajaPlanta controlador) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarPlanta = new JLabel("Seleccione una planta");
		lblSeleccionarPlanta.setBounds(10, 11, 119, 14);
		contentPane.add(lblSeleccionarPlanta);
		
		cmbPlantas = new JComboBox<String>();
		cmbPlantas.setBounds(10, 36, 176, 20);
		contentPane.add(cmbPlantas);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(137, 98, 89, 23);
		btnCancelar.addActionListener(controlador);
		contentPane.add(btnCancelar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(235, 98, 89, 23);
		btnBorrar.addActionListener(controlador);
		contentPane.add(btnBorrar);
	}
	
	public void mostrarVentana(){
		this.setVisible(true);
	}
	
	public void cerrarVentana(){
		dispose();
	}
	
	public void limpiarVista(){
		cmbPlantas.removeAllItems();
	}

	public JComboBox<String> getCmbPlantas() {
		return cmbPlantas;
	}

	public void setCmbPlantas(JComboBox<String> cmbPlantas) {
		this.cmbPlantas = cmbPlantas;
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
}
