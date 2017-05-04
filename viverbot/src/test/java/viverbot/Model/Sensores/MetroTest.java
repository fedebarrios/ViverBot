package viverbot.Model.Sensores;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.Magnitudes.Altura;
import viverbot.Model.Magnitudes.Magnitud;
import viverbot.Model.Magnitudes.Magnitudes;
import viverbot.Model.Sensores.InstrumentoFactory;
import viverbot.Model.Sensores.InstrumentoMedicion;

public class MetroTest {
	private InstrumentoMedicion metro;
	private Magnitud m;
	@Test
	public void medicionNoNegativa(){
		metro = InstrumentoFactory.crearInstrumento(Magnitudes.ALTURA);
		for(int i = 0; i< 20 ; i++){
			m = metro.getMedicion();
			if (m.getValor() < 0 ){
				assertTrue(m.getValor()==-1);
			}
			else{
				assertTrue(m.getValor()>0);
			}
		}
	}
	
	public void retornarAltura(){
		metro = InstrumentoFactory.crearInstrumento(Magnitudes.ALTURA);
		assertTrue(metro.getMedicion() instanceof Altura);
	}
}
