package viverbot.Modelo.WebCam;

public class ObtenedorImagenes {

	private GeneradorImagenes contenedorImagenes;

	public boolean obtenerImagenes() {
			ObtenedorPath obtenedorPath = new ObtenedorPath();
	
			if(obtenedorPath.obtenerPath()){
				contenedorImagenes = new GeneradorImagenes();
				contenedorImagenes.generarImagenes(obtenedorPath.getPrimerPath(), obtenedorPath.getSegundoPath());
				return true; }
			else
				return false;
	}
	

	public GeneradorImagenes getContenedorImagenes() {
		return contenedorImagenes;
	}


}
