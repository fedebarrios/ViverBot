package com.losameos.viverbot.Model.Medicion;

import java.util.TimerTask;
import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.archivos.WriterExcel;

public class AutomatizacionDeClima {
	private Temperatura temp;
	private RangoNumerico rango;
	private AireAcondicionado aireAcondicionado = new AireAcondicionado();

	public AutomatizacionDeClima(Temperatura temp, RangoNumerico rango) {
		this.temp = temp;
		this.rango = rango;
		WriterExcel.registrarAutomatizacion(aireAcondicionado);
	}

	TimerTask tt = new TimerTask() {

		@Override
		public void run() {
			aireAcondicionado.establecerPotenciaYEstado(temp, rango);
			aireAcondicionado.interferirTemperatura(temp);
			System.out.println(temp.getValor());
			if (veriricarRango()) {
				tt.cancel();
			}
		}
	};

	private boolean veriricarRango() {
		if (temp.getValor() <= rango.getMaximo() && temp.getValor() >= rango.getMinimo()) {
			return true;
		} else
			return false;
	}

}
