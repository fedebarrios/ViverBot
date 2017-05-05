package viverbot.Modelo.WebCam;

public class GeneradorImagenes {
	
	private Imagen primerImagen;
	private Imagen segundaImagen;
	
	public void generarImagenes(String primerPath, String segundoPath)
	{
		primerImagen = new Imagen(primerPath);
		segundaImagen = new Imagen(segundoPath);
		
	}

	public Imagen getPrimerImagen() {
		return primerImagen;
	}

	public void setPrimerImagen(Imagen primerImagen) {
		this.primerImagen = primerImagen;
	}

	public Imagen getSegundaImagen() {
		return segundaImagen;
	}

	public void setSegundaImagen(Imagen segundaImagen) {
		this.segundaImagen = segundaImagen;
	}

	
	
	
}
