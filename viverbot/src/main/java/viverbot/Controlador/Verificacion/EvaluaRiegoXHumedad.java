package viverbot.Controlador.Verificacion;

import viverbot.Model.EstadoVivero;
import viverbot.Model.NivelRiego;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class EvaluaRiegoXHumedad extends EvaluaRiegoDecorator{
	private RangoNumerico rangoIdeal = new RangoNumerico(50.0, 40.0);
	Medicion medicionHumedad=EstadoVivero.getInstance().getHumedadActual();
	
	
	public EvaluaRiegoXHumedad(RiegoValidable riegoValidable) {
		super(riegoValidable);
	}
	
	public NivelRiego cantidadOptimaRiego(){
		NivelRiego nivel=getRiegoValidable().cantidadOptimaRiego();		

		if (medicionHumedad.getValor()> rangoIdeal.getMaximo()){
			nivel=NivelRiego.NIVELNULO;
		}else if(medicionHumedad.getValor()< rangoIdeal.getMinimo()){
			nivel=nivel.aumentar();
		}
		return nivel;
	}

	public Medicion getMedicionHumedad() {
		return medicionHumedad;
	}

	public void setMedicionHumedad(Medicion medicionHumedad) {
		this.medicionHumedad = medicionHumedad;
	}
		
}
