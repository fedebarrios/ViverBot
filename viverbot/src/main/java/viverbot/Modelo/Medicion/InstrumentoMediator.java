package viverbot.Modelo.Medicion;

import java.util.ArrayList;

import viverbot.DTO.Planta;
import viverbot.Model.Plantas;
import viverbot.Model.SoporteFactory;
import viverbot.Model.SoporteMovible;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Sensores.Medir;
import viverbot.Modelo.Sensores.InstrumentoFactory;
import viverbot.Modelo.Simulacion.Simulador;

public class InstrumentoMediator {
	protected Medir instrumentoMedicion;
	protected String tipoValor;
	protected SoporteMovible soporte;
	protected ArrayList<Planta> plantas;

	//revisar si esto se va a seguir utilizando
	public InstrumentoMediator() {
		this.tipoValor = "";
	}

	public InstrumentoMediator(Magnitud m) {
		this.instrumentoMedicion = InstrumentoFactory.crearInstrumento(m);
	}

	public InstrumentoMediator(Medir simulador) {
		this.instrumentoMedicion = simulador;
	}

	public Medicion tomarMedicion() {
		return this.instrumentoMedicion.getMedicion();
	}

	public Medir getInstrumentoMedicion() {
		return instrumentoMedicion;
	}
}
