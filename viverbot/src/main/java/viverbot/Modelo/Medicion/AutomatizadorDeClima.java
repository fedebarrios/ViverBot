package viverbot.Modelo.Medicion;

import java.util.Timer;
import java.util.TimerTask;

import viverbot.Archivos.WriterExcel;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Temperatura;

public class AutomatizadorDeClima {
	private Temperatura temp;
	private RangoNumerico rango;
	private AireAcondicionado aire = new AireAcondicionado();
	private Timer timer;
	private boolean encendido = false;

	public AutomatizadorDeClima(Temperatura temp, RangoNumerico rango) {
		this.temp = temp;
		this.rango = rango;
		timer = new Timer();
	}

	private TimerTask tt = new TimerTask() {

		@Override
		public void run() {
			definirEstados();
			// Aca le doy a javi la diferencia de la temperatura
			// modificar el metodo ejecutar() para devuelva la diferencia
			aire.ejecutar();
			WriterExcel.registrarAutomatizacion(aire);
			System.out.println(temp.getValor());
			if (verificarRango()) {
				tt.cancel();
			}
		}
	};

	private boolean verificarRango() {
		if (temp.getValor() <= rango.getMaximo() && temp.getValor() >= rango.getMinimo()) {
			return true;
		}
		return false;
	}

	private void definirEstados() {
		definirFrioCalor();
		definirPotencia();
	}

	private void definirFrioCalor() {
		if (temp.getValor() > rango.getMaximo()) {
			aire.setFrioCalorEstado(new Frio());
		} else
			aire.setFrioCalorEstado(new Calor());
	}

	private void definirPotencia() {
		if (temp.getValor() - rango.getMaximo() <= 1.0 || rango.getMinimo() - temp.getValor() <= 1.0) {
			aire.setPotenciaEstado(new Potencia_0());
		}
		if (temp.getValor() - rango.getMaximo() > 1.0 && temp.getValor() - rango.getMaximo() <= 2.5
				|| rango.getMinimo() - temp.getValor() > 1.0 && rango.getMinimo() - temp.getValor() <= 2.5) {
			aire.setPotenciaEstado(new Potencia_1());
		}
		if (temp.getValor() - rango.getMaximo() > 2.5 && temp.getValor() - rango.getMaximo() <= 4.0
				|| rango.getMinimo() - temp.getValor() > 2.5 && rango.getMinimo() - temp.getValor() <= 4.0) {
			aire.setPotenciaEstado(new Potencia_2());
		}
		if (temp.getValor() - rango.getMaximo() > 4.0 || rango.getMinimo() - temp.getValor() > 4.0) {
			aire.setPotenciaEstado(new Potencia_3());
		}
	}

	public AireAcondicionado getAire() {
		return aire;
	}

	public Temperatura getTemp() {
		return temp;
	}

	public RangoNumerico getRango() {
		return rango;
	}

	public void encenderAutomatizador() {
		timer.schedule(tt, 1000, 1000);
		encendido = true;
	}

	public void apagarAutomatizador() {
		timer.purge();
		timer.cancel();
		encendido = false;
	}

	public boolean isEncendidoAutomatizador() {
		return encendido;
	}

}
