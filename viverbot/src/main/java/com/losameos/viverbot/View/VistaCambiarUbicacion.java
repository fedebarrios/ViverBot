package com.losameos.viverbot.View;

import java.awt.Color;

//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.losameos.viverbot.Controller.UbicacionController;


public class VistaCambiarUbicacion  extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JLabel descripcionUbicacion;
	private JPanel contentPane;
	private JLabel fila;
	private JLabel columna;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextField TColumna;
	private JTextField TFila;

	
	public VistaCambiarUbicacion(UbicacionController controlador) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		descripcionUbicacion = new JLabel("Datos sobre la ubicacion");
		descripcionUbicacion.setBounds(27, 26, 217, 16);
		contentPane.add(descripcionUbicacion);
		
//		imagenEspecie = new JLabel("");
//		imagenEspecie.setIcon(new ImageIcon(VerDetalleEspecie.class.getResource("/Recursos/rosa.jpg")));
//		imagenEspecie.setBounds(23, 63, 163, 143);
//		contentPane.add(imagenEspecie);
		
		fila = new JLabel("Fila:");
		fila.setBounds(69, 50, 61, 16);
		contentPane.add(fila);
		
		columna = new JLabel("Columna:");
		columna.setBounds(66, 100, 64, 16);
		contentPane.add(columna);
		
		this.TColumna = new JTextField();
		this.TColumna.setBounds(140, 48, 176, 20);
		contentPane.add(this.TColumna);
		this.TColumna.setColumns(10);
		
		this.TFila = new JTextField();
		this.TFila.setBounds(140, 98, 176, 20);
		contentPane.add(this.TFila);
		this.TFila.setColumns(10);

		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(20, 218, 360, 1);
		contentPane.add(panel_1);
		

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(69, 178, 117, 29);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(controlador);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(209, 178, 117, 29);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(controlador);
		

	}

	public void visible(boolean valor)
	{
		this.setVisible(valor);
	}

	public JButton getBtnAceptar() {
		// TODO Auto-generated method stub
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		// TODO Auto-generated method stub
		return btnAceptar;
	}

	
	
}
