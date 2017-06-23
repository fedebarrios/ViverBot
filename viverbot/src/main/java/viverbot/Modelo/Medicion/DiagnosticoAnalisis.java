package viverbot.Modelo.Medicion;

import viverbot.Modelo.Magnitudes.Medicion;

public class DiagnosticoAnalisis {
	private Medicion m;
	private Boolean optima;
	Double diferencia ;

	public DiagnosticoAnalisis(Medicion temperatura, Boolean optima, Double diferencia) {
		this.m = temperatura;
		this.optima = optima;
		this.diferencia = diferencia;
	}
	

	public Double getDiferencia() {
		return diferencia;
	}


	


	public Medicion getValor() {
		return m;
	}

	public Boolean getOptima() {
		return optima;
	}

//	public void setDiferencia(Double diferenccia) {
//		this.diferencia = diferenccia;
//	}
//	public void setValor(Medicion temperatura) {
//		this.m = temperatura;
//	}
//
//	public void setOptima(Boolean optima) {
//		this.optima = optima;
//	}

	@Override
	public boolean equals(Object e) {
		DiagnosticoAnalisis estado =  (DiagnosticoAnalisis) e;
		boolean ret = true;
		if(this.m.getValor() != estado.getValor().getValor() || this.getOptima() != estado.getOptima()){
			ret = false;
		}
		
		return ret;
	}

}
