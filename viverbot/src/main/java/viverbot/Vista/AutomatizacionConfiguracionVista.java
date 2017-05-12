package viverbot.Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viverbot.Controlador.AutomatizacionConfiguracionController;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AutomatizacionConfiguracionVista extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_friocalor;
	private JTextField text_potencia;
	private JTextField text_temperatura;
	private JButton btn_friocalor;
	private JButton btn_potencia;
	private JButton bnt_temperatura;
	private JButton btn_encenderAutomatizador;
	private JButton btn_encenderAire;

	public AutomatizacionConfiguracionVista(AutomatizacionConfiguracionController controlador) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 466, 205);
		setTitle("Configuracion de aire acondicionado");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Frio/Calor");
		lblNewLabel.setBounds(10, 11, 149, 29);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("Potencia");
		label.setBounds(10, 51, 149, 29);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Temperatura");
		label_1.setBounds(10, 91, 149, 29);
		contentPane.add(label_1);

		text_friocalor = new JTextField();
		text_friocalor.setBounds(169, 11, 149, 29);
		contentPane.add(text_friocalor);
		text_friocalor.setColumns(10);

		text_potencia = new JTextField();
		text_potencia.setColumns(10);
		text_potencia.setBounds(169, 51, 149, 29);
		contentPane.add(text_potencia);

		text_temperatura = new JTextField();
		text_temperatura.setColumns(10);
		text_temperatura.setBounds(169, 91, 149, 29);
		contentPane.add(text_temperatura);

		btn_friocalor = new JButton("Set");
		btn_friocalor.setBounds(328, 14, 108, 23);
		contentPane.add(btn_friocalor);

		btn_potencia = new JButton("Set");
		btn_potencia.setBounds(328, 54, 108, 23);
		contentPane.add(btn_potencia);

		bnt_temperatura = new JButton("Set");
		bnt_temperatura.setBounds(328, 94, 108, 23);
		contentPane.add(bnt_temperatura);

		btn_encenderAutomatizador = new JButton("on/off automatizador");
		btn_encenderAutomatizador.setBounds(10, 131, 208, 29);
		contentPane.add(btn_encenderAutomatizador);
		btn_encenderAutomatizador.addActionListener(controlador);

		btn_encenderAire = new JButton("on/off aire acondicionado");
		btn_encenderAire.setBounds(228, 131, 208, 29);
		contentPane.add(btn_encenderAire);
		btn_encenderAire.addActionListener(controlador);
	}

	public JTextField getText_friocalor() {
		return text_friocalor;
	}

	public void setText_friocalor(JTextField text_friocalor) {
		this.text_friocalor = text_friocalor;
	}

	public JTextField getText_potencia() {
		return text_potencia;
	}

	public void setText_potencia(JTextField text_potencia) {
		this.text_potencia = text_potencia;
	}

	public JTextField getText_temperatura() {
		return text_temperatura;
	}

	public void setText_temperatura(JTextField text_temperatura) {
		this.text_temperatura = text_temperatura;
	}

	public JButton getBtn_friocalor() {
		return btn_friocalor;
	}

	public void setBtn_friocalor(JButton btn_friocalor) {
		this.btn_friocalor = btn_friocalor;
	}

	public JButton getBtn_potencia() {
		return btn_potencia;
	}

	public void setBtn_potencia(JButton btn_potencia) {
		this.btn_potencia = btn_potencia;
	}

	public JButton getBnt_temperatura() {
		return bnt_temperatura;
	}

	public void setBnt_temperatura(JButton bnt_temperatura) {
		this.bnt_temperatura = bnt_temperatura;
	}

	public JButton getBtn_encenderAutomatizador() {
		return btn_encenderAutomatizador;
	}

	public void setBtn_encenderAutomatizador(JButton btn_encenderAutomatizador) {
		this.btn_encenderAutomatizador = btn_encenderAutomatizador;
	}

	public JButton getBtn_encenderAire() {
		return btn_encenderAire;
	}

	public void setBtn_encenderAire(JButton btn_encenderAire) {
		this.btn_encenderAire = btn_encenderAire;
	}

}
