package viverbot.View;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import viverbot.Controller.Controlador_VistaSeleccionarUbicacion;


public class Vista_SeleccionarUbicacion  extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCancelar;
	private JTable tablaUbicaciones;
	private DefaultTableModel modelProductos;
	private String[] nombreColumnas = { "Fila", "Columna", "Estado"};
	private JButton btnSeleccionar;
	private JScrollPane scrollPane;
	private ArrayList<Object[]> filas;

	public Vista_SeleccionarUbicacion(Controlador_VistaSeleccionarUbicacion controlador) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Seleccionar ubicacion");
		setBounds(100, 100, 442, 312);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tablaUbicaciones = new JTable();
		modelProductos = new DefaultTableModel(null, nombreColumnas) {
			
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(324, 249, 100, 23);
		btnCancelar.addActionListener(controlador);
		contentPane.add(btnCancelar);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(214, 249, 100, 23);
		btnSeleccionar.addActionListener(controlador);
		contentPane.add(btnSeleccionar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 227);
		contentPane.add(scrollPane);
		
		tablaUbicaciones = new JTable(modelProductos);
		tablaUbicaciones.getTableHeader().setReorderingAllowed(false);
		tablaUbicaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tablaUbicaciones);
	}

	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}

	public void llenarTabla(ArrayList<Object[]> matriz) {
		filas = matriz;
		for (int i = 0; i < matriz.size(); i++) {
			modelProductos.addRow(matriz.get(i));
		}
	}
	
	public int getFilaSeleccionada() {
		int i = tablaUbicaciones.getSelectedRow();
		if (i > -1)
			return tablaUbicaciones.getSelectedRow();
		else
			return -1;
	}
	public ArrayList<Object[]> getFilas(){
		return filas;
	}

	public void limpiarTabla() {
		tablaUbicaciones = new JTable();
		modelProductos = new DefaultTableModel(null, nombreColumnas);
		tablaUbicaciones = new JTable(modelProductos);
		scrollPane.setViewportView(tablaUbicaciones);
		filas=null;
	}

	public void mostrarVentana() {
		setVisible(true);
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void cerrarVentana() {
		dispose();
	}
}
