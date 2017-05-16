package viverbot.Controlador.Verificacion;

import java.util.List;

public class TuplaEstadosValores {
	private List<EstadoAltura> estados;
	private List<Integer> valores;
	
	public TuplaEstadosValores(List<EstadoAltura> estados, List<Integer> valores) {
		this.setEstados(estados);
		this.setValores(valores);
	}

	public List<Integer> getValores() {
		return valores;
	}

	public void setValores(List<Integer> valores) {
		this.valores = valores;
	}

	public List<EstadoAltura> getEstados() {
		return estados;
	}

	public void setEstados(List<EstadoAltura> estados) {
		this.estados = estados;
	}
}
