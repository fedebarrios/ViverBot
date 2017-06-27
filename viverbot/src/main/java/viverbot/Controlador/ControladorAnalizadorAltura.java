package viverbot.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import viverbot.Archivos.CargadorArchivos;
import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.DAO.EspecieDAO;
import viverbot.DAO.PlantaDAO;
import viverbot.DTO.Especie;
import viverbot.DTO.Planta;
import viverbot.Model.ControlHistoriales;
import viverbot.Model.GuardadorAltura;
import viverbot.Model.HistorialAltura;
import viverbot.Model.HistorialOptimo;
import viverbot.Model.SeguimientoAltura;
import viverbot.Model.RegistroHistorial;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AnalizadorAltura;
import viverbot.Vista.VistaAnalizadorAltura;
import viverbot.Vista.Auxiliares.DefaultOptionPane;

public class ControladorAnalizadorAltura implements ActionListener{
	
	private VistaAnalizadorAltura v;
	private DefaultOptionPane optionPane;
	private EspecieDAO especies;
	private PlantaDAO plantas;
	private GuardadorAltura guardador;
	private ControlHistoriales controlHistorialesOptimos;
	private String mensaje;
	
	public ControladorAnalizadorAltura(){
		v = new VistaAnalizadorAltura(this);
		especies = EspecieDAO.getInstance();
		plantas = PlantaDAO.getInstance();
		guardador = GuardadorAltura.getInstance();
		controlHistorialesOptimos = ControlHistoriales.getInstance();
		mensaje = "";
		this.optionPane = new DefaultOptionPane();
		inicializar();
		llenarCampos();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.v.getBtnAnalizarPlanta()){
			CargadorArchivos cargador = new CargadorArchivos();
			List<HistorialOptimo> historialesOptimos = cargador.seleccionarMejorDirectorio();
			for (HistorialOptimo historial : historialesOptimos){
				Especie especie = historial.getEspecie();
				especies.agregar(especie);
				controlHistorialesOptimos.agregarSeguimiento(historial);
			}
			Planta planta = v.getPlantaSeleccionada();
			Especie especiePlanta = especies.obtenerEspecie(planta.getCodigoPlanta());
			AnalizadorAltura analizador = new AnalizadorAltura(guardador);
			HistorialOptimo historialPlanta = controlHistorialesOptimos.getHistorial(especiePlanta);
			HistorialAltura historialReal = new HistorialAltura();
			SeguimientoAltura seguimiento = new SeguimientoAltura(planta, historialPlanta, historialReal);
			EstadoAltura estado = analizador.analizar(new Medicion(2.2, Magnitud.ALTURA), seguimiento, 2);
			mensaje = "El estado es: " + estado.getEstado();
			this.optionPane.showMessageDialog(this.v, mensaje);
		}
	}
	
	public void llenarCampos(){
		ArrayList<Planta> arregloPlantas = plantas.obtenerPlantas();
		v.getComboPlantas().setModel(new DefaultComboBoxModel<Planta>(arregloPlantas.toArray(new Planta[arregloPlantas.size()])));
	}
	
	public VistaAnalizadorAltura getVista(){
		return this.v;
	}

	public void inicializar() {
		this.v.setVisible(true);	
	}

	public void setOptionPane(DefaultOptionPane o) {
		this.optionPane = o;
	}
	
	public DefaultOptionPane getOptionPane() {
		return this.optionPane;
	}
	
	public String getMensaje(){
		return mensaje;
	}
}
