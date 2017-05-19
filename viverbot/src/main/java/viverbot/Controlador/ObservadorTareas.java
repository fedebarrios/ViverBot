package viverbot.Controlador;

import viverbot.DAO.ColaTareas;
import viverbot.Model.ControladorBrazoRobotico;

public class ObservadorTareas {
	private ControladorBrazoRobotico _controlador;
	
	public ObservadorTareas(ColaTareas cola){
		_controlador = new ControladorBrazoRobotico(cola);
	}
	
	public void actualizarEstadoProtocolo(){
		if(!_controlador.estaOcupado()){
			_controlador.inicializarControlador();
		}
	}
}
