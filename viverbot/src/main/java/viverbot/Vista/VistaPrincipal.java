package viverbot.Vista;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class VistaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	// Menu Administracion
	private JMenu menuAdministracion;
	// MenuAutomatizacion
	private JMenu mnAutomatizacin;
	private JMenuItem mntmControlarAltura;
	private JMenuItem mntmControolarHumedad;
	private JMenuItem mntmControlarTemperatura;
	private JMenuItem mntmTemperatura;
	private JLabel labelTemperatura;
	private JLabel labelEstado;
	private JLabel labelEstadoSensor;

	public VistaPrincipal(ActionListener controlador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 434, 21);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		panelMenu.add(menuBar);

		menuAdministracion = new JMenu("Automatizacion");
		menuBar.add(menuAdministracion);

		mntmTemperatura = new JMenuItem("De temperatura");
		menuAdministracion.add(mntmTemperatura);
		mntmTemperatura.addActionListener(controlador);

		mnAutomatizacin = new JMenu("Administracion");
		menuBar.add(mnAutomatizacin);

		mntmControlarAltura = new JMenuItem("Controlar Altura");
		mnAutomatizacin.add(mntmControlarAltura);
		this.mntmControlarAltura.addActionListener(controlador);

		mntmControolarHumedad = new JMenuItem("Controlar Humedad");
		mnAutomatizacin.add(mntmControolarHumedad);
		this.mntmControolarHumedad.addActionListener(controlador);

		mntmControlarTemperatura = new JMenuItem("Controlar Temperatura");
		mnAutomatizacin.add(mntmControlarTemperatura);
		
		labelTemperatura = new JLabel("");
		labelTemperatura.setBounds(10, 202, 177, 14);
		contentPane.add(labelTemperatura);
		
		labelEstado = new JLabel("");
		labelEstado.setBounds(10, 218, 414, 14);
		contentPane.add(labelEstado);
		
		 labelEstadoSensor = new JLabel("");
		labelEstadoSensor.setBounds(10, 243, 414, 14);
		contentPane.add(labelEstadoSensor);
		this.mntmControlarTemperatura.addActionListener(controlador);
	}

	public void mostrar() {
		this.setVisible(true);
	}

	// getters

	public JMenuItem getMntmControlarAltura() {
		return mntmControlarAltura;
	}

	public void setMntmControlarAltura(JMenuItem mntmControlarAltura) {
		this.mntmControlarAltura = mntmControlarAltura;
	}

	public JMenuItem getMntmControolarHumedad() {
		return mntmControolarHumedad;
	}

	public void setMntmControolarHumedad(JMenuItem mntmControolarHumedad) {
		this.mntmControolarHumedad = mntmControolarHumedad;
	}

	public JMenuItem getMntmControlarTemperatura() {
		return mntmControlarTemperatura;
	}

	public void setMntmControlarTemperatura(JMenuItem mntmControlarTemperatura) {
		this.mntmControlarTemperatura = mntmControlarTemperatura;
	}

	public JMenuItem getMntmTemperatura() {
		return mntmTemperatura;
	}

	public JLabel getLabelEstado() {
		return labelEstado;
	}

	public void setLabelEstado(String cadena) {
		this.labelEstado.setText(cadena);
	}

	public JLabel getLabelTemperatura() {
		return labelTemperatura;
	}

	public void setLabelTemperatura(String  cadena) {
		this.labelTemperatura.setText(cadena);
	}

	public JLabel getLabelEstadoSensor() {
		return labelEstadoSensor;
	}

	public void setLabelEstadoSensor(String cadena) {
		this.labelEstadoSensor.setText(cadena);
	}
	
	
}
