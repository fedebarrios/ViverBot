package viverbot.Controlador.Verificacion;

import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.InstrumentoMediator;



public class TransmisorTemperaturaActual extends Transmisor {

	private static Magnitudes m = Magnitudes.TEMPERATURA;


	public TransmisorTemperaturaActual() {
		super(new InstrumentoMediator(m));
		
	}


	public Temperatura getTemperaturaActual(){
		
		return new Temperatura(mediador.getInstrumentoMedicion().getMedicion().getValor());
	}
}

