package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Tarea;
import com.losameos.viverbot.Model.Temporizador;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.Colector;

public class TransmisorTemperatura extends MiObjeto {

	protected Colector colector;
	protected Magnitud valorActual;
	private AnalizadorTemperatura analizador;
	private static Magnitudes m = Magnitudes.TEMPERATURA;

	public TransmisorTemperatura() {
		colector =  new Colector(m);
		this.valorActual =  null;
		this.analizador = new AnalizadorTemperatura();
	}

	@Override
	protected void realizarTarea() {
		// TODO Auto-generated method stub
		if (realizarMedicion()) {
			this.analizador.analizar((Temperatura) this.valorActual);
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

	public AnalizadorTemperatura getAnalizador() {
		return analizador;
	}

	public void setAnalizador(AnalizadorTemperatura analizador) {
		this.analizador = analizador;
	}

}
