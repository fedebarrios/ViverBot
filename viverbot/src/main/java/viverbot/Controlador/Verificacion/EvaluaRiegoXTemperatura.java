package viverbot.Controlador.Verificacion;

import viverbot.Model.EstadoVivero;
import viverbot.Model.NivelRiego;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Medicion;

public class EvaluaRiegoXTemperatura  extends EvaluaRiegoDecorator{
	private RangoNumerico rangoIdeal = new RangoNumerico(25.0, 5.0);
	Medicion temperaturaActual = EstadoVivero.getInstance().getTemperaturaActual();
	
	public EvaluaRiegoXTemperatura(RiegoValidable riegoValidable) {
		super(riegoValidable);
	}

	
	public NivelRiego cantidadOptimaRiego(){
		NivelRiego nivel=getRiegoValidable().cantidadOptimaRiego();
		if (temperaturaActual.getValor()> rangoIdeal.getMaximo()){
			nivel=nivel.aumentar();
		}else if(temperaturaActual.getValor()< rangoIdeal.getMinimo()){
			nivel=nivel.bajar();
		}
		return nivel;
	}
	
	
	public RangoNumerico getRangoIdeal() {
		return rangoIdeal;
	}


	public Medicion getTemperaturaActual() {
		return temperaturaActual;
	}


	public void setTemperaturaActual(Medicion temperaturaActual) {
		this.temperaturaActual = temperaturaActual;
	}


}
