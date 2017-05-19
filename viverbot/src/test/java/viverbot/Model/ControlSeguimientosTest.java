package viverbot.Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import viverbot.Controlador.Verificacion.StrategyAnalisisAltura;
import viverbot.DTO.Especie;
import viverbot.DTO.Planta;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.ControlSeguimientos;
import viverbot.Model.Fecha;
import viverbot.Model.HistorialAltura;
import viverbot.Model.SeguimientoAltura;
import viverbot.Model.TuplaAltura;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class ControlSeguimientosTest {
	Especie especie1;
	Especie especie2;
	Especie especie3;
	Planta planta1 ;
	Planta planta2 ;
	Planta planta3 ;
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
		int diaActualPlanta = Fecha.diasEntreDosFechas(Fecha.obtenerFechaActual(), planta1.getFechaPlanta())-1;
		assertEquals(diaActualPlanta ,control.getSeguimiento(planta1).getUltimoDiaMedicion());

		clear();
	}
	
	@Test
	public void UltimoDiamedicionTestConMedicionGuardada() {
		inicializar();
		
		HistorialOptimo historialOptimo1 = new HistorialOptimo(tuplas1 , especie2);
		this.control = ControlSeguimientos.getInstance();
		control.agregarSeguimiento(planta1, historialOptimo1);
		GuardadorAltura g = GuardadorAltura.getInstance();
		g.guardar(new StrategyAnalisisAltura(),new Medicion(14.0,Magnitudes.ALTURA) , 5, control.getSeguimiento(planta1).getHistorialVerdadero());
		assertEquals(5,control.getSeguimiento(planta1).getUltimoDiaMedicion());

		clear();
	}
	
	private void inicializar() {
		clear();
		especie1 = new Especie(60 , "tomates" , "tomatus" , "");
		especie2 = new Especie(64 , "cebolla" , "cebollus" , "");
		especie3 = new Especie(65 , "papa" , "papus" , "");
		
		planta1 = new Planta(64, 22, new UbicacionDTO(5,4,19), new Fecha(6, 5, 2017));
		planta2 = new Planta(60, 59, new UbicacionDTO(4,4,15), new Fecha(6, 5, 2017));
		planta3 = new Planta(65, 100, new UbicacionDTO(1,4,3), new Fecha(6, 5, 2017));
		
		
		tuplas1 = new ArrayList<TuplaAltura>();
		tuplas1.add(new TuplaAltura(new Medicion(30.0, Magnitudes.ALTURA), 4));
		tuplas1.add(new TuplaAltura(new Medicion(40.0 , Magnitudes.ALTURA), 5));
		tuplas1.add(new TuplaAltura(new Medicion(50.0, Magnitudes.ALTURA), 6));
		
		tuplas2 = new ArrayList<TuplaAltura>();
		tuplas2.add(new TuplaAltura(new Medicion(30.0, Magnitudes.ALTURA), 4));
		tuplas2.add(new TuplaAltura(new Medicion(40.0, Magnitudes.ALTURA), 5));
		tuplas2.add(new TuplaAltura(new Medicion(50.0, Magnitudes.ALTURA), 6));
		
	}
	
	private void clear(){
		ControlSeguimientos.getInstance().clear();
	}
}