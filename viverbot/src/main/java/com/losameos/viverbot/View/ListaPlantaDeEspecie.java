package com.losameos.viverbot.View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.losameos.viverbot.Controller.VerDetallesEspecieController;

public class ListaPlantaDeEspecie extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel listadoPlantas;
	private JTable table;
	private String[] nombreColumnas = { "Fila", "Columna" };
	private DefaultTableModel Muestra;
	
	public ListaPlantaDeEspecie(VerDetallesEspecieController controlador){
		super();
		this.setBounds(21, 261, 385, 182);
		this.setLayout(null);
		inicializar();
		
	}
	
	private void inicializar()
	{
		
		listadoPlantas = new JLabel("Listado de plantas");
		listadoPlantas.setForeground(Color.BLACK);
		listadoPlantas.setBounds(10, 11, 136, 16);
		this.add(listadoPlantas);
		
		encabezadoTabla();
		
	}
	
	private void encabezadoTabla()
	{
		Muestra = new DefaultTableModel(null, nombreColumnas)
		{

		private static final long serialVersionUID = 1L;

		@Override
		public boolean isCellEditable(int row, int col)
			{
				return false;
			}
		};
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 31, 366, 134);
		this.add(scrollPane);
		table = new JTable(Muestra);
		table.getTableHeader().setReorderingAllowed(false); 
		table.getTableHeader().setFont(new Font("Segoe Print", Font.PLAIN, 12));	
		table.getTableHeader().setBackground(Color.GREEN);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		
		
	}
	
	public void agregarFila(Object[] obj)
	{
		Muestra.addRow(obj);
	}

	public JLabel getListadoPlantas() {
		return listadoPlantas;
	}

	public void setListadoPlantas(JLabel listadoPlantas) {
		this.listadoPlantas = listadoPlantas;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	public int filaSeleccionada()
	{
		return this.table.getSelectedRow();
	}
	
	

}
