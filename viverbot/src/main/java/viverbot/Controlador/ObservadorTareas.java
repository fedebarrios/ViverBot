package viverbot.Controlador;

import viverbot.Model.ProtocoloBrazoRobotico;

public class ObservadorTareas {
	private ProtocoloBrazoRobotico protocolo;
	
	public ObservadorTareas(){
		protocolo = new ProtocoloBrazoRobotico();
	}
	
	public void actualizarEstadoProtocolo(){
		if(!protocolo.estaOcupado()){
			protocolo.run();
		}
	}
}
