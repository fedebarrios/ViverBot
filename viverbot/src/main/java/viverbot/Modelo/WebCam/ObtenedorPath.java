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
	  primerPath="src/test/java/viverbot/recursosTest/vacio.jpg";
	  segundoPath="src/test/java/viverbot/recursosTest/3objetos.png";
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
	
	public void setPrimerPath(String path)
	{
		primerPath = path;
	}
	
	public void setSegundoPath(String path)
	{
		segundoPath = path;
	}

}
