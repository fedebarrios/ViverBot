package viverbot.Model;

import viverbot.DTO.UbicacionDTO;
import viverbot.Interfaces.IMovible;
import viverbot.Model.Magnitudes.Magnitudes;
import viverbot.Model.Medicion.InstrumentoMediator;

public class SoporteMovible implements IMovible{

	private InstrumentoMediator mediator;
	private Podador podador;
	private UbicacionDTO ubicacion;
	private UbicacionDTO defaultUbicacion= new UbicacionDTO(0,0);
	
	public SoporteMovible(Magnitudes m){
		this.mediator = new InstrumentoMediator(m);
		this.podador = Podador.getInstance();
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

	public Podador getPodador() {
		return podador;
	}

	public void setPodador(Podador podador) {
		this.podador = podador;
	}	
}
