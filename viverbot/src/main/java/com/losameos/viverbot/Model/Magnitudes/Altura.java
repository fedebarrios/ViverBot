package com.losameos.viverbot.Model.Magnitudes;

public class Altura extends Magnitud{
	private double metros;
	private double centimetros;
	private double pulgadas;
	
	/** Constructor para crear un objeto Altura desde un valor numerico y un string
	 *  @param valor => el valor numerico (puede llevar coma)
	 *  @param tipo => el tipo de medicion: metros ("metros/m"), centimetros ("centimetros/cm") y pulgadas ("pulgadas/p")
	 * **/
	
	public Altura (double valor, String tipo){
		super(valor);
		if (tipo.equals("metros") || tipo.equals("m")) {
			this.metros = valor;
		}
		else if (tipo.equals("centimetros") || tipo.equals("cm")) {
			this.centimetros = valor;
		}
		else if (tipo.equals("pulgadas") || tipo.equals("p")) {
			this.pulgadas = valor;
		}
		else { // Iniciamos el objeto con ceros
			this.metros = 0;
			this.centimetros = 0;
			this.pulgadas = 0;
		}
		this.convertirParametros(tipo);
		this.setValor(this.centimetros);
	}
	
	/** Constructor para crear un objeto Altura desde un valor compuesto en string
	 *  @param valor => el valor de medicion con el tipo: metros ("12.3metros/12.3m"), centimetros ("166centimetros/166cm") y pulgadas ("2.5pulgadas/2.5p")
	 * **/
	
	public Altura (String valor){
		super(0.0);
		String tipo = "";
		if (valor.contains("metros") || (valor.contains("m") && !valor.contains("c"))) {
			this.metros = Double.parseDouble(valor.substring(0,valor.indexOf('m')));
			tipo = valor.substring(valor.indexOf('m'), valor.length());
			this.setValor(this.metros);
		}
		else if (valor.contains("centimetros") || valor.contains("c")) {
			this.centimetros = Double.parseDouble(valor.substring(0,valor.indexOf('c')));
			tipo = valor.substring(valor.indexOf('c'), valor.length());
			this.setValor(this.centimetros);
		}
		else if (valor.contains("pulgadas") || valor.contains("p")) {
			this.pulgadas = Double.parseDouble(valor.substring(0,valor.indexOf('p')));
			tipo = valor.substring(valor.indexOf('p'), valor.length());
			this.setValor(this.pulgadas);
		}
		else { // Iniciamos el objeto con ceros
			this.metros = 0;
			this.centimetros = 0;
			this.pulgadas = 0;
		}
		this.convertirParametros(tipo);
		this.setValor(this.centimetros);
	}
	
	/** Metodo que convierte todos los valores de altura a partir de la medicion pasada por parametro
	 *  @param tipo => el tipo de medicion: metros ("metros/m"), centimetros ("centimetros/cm") y pulgadas ("pulgadas/p")
	 * **/
	
	private void convertirParametros(String tipo) {
		if (tipo.equals("metros") || tipo.equals("m")) {
			this.centimetros = this.metros * 100;
			this.pulgadas = this.metros * 39.3701;
		}
		else if (tipo.equals("centimetros") || tipo.equals("cm")) {
			this.metros = this.centimetros / 100;
			this.pulgadas = this.centimetros / 2.54;
		}
		else if (tipo.equals("pulgadas") || tipo.equals("p")) {
			this.centimetros = this.pulgadas * 2.54;
			this.metros = this.pulgadas * 0.0254;
		}
		else { // No convertir nada
			return;
		}
	}

	public double getMetros() {
		return metros;
	}

	public void setMetros(double metros) {
		this.metros = metros;
		this.convertirParametros("m");
	}

	public double getCentimetros() {
		return centimetros;
	}

	public void setCentimetros(double centimetros) {
		this.centimetros = centimetros;
		this.convertirParametros("c");
	}

	public double getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(double pulgadas) {
		this.pulgadas = pulgadas;
		this.convertirParametros("p");
	}
}
