package viverbot.Model.WebCam;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Test;

import viverbot.Modelo.WebCam.AdapterImage;
import viverbot.Modelo.WebCam.GeneradorImagenes;
import viverbot.Modelo.WebCam.Imagen;
import viverbot.Modelo.WebCam.Kernel;
import viverbot.Modelo.WebCam.ObtenedorPath;
import viverbot.Modelo.WebCam.ReconocedorFruto;
import viverbot.Modelo.WebCam.ResaltadorImagen;

public class ReconocedorTotalTest {
	
	private ObtenedorPath obtenedor; 
	private GeneradorImagenes generador;
	private AdapterImage adaptador;
	private ReconocedorFruto reconocedor;
	private Kernel kernel;
	
	//@Test
	public void deteccion5Frutostest() {
		 generarImagenes();
		 iniciarKernel();
		 
		 ResaltadorImagen.resaltarImagen(generador.getPrimerImagen(), generador.getSegundaImagen(),0,0);
		 Imagen imgResaltada = generador.getPrimerImagen();
		
		 reconocedor = new ReconocedorFruto();	
		 assertEquals(5,reconocedor.reconocerFrutos(imgResaltada, kernel,1,1).intValue());
	}
	
	
	//@Test
	public void deteccion0Frutostest() {
		generarImagenes();
		 iniciarKernel();
		 cargarImagenPrueba("src/test/java/viverbot/recursosTest/arbol.jpg");
		 ResaltadorImagen.resaltarImagen(generador.getPrimerImagen(), generador.getSegundaImagen(),0,0);
		 Imagen imgResaltada = generador.getPrimerImagen();
		
		 reconocedor = new ReconocedorFruto();	
		assertEquals(0,reconocedor.reconocerFrutos(imgResaltada, kernel,1,1).intValue());

	}
	
	
	//@Test
	public void deteccionObjetoBasuratest() {
		generarImagenes();
		 iniciarKernel();
		 cargarImagenPrueba("src/test/java/viverbot/recursosTest/arbolObjetoCayo.png");
		 ResaltadorImagen.resaltarImagen(generador.getPrimerImagen(), generador.getSegundaImagen(),0,0);
		 Imagen imgResaltada = generador.getPrimerImagen();
		
		 reconocedor = new ReconocedorFruto();	
		assertEquals(6,reconocedor.reconocerFrutos(imgResaltada, kernel,1,1).intValue());

	}
	
	//@Test
	public void deteccion15Frutostest() {
		
		generarImagenes();
		 iniciarKernel();
		 cargarImagenPrueba("src/test/java/viverbot/recursosTest/arbol15.png");
		 ResaltadorImagen.resaltarImagen(generador.getPrimerImagen(), generador.getSegundaImagen(),0,0);
		 Imagen imgResaltada = generador.getPrimerImagen();
		
		 reconocedor = new ReconocedorFruto();	
		assertEquals(15,reconocedor.reconocerFrutos(imgResaltada, kernel,1,1).intValue());

	}
	
	@Test
	public void desplazamientoPorPixelTest() {
		
		generarImagenes();
		 iniciarKernel();
		 ResaltadorImagen.resaltarImagen(generador.getPrimerImagen(), generador.getSegundaImagen(),0,0);
		 Imagen imgResaltada = generador.getPrimerImagen();
		ReconocedorFrutoMock recoFalso = new ReconocedorFrutoMock();
		assertEquals(1,recoFalso.reconocerFrutos(imgResaltada, kernel,0,0).intValue());

	}
	
	
	@Test
	public void desplazamientoPorBloqueTest() {
		generarImagenes();
		 iniciarKernel();
		 ResaltadorImagen.resaltarImagen(generador.getPrimerImagen(), generador.getSegundaImagen(),0,0);
		 Imagen imgResaltada = generador.getPrimerImagen();
		ReconocedorFrutoMock recoFalso = new ReconocedorFrutoMock();
		assertEquals(33,recoFalso.reconocerFrutos(imgResaltada, kernel,164,213).intValue());

	}
	
	
	
	@Test
	public void detectar2de2tamañosTest()
	{
		generarImagenes();
		 cargarImagenPrueba("src/test/java/viverbot/recursosTest/arbolConFChicos.png");
		 iniciarKernel();

		 ResaltadorImagen.resaltarImagen(generador.getPrimerImagen(), generador.getSegundaImagen(),0,0);
		 
		 Imagen imgResaltada = generador.getPrimerImagen();
		
		assertEquals(11,reconocedor.reconocerFrutos(imgResaltada, kernel,0.5f,1).intValue());
	}
	
	//@Test
	public void detectar2de3tamañosTest()
	{
		generarImagenes();
		 iniciarKernel();
		 cargarImagenPrueba("src/test/java/viverbot/recursosTest/arbolConFChicos3.png");
		 ResaltadorImagen.resaltarImagen(generador.getPrimerImagen(), generador.getSegundaImagen(),0,0);
		 Imagen imgResaltada = generador.getPrimerImagen();
		
		assertEquals(8,reconocedor.reconocerFrutos(imgResaltada, kernel,0.6f,1).intValue());
	}
	
	//@Test
	public void detectar3de3tamañosTest()
	{
		generarImagenes();
		 iniciarKernel();
		 cargarImagenPrueba("src/test/java/viverbot/recursosTest/arbolConFChicos3.png");
		 ResaltadorImagen.resaltarImagen(generador.getPrimerImagen(), generador.getSegundaImagen(),0,0);
		 Imagen imgResaltada = generador.getPrimerImagen();
		
		assertEquals(11,reconocedor.reconocerFrutos(imgResaltada, kernel,0.5f,1).intValue());
	}
	

	private void generarImagenes() {
		 obtenedor = new ObtenedorPath();
		 obtenedor.obtenerPath();
		 generador = new GeneradorImagenes();
		 obtenedor.setPrimerPath("src/test/java/viverbot/recursosTest/arbol.jpg");
		 obtenedor.setSegundoPath("src/test/java/viverbot/recursosTest/arbol.png");
		 generador.generarImagenes(obtenedor.getPrimerPath(),obtenedor.getSegundoPath());
	}
	
	private void iniciarKernel() {
		 adaptador = new AdapterImage();
		 adaptador.adaptarImagen("src/test/java/viverbot/recursosTest/objetoChico.png");
		 kernel = new Kernel(adaptador.getWidth(),adaptador.getHeight(),adaptador.getDatos());		
	}
	
	private void cargarImagenPrueba(String path)
	{
		 generador.setSegundaImagen(path);

	}
	
	
	

	

}
