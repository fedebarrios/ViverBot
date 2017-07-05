package viverbot.Controlador.Verificacion;

import java.util.ArrayList;

public class EstadosDeAlturaDisponibles {
	private ArrayList<EstadoAltura> estados;
	private ArrayList<Double> valores;
	
	public EstadosDeAlturaDisponibles(ArrayList<EstadoAltura> estados, ArrayList<Double> valores) throws Exception {
		if (estados.size() == valores.size() || estados.size() < valores.size() || (estados.size() - valores.size()) > 1){
			throw new Exception("El tamaño del arreglo de estados debe ser mayor en 1 al de valores.");
		}
		this.setEstados(estados);
		this.setValores(valores);
	}

	public ArrayList<Double> getValores() {
		return valores;
	}

	public void setValores(ArrayList<Double> valores) {
		this.valores = valores;
	}

	public ArrayList<EstadoAltura> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<EstadoAltura> estados) {
		this.estados = estados;
	}
}
