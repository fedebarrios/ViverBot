package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import viverbot.Archivos.GatewayConfiguracion;
import viverbot.Vista.VistaConfiguracionDirectorios;

public class ControladorConfiguracionDirectorio implements ActionListener{
	
	private VistaConfiguracionDirectorios v;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.v.getBtnCargarDirectorio()){
			if(!eligioDirectorio()){
				JOptionPane.showMessageDialog(this.v,"Seleccione un directorio a modificar");
			}
			else{
				int directorioSeleccionado = getDirectorioSeleccionado();
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int seleccion = fileChooser.showOpenDialog(v);
				if (seleccion == JFileChooser.APPROVE_OPTION)
				{
				   String directorio = fileChooser.getSelectedFile().getPath();
				   GatewayConfiguracion.setearDirectorio(directorio,directorioSeleccionado);
				   llenarCampos();
				}
			
			}	
		}
	}
	
	private int getDirectorioSeleccionado() {
		if (this.v.getRdDirectorio1().isSelected()) return 1;
		else if (this.v.getRdDirectorio2().isSelected()) return 2;
		return 3;
	}

	protected boolean eligioDirectorio() {
		return this.v.getRdDirectorio1().isSelected()||this.v.getRdDirectorio2().isSelected()||this.v.getRdDirectorio3().isSelected();
	}
	
	private void llenarCampos() {
		this.v.setDirectorio1(GatewayConfiguracion.getDirectorio(1));
		this.v.setDirectorio2(GatewayConfiguracion.getDirectorio(2));
		this.v.setDirectorio3(GatewayConfiguracion.getDirectorio(3));
	}

	public void inicializar() {
		this.v.setVisible(true);	
	}
}
