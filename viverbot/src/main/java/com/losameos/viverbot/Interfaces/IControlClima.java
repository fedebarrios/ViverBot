package com.losameos.viverbot.Interfaces;

import com.losameos.viverbot.Model.Potencia;

public interface IControlClima {
	
	public void encenderAireAcondicionado();
	
	public void apagarAireAcondicionado();

	public void encenderFan(Potencia pot);

	public void apagarFan();

	public void aumentarTemperatura();

	public void disminuirTemperatura();

	public void cambiarTemperatura(Double temp);


}
