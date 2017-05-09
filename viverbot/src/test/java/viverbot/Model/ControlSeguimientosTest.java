package viverbot.Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import viverbot.Controlador.Verificacion.StrategyAnalisisAltura;
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
	ControlSeguimientos control;
	
	
	@Test
	public void SeguimientoInvalido() {
		inicializar();
		
		HistorialOptimo historialOptimo1 = new HistorialOptimo(tuplas1 , especie2);
		
		this.control = ControlSeguimientos.getInstance();
		control.agregarSeguimiento(planta2, historialOptimo1);
		
		assertEquals(0 , control.getSeguimientos().size());
		
		clear();
	}
	
	@Test
	public void SeguimientoValidoCargado() {
		inicializar();
		
		HistorialOptimo historialOptimo1 = new HistorialOptimo(tuplas1 , especie2);
		
		this.control = ControlSeguimientos.getInstance();
		control.agregarSeguimiento(planta1, historialOptimo1);
		
		assertEquals(1 , control.getSeguimientos().size());

		clear();
	}
	
	@Test
	public void UltimoDiamedicionTestSinMedicionAnterior() {
		inicializar();
		
		HistorialOptimo historialOptimo1 = new HistorialOptimo(tuplas1 , especie2);
		
		this.control = ControlSeguimientos.getInstance();
		control.agregarSeguimiento(planta1, historialOptimo1);
		
		assertEquals(1,control.getSeguimiento(planta1).getUltimoDiaMedicion());

		clear();
	}
	
	@Test
	public void UltimoDiamedicionTestConMedicionGuardada() {
		inicializar();
		
		HistorialOptimo historialOptimo1 = new HistorialOptimo(tuplas1 , especie2);
		this.control = ControlSeguimientos.getInstance();
		control.agregarSeguimiento(planta1, historialOptimo1);
		GuardadorAltura g = GuardadorAltura.getInstance();
		g.guardar(new StrategyAnalisisAltura(),new Altura(14,"cm") , 5, control.getSeguimiento(planta1).getHistorialVerdadero());
		assertEquals(5,control.getSeguimiento(planta1).getUltimoDiaMedicion());

		clear();
	}

	
	
	@Test
	public void ControlSeguimientoTest() {
		inicializar();
		HistorialOptimo historialOptimo1 = new HistorialOptimo(tuplas1 , especie3);
		HistorialAltura historialAltura1 = new HistorialAltura(tuplas2);
		SeguimientoAltura seguimiento1 = new SeguimientoAltura(planta3, historialOptimo1 , historialAltura1 );
		
		
		ArrayList<SeguimientoAltura> seguimientos = new ArrayList<SeguimientoAltura>();
		seguimientos.add(seguimiento1);
		
		this.control = ControlSeguimientos.getInstance();
		control.cargarSeguimientos(seguimientos);
		
		assertTrue(control.getSeguimientos()!=null);
		assertTrue(control.getSeguimientos().size()==1);
		assertTrue(control.getSeguimiento(planta3)!=null);

		clear();
	}
	
	private void inicializar() {
		especie1 = new EspecieDTO(60 , "tomates" , "tomatus" , "");
		especie2 = new EspecieDTO(64 , "cebolla" , "cebollus" , "");
		especie3 = new EspecieDTO(65 , "papa" , "papus" , "");
		
		planta1 = new PlantaDTO(64, 22, new UbicacionDTO(5,4), new Fecha(6, 5, 2017));
		planta2 = new PlantaDTO(60, 59, new UbicacionDTO(4,4), new Fecha(6, 5, 2017));
		planta3 = new PlantaDTO(65, 100, new UbicacionDTO(1,4), new Fecha(6, 5, 2017));
		
		
		tuplas1 = new ArrayList<TuplaAltura>();
		tuplas1.add(new TuplaAltura(new Altura(30,"cm"), 4));
		tuplas1.add(new TuplaAltura(new Altura(40,"cm"), 5));
		tuplas1.add(new TuplaAltura(new Altura(50,"cm"), 6));
		
		tuplas2 = new ArrayList<TuplaAltura>();
		tuplas2.add(new TuplaAltura(new Altura(30,"cm"), 4));
		tuplas2.add(new TuplaAltura(new Altura(40,"cm"), 5));
		tuplas2.add(new TuplaAltura(new Altura(50,"cm"), 6));
		
	}
	
	private void clear(){
		ControlSeguimientos.getInstance().clear();;
	}
}
