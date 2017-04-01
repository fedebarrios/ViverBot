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

public class ListaPlantaDeEspecie_Panel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel listadoPlantas;
	private JTable table;
	private String[] nombreColumnas = { "Codigo", "Ubicacion","Fecha de plantado" };
	private DefaultTableModel Muestra;
	
	public ListaPlantaDeEspecie_Panel(){
		super();
		this.setBounds(21, 261, 378, 176);
		this.setLayout(null);
		inicializar();
		
	}
	
	private void inicializar()
	{
		
		listadoPlantas = new JLabel("Listado de plantas");
		listadoPlantas.setForeground(Color.BLACK);
		listadoPlantas.setBounds(20, 6, 136, 16);
		this.add(listadoPlantas);
		
		encabezadoTabla();
		
	}
	
	private void encabezadoTabla()
	{
		Muestra = new DefaultTableModel(null, nombreColumnas)
		{

		@Override
		public boolean isCellEditable(int row, int col)
			{
				return false;
			}
		};
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 25, 366, 134);
		this.add(scrollPane);
		table = new JTable(Muestra);
		table.getTableHeader().setReorderingAllowed(false); 
		table.getTableHeader().setFont(new Font("Segoe Print", Font.PLAIN, 12));	
		table.getTableHeader().setBackground(Color.GREEN);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(table);
		
		
	}
	
	public void llenarTabla(ArrayList<Object[]> matriz) {

		for (int i = 0; i < matriz.size(); i++) {
			Muestra.addRow(matriz.get(i));
		}
	}

}
