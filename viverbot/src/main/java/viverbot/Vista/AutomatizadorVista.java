package viverbot.Vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viverbot.Controlador.AutomatizadorVistaController;

public class AutomatizadorVista extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label_temperaturaAmbiente;
	private JLabel label_rango;
	private JLabel label_encendidoAutomatizador;
	private JLabel label_controlmanual;
	private JLabel label_estado;
	private JLabel label_potencia;
	private JLabel label_temperaturaAire;
	private JMenuBar menuBar;
	private JMenu menu_archivo;
	private JMenuItem menuitem_salir;
	private JMenu menu_opciones;
	private JMenuItem menuitem_onOffAutomatizador;
	private JMenuItem menuitem_configuracionManual;
	private JLabel label_texttemperaturaAmbiente;
	private JLabel label_textrango;
	private JLabel label_textencendidoAutomatizador;
	private JLabel label_textcontrolManual;
	private JLabel label_textestado;
	private JLabel label_textpotencia;
	private JLabel label_texttemperaturaAire;

	public AutomatizadorVista(AutomatizadorVistaController controlador) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 358, 333);
		setTitle("Automatizacion de temperatura");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);

		menu_archivo = new JMenu("Archivo");
		menuBar.add(menu_archivo);

		menuitem_salir = new JMenuItem("Salir");
		menu_archivo.add(menuitem_salir);
		menuitem_salir.addActionListener(controlador);

		menu_opciones = new JMenu("Opciones");
		menuBar.add(menu_opciones);

		menuitem_onOffAutomatizador = new JMenuItem("On/Off automatizador");
		menu_opciones.add(menuitem_onOffAutomatizador);
		menuitem_onOffAutomatizador.addActionListener(controlador);

		menuitem_configuracionManual = new JMenuItem("Configuracion manual");
		menu_opciones.add(menuitem_configuracionManual);
		menuitem_configuracionManual.addActionListener(controlador);

		label_temperaturaAmbiente = new JLabel("Temperatura del ambiente");
		label_temperaturaAmbiente.setBounds(10, 32, 194, 26);
		contentPane.add(label_temperaturaAmbiente);

		label_rango = new JLabel("Rango establecido");
		label_rango.setBounds(10, 69, 194, 26);
		contentPane.add(label_rango);

		label_encendidoAutomatizador = new JLabel("Estado de automatizacion");
		label_encendidoAutomatizador.setBounds(10, 106, 194, 26);
		contentPane.add(label_encendidoAutomatizador);

		label_controlmanual = new JLabel("Control manual");
		label_controlmanual.setBounds(10, 143, 194, 26);
		contentPane.add(label_controlmanual);

		label_estado = new JLabel("Frio/Calor");
		label_estado.setBounds(10, 180, 194, 26);
		contentPane.add(label_estado);

		label_potencia = new JLabel("Potencia");
		label_potencia.setBounds(10, 217, 194, 26);
		contentPane.add(label_potencia);

		label_temperaturaAire = new JLabel("Temperatura del aire acondicionado");
		label_temperaturaAire.setBounds(10, 254, 194, 26);
		contentPane.add(label_temperaturaAire);

		label_texttemperaturaAmbiente = new JLabel("");
		label_texttemperaturaAmbiente.setBounds(214, 32, 118, 21);
		contentPane.add(label_texttemperaturaAmbiente);

		label_textrango = new JLabel("");
		label_textrango.setBounds(214, 69, 118, 21);
		contentPane.add(label_textrango);

		label_textencendidoAutomatizador = new JLabel("");
		label_textencendidoAutomatizador.setBounds(214, 106, 118, 21);
		contentPane.add(label_textencendidoAutomatizador);

		label_textcontrolManual = new JLabel("");
		label_textcontrolManual.setBounds(214, 143, 118, 21);
		contentPane.add(label_textcontrolManual);

		label_textestado = new JLabel("");
		label_textestado.setBounds(214, 180, 118, 21);
		contentPane.add(label_textestado);

		label_textpotencia = new JLabel("");
		label_textpotencia.setBounds(214, 217, 118, 21);
		contentPane.add(label_textpotencia);

		label_texttemperaturaAire = new JLabel("");
		label_texttemperaturaAire.setBounds(214, 254, 118, 21);
		contentPane.add(label_texttemperaturaAire);
	}

	public JMenuItem getMenuitem_salir() {
		return menuitem_salir;
	}

	public JMenuItem getMenuitem_onOffAutomatizador() {
		return menuitem_onOffAutomatizador;
	}

	public JMenuItem getMenuitem_configuracionManual() {
		return menuitem_configuracionManual;
	}

	public JLabel getLabel_texttemperaturaAmbiente() {
		return label_texttemperaturaAmbiente;
	}

	public void setLabel_texttemperaturaAmbiente(JLabel label_texttemperaturaAmbiente) {
		this.label_texttemperaturaAmbiente = label_texttemperaturaAmbiente;
	}

	public JLabel getLabel_textrango() {
		return label_textrango;
	}

	public void setLabel_textrango(JLabel label_textrango) {
		this.label_textrango = label_textrango;
	}

	public JLabel getLabel_textencendidoAutomatizador() {
		return label_textencendidoAutomatizador;
	}

	public void setLabel_textencendidoAutomatizador(JLabel label_textencendidoAutomatizador) {
		this.label_textencendidoAutomatizador = label_textencendidoAutomatizador;
	}

	public JLabel getLabel_textcontrolManual() {
		return label_textcontrolManual;
	}

	public void setLabel_textcontrolManual(JLabel label_textcontrolManual) {
		this.label_textcontrolManual = label_textcontrolManual;
	}

	public JLabel getLabel_textestado() {
		return label_textestado;
	}

	public void setLabel_textestado(JLabel label_textestado) {
		this.label_textestado = label_textestado;
	}

	public JLabel getLabel_textpotencia() {
		return label_textpotencia;
	}

	public void setLabel_textpotencia(JLabel label_textpotencia) {
		this.label_textpotencia = label_textpotencia;
	}

	public JLabel getLabel_texttemperaturaAire() {
		return label_texttemperaturaAire;
	}

	public void setLabel_texttemperaturaAire(JLabel label_texttemperaturaAire) {
		this.label_texttemperaturaAire = label_texttemperaturaAire;
	}

}
