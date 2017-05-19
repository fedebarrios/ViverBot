package viverbot.Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viverbot.Controlador.ControlManualAireVistaController;

public class ControlManualAireVista extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("rawtypes")
	private JComboBox dropdown_friocalor;
	@SuppressWarnings("rawtypes")
	private JComboBox dropdown_potencia;
	@SuppressWarnings("rawtypes")
	private JComboBox dropdown_temperatura;
	private JLabel label_friocalor;
	private JLabel label_potencia;
	private JLabel label_temperatura;
	private JButton btn_guardar;
	private JButton btn_encenderAire;
	private JButton btn_cerrar;

	@SuppressWarnings("rawtypes")
	public ControlManualAireVista(ControlManualAireVistaController controlador) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 280, 272);
		setTitle("Configuracion manual");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		label_friocalor = new JLabel("Frio/Calor");
		label_friocalor.setBounds(10, 11, 108, 29);
		contentPane.add(label_friocalor);

		label_potencia = new JLabel("Potencia");
		label_potencia.setBounds(10, 51, 108, 29);
		contentPane.add(label_potencia);

		label_temperatura = new JLabel("Temperatura");
		label_temperatura.setBounds(10, 91, 108, 29);
		contentPane.add(label_temperatura);

		dropdown_friocalor = new JComboBox();
		dropdown_friocalor.setBounds(128, 11, 125, 29);
		dropdown_friocalor.addActionListener(controlador);
		contentPane.add(dropdown_friocalor);

		dropdown_potencia = new JComboBox();
		dropdown_potencia.setBounds(128, 51, 125, 29);
		dropdown_potencia.addActionListener(controlador);
		contentPane.add(dropdown_potencia);

		dropdown_temperatura = new JComboBox();
		dropdown_temperatura.setBounds(128, 91, 125, 29);
		dropdown_temperatura.addActionListener(controlador);
		contentPane.add(dropdown_temperatura);

		btn_guardar = new JButton("Guardar");
		btn_guardar.setBounds(145, 165, 108, 23);
		contentPane.add(btn_guardar);
		btn_guardar.addActionListener(controlador);

		btn_encenderAire = new JButton("On / Off");
		btn_encenderAire.setBounds(145, 131, 108, 23);
		contentPane.add(btn_encenderAire);
		btn_encenderAire.addActionListener(controlador);

		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.setBounds(145, 199, 108, 23);
		contentPane.add(btn_cerrar);
		btn_cerrar.addActionListener(controlador);

	}

	public JButton getBtn_guardar() {
		return btn_guardar;
	}

	public JButton getBtn_encenderAire() {
		return btn_encenderAire;
	}

	public JButton getBtn_cerrar() {
		return btn_cerrar;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getDropdown_friocalor() {
		return dropdown_friocalor;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getDropdown_potencia() {
		return dropdown_potencia;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getDropdown_temperatura() {
		return dropdown_temperatura;
	}
}
