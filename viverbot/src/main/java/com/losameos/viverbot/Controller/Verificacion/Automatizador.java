package com.losameos.viverbot.Controller.Verificacion;

import java.util.Observable;

import com.losameos.viverbot.Model.Tarea;
import com.losameos.viverbot.Model.Temporizador;

public abstract class Automatizador extends Observable implements Runnable {

	private long frecuencia = 5000; // se expresa en milisegundos
	private long delay = 0;

	@Override
	public void run() {
		iniciar();
	}

	protected void iniciar() {
		Temporizador temporizador = new Temporizador();
		Tarea t = new Tarea() {
			@Override
			public void run() {
				realizarTarea();
			}
		};
		temporizador.programar(t, delay, frecuencia);

	}

	protected void realizarTarea() {

	}

	public long getFrecuenciaDeRepeticion() {
		return frecuencia;
	}

	public void setFrecuenciaDeRepeticion(long f) {
		this.frecuencia = f;
	}

}
