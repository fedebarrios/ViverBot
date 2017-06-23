package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

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
			if(!cargarDirectorio()){
				optionPane.showMessageDialog(this.v,"Hubo un problema al seleccionar el directorio");
			}
		} else if (e.getSource() == this.v.getBtnBorrarDirectorio()){
			if(!eligioDirectorio()){
				optionPane.showMessageDialog(this.v,"Seleccione un directorio");
			} borrarDirectorio();
		}
	}

	protected void borrarDirectorio() {
		GatewayConfiguracion.borrarDirectorio(this.v.getComboBox().getSelectedIndex()-1);
		llenarCampos();
	}

	protected boolean cargarDirectorio() {
		this.selector.setFileSelectionMode(FileChooser.DIRECTORIES_ONLY);
		selector.showOpenDialog(this.v);
		File directorioElegido = selector.getSelectedFile();
		if (directorioElegido!=null)
		{
			agregarDirectorio(selector.getSelectedFile().getPath());
			return true;
		}
		return false;
	}
	
	protected void agregarDirectorio(String directorio){
		GatewayConfiguracion.agregarDirectorio(directorio);
		llenarCampos();
	}

	protected boolean eligioDirectorio() {
		return !this.v.getComboBox().getSelectedItem().equals("");
	}
	
	@SuppressWarnings("unchecked")
	protected void llenarCampos() {
		this.v.getComboBox().removeAllItems();
		this.v.getComboBox().addItem("");
		List<String> directorios = GatewayConfiguracion.getDirectorios();
		for(String path : directorios){
			this.v.getComboBox().addItem(path);
		}
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
