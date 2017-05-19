package viverbot.Controlador.Verificacion;

import viverbot.DTO.Planta;

public class EstadoAlturaDefectuosa extends EstadoAltura{
	
	public EstadoAlturaDefectuosa(double cm , Planta planta){
		this.setEstado("Defectuosa");
		this.setCmDeDiferencia(cm);
		this.setPlanta(planta);
	}
	
	@Override
	public void informar(){
		System.out.println("La planta "+ this.getPlanta().getCodigoPlanta() +" tiene un problema de crecimiento.");
	}
}
