package viverbot.Controller.Verificacion;

import viverbot.Model.Magnitudes.Magnitudes;
import viverbot.Model.Magnitudes.Temperatura;
import viverbot.Model.Medicion.InstrumentoMediator;



public class TransmisorTemperaturaActual extends Transmisor {

	private static Magnitudes m = Magnitudes.TEMPERATURA;


	public TransmisorTemperaturaActual() {
		super(new InstrumentoMediator(m));
		
	}


	public Temperatura getTemperaturaActual(){
		
		return new Temperatura(mediador.getInstrumentoMedicion().getMedicion().getValor());
	}
}

