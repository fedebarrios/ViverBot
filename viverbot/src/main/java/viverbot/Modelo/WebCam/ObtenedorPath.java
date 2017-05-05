package viverbot.Modelo.WebCam;

public class ObtenedorPath {
	
	private String primerPath;
	private String segundoPath;
	
	public ObtenedorPath()
	{
		primerPath = "";
		segundoPath = "";
	}
	
	public boolean obtenerPath()
	{
		
		// Levantar desde property
	  primerPath="src/test/java/com/losameos/viverbot/viverbot.recursos.Test/arbol.JPG";
	  segundoPath="src/test/java/com/losameos/viverbot/viverbot.recursos.Test/arbol 4.png";
	  if(validarPath()) return true;
	  else return false;
	}

	private boolean validarPath() {
		return !primerPath.isEmpty() && !segundoPath.isEmpty();
	}

	public String getPrimerPath() {
		return primerPath;
	}

	public String getSegundoPath() {
		return segundoPath;
	}

}
