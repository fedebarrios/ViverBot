package viverbot.Vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import viverbot.Controlador.AutomatizadorVistaController;

public class AutomatizadorVista extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_temperaturaAmbiente;
	private JTextField text_rango;
	private JTextField text_encendidoAutomatizador;
	private JTextField text_controlmanual;
	private JTextField text_estado;
	private JTextField text_potencia;
	private JTextField text_temperaturaAire;
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

		text_temperaturaAmbiente = new JTextField();
		text_temperaturaAmbiente.setColumns(10);
		text_temperaturaAmbiente.setBounds(214, 32, 112, 26);
		text_temperaturaAmbiente.addActionListener(controlador);
		contentPane.add(text_temperaturaAmbiente);

		text_rango = new JTextField();
		text_rango.setBounds(214, 69, 112, 26);
		text_rango.addActionListener(controlador);
		text_rango.setColumns(10);
		contentPane.add(text_rango);

		text_encendidoAutomatizador = new JTextField();
		text_encendidoAutomatizador.setBounds(214, 106, 112, 26);
		text_encendidoAutomatizador.addActionListener(controlador);
		text_encendidoAutomatizador.setColumns(10);
		contentPane.add(text_encendidoAutomatizador);

		text_controlmanual = new JTextField();
		text_controlmanual.setColumns(10);
		text_controlmanual.setBounds(214, 143, 112, 26);
		contentPane.add(text_controlmanual);
		text_controlmanual.addActionListener(controlador);

		text_estado = new JTextField();
		text_estado.setColumns(10);
		text_estado.setBounds(214, 180, 112, 26);
		text_estado.addActionListener(controlador);
		contentPane.add(text_estado);

		text_potencia = new JTextField();
		text_potencia.setColumns(10);
		text_potencia.setBounds(214, 217, 112, 26);
		text_potencia.addActionListener(controlador);
		contentPane.add(text_potencia);

		text_temperaturaAire = new JTextField();
		text_temperaturaAire.setColumns(10);
		text_temperaturaAire.setBounds(214, 254, 112, 26);
		text_temperaturaAire.addActionListener(controlador);
		contentPane.add(text_temperaturaAire);
	}

	public JTextField getText_temperaturaAmbiente() {
		return text_temperaturaAmbiente;
	}

	public void setText_temperaturaAmbiente(JTextField text_temperaturaAmbiente) {
		this.text_temperaturaAmbiente = text_temperaturaAmbiente;
	}

	public JTextField getText_rango() {
		return text_rango;
	}

	public void setText_rango(JTextField text_rango) {
		this.text_rango = text_rango;
	}

	public JTextField getText_encendidoAutomatizador() {
		return text_encendidoAutomatizador;
	}

	public void setText_encendidoAutomatizador(JTextField text_encendidoAutomatizador) {
		this.text_encendidoAutomatizador = text_encendidoAutomatizador;
	}

	public JTextField getText_controlmanual() {
		return text_controlmanual;
	}

	public void setText_controlmanual(JTextField text_controlmanual) {
		this.text_controlmanual = text_controlmanual;
	}

	public JTextField getText_estado() {
		return text_estado;
	}

	public void setText_estado(JTextField text_estado) {
		this.text_estado = text_estado;
	}

	public JTextField getText_potencia() {
		return text_potencia;
	}

	public void setText_potencia(JTextField text_potencia) {
		this.text_potencia = text_potencia;
	}

	public JTextField getText_temperaturaAire() {
		return text_temperaturaAire;
	}

	public void setText_temperaturaAire(JTextField text_temperaturaAire) {
		this.text_temperaturaAire = text_temperaturaAire;
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

}
