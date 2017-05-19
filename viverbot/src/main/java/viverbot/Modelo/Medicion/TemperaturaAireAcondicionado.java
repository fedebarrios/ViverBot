package viverbot.Modelo.Medicion;

import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class TemperaturaAireAcondicionado {
	private String temp;
	private Medicion diferencia;

	public TemperaturaAireAcondicionado() {
		this.diferencia = new Medicion(0.026, Magnitudes.TEMPERATURA);
		this.temp = "24";
	}

	public void definirTemp(String s) {
		switch (s) {
		case "16":
			this.diferencia.setValor(0.003);
			this.temp = "16";
			break;
		case "17":
			this.diferencia.setValor(0.006);
			this.temp = "17";
			break;
		case "18":
			this.diferencia.setValor(0.009);
			this.temp = "18";
			break;
		case "19":
			this.diferencia.setValor(0.011);
			this.temp = "19";
			break;
		case "20":
			this.diferencia.setValor(0.013);
			this.temp = "20";
			break;
		case "21":
			this.diferencia.setValor(0.017);
			this.temp = "21";
			break;
		case "22":
			this.diferencia.setValor(0.020);
			this.temp = "22";
			break;
		case "23":
			this.diferencia.setValor(0.023);
			this.temp = "23";
			break;
		case "24":
			this.diferencia.setValor(0.026);
			this.temp = "24";
			break;
		case "25":
			this.diferencia.setValor(0.029);
			this.temp = "25";
			break;
		case "26":
			this.diferencia.setValor(0.032);
			this.temp = "26";
			break;
		case "27":
			this.diferencia.setValor(0.035);
			this.temp = "27";
			break;
		case "28":
			this.diferencia.setValor(0.037);
			this.temp = "28";
			break;
		case "29":
			this.diferencia.setValor(0.040);
			this.temp = "29";
			break;
		}
	}

	public Medicion getDiferencia() {
		return diferencia;
	}

	@Override
	public String toString() {
		return temp;
	}

}
