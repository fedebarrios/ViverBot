package com.losameos.viverbot.Controller.Verificacion;

import java.util.ArrayList;

import com.losameos.viverbot.Model.HistorialAltura;
import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.Model.SeguimientoAltura;
import com.losameos.viverbot.Model.TuplaAltura;
import com.losameos.viverbot.Model.Magnitudes.Altura;

public class StubPlantasPerfectas extends StubSeguimientoAltura {

	public StubPlantasPerfectas(){
		
	}

	@Override
	public ArrayList<SeguimientoAltura> generarSeguimiento(){
		this.seguimientos = new ArrayList<SeguimientoAltura>();
		
		ArrayList<TuplaAltura> tuplas0 = new ArrayList<TuplaAltura>();
		tuplas0.add(new TuplaAltura(new Altura(100,"cm"),1));
		tuplas0.add(new TuplaAltura(new Altura(105,"cm"),2));
		tuplas0.add(new TuplaAltura(new Altura(110,"cm"),3));
		tuplas0.add(new TuplaAltura(new Altura(125,"cm"),4));
		tuplas0.add(new TuplaAltura(new Altura(140,"cm"),5));
		tuplas0.add(new TuplaAltura(new Altura(150,"cm"),6));
		tuplas0.add(new TuplaAltura(new Altura(150,"cm"),7));
		tuplas0.add(new TuplaAltura(new Altura(150,"cm"),8));
		tuplas0.add(new TuplaAltura(new Altura(160,"cm"),9));
		tuplas0.add(new TuplaAltura(new Altura(150,"cm"),10));
		tuplas0.add(new TuplaAltura(new Altura(140,"cm"),11));
		tuplas0.add(new TuplaAltura(new Altura(130,"cm"),12));
		tuplas0.add(new TuplaAltura(new Altura(120,"cm"),13));
		tuplas0.add(new TuplaAltura(new Altura(110,"cm"),14));
		HistorialAltura historialOptimo0 = new HistorialAltura(tuplas0);
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
		HistorialAltura historialOptimo1 = new HistorialAltura(tuplas1);
		this.agregarSeguimiento(new Plantas().obtenerPlantaEspecifica(1), historialOptimo1);
		
		ArrayList<TuplaAltura> tuplas2 = new ArrayList<TuplaAltura>();
		tuplas2.add(new TuplaAltura(new Altura(95,"cm"),1));
		tuplas2.add(new TuplaAltura(new Altura(99,"cm"),2));
		tuplas2.add(new TuplaAltura(new Altura(110,"cm"),3));
		tuplas2.add(new TuplaAltura(new Altura(111,"cm"),4));
		tuplas2.add(new TuplaAltura(new Altura(130,"cm"),5));
		tuplas2.add(new TuplaAltura(new Altura(150,"cm"),6));
		tuplas2.add(new TuplaAltura(new Altura(170,"cm"),7));
		tuplas2.add(new TuplaAltura(new Altura(180,"cm"),8));
		tuplas2.add(new TuplaAltura(new Altura(180,"cm"),9));
		tuplas2.add(new TuplaAltura(new Altura(170,"cm"),10));
		tuplas2.add(new TuplaAltura(new Altura(160,"cm"),11));
		tuplas2.add(new TuplaAltura(new Altura(140,"cm"),12));
		tuplas2.add(new TuplaAltura(new Altura(140,"cm"),13));
		tuplas2.add(new TuplaAltura(new Altura(130,"cm"),14));
		HistorialAltura historialOptimo2 = new HistorialAltura(tuplas2);
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
		HistorialAltura historialOptimo3 = new HistorialAltura(tuplas3);
		this.agregarSeguimiento(new Plantas().obtenerPlantaEspecifica(3), historialOptimo3);
		
		ArrayList<TuplaAltura> tuplas4 = new ArrayList<TuplaAltura>();
		tuplas4.add(new TuplaAltura(new Altura(110,"cm"),1));
		tuplas4.add(new TuplaAltura(new Altura(110,"cm"),2));
		tuplas4.add(new TuplaAltura(new Altura(110,"cm"),3));
		tuplas4.add(new TuplaAltura(new Altura(110,"cm"),4));
		tuplas4.add(new TuplaAltura(new Altura(110,"cm"),5));
		tuplas4.add(new TuplaAltura(new Altura(110,"cm"),6));
		tuplas4.add(new TuplaAltura(new Altura(110,"cm"),7));
		tuplas4.add(new TuplaAltura(new Altura(115,"cm"),8));
		tuplas4.add(new TuplaAltura(new Altura(120,"cm"),9));
		tuplas4.add(new TuplaAltura(new Altura(120,"cm"),10));
		tuplas4.add(new TuplaAltura(new Altura(110,"cm"),11));
		tuplas4.add(new TuplaAltura(new Altura(110,"cm"),12));
		tuplas4.add(new TuplaAltura(new Altura(111,"cm"),13));
		tuplas4.add(new TuplaAltura(new Altura(110,"cm"),14));
		HistorialAltura historialOptimo4 = new HistorialAltura(tuplas4);
		this.agregarSeguimiento(new Plantas().obtenerPlantaEspecifica(4), historialOptimo4);
		
		ArrayList<TuplaAltura> tuplas5 = new ArrayList<TuplaAltura>();
		tuplas5.add(new TuplaAltura(new Altura(200,"cm"),1));
		tuplas5.add(new TuplaAltura(new Altura(190,"cm"),2));
		tuplas5.add(new TuplaAltura(new Altura(180,"cm"),3));
		tuplas5.add(new TuplaAltura(new Altura(170,"cm"),4));
		tuplas5.add(new TuplaAltura(new Altura(160,"cm"),5));
		tuplas5.add(new TuplaAltura(new Altura(150,"cm"),6));
		tuplas5.add(new TuplaAltura(new Altura(140,"cm"),7));
		tuplas5.add(new TuplaAltura(new Altura(130,"cm"),8));
		tuplas5.add(new TuplaAltura(new Altura(120,"cm"),9));
		tuplas5.add(new TuplaAltura(new Altura(120,"cm"),10));
		tuplas5.add(new TuplaAltura(new Altura(120,"cm"),11));
		tuplas5.add(new TuplaAltura(new Altura(120,"cm"),12));
		tuplas5.add(new TuplaAltura(new Altura(120,"cm"),13));
		tuplas5.add(new TuplaAltura(new Altura(110,"cm"),14));
		HistorialAltura historialOptimo5 = new HistorialAltura(tuplas5);
		this.agregarSeguimiento(new Plantas().obtenerPlantaEspecifica(5), historialOptimo5);
		
		return this.seguimientos;
	}
}
