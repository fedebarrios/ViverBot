package viverbot.Controlador.Verificacion;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import viverbot.Model.SoporteFactory;
import viverbot.Model.SoporteMovible;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Vista.Auxiliares.DefaultOptionPane;


public class InformadorAltura implements Observer{
	private static InformadorAltura planificador;
	private SoporteMovible soporte;
	private DefaultOptionPane optionPane = new DefaultOptionPane();
	
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
		
		if( estado.getEstado().equals("Defectuosa")){
			
			Object[] options = {"Si","No"};
			int n = optionPane.showOptionDialog(null,"Desea cosechar la planta?",
			            "Cosecha",
			            JOptionPane.YES_NO_CANCEL_OPTION,
			            JOptionPane.DEFAULT_OPTION,
			            null,
			            options,
			            options[1]);  
		
			if(n==0){  
				if(soporte.getPodador().podar(estado.getPlanta())){
					System.out.println("La planta "+ estado.getPlanta().getCodigoPlanta()+" se ha podado.");
				}
				else{
					System.out.println("No se pudo podar la planta "+ estado.getPlanta().getCodigoPlanta() + ".");
				}
			}else if(n==1){
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
	
	public void setOptionPane(DefaultOptionPane j){
		this.optionPane = j;
	}
}
