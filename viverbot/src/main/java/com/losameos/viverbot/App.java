package com.losameos.viverbot;

import java.io.File;
import java.util.ArrayList;

import com.losameos.viverbot.Controller.AltaEspecie_Controller;
import com.losameos.viverbot.Controller.BajaEspecie_Controller;
import com.losameos.viverbot.Controller.VerDetallesEspecie_Controller;
import com.losameos.viverbot.Controller.Medicion.Temperatura.ColectorTemperatura;
import com.losameos.viverbot.Controller.Verificacion.Temperatura.TransmisorTemperatura;
import com.losameos.viverbot.dto.EspecieDTO;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    
    	
    	//capas este metodo deberia ser una clase que maneje todo el ciclo referido desde que se toma
    	//la temperatura hasta que se toma alguna accion.
    	//controlarTemperatura();

    	VerDetallesEspecie_Controller controladorPlanta = new VerDetallesEspecie_Controller(new EspecieDTO("especie1","blancas","rosa.jpg"));
    	AltaEspecie_Controller controladorAlta = new AltaEspecie_Controller();
    	BajaEspecie_Controller controladorBaja = new BajaEspecie_Controller();

    }

	private static void controlarTemperatura() {
		ColectorTemperatura colector = new ColectorTemperatura();
		Thread hiloColector =  new Thread(colector);
		hiloColector.start();
		
		Thread hiloTransmisor = new Thread( new TransmisorTemperatura(colector));
		hiloTransmisor.start();
		
	}
}
