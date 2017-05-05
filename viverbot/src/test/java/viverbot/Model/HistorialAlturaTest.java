package viverbot.Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import viverbot.Model.HistorialAltura;
import viverbot.Model.TuplaAltura;
import viverbot.Model.Magnitudes.Altura;
import viverbot.Model.Magnitudes.EmptyAltura;

public class HistorialAlturaTest {
	private HistorialAltura historial ;
	private ArrayList<TuplaAltura> tuplas;
	
	@Test
	public void BuscarTupla(){
		tuplas = new ArrayList<TuplaAltura>();
		tuplas.add(new TuplaAltura(new Altura(10,"cm"),1));
		tuplas.add(new TuplaAltura(new Altura(14,"cm"),2));
		tuplas.add(new TuplaAltura(new Altura(16,"cm"),3));
		tuplas.add(new TuplaAltura(new Altura(18,"cm"),4));
		historial = new HistorialAltura(tuplas);
		
		assertTrue(historial.tamaño()==4);
		assertTrue(historial.buscarTupla(new Altura(13,"cm")).getAltura() instanceof EmptyAltura);
		assertTrue(historial.buscarTupla(5).getAltura() instanceof EmptyAltura);
		assertTrue(historial.buscarTupla(new Altura(14,"cm")).getDiaDeVida() == 2);
		assertTrue(historial.buscarTupla(4).getAltura().getValor() == 18);
	}
	
	@Test
	public void BuscarMedicionPorDia(){
		tuplas = new ArrayList<TuplaAltura>();
		tuplas.add(new TuplaAltura(new Altura(25,"cm"),10));
		tuplas.add(new TuplaAltura(new Altura(58,"cm"),20));
		tuplas.add(new TuplaAltura(new Altura(64,"cm"),30));
		tuplas.add(new TuplaAltura(new Altura(69,"cm"),40));
		historial = new HistorialAltura(tuplas);
		
		assertTrue(historial.tamaño()==4);
		TuplaAltura nuevaTupla = new TuplaAltura(new Altura(60,"cm"),5);
		historial.agregarTupla(nuevaTupla);
		assertTrue(historial.tamaño()==5);
		historial.borrarTupla(nuevaTupla);
		assertTrue(historial.tamaño()==4);
		
		assertTrue(historial.verificarExistente(20));
		assertFalse(historial.verificarExistente(4));
	}
}
