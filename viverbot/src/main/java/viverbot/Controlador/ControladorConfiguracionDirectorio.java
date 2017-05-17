package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import viverbot.Archivos.GatewayConfiguracion;
import viverbot.Vista.VistaConfiguracionDirectorios;
import viverbot.Vista.Auxiliares.DefaultOptionPane;
import viverbot.Vista.Auxiliares.FileChooser;

public class ControladorConfiguracionDirectorio implements ActionListener{
	
	private VistaConfiguracionDirectorios v;
	private DefaultOptionPane optionPane;
	private FileChooser selector;
	
	public ControladorConfiguracionDirectorio(){
		v = new VistaConfiguracionDirectorios(this);
		this.optionPane = new DefaultOptionPane();
		this.selector = new FileChooser();
		inicializar();
		llenarCampos();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.v.getBtnCargarDirectorio()){
			if(!eligioDirectorio()){
				optionPane.showMessageDialog(this.v,"Seleccione un directorio a modificar");
			}
			else{
				if(!cargarDirectorio()){
					optionPane.showMessageDialog(this.v,"Hubo un problema al seleccionar el directorio");
				}
			}	
		}
	}

	protected boolean cargarDirectorio() {
		this.selector.setFileSelectionMode(FileChooser.DIRECTORIES_ONLY);
		selector.showOpenDialog(this.v);
		File directorioElegido = selector.getSelectedFile();
		if (directorioElegido!=null)
		{
			System.out.println(selector.getSelectedFile().getPath());
			setearDirectorio(selector.getSelectedFile().getPath());
			return true;
		}
		return false;
	}
	
	protected int getDirectorioSeleccionado() {
		if (this.v.getRdDirectorio1().isSelected()) return 1;
		else if (this.v.getRdDirectorio2().isSelected()) return 2;
		return 3;
	}
	
	protected void setearDirectorio(String directorio){
		GatewayConfiguracion.setearDirectorio(directorio, getDirectorioSeleccionado());
		llenarCampos();
	}

	protected boolean eligioDirectorio() {
		return this.v.getRdDirectorio1().isSelected()||this.v.getRdDirectorio2().isSelected()||this.v.getRdDirectorio3().isSelected();
	}
	
	protected void llenarCampos() {
		this.v.setDirectorio1(GatewayConfiguracion.getDirectorio(1));
		this.v.setDirectorio2(GatewayConfiguracion.getDirectorio(2));
		this.v.setDirectorio3(GatewayConfiguracion.getDirectorio(3));
	}
	
	public VistaConfiguracionDirectorios getVista(){
		return this.v;
	}

	public void inicializar() {
		this.v.setVisible(true);	
	}

	public void setOptionPane(DefaultOptionPane o) {
		this.optionPane = o;
	}
	
	public void setFileChooser(FileChooser f){
		this.selector = f;
	}
}
