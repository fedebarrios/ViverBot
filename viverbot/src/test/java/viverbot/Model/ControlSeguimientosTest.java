package viverbot.Model;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

import viverbot.DTO.PlantaDTO;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.ControlSeguimientos;
import viverbot.Model.Fecha;
import viverbot.Model.HistorialAltura;
import viverbot.Model.SeguimientoAltura;
import viverbot.Model.TuplaAltura;
import viverbot.Model.Magnitudes.Altura;

public class ControlSeguimientosTest {
	private ArrayList<SeguimientoAltura> seguimientosTest1 = new ArrayList<SeguimientoAltura>();
	private ArrayList<TuplaAltura> tuplas;
	private HistorialAltura historial;
	private ArrayList<TuplaAltura> tuplasSetear;
	private HistorialAltura historialSetear;
	
	@Test
	public void controlSeguimientos(){
		ControlSeguimientos control = ControlSeguimientos.getInstance();
		control.setSeguimientos(seguimientosTest1);
		assertTrue(control.getSeguimientos()!=null);
		PlantaDTO planta1 = new PlantaDTO(1, 60, new UbicacionDTO(5,4), new Fecha(10, 10, 2016));
		PlantaDTO planta2 = new PlantaDTO(4, 59, new UbicacionDTO(4,4), new Fecha(10, 10, 2016));
		tuplas = new ArrayList<TuplaAltura>();
		tuplas.add(new TuplaAltura(new Altura(40,"cm"), 4));
		historial = new HistorialAltura(tuplas);
		assertTrue(control.getSeguimientos().size()==1);
		assertTrue(control.getSeguimiento(planta1).getHistorialVerdadero()!=null);
		assertTrue(control.getSeguimiento(planta1).getHistorialOptimo()!=null);
		assertTrue(control.getSeguimiento(planta2)==null);
		PlantaDTO planta3 = new PlantaDTO(10, 11, new UbicacionDTO(4,59), new Fecha(10, 4, 2017));
		control.getSeguimiento(planta1).setPlanta(planta3);
		assertTrue(control.getSeguimiento(planta3).getUltimoDiaMedicion()==1);
		tuplasSetear = new ArrayList<TuplaAltura>();
		tuplasSetear.add(new TuplaAltura(new Altura(60,"cm"), 8));
		historialSetear = new HistorialAltura(tuplasSetear);
		control.getSeguimiento(planta3).setHistorialVerdadero(historialSetear);
		assertTrue(control.getSeguimiento(planta3).getUltimoDiaMedicion()==8);
		
		
	
	}

}
