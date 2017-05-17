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

public class VistaConfiguracionDirectorios extends JFrame{
	
	private JPanel contentPane;
	private JLabel seleccioneDirectorios;
	private JLabel directorioPrimario;
	private JTextField directorio1_tf;
	private JButton btnCargarDirectorio1;
	private JTextField directorio2_tf;
	private JTextField directorio3_tf;
	private JRadioButton rdDirectorio1;
	private JRadioButton rdDirectorio2;
	private JRadioButton rdDirectorio3;

	public VistaConfiguracionDirectorios(ControladorConfiguracionDirectorio controlador){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 300);
		setTitle("Directorios configurados");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		this.seleccioneDirectorios = new JLabel("Seleccione que directorio quiere modificar");
		this.seleccioneDirectorios.setBounds(10, 11, 324, 16);
		contentPane.add(this.seleccioneDirectorios);
		
		this.directorioPrimario = new JLabel("Directorio Primario");
		this.directorioPrimario.setBounds(10, 50, 157, 16);
		contentPane.add(this.directorioPrimario);
		
		this.directorio1_tf = new JTextField();
		this.directorio1_tf.setBounds(177, 48, 176, 20);
		contentPane.add(this.directorio1_tf);
		this.directorio1_tf.setColumns(10);
		
		btnCargarDirectorio1 = new JButton("Cargar Directorio");
		btnCargarDirectorio1.setBounds(213, 227, 176, 23);
		contentPane.add(btnCargarDirectorio1);
		this.btnCargarDirectorio1.addActionListener(controlador);
		
		JLabel directorioSecundario = new JLabel("Directorio Secundario");
		directorioSecundario.setBounds(10, 104, 157, 16);
		contentPane.add(directorioSecundario);
		
		JLabel lblDirectorioTerciario = new JLabel("Directorio Terciario");
		lblDirectorioTerciario.setBounds(10, 163, 157, 16);
		contentPane.add(lblDirectorioTerciario);
		
		directorio2_tf = new JTextField();
		directorio2_tf.setColumns(10);
		directorio2_tf.setBounds(177, 102, 176, 20);
		contentPane.add(directorio2_tf);
		
		directorio3_tf = new JTextField();
		directorio3_tf.setColumns(10);
		directorio3_tf.setBounds(177, 161, 176, 20);
		contentPane.add(directorio3_tf);
		
		rdDirectorio1 = new JRadioButton("");
		rdDirectorio1.setBounds(359, 48, 109, 23);
		contentPane.add(rdDirectorio1);
		
		rdDirectorio2 = new JRadioButton("");
		rdDirectorio2.setBounds(359, 99, 109, 23);
		contentPane.add(rdDirectorio2);
		
		rdDirectorio3 = new JRadioButton("");
		rdDirectorio3.setBounds(359, 158, 109, 23);
		contentPane.add(rdDirectorio3);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdDirectorio1);
		grupo.add(rdDirectorio2);
		grupo.add(rdDirectorio3);
	}

	public JTextField getDirectorio1() {
		return directorio1_tf;
	}

	public void setDirectorio1(String s) {
		this.directorio1_tf.setText(s);
	}
	
	public JTextField getDirectorio2() {
		return directorio2_tf;
	}

	public void setDirectorio2(String s) {
		this.directorio2_tf.setText(s);
	}
	
	public JTextField getDirectorio3() {
		return directorio3_tf;
	}

	public void setDirectorio3(String s) {
		this.directorio3_tf.setText(s);
	}
	
	public JButton getBtnCargarDirectorio() {
		return btnCargarDirectorio1;
	}

	public JRadioButton getRdDirectorio1() {
		return rdDirectorio1;
	}

	public void setRdDirectorio1(boolean b) {
		this.rdDirectorio1.setSelected(b);
	}

	public JRadioButton getRdDirectorio2() {
		return rdDirectorio2;
	}

	public void setRdDirectorio2(boolean b) {
		this.rdDirectorio2.setSelected(b);
	}

	public JRadioButton getRdDirectorio3() {
		return rdDirectorio3;
	}

	public void setRdDirectorio3(boolean b) {
		this.rdDirectorio3.setSelected(b);
	}
}
