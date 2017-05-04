package viverbot.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PrincipalView extends JFrame {

	private JPanel contentPane;
	
	private JMenuBar menuBar;
	//Menu Administracion
	private JMenu menuAdministracion;
	//MenuAutomatizacion
	private JMenu mnAutomatizacin;
	private JMenuItem mntmControlarAltura;
	private JMenuItem mntmControolarHumedad;
	private JMenuItem mntmControlarTemperatura;
	
	

	
	public PrincipalView(ActionListener controlador) {
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
		
		 menuAdministracion = new JMenu("Administración");
		menuBar.add(menuAdministracion);
		
		 mnAutomatizacin = new JMenu("Automatización");
		menuBar.add(mnAutomatizacin);
		
		 mntmControlarAltura = new JMenuItem("Controlar Altura");
		mnAutomatizacin.add(mntmControlarAltura);
		this.mntmControlarAltura.addActionListener(controlador);
		
		 mntmControolarHumedad = new JMenuItem("Controlar Humedad");
		mnAutomatizacin.add(mntmControolarHumedad);
		this.mntmControolarHumedad.addActionListener(controlador);
		
		 mntmControlarTemperatura = new JMenuItem("Controlar Temperatura");
		mnAutomatizacin.add(mntmControlarTemperatura);
		this.mntmControlarTemperatura.addActionListener(controlador);
	}
	
	

	public void mostrar() {
		this.setVisible(true);
	}
	
	//getters

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
}
