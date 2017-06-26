package viverbot.Controlador.Verificacion;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import viverbot.Model.LectorConsola;
import viverbot.Model.SoporteFactory;
import viverbot.Model.SoporteMovible;
import viverbot.Modelo.Magnitudes.Magnitudes;


public class InformadorAltura implements Observer{
	private static InformadorAltura planificador;
	private SoporteMovible soporte;
	
	private InformadorAltura(){
		this.soporte = SoporteFactory.crearSoporte(Magnitudes.ALTURA);
	}
	
	public static InformadorAltura getInstance(){
		if(planificador == null ){
			planificador = new InformadorAltura();
		}
		return planificador;
	}
	
	protected SoporteMovible getSoporte() {
		return soporte;
	}
	
	public void actuar(EstadoAltura estado){
		estado.informar();
		
		if( estado.getEstado() == "Defectuosa"){
			System.out.println("Ingrese Si, si desea podar la planta.");
			String entradaTeclado = LectorConsola.getInstance().leerLinea();
		    if(entradaTeclado.equals("si")){
		    	if(soporte.getPodador().podar(estado.getPlanta())){
					System.out.println("La planta "+ estado.getPlanta().getCodigoPlanta()+" se ha podado.");
				}
				else{
					System.out.println("No se pudo podar la planta "+ estado.getPlanta().getCodigoPlanta() + ".");
				}
		    }
		    else{
		    	System.out.println("La planta no se podo.");
		    }
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object estadosDevueltos) {
		List<EstadoAltura> estados = (List<EstadoAltura>) estadosDevueltos;		
		for(EstadoAltura e : estados){
			actuar(e);
		}
	}
}
