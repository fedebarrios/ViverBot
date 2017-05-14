package viverbot.Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viverbot.Controlador.ControlManualAireVistaController;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ControlManualAireVista extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox dropdown_friocalor;
	private JComboBox dropdown_potencia;
	private JTextField text_temperatura;
	private JLabel label_friocalor;
	private JLabel label_potencia;
	private JLabel label_temperatura;
	private JButton btn_guardar;
	private JButton btn_encenderAire;
	private JButton btn_cerrar;

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
		contentPane.add(dropdown_friocalor);

		dropdown_potencia = new JComboBox();
		dropdown_potencia.setBounds(128, 51, 125, 29);
		contentPane.add(dropdown_potencia);

		text_temperatura = new JTextField();
		text_temperatura.setColumns(10);
		text_temperatura.setBounds(128, 91, 125, 29);
		contentPane.add(text_temperatura);
		text_temperatura.addActionListener(controlador);

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

	public JTextField getText_temperatura() {
		return text_temperatura;
	}

	public void setText_temperatura(JTextField text_temperatura) {
		this.text_temperatura = text_temperatura;
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

	public JComboBox getDropdown_friocalor() {
		return dropdown_friocalor;
	}

	public void setDropdown_friocalor(JComboBox dropdown_friocalor) {
		this.dropdown_friocalor = dropdown_friocalor;
	}

	public JComboBox getDropdown_potencia() {
		return dropdown_potencia;
	}

	public void setDropdown_potencia(JComboBox dropdown_potencia) {
		this.dropdown_potencia = dropdown_potencia;
	}

}
