package viverbot.Controlador.Especies;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import viverbot.Controlador.Verificacion.Verificador;
import viverbot.Model.Inventario;
import viverbot.Vista.Especie.AltaEspecie;

public class AltaEspecie_Controller implements ActionListener {

	private AltaEspecie altaVista;
	private Inventario inventario;

	public AltaEspecie_Controller() {
		this.inventario = new Inventario();
		this.altaVista = new AltaEspecie(this);
		this.altaVista.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.altaVista.getCancelar_btn()) {
			this.altaVista.dispose();
		} else if (e.getSource() == this.altaVista.getGuardar_btn()) {
			
			if(!registrarEspecie()){
				if(nombreEspecieVacio()){
					JOptionPane.showMessageDialog(this.altaVista, "Cargue un nombre de Especie");
				}else if(nombreCientificoVacio()){
					JOptionPane.showMessageDialog(this.altaVista, "Cargue un nombre Cientifico");
				}else if(nombreImagenVacio()){
					JOptionPane.showMessageDialog(this.altaVista, "Cargue una imagen");
				}else{
					JOptionPane.showMessageDialog(this.altaVista, "No ingrese numeros");
				}
			}
			else{
				JOptionPane.showMessageDialog(this.altaVista, "Se guardo correctamente la nueva especie");
				limpiar();
			}
			
		} else if (e.getSource() == this.altaVista.getBtnCargarImagen()) {
			
			
			JFileChooser selector=new JFileChooser(); 
			selector.setDialogTitle("Seleccione Imagen");
			FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
			selector.setFileFilter(filtroImagen);
			selector.showOpenDialog(this.altaVista);
			File archivoElegido = selector.getSelectedFile();
			if (archivoElegido!=null){
				String path = archivoElegido.getPath().toString();
				this.altaVista.getImagen_tf().setText(path);
			}
		}
	}

	public void limpiar() {
		this.altaVista.getNombreEspecie_tf().setText("");
		this.altaVista.getNombreCientifico_tf().setText("");
		this.altaVista.getImagen_tf().setText("");
	}

	private String copiar(String origen, String destino) {
		File archivoOrigen = new File(origen);
		String extension = origen.substring(origen.length() - 4, origen.length());
		String pathNuevo = "src/main/java/Recursos/" + destino + extension;
		File archivoDestino = new File(pathNuevo);
		archivoOrigen.renameTo(archivoDestino);
		System.out.println(pathNuevo+"----jeje");
		return pathNuevo;
	}
	
	public boolean esValido(String s){
		return Verificador.campoExclusivamenteAlfabetico(s);
	}
	
	public boolean registrarEspecie() {
		String nombreEspecie = this.altaVista.getNombreEspecie_tf().getText();
		String nombreCientifico = this.altaVista.getNombreCientifico_tf().getText();
		String path = this.altaVista.getImagen_tf().getText();
		if(esValido(nombreEspecie) && esValido(nombreCientifico) && path.length()>0){
			String pathAGuardar = copiar(this.altaVista.getImagen_tf().getText(), nombreEspecie);
			this.inventario.agregarEspecie(nombreEspecie, nombreCientifico, pathAGuardar);
			return true;
		}
		return false;
	}
	
	public boolean nombreEspecieVacio(){
		return altaVista.getNombreEspecie_tf().getText().length()==0;
	}
	
	public boolean nombreCientificoVacio(){
		return altaVista.getNombreCientifico_tf().getText().length()==0;
	}
	
	public boolean nombreImagenVacio(){
		return altaVista.getImagen_tf().getText().length()==0;
	}

	public AltaEspecie getAltaVista() {
		return altaVista;
	}
	
	public Inventario getInventario(){
		return this.inventario;
	}

}
