package viverbot.Vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import viverbot.Controlador.AutomatizacionController;

public class AutomatizacionVista extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_temperaturaAmbiente;
	private JTextField text_rango;
	private JTextField text_encendido;
	private JTextField text_estado;
	private JTextField text_potencia;
	private JTextField text_temperaturaAire;
	private JLabel label_temperaturaAmbiente;
	private JLabel label_rango;
	private JLabel label_encendido;
	private JLabel label_estado;
	private JLabel label_potencia;
	private JLabel label_temperaturaAire;
	private JMenuBar menuBar;
	private JMenu menu_archivo;
	private JMenuItem menuitem_salir;
	private JMenu menu_opciones;
	private JMenuItem menuitem_configuracion;

	public AutomatizacionVista(AutomatizacionController controlador) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 363, 317);
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

		menuitem_configuracion = new JMenuItem("Configuracion");
		menu_opciones.add(menuitem_configuracion);
		menuitem_configuracion.addActionListener(controlador);

		label_temperaturaAmbiente = new JLabel("Temperatura ambiente en C°");
		label_temperaturaAmbiente.setBounds(10, 43, 153, 26);
		contentPane.add(label_temperaturaAmbiente);

		label_rango = new JLabel("Rango establecido");
		label_rango.setBounds(10, 82, 153, 26);
		contentPane.add(label_rango);

		label_encendido = new JLabel("Estado de automatizacion");
		label_encendido.setBounds(10, 119, 153, 26);
		contentPane.add(label_encendido);

		label_estado = new JLabel("Frio/Calor");
		label_estado.setBounds(10, 156, 153, 26);
		contentPane.add(label_estado);

		label_potencia = new JLabel("Potencia");
		label_potencia.setBounds(10, 193, 153, 26);
		contentPane.add(label_potencia);

		label_temperaturaAire = new JLabel("Temperatura del aire en C°");
		label_temperaturaAire.setBounds(10, 230, 153, 26);
		contentPane.add(label_temperaturaAire);

		text_temperaturaAmbiente = new JTextField();
		text_temperaturaAmbiente.setColumns(10);
		text_temperaturaAmbiente.setBounds(173, 45, 153, 26);
		text_temperaturaAmbiente.addActionListener(controlador);
		contentPane.add(text_temperaturaAmbiente);

		text_rango = new JTextField();
		text_rango.setBounds(173, 82, 153, 26);
		text_rango.addActionListener(controlador);
		text_rango.setColumns(10);
		contentPane.add(text_rango);

		text_encendido = new JTextField();
		text_encendido.setBounds(173, 119, 153, 26);
		text_encendido.addActionListener(controlador);
		text_encendido.setColumns(10);
		contentPane.add(text_encendido);

		text_estado = new JTextField();
		text_estado.setColumns(10);
		text_estado.setBounds(173, 156, 153, 26);
		text_estado.addActionListener(controlador);
		contentPane.add(text_estado);

		text_potencia = new JTextField();
		text_potencia.setColumns(10);
		text_potencia.setBounds(173, 193, 153, 26);
		text_potencia.addActionListener(controlador);
		contentPane.add(text_potencia);

		text_temperaturaAire = new JTextField();
		text_temperaturaAire.setColumns(10);
		text_temperaturaAire.setBounds(173, 230, 153, 26);
		text_temperaturaAire.addActionListener(controlador);
		contentPane.add(text_temperaturaAire);

	}

	public JTextField getText_rango() {
		return text_rango;
	}

	public void setText_rango(JTextField text_rango) {
		this.text_rango = text_rango;
	}

	public JTextField getText_encendido() {
		return text_encendido;
	}

	public void setText_encendido(JTextField text_encendido) {
		this.text_encendido = text_encendido;
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

	public void setText_temperaturaAire(JTextField text_temperatura) {
		this.text_temperaturaAire = text_temperatura;
	}

	public JMenuItem getMenuitem_salir() {
		return menuitem_salir;
	}

	public void setMenuitem_salir(JMenuItem menuitem_salir) {
		this.menuitem_salir = menuitem_salir;
	}

	public JMenuItem getMenuitem_configuracion() {
		return menuitem_configuracion;
	}

	public void setMenuitem_configuracion(JMenuItem menuitem_configuracion) {
		this.menuitem_configuracion = menuitem_configuracion;
	}

	public JTextField getText_temperaturaAmbiente() {
		return text_temperaturaAmbiente;
	}

	public void setText_temperaturaAmbiente(JTextField text_temperaturaAmbiente) {
		this.text_temperaturaAmbiente = text_temperaturaAmbiente;
	}

}
