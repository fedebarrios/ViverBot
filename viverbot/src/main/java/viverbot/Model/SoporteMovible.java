package viverbot.Model;

import viverbot.DTO.UbicacionDTO;
import viverbot.Interfaces.Movible;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Medicion.InstrumentoMediator;

public class SoporteMovible implements Movible{

	private InstrumentoMediator mediator;
	private Cosechador podador;
	private UbicacionDTO ubicacion;
	private UbicacionDTO defaultUbicacion= new UbicacionDTO(0,0,0);
	
	public SoporteMovible(Magnitud m){
		this.mediator = new InstrumentoMediator(m);
		this.podador = Cosechador.getInstance();
		this.ubicacion = defaultUbicacion;
	}
	
	@Override
	public void mover(UbicacionDTO u) {
		this.setUbicacion(u);
	}

	public InstrumentoMediator getColector() {
		return mediator;
	}

	public void setColector(InstrumentoMediator colector) {
		this.mediator = colector;
	}

	public UbicacionDTO getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(UbicacionDTO ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Cosechador getPodador() {
		return podador;
	}

	public void setPodador(Cosechador podador) {
		this.podador = podador;
	}	
}
