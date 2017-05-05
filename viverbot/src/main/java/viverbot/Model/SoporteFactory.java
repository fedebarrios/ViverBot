package viverbot.Model;

import viverbot.Modelo.Magnitudes.Magnitudes;

public class SoporteFactory {
	
	static SoporteMovible soporteHumedad;
	static SoporteMovible soporteAltura;
	
	public static SoporteMovible crearSoporte(Magnitudes m){
		if(m.equals(Magnitudes.HUMEDAD)){
			return getInstanceSoporteHumedad(m);
		} else if(m.equals(Magnitudes.ALTURA)){
			return getInstanceSoporteAltura(m);
		}
		return null;
	}
	private static SoporteMovible getInstanceSoporteHumedad(Magnitudes m) {
		if(soporteHumedad == null){
			soporteHumedad = new SoporteMovible(m);
		}
		return soporteHumedad;
	}
	
	private static SoporteMovible getInstanceSoporteAltura(Magnitudes m) {
		if(soporteAltura == null){
			soporteAltura = new SoporteMovible(m);
		}
		return soporteAltura;
	}
	

}
