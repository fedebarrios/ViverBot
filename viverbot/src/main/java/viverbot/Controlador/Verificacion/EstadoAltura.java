package viverbot.Controlador.Verificacion;

import viverbot.DTO.Planta;

public class EstadoAltura {
	private String estado;
	private double cmDeDiferencia;
	private Planta planta;
	
	public EstadoAltura(){
		this.estado = "";
		this.cmDeDiferencia = 0;
		this.planta = null;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Planta getPlanta() {
		return planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}

	public double getCmDeDiferencia() {
		return cmDeDiferencia;
	}
	
	public void setCmDeDiferencia(double cmDeDiferencia) {
		this.cmDeDiferencia = cmDeDiferencia;
	}
	
	public void informar(){
		
	}
}
