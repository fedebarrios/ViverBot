package viverbot.Controlador.Verificacion;

import viverbot.Model.NivelRiego;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Temperatura;

public class EvaluaRiegoXTemperatura  extends EvaluaRiegoDecorator{
	private TransmisorTemperaturaActual transmTempActual;
	private RangoNumerico rangoIdeal = new RangoNumerico(25.0, 5.0);


	public EvaluaRiegoXTemperatura(RiegoValidable riegoValidable) {
		super(riegoValidable);
	/*	transmTempActual =new TransmisorTemperaturaActual();*/
		
	}

	
	public NivelRiego cantidadOptimaRiego(){
		Temperatura temperaturaActual= transmTempActual.getTemperaturaActual();
		NivelRiego nivel=NivelRiego.NORMAL;
		
		if (temperaturaActual.getValor()> rangoIdeal.getMaximo()){
			nivel= NivelRiego.AUMENTAR;
		}else if(temperaturaActual.getValor()< rangoIdeal.getMinimo()){
			nivel= NivelRiego.BAJAR;
		}
		return getRiegoValidable().cantidadOptimaRiego().nivelar(nivel);
	}
	
	public TransmisorTemperaturaActual getTransmTempActual() {
		return transmTempActual;
	}


	public RangoNumerico getRangoIdeal() {
		return rangoIdeal;
	}


}
