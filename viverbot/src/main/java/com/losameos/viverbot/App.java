package com.losameos.viverbot;

import java.util.ArrayList;

import com.losameos.viverbot.Controller.AltaEspecie_Controller;
import com.losameos.viverbot.Controller.BajaEspecie_Controller;
import com.losameos.viverbot.Controller.VerDetallesEspecie_Controller;
import com.losameos.viverbot.Controller.Medicion.Temperatura.ColectorTemperatura;
import com.losameos.viverbot.dto.EspecieDTO;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//VerDetallesEspecie_Controller controladorPlanta = new VerDetallesEspecie_Controller(new EspecieDTO("rosas","blancas","mascara.jpg"));
    	//AltaEspecie_Controller controladorAlta = new AltaEspecie_Controller();
    	//BajaEspecie_Controller controladorBaja = new BajaEspecie_Controller();
    	
    	
    	//capas este metodo deberia ser una clase que maneje todo el ciclo referido desde que se toma
    	//la temperatura hasta que se toma alguna accion.
    	controlarTemperatura();
    }

	private static void controlarTemperatura() {
		ColectorTemperatura colector = new ColectorTemperatura();
		colector.run();
		
	}
}
