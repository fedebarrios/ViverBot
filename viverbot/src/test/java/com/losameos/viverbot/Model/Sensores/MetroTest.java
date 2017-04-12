package com.losameos.viverbot.Model.Sensores;

import static org.junit.Assert.*;

import org.junit.Test;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class MetroTest {
	private Magnitud m;
	@Test
	public void medicionNoNegativa(){
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
}
