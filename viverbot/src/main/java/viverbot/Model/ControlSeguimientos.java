package viverbot.Model;

import java.util.ArrayList;
import viverbot.DAO.EspecieDAO;
import viverbot.DTO.PlantaDTO;
import viverbot.Modelo.Magnitudes.Altura;

public class ControlSeguimientos {
	private static ControlSeguimientos control;
	public ArrayList<SeguimientoAltura> seguimientos;
	
	private ControlSeguimientos(){
	}
	
	public static ControlSeguimientos getInstance(){
		if(control == null ){
			control = new ControlSeguimientos();
		}
		return control;
	}

	public ArrayList<SeguimientoAltura> getSeguimientos() {
		return seguimientos;
	}
	
	public SeguimientoAltura getSeguimiento( PlantaDTO planta ){
		for (int i = 0; i<seguimientos.size() ; i++){
			if( seguimientos.get(i).getPlanta().getCodigo() == planta.getCodigo()
				&& seguimientos.get(i).getPlanta().getCodigoPlanta() == planta.getCodigoPlanta()){
				return seguimientos.get(i);
			}
		}
		return null;
	}
	
	public void cargarSeguimientosHardcodeados(){
		this.seguimientos = new ArrayList<SeguimientoAltura>();
		
		ArrayList<TuplaAltura> tuplas0 = new ArrayList<TuplaAltura>();
		tuplas0.add(new TuplaAltura(new Altura(140,"cm"),1));
		tuplas0.add(new TuplaAltura(new Altura(157,"cm"),2));
		tuplas0.add(new TuplaAltura(new Altura(179,"cm"),3));
		tuplas0.add(new TuplaAltura(new Altura(181,"cm"),4));
		tuplas0.add(new TuplaAltura(new Altura(191,"cm"),5));
		tuplas0.add(new TuplaAltura(new Altura(199,"cm"),6));
		tuplas0.add(new TuplaAltura(new Altura(204,"cm"),7));
		tuplas0.add(new TuplaAltura(new Altura(200,"cm"),8));
		tuplas0.add(new TuplaAltura(new Altura(197,"cm"),9));
		tuplas0.add(new TuplaAltura(new Altura(206,"cm"),10));
		tuplas0.add(new TuplaAltura(new Altura(240,"cm"),11));
		tuplas0.add(new TuplaAltura(new Altura(230,"cm"),12));
		tuplas0.add(new TuplaAltura(new Altura(200,"cm"),13));
		tuplas0.add(new TuplaAltura(new Altura(180,"cm"),14));
		HistorialOptimo historialOptimo0 = new HistorialOptimo( tuplas0, EspecieDAO.getInstance().obtenerEspecie(0));
		this.agregarSeguimiento(new Plantas().obtenerPlantaEspecifica(0), historialOptimo0);
		
		ArrayList<TuplaAltura> tuplas1 = new ArrayList<TuplaAltura>();
		tuplas1.add(new TuplaAltura(new Altura(130,"cm"),1));
		tuplas1.add(new TuplaAltura(new Altura(144,"cm"),2));
		tuplas1.add(new TuplaAltura(new Altura(145,"cm"),3));
		tuplas1.add(new TuplaAltura(new Altura(147,"cm"),4));
		tuplas1.add(new TuplaAltura(new Altura(150,"cm"),5));
		tuplas1.add(new TuplaAltura(new Altura(161,"cm"),6));
		tuplas1.add(new TuplaAltura(new Altura(170,"cm"),7));
		tuplas1.add(new TuplaAltura(new Altura(180,"cm"),8));
		tuplas1.add(new TuplaAltura(new Altura(190,"cm"),9));
		tuplas1.add(new TuplaAltura(new Altura(206,"cm"),10));
		tuplas1.add(new TuplaAltura(new Altura(206,"cm"),11));
		tuplas1.add(new TuplaAltura(new Altura(206,"cm"),12));
		tuplas1.add(new TuplaAltura(new Altura(200,"cm"),13));
		tuplas1.add(new TuplaAltura(new Altura(150,"cm"),14));
		HistorialOptimo historialOptimo1 = new HistorialOptimo( tuplas1, EspecieDAO.getInstance().obtenerEspecie(0));
		this.agregarSeguimiento(new Plantas().obtenerPlantaEspecifica(1), historialOptimo1);
		
		ArrayList<TuplaAltura> tuplas2 = new ArrayList<TuplaAltura>();
		tuplas2.add(new TuplaAltura(new Altura(145,"cm"),1));
		tuplas2.add(new TuplaAltura(new Altura(162,"cm"),2));
		tuplas2.add(new TuplaAltura(new Altura(163,"cm"),3));
		tuplas2.add(new TuplaAltura(new Altura(164,"cm"),4));
		tuplas2.add(new TuplaAltura(new Altura(165,"cm"),5));
		tuplas2.add(new TuplaAltura(new Altura(166,"cm"),6));
		tuplas2.add(new TuplaAltura(new Altura(170,"cm"),7));
		tuplas2.add(new TuplaAltura(new Altura(180,"cm"),8));
		tuplas2.add(new TuplaAltura(new Altura(180,"cm"),9));
		tuplas2.add(new TuplaAltura(new Altura(170,"cm"),10));
		tuplas2.add(new TuplaAltura(new Altura(160,"cm"),11));
		tuplas2.add(new TuplaAltura(new Altura(140,"cm"),12));
		tuplas2.add(new TuplaAltura(new Altura(140,"cm"),13));
		tuplas2.add(new TuplaAltura(new Altura(130,"cm"),14));
		HistorialOptimo historialOptimo2 = new HistorialOptimo( tuplas2, EspecieDAO.getInstance().obtenerEspecie(0));
		this.agregarSeguimiento(new Plantas().obtenerPlantaEspecifica(2), historialOptimo2);
		
		ArrayList<TuplaAltura> tuplas3 = new ArrayList<TuplaAltura>();
		tuplas3.add(new TuplaAltura(new Altura(140,"cm"),1));
		tuplas3.add(new TuplaAltura(new Altura(144,"cm"),2));
		tuplas3.add(new TuplaAltura(new Altura(145,"cm"),3));
		tuplas3.add(new TuplaAltura(new Altura(147,"cm"),4));
		tuplas3.add(new TuplaAltura(new Altura(150,"cm"),5));
		tuplas3.add(new TuplaAltura(new Altura(150,"cm"),6));
		tuplas3.add(new TuplaAltura(new Altura(160,"cm"),7));
		tuplas3.add(new TuplaAltura(new Altura(170,"cm"),8));
		tuplas3.add(new TuplaAltura(new Altura(180,"cm"),9));
		tuplas3.add(new TuplaAltura(new Altura(190,"cm"),10));
		tuplas3.add(new TuplaAltura(new Altura(200,"cm"),11));
		tuplas3.add(new TuplaAltura(new Altura(206,"cm"),12));
		tuplas3.add(new TuplaAltura(new Altura(250,"cm"),13));
		tuplas3.add(new TuplaAltura(new Altura(280,"cm"),14));
		HistorialOptimo historialOptimo3 = new HistorialOptimo( tuplas3, EspecieDAO.getInstance().obtenerEspecie(0));
		this.agregarSeguimiento(new Plantas().obtenerPlantaEspecifica(3), historialOptimo3);
		
		ArrayList<TuplaAltura> tuplas4 = new ArrayList<TuplaAltura>();
		tuplas4.add(new TuplaAltura(new Altura(200,"cm"),1));
		tuplas4.add(new TuplaAltura(new Altura(190,"cm"),2));
		tuplas4.add(new TuplaAltura(new Altura(180,"cm"),3));
		tuplas4.add(new TuplaAltura(new Altura(170,"cm"),4));
		tuplas4.add(new TuplaAltura(new Altura(160,"cm"),5));
		tuplas4.add(new TuplaAltura(new Altura(150,"cm"),6));
		tuplas4.add(new TuplaAltura(new Altura(140,"cm"),7));
		tuplas4.add(new TuplaAltura(new Altura(130,"cm"),8));
		tuplas4.add(new TuplaAltura(new Altura(120,"cm"),9));
		tuplas4.add(new TuplaAltura(new Altura(120,"cm"),10));
		tuplas4.add(new TuplaAltura(new Altura(120,"cm"),11));
		tuplas4.add(new TuplaAltura(new Altura(120,"cm"),12));
		tuplas4.add(new TuplaAltura(new Altura(120,"cm"),13));
		tuplas4.add(new TuplaAltura(new Altura(110,"cm"),14));
		HistorialOptimo historialOptimo4 = new HistorialOptimo( tuplas4, EspecieDAO.getInstance().obtenerEspecie(0));
		this.agregarSeguimiento(new Plantas().obtenerPlantaEspecifica(4), historialOptimo4);
		
	}
	
	public void agregarSeguimiento(PlantaDTO planta, HistorialOptimo historialOptimo){
		ArrayList<TuplaAltura> tuplas = new ArrayList<TuplaAltura>();
		HistorialAltura h2 = new HistorialAltura(tuplas);
		try {
			this.seguimientos.add(new SeguimientoAltura(planta, historialOptimo, h2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cargarSeguimientos(ArrayList<SeguimientoAltura> seguimientos){
		this.seguimientos = seguimientos;
	}
}
