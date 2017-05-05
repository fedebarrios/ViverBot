package viverbot.Model;

import viverbot.DTO.PlantaDTO;

public class SeguimientoAltura {
	private PlantaDTO planta;
	private HistorialOptimo historialOptimo;
	private HistorialAltura historialVerdadero;
	private String estado;
	
	public SeguimientoAltura(PlantaDTO p, HistorialOptimo h1, HistorialAltura h2) {
	
			this.planta = p;
			this.historialOptimo = h1;
			this.historialVerdadero = h2;
			this.estado = "";
		
		
	}

	public PlantaDTO getPlanta() {
		return planta;
	}

	public void setPlanta(PlantaDTO planta) {
		this.planta = planta;
	}

	public HistorialOptimo getHistorialOptimo() {
		return historialOptimo;
	}

	public void setHistorialOptimo(HistorialOptimo historialOptimo) {
		this.historialOptimo = historialOptimo;
	}

	public HistorialAltura getHistorialVerdadero() {
		return historialVerdadero;
	}

	public void setHistorialVerdadero(HistorialAltura historialVerdadero) {
		this.historialVerdadero = historialVerdadero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getUltimoDiaMedicion(){
		if(historialVerdadero.tamaño()==0){
			Fecha diaNacimiento = this.planta.getFechaPlanta();
			Fecha hoy = Fecha.obtenerFechaActual();
			int diaActualPlanta = Fecha.diasEntreDosFechas(hoy, diaNacimiento);
			return diaActualPlanta-1;
		}
		else{
			return historialVerdadero.diaUltimaMedicion();
		}
	}
}
