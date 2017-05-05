package viverbot.Controller.Verificacion;

import viverbot.Model.NivelRiego;
import viverbot.Model.RangoNumerico;
import viverbot.Model.Magnitudes.Temperatura;

public class ValidaRiegoTemperatura  extends ValidaRiegoDecorator{
	private TransmisorTemperaturaActual transmTempActual;
	private RangoNumerico rangoIdeal = new RangoNumerico(25.0, 5.0);


	public ValidaRiegoTemperatura(RiegoValidable riegoValidable) {
		super(riegoValidable);
		transmTempActual =new TransmisorTemperaturaActual();
		
	}

	
	public NivelRiego cantidadOptimaRiego(){
		Temperatura temperaturaActual= transmTempActual.getTemperaturaActual();
		NivelRiego nivel=NivelRiego.NORMAL;
		
		if (temperaturaActual.getValor()> rangoIdeal.getMaximo()){
			nivel= NivelRiego.AUMENTAR;
		}else if(temperaturaActual.getValor()< rangoIdeal.getMinimo()){
			nivel= NivelRiego.BAJAR;
		}
		return promediaNivel(nivel);
	}
	
	public TransmisorTemperaturaActual getTransmTempActual() {
		return transmTempActual;
	}


	public RangoNumerico getRangoIdeal() {
		return rangoIdeal;
	}


}
