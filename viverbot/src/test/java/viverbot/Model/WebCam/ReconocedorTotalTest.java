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
import viverbot.Modelo.WebCam.ResaltadorImagen;

public class ReconocedorTotalTest {
	
	private ObtenedorPath obtenedor; 
	private GeneradorImagenes generador;
	private AdapterImage adaptador;
	private PosicionadorKernel posicionador;
	private ReconocedorFruto reconocedor;
	private ResaltadorImagen resaltador;
	
	@Test
	public void deteccion5Frutostest() {
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol.png");
		iniciarImagenes();
		posicionarKernel(0, 0);
		assertEquals(5,reconocedor.reconocerFrutos(imgResaltada(), posicionador,1,1).intValue());
	}
	
	@Test
	public void deteccion0Frutostest() {
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol.JPG");
		iniciarImagenes();
		posicionarKernel(0, 0);
		assertEquals(0,reconocedor.reconocerFrutos(imgResaltada(), posicionador,1,1).intValue());

	}
	
	
	@Test
	public void deteccionObjetoBasuratest() {
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbolObjetoCayo.png");
		iniciarImagenes();
		posicionarKernel(0, 0);
		assertEquals(6,reconocedor.reconocerFrutos(imgResaltada(), posicionador,1,1).intValue());

	}
	
	@Test
	public void deteccion15Frutostest() {
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol15.png");
		iniciarImagenes();
		posicionarKernel(0, 0);
		assertEquals(15,reconocedor.reconocerFrutos(imgResaltada(), posicionador,1,1).intValue());


	}
	
	@Test
	public void desplazamientoPorPixelTest() {
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol.png");
		iniciarImagenes();
		posicionarKernel(0, 0);
		ReconocedorFrutoMock recoFalso = new ReconocedorFrutoMock();
		assertEquals(1,recoFalso.reconocerFrutos(imgResaltada(), posicionador).intValue());

	}
	
	
	@Test
	public void desplazamientoPorBloqueTest() {
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol.png");
		iniciarImagenes();
		posicionarKernel(164, 213);
		ReconocedorFrutoMock recoFalso = new ReconocedorFrutoMock();
		assertEquals(33,recoFalso.reconocerFrutos(imgResaltada(), posicionador).intValue());

	}
	
	
	
	@Test
	public void detectar2de2tamañosTest()
	{
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbolConFChicos.png");
		iniciarImagenes();
		posicionarKernel(0, 0);
		assertEquals(11,reconocedor.reconocerFrutos(imgResaltada(), posicionador,0.5f,1).intValue());
	}
	
	@Test
	public void detectar2de3tamañosTest()
	{
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbolConFChicos3.png");
		iniciarImagenes();
		posicionarKernel(0, 0);
		assertEquals(8,reconocedor.reconocerFrutos(imgResaltada(), posicionador,0.6f,1).intValue());
	}
	
	@Test
	public void detectar3de3tamañosTest()
	{
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbolConFChicos3.png");
		iniciarImagenes();
		posicionarKernel(0, 0);
		assertEquals(11,reconocedor.reconocerFrutos(imgResaltada(), posicionador,0.5f,1).intValue());
	}
	
	
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
		resaltador = new ResaltadorImagen();
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
