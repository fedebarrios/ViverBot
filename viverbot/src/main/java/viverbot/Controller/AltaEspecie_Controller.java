package viverbot.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import viverbot.Controller.Verificacion.Verificador;
import viverbot.Model.Inventario;
import viverbot.View.AltaEspecie;

public class AltaEspecie_Controller implements ActionListener {

	private AltaEspecie altaVista;
	public Inventario inventario;

	public AltaEspecie_Controller() {
		this.inventario = new Inventario();
		this.altaVista = new AltaEspecie(this);
		this.altaVista.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.altaVista.getCancelar_btn()) {
			this.altaVista.dispose();
		} else if (e.getSource() == this.altaVista.getGuardar_btn()) {
			String nombreEspecie = this.altaVista.getNombreEspecie_tf().getText();
			String nombreCientifico = this.altaVista.getNombreCientifico_tf().getText();
			System.out.println(nombreEspecie);
			System.out.println(nombreCientifico);
			boolean esValido = Verificador.campoExclusivamenteAlfabetico(nombreEspecie);
			if (!esValido) {
				JOptionPane.showMessageDialog(this.altaVista, "No ingrese numeros");
			} else if (this.altaVista.getImagen_tf().getText().equals("")){
				JOptionPane.showMessageDialog(this.altaVista, "Cargue una imagen");
			} else if (this.altaVista.getNombreCientifico_tf().getText().equals("")){
				JOptionPane.showMessageDialog(this.altaVista, "Cargue un nombre Cientifico");
			} else if (this.altaVista.getNombreEspecie_tf().getText().equals("")){
				JOptionPane.showMessageDialog(this.altaVista, "Cargue un nombre de Especie");
			} else {
				String pathAlmacenado = copiar(this.altaVista.getImagen_tf().getText(), nombreEspecie);
				this.inventario.agregarEspecie(nombreEspecie, nombreCientifico, pathAlmacenado);
				JOptionPane.showMessageDialog(this.altaVista, "Se guardo correctamente la nueva especie");
				this.altaVista.getNombreEspecie_tf().setText("");
				this.altaVista.getNombreCientifico_tf().setText("");
				this.altaVista.getImagen_tf().setText("");
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

	private String copiar(String origen, String destino) {
		File archivoOrigen = new File(origen);
		String extension = origen.substring(origen.length() - 4, origen.length());
		String pathNuevo = "src/main/java/Recursos/" + destino + extension;
		File archivoDestino = new File(pathNuevo);
		archivoOrigen.renameTo(archivoDestino);
		return pathNuevo;
	}

}