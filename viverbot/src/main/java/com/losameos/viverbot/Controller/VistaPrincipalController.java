package com.losameos.viverbot.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.losameos.viverbot.Controller.Verificacion.TransmisorHumedad;
import com.losameos.viverbot.Model.SoporteFactory;
import com.losameos.viverbot.Model.SoporteMovible;
import com.losameos.viverbot.Model.Medicion.ColectorAltura;
import com.losameos.viverbot.Model.Medicion.ColectorTemperatura;
import com.losameos.viverbot.Model.Medicion.TransmisorAltura;
import com.losameos.viverbot.Model.Medicion.TransmisorTemperatura;
import com.losameos.viverbot.View.PrincipalView;

public class VistaPrincipalController  implements ActionListener{
	
	private PrincipalView vistaPrincipal;
	
	public VistaPrincipalController(){
		this.vistaPrincipal =  new PrincipalView(this);
		this.vistaPrincipal.mostrar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// implementar un distpacher y dentro del distpacher commands
		
		if(e.getSource() == this.vistaPrincipal.getMntmControlarTemperatura()){
			//abstraer en otro objeto
			ColectorTemperatura t = new ColectorTemperatura(5000, 0);

			TransmisorTemperatura tr = new TransmisorTemperatura();
			t.addObserver(tr);
			t.colectar();
		}
		else if(e.getSource() == this.vistaPrincipal.getMntmControolarHumedad()){
			SoporteMovible soporte = SoporteFactory.crearSoporte((TransmisorHumedad.getTipoMagnitud()));
			Thread hiloTransmisor = new Thread(new TransmisorHumedad(soporte));
			hiloTransmisor.start();
		}
		else if(e.getSource() == this.vistaPrincipal.getMntmControlarAltura()){
			ColectorAltura t = new ColectorAltura();
			TransmisorAltura tr = new TransmisorAltura();
			t.addObserver(tr);
			t.colectar();
		}
		
	}

	
	
}
