package viverbot.Modelo.Medicion;

import java.util.TimerTask;

import viverbot.Archivos.WriterExcel;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Temperatura;

public class AutomatizacionDeClima {
	private Temperatura temp;
	private RangoNumerico rango;
	private AireAcondicionado aireAcondicionado = new AireAcondicionado();

	public AutomatizacionDeClima(Temperatura temp, RangoNumerico rango) {
		this.temp = temp;
		this.rango = rango;
	}

	public TimerTask tt = new TimerTask() {
		
		@Override
		public void run() {
			aireAcondicionado.establecerPotenciaYEstado(temp, rango);
			aireAcondicionado.interferirTemperatura(temp);
			WriterExcel.registrarAutomatizacion(aireAcondicionado);
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
