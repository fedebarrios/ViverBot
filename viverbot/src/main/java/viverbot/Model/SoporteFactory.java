package viverbot.Model;

import viverbot.Modelo.Magnitudes.Magnitud;

public class SoporteFactory {
	
	static SoporteMovible soporteHumedad;
	static SoporteMovible soporteAltura;
	
	public static SoporteMovible crearSoporte(Magnitud m){
		if(m.equals(Magnitud.HUMEDAD)){
			return getInstanceSoporteHumedad(m);
		} else if(m.equals(Magnitud.ALTURA)){
			return getInstanceSoporteAltura(m);
		}
		return null;
	}
	private static SoporteMovible getInstanceSoporteHumedad(Magnitud m) {
		if(soporteHumedad == null){
			soporteHumedad = new SoporteMovible(m);
		}
		return soporteHumedad;
	}
	
	private static SoporteMovible getInstanceSoporteAltura(Magnitud m) {
		if(soporteAltura == null){
			soporteAltura = new SoporteMovible(m);
		}
		return soporteAltura;
	}
	

}
