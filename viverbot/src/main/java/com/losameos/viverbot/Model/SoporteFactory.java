package com.losameos.viverbot.Model;

import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class SoporteFactory {
	
	public static SoporteMovible creatSoporte(Magnitudes m){
		if(m.equals(Magnitudes.HUMEDAD)){
			return new SoporteMovible(m);
		}
		return null;
	}

}
