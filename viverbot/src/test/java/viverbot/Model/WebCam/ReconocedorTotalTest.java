package viverbot.Model.WebCam;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.WebCam.GeneradorImagenes;
import viverbot.Modelo.WebCam.ObtenedorPath;
import viverbot.Modelo.WebCam.ReconocedorFruto;
import viverbot.Modelo.WebCam.ResaltadorImagen;

public class ReconocedorTotalTest {

	
	private ResaltadorImagen resaltador;
	private ReconocedorFruto reconocedor;
	private ReconocedorVertical reconocedorVertical;
	private ObtenedorPath obtenedor; 
	private GeneradorImagenes generador;
	
	@Test
	public void deteccion5Frutostest() {
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol.png");
		iniciarReconocimiento(0, 0);
		assertTrue(5==reconocedor.getCont());
		clean();
	}
	
	@Test
	public void deteccion0Frutostest() {
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol.JPG");
		iniciarReconocimiento(0, 0);
		assertTrue(0==reconocedor.getCont());
		clean();

	}
	
	@Test
	public void deteccionObjetoBasuratest() {
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbolObjetoCayo.png");
		iniciarReconocimiento(0, 0);
		assertTrue(6==reconocedor.getCont());
		clean();

	}
	
	@Test
	public void deteccion10Frutostest() {
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol10.png");
		iniciarReconocimiento(0, 0);
		assertTrue(10==reconocedor.getCont());
		clean();

	}
	
	@Test
	public void desplazamientoPorBloqueTest() {
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol10.png");
		generador.generarImagenes(obtenedor.getPrimerPath(),obtenedor.getSegundoPath());
		reconocedorVertical.reconocerFrutos(resaltador.resaltarImagen(generador),0,0);
		assertTrue(33==reconocedorVertical.getCont());
		clean();

	}
	
	
	@Test
	public void sinDeteccionPixeles() {
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol10.png");
		generador.generarImagenes(obtenedor.getPrimerPath(),obtenedor.getSegundoPath());
		reconocedorVertical.reconocerFrutos(resaltador.resaltarImagen(generador),0,0);
		assertTrue(33==reconocedorVertical.getCont());
		clean();

	}
	
	
	
	private void inicializar()
	{
		resaltador = new ResaltadorImagen();
		reconocedor = new ReconocedorFruto();
		reconocedorVertical = new ReconocedorVertical();
	
	}
	
	private void iniciarPath(String path)
	{
		obtenedor = new ObtenedorPath();
		obtenedor.obtenerPath();
		obtenedor.setSegundoPath(path);
		generador = new GeneradorImagenes();
	}
	
	private void iniciarReconocimiento(int ancho, int alto)
	{
		generador.generarImagenes(obtenedor.getPrimerPath(),obtenedor.getSegundoPath());
		reconocedor.reconocerFrutos(resaltador.resaltarImagen(generador)).getRepresentacion();
		System.out.println("cantidad de frutos detectados:"+reconocedor.getCont());

	}
	
	private void clean()
	{
		resaltador = null;
		reconocedor = null;
		reconocedorVertical = null;
		obtenedor = null;
		generador = null;
	}

}
