package viverbot.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import viverbot.DTO.EspecieDTO;
import viverbot.DTO.PlantaDTO;
import viverbot.Model.Plantas;
import viverbot.View.VerDetalleEspecie;

public class VerDetallesEspecie_Controller implements ActionListener {

	private VerDetalleEspecie vistaVerDetalle;
	private Plantas plantas;

	public VerDetallesEspecie_Controller(EspecieDTO especie) {
		vistaVerDetalle = new VerDetalleEspecie(this);
		this.plantas = new Plantas();
		
		vistaVerDetalle.visible(true);
		cargarDatosEspecie(especie);
		llenarTabla(especie);

	}

	private void cargarDatosEspecie(EspecieDTO especie) {
		vistaVerDetalle.setLlegoNombre(especie.getNombre());
		vistaVerDetalle.setLlegoNombreC(especie.getNombreCientifico());
		vistaVerDetalle.setImagenEspecie(especie.getUrlImage());

	}

	private void llenarTabla(EspecieDTO especie) {

		ArrayList<PlantaDTO> listadoPlantas = plantas.obtenerPlantas(especie.getCodEspecie());
		System.out.println(listadoPlantas.isEmpty());

		if (!listadoPlantas.isEmpty()) {
			for (PlantaDTO p : listadoPlantas) {
				vistaVerDetalle.getPanel().msgTablaVacia(false);
				Object[] obj = { p.getCodigo(), p.getUbicacion().getFila(), p.getUbicacion().getColumna() };
				vistaVerDetalle.getPanel().agregarFila(obj);
			}
		} else
			vistaVerDetalle.getPanel().msgTablaVacia(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vistaVerDetalle.getBtnRevivir()) {
			System.out.println(vistaVerDetalle.filaSeleccionada());
		} else if (e.getSource() == vistaVerDetalle.getBtnEliminar()) {

		}

	}

	public VerDetalleEspecie getVistaVerDetalle() {
		return vistaVerDetalle;
	}

	public void setVistaVerDetalle(VerDetalleEspecie vistaVerDetalle) {
		this.vistaVerDetalle = vistaVerDetalle;
	}

	public Plantas getPlantas() {
		return plantas;
	}

	public void setPlantas(Plantas plantas) {
		this.plantas = plantas;
	}
}