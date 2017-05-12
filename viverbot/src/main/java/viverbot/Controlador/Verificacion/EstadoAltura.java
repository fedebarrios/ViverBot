package viverbot.Controlador.Verificacion;

import viverbot.DTO.PlantaDTO;

public class EstadoAltura {
	private String estado;
	private int valorMin;
	private int valorMax;
	private double cmDeDiferencia;
	private PlantaDTO planta;
	
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
	
	public PlantaDTO getPlanta() {
		return planta;
	}

	public void setPlanta(PlantaDTO planta) {
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

	public int getValorMin() {
		return valorMin;
	}

	public void setValorMin(int valorMin) {
		this.valorMin = valorMin;
	}

	public int getValorMax() {
		return valorMax;
	}

	public void setValorMax(int valorMax) {
		this.valorMax = valorMax;
	}

}
