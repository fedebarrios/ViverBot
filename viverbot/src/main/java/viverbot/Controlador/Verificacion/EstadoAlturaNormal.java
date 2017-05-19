package viverbot.Controlador.Verificacion;

import viverbot.DTO.Planta;

public class EstadoAlturaNormal extends EstadoAltura{

	public EstadoAlturaNormal(double cm, Planta planta){
		this.setEstado("Normal");
		this.setCmDeDiferencia(cm);
		this.setPlanta(planta);
	}
	
	@Override
	public void informar(){
		System.out.println("La planta "+ this.getPlanta().getCodigoPlanta() +" esta creciendo normalmente entre los valores esperados.");
	}
}
