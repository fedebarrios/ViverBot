package com.losameos.viverbot.View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.losameos.viverbot.Controller.AltaEspecieController;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AltaEspecie extends JFrame{
	
	private JPanel contentPane;
	private JLabel ingreseDatos;
	private JLabel nombreEspecie;
	private JLabel lblImagen;
	private JLabel nombreCientificoEspecie;
	private JTextField nombreEspecie_tf;
	private JTextField nombreCientifico_tf;
	//private JLabel Foto;
	private JButton guardar_btn;
	private JButton cancelar_btn;
	private JTextField imagen_tf;
	


	public AltaEspecie(AltaEspecieController controlador){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 212);
		setTitle("Alta de Especie");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.ingreseDatos = new JLabel("Ingrese la informacion requerida");
		this.ingreseDatos.setBounds(10, 11, 293, 20);
		contentPane.add(this.ingreseDatos);
		
		this.nombreEspecie = new JLabel("Nombre");
		this.nombreEspecie.setBounds(10, 42, 110, 20);
		contentPane.add(this.nombreEspecie);
		
		this.lblImagen = new JLabel("Imagen");
		this.lblImagen.setBounds(10, 104, 110, 20);
		contentPane.add(lblImagen);
		
		this.nombreCientificoEspecie = new JLabel("Nombre Cientifico");
		this.nombreCientificoEspecie.setBounds(10, 73, 110, 20);
		contentPane.add(this.nombreCientificoEspecie);
		
		this.nombreEspecie_tf = new JTextField();
		this.nombreEspecie_tf.setBounds(130, 42, 176, 20);
		contentPane.add(this.nombreEspecie_tf);
		this.nombreEspecie_tf.setColumns(10);
		
		this.nombreCientifico_tf = new JTextField();
		this.nombreCientifico_tf.setBounds(130, 73, 176, 20);
		contentPane.add(this.nombreCientifico_tf);
		this.nombreCientifico_tf.setColumns(10);
		
		this.guardar_btn = new JButton("Guardar");
		this.guardar_btn.setBounds(217, 135, 89, 23);
		contentPane.add(this.guardar_btn);
		this.guardar_btn.addActionListener(controlador);
		
		this.cancelar_btn = new JButton("Cancelar");
		this.cancelar_btn.setBounds(118, 135, 89, 23);
		contentPane.add(this.cancelar_btn);
		this.cancelar_btn.addActionListener(controlador);
		
		this.imagen_tf = new JTextField();
		this.imagen_tf.setBounds(130, 104, 176, 20);
		contentPane.add(imagen_tf);
		this.imagen_tf.setColumns(10);
	}

	public JTextField getNombreEspecie_tf() {
		return nombreEspecie_tf;
	}

	public void setNombreEspecie_tf(JTextField nombreEspecie_tf) {
		this.nombreEspecie_tf = nombreEspecie_tf;
	}

	public JTextField getNombreCientifico_tf() {
		return nombreCientifico_tf;
	}

	public void setNombreCientifico_tf(JTextField nombreCientifico_tf) {
		this.nombreCientifico_tf = nombreCientifico_tf;
	}

	public JButton getGuardar_btn() {
		return this.guardar_btn;
	}

	public void setGuardar_btn(JButton guardar_btn) {
		this.guardar_btn = guardar_btn;
	}

	public JButton getCancelar_btn() {
		return this.cancelar_btn;
	}

	public void setCancelar_btn(JButton cancelar_btn) {
		this.cancelar_btn = cancelar_btn;
	}

	public JTextField getImagen_tf() {
		return imagen_tf;
	}

	public void setImagen_tf(JTextField imagen_tf) {
		this.imagen_tf = imagen_tf;
	}
	
	
}
