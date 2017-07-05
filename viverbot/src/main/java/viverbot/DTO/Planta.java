package viverbot.DTO;

import viverbot.Model.Fecha;

public class Planta {
	
	private int codigoEspecie;
	private int codigoPlanta;
	private String nombreEspecie;
	private UbicacionDTO ubicacion;
	private Fecha fechaPlanta;
	
	public Planta(int codigoEspecie, int codigoPlanta, UbicacionDTO ubicacion, Fecha fechaPlanta)
	{
		this.codigoEspecie = codigoEspecie;
		this.nombreEspecie = "";
		this.ubicacion = ubicacion;
		this.fechaPlanta = fechaPlanta;
		this.codigoPlanta = codigoPlanta;
	}
	
	public Planta(String nombreEspecie, int codigoPlanta, UbicacionDTO ubicacion, Fecha fechaPlanta)
	{
		this.codigoEspecie = -1;
		this.nombreEspecie = nombreEspecie;
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
		Planta other = (Planta) obj;
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

	public String getNombreEspecie() {
		return nombreEspecie;
	}

	public void setNombreEspecie(String nombreEspecie) {
		this.nombreEspecie = nombreEspecie;
	}
}
