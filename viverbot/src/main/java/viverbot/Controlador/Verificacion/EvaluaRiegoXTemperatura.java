package viverbot.Controlador.Verificacion;

import viverbot.Model.NivelRiego;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Temperatura;

public class EvaluaRiegoXTemperatura  extends EvaluaRiegoDecorator{
	private RangoNumerico rangoIdeal = new RangoNumerico(25.0, 5.0);
	private Temperatura temperaturaActual=new TransmisorTemperaturaActual().getTemperaturaActual();

	public EvaluaRiegoXTemperatura(RiegoValidable riegoValidable) {
		super(riegoValidable);
	}

	
	public NivelRiego cantidadOptimaRiego(){
		NivelRiego nivel=NivelRiego.NORMAL;
		if (temperaturaActual.getValor()> rangoIdeal.getMaximo()){
			nivel= NivelRiego.AUMENTAR;
		}else if(temperaturaActual.getValor()< rangoIdeal.getMinimo()){
			nivel= NivelRiego.BAJAR;
		}
		return getRiegoValidable().cantidadOptimaRiego().nivelar(nivel);
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
