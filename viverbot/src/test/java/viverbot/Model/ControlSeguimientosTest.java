package viverbot.Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import viverbot.DTO.EspecieDTO;
import viverbot.DTO.PlantaDTO;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.ControlSeguimientos;
import viverbot.Model.Fecha;
import viverbot.Model.HistorialAltura;
import viverbot.Model.SeguimientoAltura;
import viverbot.Model.TuplaAltura;
import viverbot.Modelo.Magnitudes.Altura;

public class ControlSeguimientosTest {
	EspecieDTO especie1;
	EspecieDTO especie2;
	EspecieDTO especie3;
	PlantaDTO planta1 ;
	PlantaDTO planta2 ;
	PlantaDTO planta3 ;
	ArrayList<TuplaAltura> tuplas1;
	ArrayList<TuplaAltura> tuplas2 ;
	HistorialOptimo historialOptimo1;
	HistorialAltura historialAltura1;
	SeguimientoAltura seguimiento1;
	
	
	@Test(expected = Exception.class)
	public void SeguimientoInvalido() throws Exception{
		inicializar();
		
		HistorialOptimo historialOptimo1 = new HistorialOptimo(tuplas1 , especie1);
		HistorialAltura historialAltura1 = new HistorialAltura(tuplas2);
		
		SeguimientoAltura seguimiento1 = new SeguimientoAltura(planta1, historialOptimo1 , historialAltura1 );	
	}
	
	@Test
	public void ControlSeguimientoTest() throws Exception{
		inicializar();
		HistorialOptimo historialOptimo1 = new HistorialOptimo(tuplas1 , especie3);
		HistorialAltura historialAltura1 = new HistorialAltura(tuplas2);
		SeguimientoAltura seguimiento1 = new SeguimientoAltura(planta3, historialOptimo1 , historialAltura1 );
		
		
		ArrayList<SeguimientoAltura> seguimientos = new ArrayList<SeguimientoAltura>();
		seguimientos.add(seguimiento1);
		
		ControlSeguimientos control = ControlSeguimientos.getInstance();
		control.cargarSeguimientos(seguimientos);
		
		assertTrue(control.getSeguimientos()!=null);
		assertTrue(control.getSeguimientos().size()==1);
		assertTrue(control.getSeguimiento(planta3)!=null);
	}
	
	private void inicializar() {
		especie1 = new EspecieDTO(60 , "tomates" , "tomatus" , "");
		especie2 = new EspecieDTO(64 , "cebolla" , "cebollus" , "");
		especie3 = new EspecieDTO(65 , "papa" , "papus" , "");
		
		planta1 = new PlantaDTO(64, 22, new UbicacionDTO(5,4), new Fecha(10, 10, 2016));
		planta2 = new PlantaDTO(60, 59, new UbicacionDTO(4,4), new Fecha(10, 10, 2016));
		planta3 = new PlantaDTO(65, 100, new UbicacionDTO(1,4), new Fecha(10, 10, 2016));
		
		
		tuplas1 = new ArrayList<TuplaAltura>();
		tuplas1.add(new TuplaAltura(new Altura(30,"cm"), 4));
		tuplas1.add(new TuplaAltura(new Altura(40,"cm"), 5));
		tuplas1.add(new TuplaAltura(new Altura(50,"cm"), 6));
		
		tuplas2 = new ArrayList<TuplaAltura>();
		tuplas2.add(new TuplaAltura(new Altura(30,"cm"), 4));
		tuplas2.add(new TuplaAltura(new Altura(40,"cm"), 5));
		tuplas2.add(new TuplaAltura(new Altura(50,"cm"), 6));
		
	}
}
