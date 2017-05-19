package viverbot.Model;

import viverbot.DTO.Planta;

public class SeguimientoAltura {
	private Planta planta;
	private HistorialOptimo historialOptimo;
	private HistorialAltura historialVerdadero;
	private String estado;
	
	public SeguimientoAltura(Planta p, HistorialOptimo h1, HistorialAltura h2) {
	
			this.planta = p;
			this.historialOptimo = h1;
			this.historialVerdadero = h2;
			this.estado = "";
		
		
	}

	public Planta getPlanta() {
		return planta;
	}

	public HistorialOptimo getHistorialOptimo() {
		return historialOptimo;
	}

	public HistorialAltura getHistorialVerdadero() {
		return historialVerdadero;
	}

	public String getEstado() {
		return estado;
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
