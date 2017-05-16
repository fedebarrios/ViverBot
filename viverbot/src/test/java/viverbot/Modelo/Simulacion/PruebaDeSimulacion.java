package viverbot.Modelo.Simulacion;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Medicion.AnalizadorTemperatura;
import viverbot.Modelo.Medicion.ColectorTemperatura;
import viverbot.Modelo.Medicion.InstrumentoMediator;
import viverbot.Modelo.Sensores.SensorTemperatura;

public class PruebaDeSimulacion {

	public static void main(String[] args) {

		RangoNumerico r1 = new RangoNumerico(0.0, 1.0);
		RangoNumerico r2 = new RangoNumerico(1.0, 2.0);
		RangoNumerico r3 = new RangoNumerico(2.0, 3.0);
		RangoNumerico r4 = new RangoNumerico(3.0, 4.0);
		RangoNumerico r5 = new RangoNumerico(4.0, 5.0);
		RangoNumerico r6 = new RangoNumerico(5.0, 6.0);
		RangoNumerico r7 = new RangoNumerico(6.0, 7.0);
		RangoNumerico r8 = new RangoNumerico(7.0, 8.0);

		Map<Horario, RangoNumerico> r = new HashMap<Horario, RangoNumerico>();
		r.put(Horario.MEDIANOCHE, r1);
		r.put(Horario.MADRUGADA, r2);
		r.put(Horario.AMANECER, r3);
		r.put(Horario.MAÑANA,r4);
		r.put(Horario.MEDIODIA,r5);
		r.put(Horario.TARDE, r6);
		r.put(Horario.ATARDECER, r7);
		r.put(Horario.NOCHE, r8);

		Simulador simulador = new Simulador(r, Magnitudes.TEMPERATURA);
		simulador.setFrecuencia(5000);
		InstrumentoMediator i = new InstrumentoMediator(Magnitudes.TEMPERATURA);
		SensorTemperatura s = (SensorTemperatura) i.getInstrumentoMedicion();
		simulador.simular();
		s.setSimulador(simulador);

		ColectorTemperatura t = new ColectorTemperatura(5000, 0, i);

		t.colectar();

	}

}
