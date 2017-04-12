package com.losameos.viverbot.Controller;

import com.losameos.viverbot.Interfaces.IControlClima;
import com.losameos.viverbot.Model.AireAcondicionado;
import com.losameos.viverbot.Model.Potencia;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class AireAcondicionadoController implements IControlClima {
	private AireAcondicionado aireAcondicionado;

	public AireAcondicionadoController() {
		this.aireAcondicionado = new AireAcondicionado();
		Temperatura temp = new Temperatura(24.0);
		this.aireAcondicionado.setTemperatura(temp);
		this.aireAcondicionado.setFrio_calor(true);
		this.aireAcondicionado.setPotencia(Potencia.POTENCIA0);
	}

	public Potencia getPotencia() {
		return this.aireAcondicionado.getPotencia();
	}

	public boolean isOn_off() {
		return this.aireAcondicionado.isOn_off();
	}

	public boolean isFrio_calor() {
		return this.aireAcondicionado.isFrio_calor();
	}

	@Override
	public void encenderAireAcondicionado() {
		this.aireAcondicionado.setOn_off(true);
		System.out.println("Se encendio el aire acondicionado.");
		System.out.print("Temperatura: " + this.aireAcondicionado.getTemperatura().getValor() + " // ");
		if (this.aireAcondicionado.isFrio_calor() == true) {
			System.out.print("FRIO // ");
		} else
			System.out.print("CALOR // ");
		System.out.println("FAN: " + this.aireAcondicionado.getPotencia().toString());
	}

	@Override
	public void apagarAireAcondicionado() {
		this.aireAcondicionado.setOn_off(false);
		System.out.println("Se apago el aire acondicionado.");
	}

	@Override
	public void encenderFan(Potencia pot) {
		if (pot != Potencia.POTENCIA0) {
			this.aireAcondicionado.setPotencia(pot);
			System.out.println("El fan se encedio en " + pot.toString() + ".");
		} else
			throw new IllegalArgumentException("La potencia no puede ser 0.");
	}

	@Override
	public void apagarFan() {
		this.aireAcondicionado.setPotencia(Potencia.POTENCIA0);
		System.out.println("Fan apagado.");
	}

	@Override
	public void aumentarTemperatura() {
		Double temp_double = this.aireAcondicionado.getTemperatura().getValor() + 1.0;
		Temperatura temp = new Temperatura(temp_double);
		this.aireAcondicionado.setTemperatura(temp);
		System.out.println("La temperatura ha aumentado un grado.");
		System.out
				.println("La temperatura del aire acondicionado es: " + aireAcondicionado.getTemperatura().getValor());
	}

	@Override
	public void disminuirTemperatura() {
		Double temp_double = this.aireAcondicionado.getTemperatura().getValor() - 1.0;
		Temperatura temp = new Temperatura(temp_double);
		this.aireAcondicionado.setTemperatura(temp);
		System.out.println("La temperatura ha disminuido un grado.");
		System.out
				.println("La temperatura del aire acondicionado es: " + aireAcondicionado.getTemperatura().getValor());

	}

	@Override
	public void cambiarTemperatura(Double temp_double) {
		Temperatura temp = new Temperatura(temp_double);
		if (temp_double >= 16.0 && temp_double <= 29.0) {
			this.aireAcondicionado.setTemperatura(temp);
			System.out.println("La temperatura del aire ahora es de: " + aireAcondicionado.getTemperatura().getValor());
		} else
			throw new IllegalArgumentException("La temperatura debe ser entre 16 y 29 grados.");

	}

	@Override
	public void cambiarFrioCalor() {
		if (this.aireAcondicionado.isFrio_calor() == true) {
			this.aireAcondicionado.setFrio_calor(false);
			System.out.println("El aire acondicionado ha cambiado a CALOR");
		} else {
			this.aireAcondicionado.setFrio_calor(true);
			System.out.println("El aire acondicionado ha cambiado a FRIO");
		}
	}

}
