package viverbot.Modelo.Medicion;

import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.Temperatura;

public class DiagnosticoAnalisis {
	private Medicion m;
	private Boolean optima;
	Double diferencia ;

	public DiagnosticoAnalisis(Medicion temperatura, Boolean optima) {
		super();
		this.m = temperatura;
		this.optima = optima;
		this.diferencia = 0.0;
	}
	

	public Double getDiferencia() {
		return diferencia;
	}


	public void setDiferencia(Double diferenccia) {
		this.diferencia = diferenccia;
	}


	public Medicion getMagnitud() {
		return m;
	}

	public Boolean getOptima() {
		return optima;
	}

	public void setTemperatura(Medicion temperatura) {
		this.m = temperatura;
	}

	public void setOptima(Boolean optima) {
		this.optima = optima;
	}

	@Override
	public boolean equals(Object e) {
		DiagnosticoAnalisis estado =  (DiagnosticoAnalisis) e;
		boolean ret = true;
		if(this.m.getValor() != estado.getMagnitud().getValor() || 
				this.getOptima() != estado.getOptima()){
			ret = false;
		}
		
		return ret;
	}

}
