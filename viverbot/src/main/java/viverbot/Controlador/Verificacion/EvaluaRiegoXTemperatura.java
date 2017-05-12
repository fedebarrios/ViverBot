package viverbot.Controlador.Verificacion;

import viverbot.Model.NivelRiego;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Temperatura;

public class EvaluaRiegoXTemperatura  extends EvaluaRiegoDecorator{
	private RangoNumerico rangoIdeal = new RangoNumerico(25.0, 5.0);
//	private Temperatura temperaturaActual=new TransmisorTemperaturaActual().getTemperaturaActual();
	private Temperatura temperaturaActual=new Temperatura(5.0);
	
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


	public Temperatura getTemperaturaActual() {
		return temperaturaActual;
	}


	public void setTemperaturaActual(Temperatura temperaturaActual) {
		this.temperaturaActual = temperaturaActual;
	}


}
