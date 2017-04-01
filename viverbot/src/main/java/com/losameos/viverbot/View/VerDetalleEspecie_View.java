package com.losameos.viverbot.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class VerDetalleEspecie_View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel descripcionEspecie;
	private JLabel nombreEspecie;
	private JLabel llegoNombre;
	private JLabel nombreCientificoEspecie;
	private JLabel imagenEspecie;
	private ListaPlantaDeEspecie_Panel panel;
	private JLabel llegoNombreC;
	


	public VerDetalleEspecie_View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		
		descripcionEspecie = new JLabel("Datos detallados sobre la especie");
		descripcionEspecie.setBounds(27, 26, 217, 16);
		contentPane.add(descripcionEspecie);
		
		imagenEspecie = new JLabel("");
		imagenEspecie.setIcon(new ImageIcon(VerDetalleEspecie_View.class.getResource("/Recursos/mascara.jpg")));
		imagenEspecie.setBounds(23, 63, 163, 143);
		contentPane.add(imagenEspecie);
		
		nombreEspecie = new JLabel("Nombre:");
		nombreEspecie.setBounds(205, 70, 61, 16);
		contentPane.add(nombreEspecie);
		
		nombreCientificoEspecie = new JLabel("Nombre cientifico:");
		nombreCientificoEspecie.setBounds(205, 115, 139, 16);
		contentPane.add(nombreCientificoEspecie);
		
		panel = new ListaPlantaDeEspecie_Panel();
		panel.setBounds(20, 220, 360, 203);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(20, 218, 360, 1);
		contentPane.add(panel_1);
		
		llegoNombre = new JLabel("");
		llegoNombre.setBounds(265, 87, 115, 16);
		contentPane.add(llegoNombre);
		
		llegoNombreC = new JLabel("");
		llegoNombreC.setBounds(265, 134, 139, 16);
		contentPane.add(llegoNombreC);
		

	}

	public void visible(boolean valor)
	{
		this.setVisible(valor);
	}
	public ListaPlantaDeEspecie_Panel getPanel() {
		return panel;
	}


	public void setPanel(ListaPlantaDeEspecie_Panel panel) {
		this.panel = panel;
	}

	public JLabel getLlegoNombre() {
		return llegoNombre;
	}

	public void setLlegoNombre(String llegoNombre) {
		this.llegoNombre.setText(llegoNombre);
	}

	public JLabel getLlegoNombreC() {
		return llegoNombreC;
	}

	public void setLlegoNombreC(String llegoNombreC) {
		this.llegoNombreC.setText(llegoNombreC);;
	}

	public JLabel getImagenEspecie() {
		return imagenEspecie;
	}

	public void setImagenEspecie(String imagenEspecie) {
		this.imagenEspecie.setIcon(new ImageIcon(VerDetalleEspecie_View.class.getResource("/Recursos/"+imagenEspecie)));
	}
	
	
	
	
}
