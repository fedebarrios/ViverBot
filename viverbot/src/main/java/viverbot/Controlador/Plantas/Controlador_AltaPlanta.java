package viverbot.Controlador.Plantas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import viverbot.Controlador.Verificacion.Verificador;
import viverbot.DTO.Especie;
import viverbot.Model.Fecha;
import viverbot.Model.Inventario;
import viverbot.Model.Plantas;
import viverbot.Vista.Plantas.Vista_AltaPlanta;

public class Controlador_AltaPlanta implements ActionListener {

	private Vista_AltaPlanta vistaAltaPlanta;
	private Plantas gestorPlantas;
	private ArrayList<Especie> listaEspecies;
	private Inventario gestorEspecies;

	public Controlador_AltaPlanta() {
		this.gestorEspecies = new Inventario();
		this.gestorPlantas = new Plantas();
		listaEspecies = new ArrayList<Especie>();
	}

	public void inicializar() {
		if (this.vistaAltaPlanta == null) {
			this.vistaAltaPlanta = new Vista_AltaPlanta(this);
			llenarComboEspecies();
		}
		this.vistaAltaPlanta.mostrarVentana();
	}

	public boolean camposValidos() {
		String ubicacion = this.vistaAltaPlanta.getTextUbicacion().getText();
		Date fecha = this.vistaAltaPlanta.getDateFiltro();

		if (comprobarUbicacion(ubicacion)) {

			if (!comprobarFecha(fecha)) {
				return true;
			} else
				JOptionPane.showMessageDialog(null, "La fecha de plantado es superior a la fecha actual");
		} else
			JOptionPane.showMessageDialog(null, "Complete correctamente el campo Ubicacion");
		return false;
	}

	public boolean comprobarFecha(Date fecha) {
		if (fecha != null) {
			return Verificador.fechaFutura(fecha);
		}
		return false;
	}

	public boolean comprobarUbicacion(String ubicacion) {
		if (ubicacion != "") {
			return true;
		} else {
			return false;
		}
	}
	@SuppressWarnings("deprecation")
	public boolean registrarPlanta() {
		String ubicacion = this.vistaAltaPlanta.getTextUbicacion().getText();
		Fecha fecha = new Fecha(this.vistaAltaPlanta.getDateFiltro().getDay(),
				this.vistaAltaPlanta.getDateFiltro().getMonth(), this.vistaAltaPlanta.getDateFiltro().getYear());
		int codEspecie = listaEspecies.get(obtenerIndiceSeleccionado()).getCodEspecie();
		return gestorPlantas.agregarPlanta(codEspecie, ubicacion, fecha);
	}

	public void seleccionarUbicacion(String ubicacion) {
		this.vistaAltaPlanta.getTextUbicacion().setText(ubicacion);
	}

	public void llenarComboEspecies() {
		listaEspecies = gestorEspecies.obtenerEspecies();
		for (Especie i : listaEspecies) {
			vistaAltaPlanta.getCmbEspecies().addItem(i.getNombre());
		}
	}

	public int obtenerIndiceSeleccionado() {
		return vistaAltaPlanta.getCmbEspecies().getSelectedIndex();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();

		if (evento == this.vistaAltaPlanta.getBtnAceptar()) {
			if (camposValidos()) {
				registrarPlanta();
			}
		}
	}

	public Vista_AltaPlanta getVista() {
		return vistaAltaPlanta;
	}
}
