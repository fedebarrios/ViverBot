package viverbot.Modelo.WebCam;

public class ObtenedorImagenes {

	private GeneradorImagenes contenedorImagenes;

	public void obtenerImagenes(String img1, String img2) {
		
				contenedorImagenes = new GeneradorImagenes();
				contenedorImagenes.generarImagenes(img1, img2);
	}
	

	public GeneradorImagenes getContenedorImagenes() {
		return contenedorImagenes;
	}


}
