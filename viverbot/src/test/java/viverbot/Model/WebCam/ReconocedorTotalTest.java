package viverbot.Model.WebCam;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import viverbot.Modelo.WebCam.AdapterImage;
import viverbot.Modelo.WebCam.DetectorFruto;
import viverbot.Modelo.WebCam.GeneradorImagenes;
import viverbot.Modelo.WebCam.Imagen;
import viverbot.Modelo.WebCam.ObtenedorPath;
import viverbot.Modelo.WebCam.PosicionadorKernel;
import viverbot.Modelo.WebCam.ReconocedorFruto;
import viverbot.Modelo.WebCam.RectificadorImagen;

public class ReconocedorTotalTest {
	
	private ObtenedorPath obtenedor; 
	private GeneradorImagenes generador;
	private AdapterImage adaptador;
	private PosicionadorKernel posicionador;
	private ReconocedorFruto reconocedor;
	private RectificadorImagen<Imagen> resaltador;
	
	//@Test
	public void deteccion5Frutostest() {
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol.png");
		iniciarImagenes();
		posicionarKernel(0, 0);
		assertEquals(5,reconocedor.reconocerFrutos(imgResaltada(), posicionador).intValue());
	}
	
	//@Test
	public void deteccion0Frutostest() {
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol.JPG");
		iniciarImagenes();
		posicionarKernel(0, 0);
		assertEquals(0,reconocedor.reconocerFrutos(imgResaltada(), posicionador).intValue());

	}
	
	
	//@Test
	public void deteccionObjetoBasuratest() {
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbolObjetoCayo.png");
		iniciarImagenes();
		posicionarKernel(0, 0);
		assertEquals(6,reconocedor.reconocerFrutos(imgResaltada(), posicionador).intValue());

	}
	
	@Test
	public void deteccion15Frutostest() {
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol15.png");
		iniciarImagenes();
		posicionarKernel(0, 0);
		assertEquals(15,reconocedor.reconocerFrutos(imgResaltada(), posicionador).intValue());


	}
	/*
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
	
	
	*/
	
	private Imagen imgResaltada()
	{
		return resaltador.rectificarImagen(generador.getPrimerImagen(), generador.getSegundaImagen());

	}
	
	private void posicionarKernel(int x, int y)
	{
		posicionador = new PosicionadorKernel(x,y,adaptador);

	}
	
	
	private void inicializar()
	{
		adaptador = new AdapterImage();
		resaltador = new RectificadorImagen<Imagen>();
		reconocedor = new ReconocedorFruto();
	
	}
	
	private void iniciarPath(String path)
	{
		obtenedor = new ObtenedorPath();
		obtenedor.obtenerPath();
		obtenedor.setSegundoPath(path);
		generador = new GeneradorImagenes();
	}
	
	private void iniciarImagenes()
	{
		generador.generarImagenes(obtenedor.getPrimerPath(),obtenedor.getSegundoPath());
		adaptador.adaptarImagen("src/test/java/viverbot/recursosTest/objetoChico.png");

	}
	

}
