package viverbot.DTO;

public class UbicacionDTO {
	private Integer fila;
	private Integer columna;
	private boolean estado;
	private Integer indice;

	public UbicacionDTO(Integer fila, Integer columna, Integer indice) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.estado = false;
		this.indice = indice;
	}

	public Integer getFila() {
		return fila;
	}


	public Integer getColumna() {
		return columna;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public boolean equals(Object obj) {
		UbicacionDTO u;
		if (obj instanceof UbicacionDTO) {
			u = (UbicacionDTO) obj;
		} else {
			return false;
		}
		if (this.getColumna().equals(u.getColumna()) && this.getFila().equals(u.getFila())) {
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getFila() + "," + this.getColumna() + "," + this.getIndice();
	}

	public Integer getIndice() {
		return indice;
	}


}
