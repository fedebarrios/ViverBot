package viverbot.Vista;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import viverbot.Controlador.ControladorConfiguracionDirectorio;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class VistaConfiguracionDirectorios extends JFrame{
	
	private JPanel contentPane;
	private JLabel seleccioneDirectorios;
	private JButton btnCargarDirectorio;
	private JComboBox comboBox;
	private JButton btnBorrarDirectorio;
	public VistaConfiguracionDirectorios(ControladorConfiguracionDirectorio controlador){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 212);
		setTitle("Directorios configurados");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		this.seleccioneDirectorios = new JLabel("Seleccione que directorio quiere modificar");
		this.seleccioneDirectorios.setBounds(10, 11, 324, 16);
		contentPane.add(this.seleccioneDirectorios);
		

		btnCargarDirectorio = new JButton("Cargar Directorio");
		btnCargarDirectorio.setBounds(252, 106, 152, 23);
		contentPane.add(btnCargarDirectorio);
		this.btnCargarDirectorio.addActionListener(controlador);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 50, 288, 20);
		contentPane.add(comboBox);
		
		btnBorrarDirectorio = new JButton("Borrar Directorio");
		btnBorrarDirectorio.setBounds(78, 106, 137, 23);
		contentPane.add(btnBorrarDirectorio);
		this.btnBorrarDirectorio.addActionListener(controlador);
	}

	
	public JComboBox getComboBox() {
		return comboBox;
	}

	public JButton getBtnCargarDirectorio() {
		return btnCargarDirectorio;
	}
	public JButton getBtnBorrarDirectorio() {
		return btnBorrarDirectorio;
	}
}
