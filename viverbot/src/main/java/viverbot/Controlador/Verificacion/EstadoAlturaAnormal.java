package viverbot.Controlador.Verificacion;

import viverbot.DTO.Planta;

public class EstadoAlturaAnormal extends EstadoAltura{

	public EstadoAlturaAnormal(double cm, Planta planta){
		this.setEstado("Anormal");
		this.setCmDeDiferencia(cm);
		this.setPlanta(planta);
	}
	
	@Override
	public void informar(){
		System.out.println("La planta "+ this.getPlanta().getCodigoPlanta() + " esta creciendo menos de lo esperado. Tomar accion lo antes posible.");
	}
}
