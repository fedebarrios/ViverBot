package com.losameos.viverbot.Model;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.DTO.UbicacionDTO;
import com.losameos.viverbot.Model.Magnitudes.Altura;

public class ControlSeguimientosTest {
	private ArrayList<SeguimientoAltura> seguimientosTest1 = new ArrayList<SeguimientoAltura>();
	private ArrayList<TuplaAltura> tuplas;
	private HistorialAltura historial;
	
	@Test
	public void controlSeguimientos(){
		ControlSeguimientos control = ControlSeguimientos.getInstance();
		control.setSeguimientos(seguimientosTest1);
		assertTrue(control.getSeguimientos()!=null);
		PlantaDTO planta1 = new PlantaDTO(1, 60, new UbicacionDTO(5,4), new Date(10, 10, 2017));
		PlantaDTO planta2 = new PlantaDTO(4, 59, new UbicacionDTO(4,4), new Date(10, 10, 2017));
		tuplas = new ArrayList<TuplaAltura>();
		tuplas.add(new TuplaAltura(new Altura(40,"cm"), 1));
		historial = new HistorialAltura(tuplas);
		control.agregarSeguimiento(planta1, historial);
		assertTrue(control.getSeguimientos().size()==1);
		assertTrue(control.getSeguimiento(planta1).getHistorialVerdadero()!=null);
		assertTrue(control.getSeguimiento(planta1).getHistorialOptimo()!=null);
		assertTrue(control.getSeguimiento(planta2)==null);
		PlantaDTO planta3 = new PlantaDTO(10, 11, new UbicacionDTO(4,59), new Date(10, 10, 2017));
		control.getSeguimiento(planta1).setPlanta(planta3);
		
		
	}

}
