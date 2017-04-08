package com.losameos.viverbot.VistasPlantas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.losameos.viverbot.ControladorPlantas.Controlador_AltaPlanta;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Vista_AltaPlanta extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUbicacion;
	private JLabel lblAltaDePlanta;
	private JButton btnSeleccionarUbicacion;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblUbicacion;
	private JLabel lblFechaPlantado;
	private JCalendar calendarFiltro;
	private Date dateFiltro;
	private JComboBox<String> comboBox;
	
	@SuppressWarnings("deprecation")
	public Vista_AltaPlanta(Controlador_AltaPlanta controlador) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 367, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAltaDePlanta = new JLabel("Alta de planta");
		lblAltaDePlanta.setFont(new Font("Forte", Font.PLAIN, 22));
		lblAltaDePlanta.setBounds(93, 11, 155, 31);
		contentPane.add(lblAltaDePlanta);
		
		lblUbicacion = new JLabel("Ubicación");
		lblUbicacion.setBounds(10, 125, 69, 14);
		contentPane.add(lblUbicacion);
		
		textUbicacion = new JTextField();
		textUbicacion.setBounds(138, 118, 183, 20);
		contentPane.add(textUbicacion);
		textUbicacion.setColumns(10);
		
		btnSeleccionarUbicacion = new JButton("+");
		btnSeleccionarUbicacion.setBounds(320, 118, 21, 19);
		btnSeleccionarUbicacion.addActionListener(controlador);
		contentPane.add(btnSeleccionarUbicacion);
		
		lblFechaPlantado = new JLabel("Fecha de plantado");
		lblFechaPlantado.setBounds(10, 186, 145, 14);
		contentPane.add(lblFechaPlantado);
		
		calendarFiltro = new JCalendar();
		calendarFiltro.setBounds(138, 185, 200, 170);
		contentPane.add(calendarFiltro);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(249, 355, 89, 23);
		btnCancelar.addActionListener(controlador);
		contentPane.add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(150, 355, 89, 23);
		btnAceptar.addActionListener(controlador);
		contentPane.add(btnAceptar);
		
		JLabel lblEspecie = new JLabel("Especie");
		lblEspecie.setBounds(10, 64, 46, 14);
		contentPane.add(lblEspecie);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(137, 61, 204, 20);
		contentPane.add(comboBox);
		
		calendarFiltro.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
				dateFiltro.setDate((Integer) e.getNewValue());
			}
		});
		calendarFiltro.getMonthChooser().addPropertyChangeListener("month", new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
				dateFiltro.setMonth((Integer) e.getNewValue());
			}
		});
		calendarFiltro.getYearChooser().addPropertyChangeListener("year", new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
				dateFiltro.setYear((Integer) e.getNewValue() - 1900);
			}
		});
		dateFiltro = new Date(calendarFiltro.getYearChooser().getYear() - 1900,
				calendarFiltro.getMonthChooser().getMonth(), calendarFiltro.getDayChooser().getDay());
	}

	public void mostrarVentana() {
		this.setVisible(true);
	}

	public JTextField getTextUbicacion() {
		return textUbicacion;
	}

	public void setTextUbicacion(JTextField textUbicacion) {
		this.textUbicacion = textUbicacion;
	}

	public Date getDateFiltro() {
		return dateFiltro;
	}

	public void setDateFiltro(Date dateFiltro) {
		this.dateFiltro = dateFiltro;
	}

	public JButton getBtnSeleccionarUbicacion() {
		return btnSeleccionarUbicacion;
	}

	public void setBtnSeleccionarUbicacion(JButton btnSeleccionarUbicacion) {
		this.btnSeleccionarUbicacion = btnSeleccionarUbicacion;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}
}
