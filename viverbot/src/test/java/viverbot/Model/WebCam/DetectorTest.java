package viverbot.Model.WebCam;

import static org.junit.Assert.*;


import org.junit.Test;

import viverbot.Modelo.WebCam.AdapterImage;
import viverbot.Modelo.WebCam.DetectorFruto;
import viverbot.Modelo.WebCam.GeneradorImagenes;
import viverbot.Modelo.WebCam.Imagen;
import viverbot.Modelo.WebCam.Kernel;
import viverbot.Modelo.WebCam.ObtenedorPath;
import viverbot.Modelo.WebCam.PosicionadorKernel;
import viverbot.Modelo.WebCam.ReconocedorFruto;
import viverbot.Modelo.WebCam.RectificadorImagen;
import viverbot.Modelo.WebCam.ValidadorKernel;

public class DetectorTest {
	
	private ReconocedorFruto reconocedor;
	private ObtenedorPath obtenedor; 
	private GeneradorImagenes generador;
	private AdapterImage adaptador;
	private PosicionadorKernel posicionador;
	private RectificadorImagen<PosicionadorKernel> rectificador;
	private RectificadorImagen<Imagen> resaltador;



	@Test
	public void kernelValidoTest() {
		//kernel ubicado sobre ubicacion valida
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol.png");
		iniciarImagenes();
		posicionarKernel(0, 0);
		assertTrue(DetectorFruto.detectar(imgResaltada(), 164, 213, posicionador.getKernel()));
		clean();
	}
	
	@Test
	public void posicionKernelTest()
	{
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol.png");
		iniciarImagenes();
		posicionarKernel(10, 12);
		assertEquals(10,posicionador.getX().intValue());
		assertEquals(12,posicionador.getY().intValue());
		clean();
	}
	
	@Test
	public void kernelSinDimensionesTest()
	{
		adaptador = new AdapterImage();
		Imagen imgPrueba = new Imagen("src/test/java/viverbot/recursosTest/imgVacia.png");
		assertEquals(1,imgPrueba.getAlto().intValue());
		assertEquals(1,imgPrueba.getAncho().intValue());
		assertFalse(adaptador.adaptarImagen("src/test/java/viverbot/recursosTest/imgVacia.png"));
		clean();
	}
	

	@Test
	public void kernelSinFrutoTest()
	{
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol.png");
		iniciarImagenes();
		posicionarKernel(0, 0);
		assertTrue(DetectorFruto.detectar(imgResaltada(), 164, 213, posicionador.getKernel()));
		assertFalse(DetectorFruto.detectar(imgResaltada(), 164, 223, posicionador.getKernel()));
		clean();
		
	}
	
	@Test
	public void kernelSuperaDimensiones()
	{
		adaptador = new AdapterImage();
		Imagen imagen = new Imagen("src/test/java/viverbot/recursosTest/arbol.JPG");
		Imagen imgPrueba = new Imagen("src/test/java/viverbot/recursosTest/naranja.png");
		assertEquals(768,imgPrueba.getAlto().intValue());
		assertEquals(768,imgPrueba.getAncho().intValue());
		assertEquals(440,imagen.getAncho().intValue());
		assertEquals(440,imagen.getAlto().intValue());

		assertFalse(adaptador.adaptarImagen("src/test/java/viverbot/recursosTest/naranja.png"));
		clean();

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
		rectificador = new RectificadorImagen<PosicionadorKernel>();
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
	
	private void clean()
	{
		reconocedor = null;
		obtenedor = null;
		generador = null;
		
	}
	}
