package com.losameos.viverbot.Model;

import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class SoporteFactory {
	
	static SoporteMovible soporte;
	public static SoporteMovible crearSoporte(Magnitudes m){
		if(m.equals(Magnitudes.HUMEDAD)){
			return getInstanceSoporte(soporte, m);
		} else if(m.equals(Magnitudes.ALTURA)){
			return getInstanceSoporte(soporte, m);
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
