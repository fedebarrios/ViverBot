package viverbot.DTO;

public class Especie {
	
	private int codEspecie;
	private String nombre;
	private String nombreCientifico;
	private String urlImage;
	
	public Especie(int codEspecie, String nombre, String nombreC, String imagen)
	{
		this.codEspecie = codEspecie;
		this.nombre = nombre; 
		this.nombreCientifico = nombreC;
		this.urlImage = imagen;
	}

	public int getCodEspecie() {
		return codEspecie;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public String getUrlImage() {
		return urlImage;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Especie){
			if(((Especie) o).getNombre().equals(nombre)&&((Especie) o).getNombreCientifico().equals(nombreCientifico)){
				return true;
			}
		}
		return false;
		
	}
}
