package viverbot.Modelo.Medicion;

import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class TemperaturaAireAcondicionado {
	private String temp;
	private Medicion diferencia;

	public TemperaturaAireAcondicionado() {
		this.diferencia = new Medicion(0.5, Magnitudes.TEMPERATURA);
		this.temp = "24";
	}

	public void definirTemp(String s) {
		switch (s) {
		case "16":
			this.diferencia.setValor(0.01);
			this.temp = "16";
			System.out.println("Temperatura del aire: 16 C°");
			break;
		case "17":
			this.diferencia.setValor(0.015);
			this.temp = "17";
			System.out.println("Temperatura del aire: 17 C°");
			break;
		case "18":
			this.diferencia.setValor(0.02);
			this.temp = "18";
			System.out.println("Temperatura del aire: 18 C°");
			break;
		case "19":
			this.diferencia.setValor(0.025);
			this.temp = "19";
			System.out.println("Temperatura del aire: 19 C°");
			break;
		case "20":
			this.diferencia.setValor(0.03);
			this.temp = "20";
			System.out.println("Temperatura del aire: 20 C°");
			break;
		case "21":
			this.diferencia.setValor(0.035);
			this.temp = "21";
			System.out.println("Temperatura del aire: 21 C°");
			break;
		case "22":
			this.diferencia.setValor(0.04);
			this.temp = "22";
			System.out.println("Temperatura del aire: 22 C°");
			break;
		case "23":
			this.diferencia.setValor(0.045);
			this.temp = "23";
			System.out.println("Temperatura del aire: 23 C°");
			break;
		case "24":
			this.diferencia.setValor(0.05);
			this.temp = "24";
			System.out.println("Temperatura del aire: 24 C°");
			break;
		case "25":
			this.diferencia.setValor(0.055);
			this.temp = "25";
			System.out.println("Temperatura del aire: 25 C°");
			break;
		case "26":
			this.diferencia.setValor(0.06);
			this.temp = "26";
			System.out.println("Temperatura del aire: 26 C°");
			break;
		case "27":
			this.diferencia.setValor(0.065);
			this.temp = "27";
			System.out.println("Temperatura del aire: 27 C°");
			break;
		case "28":
			this.diferencia.setValor(0.07);
			this.temp = "28";
			System.out.println("Temperatura del aire: 28 C°");
			break;
		case "29":
			this.diferencia.setValor(0.075);
			this.temp = "29";
			System.out.println("Temperatura del aire: 29 C°");
			break;
		}
	}

	public Medicion getDiferencia() {
		return diferencia;
	}

	@Override
	public String toString() {
		return "Temperatura:" + temp;
	}

}
