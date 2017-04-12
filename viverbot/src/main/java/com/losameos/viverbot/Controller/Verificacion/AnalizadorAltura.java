package com.losameos.viverbot.Controller.Verificacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.losameos.viverbot.Model.HistorialAltura;
import com.losameos.viverbot.Model.SeguimientoAltura;
import com.losameos.viverbot.Model.TuplaAltura;
import com.losameos.viverbot.Model.Magnitudes.Altura;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class AnalizadorAltura {
	private HistorialAltura historialOptimo;
	private HistorialAltura historialVerdadero;
	public String estadoPlantaAnalizada = "";
	public Altura diferenciaAltura = null;
	
	public AnalizadorAltura(){
		
	}
	
	public void analizarDiaEspecifico(Magnitud altura, SeguimientoAltura seguimiento){
		this.historialOptimo = seguimiento.getHistorialOptimo();
		this.historialVerdadero = seguimiento.getHistorialVerdadero();
		Date diaNacimiento = seguimiento.getPlanta().getFechaPlanta();
		int diaActual = diasEntreDosFechas(new Date(), diaNacimiento);
		//TODO: chequear que la misma altura y dia no esten ya en el historial
		this.historialVerdadero.agregarTupla(new TuplaAltura((Altura) altura, diaActual));
		TuplaAltura tuplaOptima = historialOptimo.buscarTupla(diaActual);
		double alturaActual = altura.getValor();
		System.out.println("altura actual : "+alturaActual);
		if( tuplaOptima == null ){
			System.out.println("No se encontro un dia en donde este especificada la altura optima");
		} else if (tuplaOptima.getAltura().getCentimetros() < alturaActual){
			System.out.println("La planta ha crecido mas de lo esperado");
			this.diferenciaAltura = diferenciaDeAlturas(tuplaOptima.getAltura(), new Altura(alturaActual, "cm"));
		} else {
			System.out.println("La planta esta creciendo menos de lo esperado");
			this.diferenciaAltura = diferenciaDeAlturas(tuplaOptima.getAltura(), new Altura(alturaActual, "cm"));
		}
	}
	
	public void analizarExaustivo(Magnitud altura, SeguimientoAltura seguimiento){
		System.out.println("La planta esta midiendo "+altura.getValor()+"cm actualmente");
		this.historialOptimo = seguimiento.getHistorialOptimo();
		this.historialVerdadero = seguimiento.getHistorialVerdadero();
		Date diaNacimiento = seguimiento.getPlanta().getFechaPlanta();
		int diaActualPlanta = diasEntreDosFechas(new Date(), diaNacimiento);
		System.out.println(diaActualPlanta);
		if (!this.historialVerdadero.verificarExistente(diaActualPlanta)){
			this.historialVerdadero.agregarTupla(new TuplaAltura((Altura) altura, diaActualPlanta));
		}
		int valorCrecimiento = 0;
		ArrayList<Double> porcentajes = new ArrayList<Double>();
		for (int i = 0; i < this.historialVerdadero.tamaño(); i++){
			TuplaAltura tuplaReal = this.historialVerdadero.buscarPorIndice(i);
			TuplaAltura tuplaOptima = this.historialOptimo.buscarTupla(tuplaReal.getDiaDeVida());
			if (tuplaOptima != null){
				analizarPorcentajeEnDia(tuplaReal, tuplaOptima, porcentajes);
				if (i == (this.historialVerdadero.tamaño() - 1)){
					this.diferenciaAltura = diferenciaDeAlturas(tuplaOptima.getAltura(), tuplaReal.getAltura());
				}
			}
		}
		valorCrecimiento = calcularCrecimiento(valorCrecimiento, porcentajes);
		if( valorCrecimiento > 150 ){
			System.out.println("La planta creció demasiado para lo que se esperaba.");
			this.estadoPlantaAnalizada = "Sublime";
		} else if (valorCrecimiento > 110 ){
			System.out.println("La planta ha crecido mas de lo esperado en su ciclo vital");
			this.estadoPlantaAnalizada = "Perfecta";
		} else if (valorCrecimiento > 90 ){
			System.out.println("La planta esta creciendo normalmente entre los valores esperados");
			this.estadoPlantaAnalizada = "Normal";
		}
		else if (valorCrecimiento > 70 ){
			System.out.println("La planta esta creciendo menos de lo esperado. Tomar accion lo antes posible");
			this.estadoPlantaAnalizada = "Anormal";
		}
		else {
			System.out.println("La planta tiene un problema de crecimiento. ¿Matarla?");
			this.estadoPlantaAnalizada = "Defectuosa";
		}
	}
	
	public void verificarAlturaActual() {
		if (this.diferenciaAltura == null){
			System.out.println("La planta no tiene un optimo en el historial para comparar en el dia de la fecha.");
		}
		else if (this.diferenciaAltura.getValor() > 0){
			System.out.println("La planta esta unos: " + (int) this.diferenciaAltura.getCentimetros() + "cm por encima de lo optimo.");
		}
		else if (this.diferenciaAltura.getValor() == 0){
			System.out.println("La planta esta exactamente en el valor optimo.");
		}
		else {
			System.out.println("La planta esta unos: " + (int) this.diferenciaAltura.getCentimetros() + "cm por debajo de lo optimo.");
		}
	}
	
	public Altura diferenciaDeAlturas(Altura optima, Altura actual){
		System.out.println(actual.getValor() + " y " + optima.getValor());
		double dif = actual.getValor() - optima.getValor();
		return new Altura(dif + "cm");
	}
	
	public void analizarPorcentajeEnDia(TuplaAltura real, TuplaAltura tentativa, ArrayList<Double> porcentajes){
		double porcentaje =  (real.getAltura().getValor() / tentativa.getAltura().getValor() * 100);
		porcentajes.add(porcentaje);
	}
	
	public int calcularCrecimiento(int porcentajeTotal, ArrayList<Double> porcentajes){
		double porcentajeAcumulado = 0;
		for (int i = 0; i < porcentajes.size(); i++){
			porcentajeAcumulado = porcentajeAcumulado + porcentajes.get(i);
		}
		porcentajeAcumulado = porcentajeAcumulado / porcentajes.size();
		return (int) porcentajeAcumulado;
	}
	
	public int diasEntreDosFechas(Date hoy, Date diaNacimiento) {
		DateFormat df = new SimpleDateFormat("dd MM yyyy");
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        final LocalDate firstDate = LocalDate.parse(df.format(hoy), formatter);
        final LocalDate secondDate = LocalDate.parse(df.format(diaNacimiento), formatter);
        final long days = ChronoUnit.DAYS.between(secondDate, firstDate);
        return (int) days;
	}
}
