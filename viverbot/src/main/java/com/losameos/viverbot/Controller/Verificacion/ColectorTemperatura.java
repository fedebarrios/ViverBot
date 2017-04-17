package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.Colector;

public class ColectorTemperatura extends Automatizador {

	protected Colector colector;
	protected Magnitud valorActual;
	private final static Magnitudes m = Magnitudes.TEMPERATURA;

	public ColectorTemperatura() {
		colector =  new Colector(m);
		this.valorActual =  null;
	}

	@Override
	protected void realizarTarea() {
		// TODO Auto-generated method stub
		if (realizarMedicion()) {
			this.setChanged();
			this.notifyObservers(this.valorActual);
		} else {
			// aqui se debe la acoplar la logica de alarmas o bien el
			// soporte que pueda brindar el
			// sistema ante fallas en la medicion, los cuales aun no se han
			// definido ni planificado
		}
	}

	private boolean realizarMedicion() {
		// TODO Auto-generated method stub
		this.valorActual = this.colector.tomarMedicion();
		return this.valorActual != null;
	}

	

}
