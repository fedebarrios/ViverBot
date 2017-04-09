package com.losameos.viverbot.Model;

import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class SoporteFactory {
	
	static SoporteMovible soporteHumedad;
	public static SoporteMovible creatSoporte(Magnitudes m){
		if(m.equals(Magnitudes.HUMEDAD)){
			return getInstanceSoporte(soporteHumedad, m);
		}
		return null;
	}
	private static SoporteMovible getInstanceSoporte(SoporteMovible soporte, Magnitudes m) {
		if(soporte == null){
			soporte = new SoporteMovible(m);
		}
		return soporte;
	}
	

}
