package viverbot.DTO;

import viverbot.Model.Fecha;

public class PlantaDTO {
	
	private int codigoEspecie;
	private int codigoPlanta;
	private UbicacionDTO ubicacion;
	private Fecha fechaPlanta;
	
	public PlantaDTO(int codigoEspecie, int codigoPlanta, UbicacionDTO ubicacion, Fecha fechaPlanta)
	{
		this.codigoEspecie = codigoEspecie;
		this.ubicacion = ubicacion;
		this.fechaPlanta = fechaPlanta;
		this.codigoPlanta = codigoPlanta;
	}

	public int getCodigoPlanta() {
		return codigoPlanta;
	}

	public Fecha getFechaPlanta() {
		return fechaPlanta;
	}

	public UbicacionDTO getUbicacion() {
		return ubicacion;
	}

	public Integer getCodigo() {
		return codigoEspecie;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlantaDTO other = (PlantaDTO) obj;
		if (codigoEspecie != other.codigoEspecie)
			return false;
		if (codigoPlanta != other.codigoPlanta)
			return false;
		if (fechaPlanta == null) {
			if (other.fechaPlanta != null)
				return false;
		} else if (!fechaPlanta.equals(other.fechaPlanta))
			return false;
		if (ubicacion == null) {
			if (other.ubicacion != null)
				return false;
		} else if (!ubicacion.equals(other.ubicacion))
			return false;
		return true;
	}
}
