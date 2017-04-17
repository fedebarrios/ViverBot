package com.losameos.viverbot.Model;

import java.util.Timer;
import java.util.TimerTask;

public class Temporizador {

	Timer timer;

	public Temporizador(){
		this.timer =  new Timer();
	}
	
	public void programar(TimerTask t, long delay, long frecuencia){
		this.timer.schedule(t, delay, frecuencia);
	}

}
