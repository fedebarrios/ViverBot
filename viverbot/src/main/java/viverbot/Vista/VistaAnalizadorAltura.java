package viverbot.Vista;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viverbot.Controlador.ControladorAnalizadorAltura;
import viverbot.DTO.Planta;

public class VistaAnalizadorAltura extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelPlantas;
	private JComboBox<Planta> listadoPlantas;
	private JButton btnAnalizarPlanta;

	public VistaAnalizadorAltura(ControladorAnalizadorAltura controladorAnalizadorAltura){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 300);
		setTitle("Analizis de plantas");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		this.labelPlantas = new JLabel("Listado de plantas");
		this.labelPlantas.setBounds(10, 11, 324, 16);
		contentPane.add(this.labelPlantas);
		
		this.listadoPlantas = new JComboBox<Planta>();
		this.listadoPlantas.setBounds(10, 50, 157, 16);
		contentPane.add(this.listadoPlantas);
		this.listadoPlantas.addActionListener(controladorAnalizadorAltura);
		
		btnAnalizarPlanta = new JButton("Analizar Planta");
		btnAnalizarPlanta.setBounds(213, 227, 176, 23);
		contentPane.add(btnAnalizarPlanta);
		this.btnAnalizarPlanta.addActionListener(controladorAnalizadorAltura);
	}
	
	public JButton getBtnAnalizarPlanta() {
		return btnAnalizarPlanta;
	}
	
	public Planta getPlantaSeleccionada() {
		return (Planta) listadoPlantas.getSelectedItem();
	}
	
	public JComboBox<Planta> getComboPlantas() {
		return listadoPlantas;
	}
}
