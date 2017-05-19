package viverbot.Controlador.Verificacion;

import viverbot.DTO.Planta;

public class EstadoAlturaPerfecta extends EstadoAltura{

	public EstadoAlturaPerfecta(double cm , Planta planta){
		this.setEstado("Perfecta");
		this.setCmDeDiferencia(cm);
		this.setPlanta(planta);
	}
	
	@Override
	public void informar(){
		System.out.println("La planta "+ this.getPlanta().getCodigoPlanta() +" creció demasiado para lo que se esperaba.");
		System.out.println("Tiene "+this.getCmDeDiferencia()+" cm de diferencia con lo optimo");
	}
}
