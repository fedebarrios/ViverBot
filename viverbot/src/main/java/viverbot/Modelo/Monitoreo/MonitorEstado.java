package viverbot.Modelo.Monitoreo;

import java.util.Observable;
import java.util.Observer;

import viverbot.Controlador.VistaPrincipalController;
import viverbot.Model.EstadoVivero;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AnalizadorTemperatura;
import viverbot.Modelo.Medicion.DiagnosticoAnalisis;

public class MonitorEstado implements Observer {
	private Medicion temperaturaActual;
	private AnalizadorTemperatura analizador;
	private VistaPrincipalController controlador;
	private static final String tempAlta = "La temperatura esta por encima del rango ideal por ";
	private static final String tempBaja = "La temperatura esta por debajo del rango ideal por ";
	private static final String tempOptima = "La temperatura esta dentro del rango ideal";

	public MonitorEstado(VistaPrincipalController c) {
		this.temperaturaActual = new Medicion(0.0, Magnitudes.TEMPERATURA);
		this.analizador = new AnalizadorTemperatura();
		this.controlador = c;
	}

	public Medicion getTemperaturaActual() {
		return temperaturaActual;
	}

	public void setTemperaturaActual(Medicion t) {
		this.temperaturaActual = new Medicion(t.getValor(), t.getTipo());
	}

	@Override
	public void update(Observable o, Object arg) {
		if (!this.temperaturaActual.equals(arg)) {
			this.setTemperaturaActual((Medicion) arg);
			DiagnosticoAnalisis d = this.analizador.analizar(this.temperaturaActual, EstadoVivero.getInstance().getRangoTemperatura());
			if (!d.getOptima()) {
				if (d.getDiferencia() < 0) {
					this.controlador.actualizarLabelEstado(tempBaja + redondear(d.getDiferencia()) + " ºC",
							redondear(this.temperaturaActual.getValor()) + " ºC");

				} else {
					this.controlador.actualizarLabelEstado(tempAlta + redondear(d.getDiferencia()) + " ºC",
							redondear(this.temperaturaActual.getValor()) + " ºC");

				}
			} else {
				this.controlador.actualizarLabelEstado(tempOptima,
						redondear(this.temperaturaActual.getValor()) + " ºC");
			}

		}
	}

	private Double redondear(Double valor) {
		// TODO Auto-generated method stub
		return Math.rint(valor * 100) / 100;
	}

}
