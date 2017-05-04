package viverbot.Model.Medicion;

import java.util.ArrayList;

import viverbot.Controller.Verificacion.EstadoAltura;
import viverbot.Controller.Verificacion.PlanificadorAltura;
import viverbot.Controller.Verificacion.StrategyAnalisisAltura;
import viverbot.Controller.Verificacion.StrategyMetroDown;
import viverbot.Controller.Verificacion.StrategySeguimientoNull;
import viverbot.DTO.PlantaDTO;
import viverbot.Interfaces.IAnalisisAltura;
import viverbot.Model.ControlSeguimientos;
import viverbot.Model.Plantas;
import viverbot.Model.SeguimientoAltura;
import viverbot.Model.Magnitudes.Altura;
import viverbot.Model.Magnitudes.Magnitud;

public class AnalizadorAltura implements AnalizadorMagnitud{
	private IAnalisisAltura estrategia;
	private ControlSeguimientos seguimientos;
	private ArrayList<PlantaDTO> plantas;
	private SeguimientoAltura seguimientoBuscado;
	private ArrayList<Altura> alturasRecibidas;
	private PlanificadorAltura planificador;
	private Magnitud m;
	
	public AnalizadorAltura() {
		this.estrategia = null;
		this.m = null;
		this.plantas = new Plantas().obtenerPlantas();
		this.seguimientos = ControlSeguimientos.getInstance();
		this.planificador = PlanificadorAltura.getInstance();
	}

	public void analizar(ArrayList<Altura> alturas) {
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
	
	public ArrayList<Altura> getAlturasRecibidas() {
		return alturasRecibidas;
	}
}
