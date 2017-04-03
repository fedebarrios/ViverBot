package com.losameos.viverbot.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.losameos.viverbot.Controller.BajaEspecieController;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class BajaEspecie extends JFrame{

	private JPanel contentPane;
	private JComboBox comboBox;
	private JButton btnCancelar;
	private JButton btnBorrar;	
	
	public BajaEspecie(BajaEspecieController controlador){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 126);
		setTitle("Baja de Especie");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(139, 15, 136, 20);
		contentPane.add(comboBox);
		
		JLabel lblSeleccioneUnaEspecie = new JLabel("Seleccione una especie");
		lblSeleccioneUnaEspecie.setBounds(10, 15, 119, 20);
		contentPane.add(lblSeleccioneUnaEspecie);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(186, 46, 89, 23);
		contentPane.add(btnBorrar);
		btnBorrar.addActionListener(controlador);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(87, 46, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(controlador);
	}
	
	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}
}
