package com.losameos.viverbot.Model.Medicion;

import java.util.ArrayList;

import com.losameos.viverbot.Controller.Verificacion.EstadoAltura;
import com.losameos.viverbot.Controller.Verificacion.PlanificadorAltura;
import com.losameos.viverbot.Controller.Verificacion.StrategyAnalisisAltura;
import com.losameos.viverbot.Controller.Verificacion.StrategyMetroDown;
import com.losameos.viverbot.Controller.Verificacion.StrategySeguimientoNull;
import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.Interfaces.IAnalisisAltura;
import com.losameos.viverbot.Model.ControlSeguimientos;
import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.Model.SeguimientoAltura;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class AnalizadorAltura {
	private IAnalisisAltura estrategia;
	private ControlSeguimientos seguimientos;
	private ArrayList<PlantaDTO> plantas;
	private SeguimientoAltura seguimientoBuscado;
	private ArrayList<Magnitud> alturasRecibidas;
	private PlanificadorAltura planificador;
	private Magnitud m;
	
	public AnalizadorAltura() {
		this.estrategia = null;
		this.m = null;
		this.plantas = new Plantas().obtenerPlantas();
		this.seguimientos = ControlSeguimientos.getInstance();
		this.planificador = PlanificadorAltura.getInstance();
	}

	public void analizarAlturas(ArrayList<Magnitud> alturas) {
		this.plantas = new Plantas().obtenerPlantas();
		alturasRecibidas = alturas;
		for(int i = 0; i<plantas.size(); i++){
			if(i<alturas.size()){
				this.m = alturas.get(i);
			} else{
				this.m = null;
			}
			this.seguimientoBuscado = seguimientos.getSeguimiento(plantas.get(i));
			this.estrategia = this.getStrategy(m, seguimientoBuscado);
			EstadoAltura estadoActual = this.estrategia.analizar(m, seguimientoBuscado);
			planificador.actuar(estadoActual);
		}
	}
	
	private IAnalisisAltura getStrategy(Magnitud temp, SeguimientoAltura seguimiento) {
		if (seguimiento == null){
			return new StrategySeguimientoNull();
		}else if (temp.getValor() == -1){
			return new StrategyMetroDown();
		}
		else{
			return new StrategyAnalisisAltura();
		}
	}	
	
	public ArrayList<Magnitud> getAlturasRecibidas() {
		return alturasRecibidas;
	}
}
