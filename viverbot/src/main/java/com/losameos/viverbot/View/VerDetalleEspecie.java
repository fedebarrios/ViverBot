package com.losameos.viverbot.View;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.losameos.viverbot.Controller.VerDetallesEspecieController;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;

public class VerDetalleEspecie extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel descripcionEspecie;
	private JLabel nombreEspecie;
	private JLabel llegoNombre;
	private JLabel nombreCientificoEspecie;
	private JLabel imagenEspecie;
	private ListaPlantaDeEspecie panel;
	private JLabel llegoNombreC;
	private JButton btnRevivir;
	private JButton btnEliminar;
	


	public VerDetalleEspecie(VerDetallesEspecieController controlador) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		
		descripcionEspecie = new JLabel("Datos detallados sobre la especie");
		descripcionEspecie.setBounds(10, 11, 217, 21);
		contentPane.add(descripcionEspecie);
		
		imagenEspecie = new JLabel("");
		imagenEspecie.setIcon(new ImageIcon(VerDetalleEspecie.class.getResource("/Recursos/mascara.jpg")));
		imagenEspecie.setBounds(10, 43, 163, 143);
		contentPane.add(imagenEspecie);
		
		nombreEspecie = new JLabel("Nombre:");
		nombreEspecie.setBounds(183, 43, 91, 21);
		contentPane.add(nombreEspecie);
		
		nombreCientificoEspecie = new JLabel("Nombre cientifico:");
		nombreCientificoEspecie.setBounds(181, 75, 93, 21);
		contentPane.add(nombreCientificoEspecie);
		
		panel = new ListaPlantaDeEspecie(controlador);
		panel.getListadoPlantas().setLocation(10, 11);
		panel.setBounds(10, 197, 389, 181);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(20, 218, 360, 1);
		contentPane.add(panel_1);
		
		llegoNombre = new JLabel("");
		llegoNombre.setBounds(284, 43, 115, 21);
		contentPane.add(llegoNombre);
		
		llegoNombreC = new JLabel("");
		llegoNombreC.setBounds(284, 75, 115, 21);
		contentPane.add(llegoNombreC);
		
		btnRevivir = new JButton("Revivir");
		btnRevivir.setBounds(157, 389, 117, 29);
		contentPane.add(btnRevivir);
		btnRevivir.addActionListener(controlador);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(284, 389, 117, 29);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(controlador);
		

	}

	public void visible(boolean valor)
	{
		this.setVisible(valor);
	}
	public ListaPlantaDeEspecie getPanel() {
		return panel;
	}


	public void setPanel(ListaPlantaDeEspecie panel) {
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
		this.imagenEspecie.setIcon(new ImageIcon(VerDetalleEspecie.class.getResource("/Recursos/"+imagenEspecie)));
	}

	public JButton getBtnRevivir() {
		return btnRevivir;
	}

	public void setBtnRevivir(JButton btnRevivir) {
		this.btnRevivir = btnRevivir;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
	
	public int filaSeleccionada()
	{
		return panel.filaSeleccionada(); 
	}
	
}
