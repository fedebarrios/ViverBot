package viverobot.Vista.WebCam;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viverbot.Controlador.WebCam.ObtenedorComando;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ObtenedorSeleccionVista extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPanePrimera;
	private JScrollPane scrollPaneSegunda;
	private JButton btnCargar;
	private JButton btnFiltrar;
	private JButton btnCerrar;
	private JLabel panelPrimeraImagen;
	private JLabel panelSegundaImagen;
	
	public ObtenedorSeleccionVista(ObtenedorComando controlador) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		iniComponentes();
		listenerControlador(controlador);
		
	
	}
	
	private void iniComponentes()
	{
		scrollPanePrimera = new JScrollPane();
		scrollPanePrimera.setBounds(19, 19, 310, 405);
		contentPane.add(scrollPanePrimera);
		
		scrollPaneSegunda = new JScrollPane();
		scrollPaneSegunda.setBounds(341, 19, 310, 405);
		contentPane.add(scrollPaneSegunda);
		
		panelPrimeraImagen = new JLabel("Primer imagen");
		scrollPanePrimera.setViewportView(panelPrimeraImagen);
		
		panelSegundaImagen = new JLabel("Segunda imagen");
		scrollPaneSegunda.setViewportView(panelSegundaImagen);
		
		btnCargar = new JButton("Cargar");
		btnCargar.setBounds(13, 436, 117, 29);
		contentPane.add(btnCargar);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(134, 436, 117, 29);
		contentPane.add(btnFiltrar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(541, 436, 117, 29);
		contentPane.add(btnCerrar);
	}
	
	private void listenerControlador(ObtenedorComando controlador)
	{
		btnFiltrar.addActionListener(controlador);
		btnCargar.addActionListener(controlador);
		btnCerrar.addActionListener(controlador);

	}
	

	public void visible(boolean b) {
		this.setVisible(b);
	}
	
	public void cerrarVentana() {
		this.dispose();
	}

	public JButton getBtnCargar() {
		return btnCargar;
	}
	
	public JLabel getPanelPrimeraImagen() {
		return panelPrimeraImagen;
	}

	public void setPanelPrimeraImagen(JLabel panelPrimeraImagen) {
		this.panelPrimeraImagen = panelPrimeraImagen;
	}

	public JLabel getPanelSegundaImagen() {
		return panelSegundaImagen;
	}

	public void setPanelSegundaImagen(JLabel panelSegundaImagen) {
		this.panelSegundaImagen = panelSegundaImagen;
	}

	public void setBtnCargar(JButton btnCargar) {
		this.btnCargar = btnCargar;
	}

	public JButton getBtnFiltrar() {
		return btnFiltrar;
	}

	public void setBtnFiltrar(JButton btnFiltrar) {
		this.btnFiltrar = btnFiltrar;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public void setBtnCerrar(JButton btnCerrar) {
		this.btnCerrar = btnCerrar;
	}


	
}
