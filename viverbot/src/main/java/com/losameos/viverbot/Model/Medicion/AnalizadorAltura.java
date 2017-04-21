package com.losameos.viverbot.Model.Medicion;

import java.util.ArrayList;

import com.losameos.viverbot.Controller.Verificacion.StrategyAnalisisAltura;
import com.losameos.viverbot.Controller.Verificacion.StrategyMetroDown;
import com.losameos.viverbot.Controller.Verificacion.StrategySeguimientoNull;
import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.Interfaces.IAnalisisAltura;
import com.losameos.viverbot.Model.ControlSeguimientos;
import com.losameos.viverbot.Model.HistorialAltura;
import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.Model.SeguimientoAltura;
import com.losameos.viverbot.Model.Magnitudes.Altura;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class AnalizadorAltura {
	private IAnalisisAltura estrategia;
	private ControlSeguimientos seguimientos;
	private ArrayList<PlantaDTO> plantas;
	private SeguimientoAltura seguimientoBuscado;
	private HistorialAltura historialOptimo;
	private HistorialAltura historialVerdadero;
	public String estadoPlantaAnalizada = "";
	public Altura diferenciaAltura = null;
	public Magnitud m;
	
	public AnalizadorAltura() {
		this.estrategia = null;
		this.m = null;
		this.plantas = new Plantas().obtenerPlantas();
		this.seguimientos = ControlSeguimientos.getInstance();
	}

	public void analizar(ArrayList<Magnitud> alturas) {
		for(int i = 0; i<plantas.size(); i++){
			this.m = alturas.get(i);
			this.seguimientoBuscado = seguimientos.getSeguimiento(plantas.get(i));
			this.estrategia = this.getStrategy(m, seguimientoBuscado);
			this.estrategia.analizar(m, seguimientoBuscado);
		}
	}
	
	private IAnalisisAltura getStrategy(Magnitud temp, SeguimientoAltura seguimiento) {
		if (seguimiento == null){
			return new StrategySeguimientoNull();
		}else if (temp == null){
			return new StrategyMetroDown();
		}
		else{
			return new StrategyAnalisisAltura();
		}
	}	
}
