package viverbot.Controller.Verificacion;

public class EstadoAlturaNoComparada extends EstadoAltura{
	
	public EstadoAlturaNoComparada(String estado){
		this.setEstado(estado);
	}
	
	@Override
	public void informar(){
		if(this.getEstado() == "MetroDown"){
			System.out.println("-------------------------------------------------");
			System.out.println("El metro esta averiado");
		}
		else if(this.getEstado() == "SeguimientoNull"){
			System.out.println("-------------------------------------------------");
			System.out.println("No existe un seguimiento vinculado a la planta actual");
		}
	}
}
