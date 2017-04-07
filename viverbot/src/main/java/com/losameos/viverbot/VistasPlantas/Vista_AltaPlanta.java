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

public class Vista_AltaPlanta extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textNombreCientifico;
	private JTextField textUbicacion;
	private JLabel lblAltaDePlanta;
	private JLabel lblNewLabel;
	private JLabel lblNombreCientifico;
	private JButton btnSeleccionarUbicacion;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblUbicacion;
	private JLabel lblFechaPlantado;
	private JCalendar calendarFiltro;
	private Date dateFiltro;

	@SuppressWarnings("deprecation")
	public Vista_AltaPlanta(Controlador_AltaPlanta controlador) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 367, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAltaDePlanta = new JLabel("Alta de planta");
		lblAltaDePlanta.setFont(new Font("Forte", Font.PLAIN, 22));
		lblAltaDePlanta.setBounds(97, 11, 155, 31);
		contentPane.add(lblAltaDePlanta);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 63, 69, 14);
		contentPane.add(lblNewLabel);
		
		textNombre = new JTextField();
		textNombre.setBounds(137, 56, 204, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		lblNombreCientifico = new JLabel("Nombre científico");
		lblNombreCientifico.setBounds(10, 111, 117, 14);
		contentPane.add(lblNombreCientifico);
		
		textNombreCientifico = new JTextField();
		textNombreCientifico.setBounds(137, 104, 204, 20);
		contentPane.add(textNombreCientifico);
		textNombreCientifico.setColumns(10);
		
		lblUbicacion = new JLabel("Ubicación");
		lblUbicacion.setBounds(10, 164, 69, 14);
		contentPane.add(lblUbicacion);
		
		textUbicacion = new JTextField();
		textUbicacion.setBounds(138, 157, 183, 20);
		contentPane.add(textUbicacion);
		textUbicacion.setColumns(10);
		
		btnSeleccionarUbicacion = new JButton("+");
		btnSeleccionarUbicacion.setBounds(320, 157, 21, 19);
		btnSeleccionarUbicacion.addActionListener(controlador);
		contentPane.add(btnSeleccionarUbicacion);
		
		lblFechaPlantado = new JLabel("Fecha de plantado");
		lblFechaPlantado.setBounds(10, 225, 145, 14);
		contentPane.add(lblFechaPlantado);
		
		calendarFiltro = new JCalendar();
		calendarFiltro.setBounds(138, 224, 200, 170);
		contentPane.add(calendarFiltro);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(249, 394, 89, 23);
		btnCancelar.addActionListener(controlador);
		contentPane.add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(150, 394, 89, 23);
		btnAceptar.addActionListener(controlador);
		contentPane.add(btnAceptar);
		
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
}
