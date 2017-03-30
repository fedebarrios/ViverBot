package com.losameos.viverbot;

import java.util.ArrayList;

import com.ViveroBot.Controller.VerDetallesEspecie_Controller;
import com.ViveroBot.View.VerDetalleEspecie_View;
import com.ViveroBot.dto.EspecieDTO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	VerDetallesEspecie_Controller controladorPlanta = new VerDetallesEspecie_Controller(new EspecieDTO("rosas","blancas","mascara.jpg"));
       
    }
}
