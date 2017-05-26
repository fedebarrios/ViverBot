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

	public Imagen getSegundaImagen() {
		return segundaImagen;
	}
	
	public void setSegundaImagen(String path)
	{
		segundaImagen = new Imagen(path);
	}

	
	
	
}
