package viverbot.Controlador.Plantas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import viverbot.DTO.Planta;
import viverbot.Model.Inventario;
import viverbot.Model.Plantas;
import viverbot.Vista.Auxiliares.DefaultOptionPane;
import viverbot.Vista.Plantas.Vista_BajaPlanta;

public class Controlador_BajaPlanta implements ActionListener{

	private Vista_BajaPlanta vistaBajaPlanta;
	private ArrayList<Planta> listaPlantas;
	private Plantas gestorPlantas;
	private Inventario inventario;
	private DefaultOptionPane optionPane;
	
	public Controlador_BajaPlanta(){
		this.gestorPlantas = new Plantas();
		this.inventario = new Inventario();
		this.optionPane = new DefaultOptionPane();
	}
	
	public void inicializar(){
		if(this.vistaBajaPlanta==null){
			this.vistaBajaPlanta = new Vista_BajaPlanta(this);
			llenarComboPlantas();
			this.vistaBajaPlanta.mostrarVentana();
		}
		else{
			this.vistaBajaPlanta.mostrarVentana();
			this.vistaBajaPlanta.limpiarVista();
			llenarComboPlantas();
		}
	}
	
	public void llenarComboPlantas() {
		listaPlantas = gestorPlantas.obtenerPlantas();
		String aux;
		for(Planta i: listaPlantas) {
			aux = this.inventario.obtenerEspecie(i.getCodigo()).getNombre();
			vistaBajaPlanta.getCmbPlantas().addItem(aux);
		}
	}
	
	public int obtenerIndiceSeleccionado(){
		return this.vistaBajaPlanta.getCmbPlantas().getSelectedIndex();
	}
	
	public void borrarItemPlanta(int i){
		this.vistaBajaPlanta.getCmbPlantas().remove(i);
		gestorPlantas.eliminarPlanta(listaPlantas.get(i).getCodigoPlanta());
		listaPlantas.remove(i);
		this.vistaBajaPlanta.limpiarVista();
		this.llenarComboPlantas();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		if(evento == this.vistaBajaPlanta.getBtnCancelar()){
			this.vistaBajaPlanta.cerrarVentana();
		}else if(evento == this.vistaBajaPlanta.getBtnBorrar()){
			int indice = obtenerIndiceSeleccionado();
			if(indice>=0){
				borrarItemPlanta(indice);
			}else{
				optionPane.showMessageDialog(null, "No ha seleccionado ninguna planta");
			}
		}
	}

	public Vista_BajaPlanta getVistaBajaPlanta() {
		return vistaBajaPlanta;
	}
	
	public void setOptionPane(DefaultOptionPane optionPane){
		this.optionPane=optionPane;
	}
}
