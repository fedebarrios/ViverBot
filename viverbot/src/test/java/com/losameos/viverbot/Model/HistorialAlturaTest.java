package com.losameos.viverbot.Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.losameos.viverbot.Model.Magnitudes.Altura;

public class HistorialAlturaTest {
	private HistorialAltura historial ;
	private ArrayList<TuplaAltura> tuplas;
	
	@Test
	public void HistorialTest(){
		tuplas = new ArrayList<TuplaAltura>();
		tuplas.add(new TuplaAltura(new Altura(14,"cm"),2));
		historial = new HistorialAltura(tuplas);
		assertTrue(historial.tamaño()==1);
		assertTrue(historial.buscarPorIndice(0).getAltura().getCentimetros()==14);
		assertFalse(historial.buscarPorIndice(1)!=null);
		TuplaAltura nuevaTupla = new TuplaAltura(new Altura(60,"cm"),5);
		historial.agregarTupla(nuevaTupla);
		assertTrue(historial.tamaño()==2);
		historial.borrarTupla(nuevaTupla);
		assertTrue(historial.tamaño()==1);
		assertTrue(historial.buscarTupla(new Altura(14,"cm")).getDiaDeVida()==2);
		assertTrue(historial.buscarTupla(new Altura(10,"cm"))==null);
		assertTrue(historial.buscarTupla(2).getAltura().getCentimetros()==14);
		assertTrue(historial.buscarTupla(4)==null);
		assertTrue(historial.verificarExistente(2));
		assertFalse(historial.verificarExistente(4));
	}
}
