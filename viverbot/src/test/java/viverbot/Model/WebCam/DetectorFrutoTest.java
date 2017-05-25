package viverbot.Model.WebCam;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.rules.ExpectedException;

import viverbot.Modelo.WebCam.AdapterImage;
import viverbot.Modelo.WebCam.DetectorFruto;
import viverbot.Modelo.WebCam.GeneradorImagenes;
import viverbot.Modelo.WebCam.Imagen;
import viverbot.Modelo.WebCam.Kernel;
import viverbot.Modelo.WebCam.ObtenedorPath;
import viverbot.Modelo.WebCam.PosicionadorKernel;
import viverbot.Modelo.WebCam.ReconocedorFruto;
import viverbot.Modelo.WebCam.ResaltadorImagen;
import viverbot.Modelo.WebCam.ValidadorKernel;

public class DetectorFrutoTest {
	

	private ObtenedorPath obtenedor; 
	private GeneradorImagenes generador;
	private AdapterImage adaptador;
	private PosicionadorKernel posicionador;
	private ResaltadorImagen resaltador;



	@Test
	public void kernelValidoTest() {
		//kernel ubicado sobre ubicacion valida
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/testDeteccion1.png");
		iniciarImagenes();
		posicionarKernel(0, 0);
		assertTrue(DetectorFruto.detectar(imgResaltada(), 0, 0, posicionador.getKernel()));
	}
	
	@Test
	public void kernelVacioFrutoTest() {
		//kernel ubicado sobre ubicacion valida
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbol.png");
		iniciarImagenes();
		posicionarKernel(0, 0);
		assertFalse(DetectorFruto.detectar(imgResaltada(), 0, 0, posicionador.getKernel()));
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
	}
	
	@Test
	public void kernelMedioFrutoTest() {
		//kernel ubicado sobre ubicacion valida
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/testDeteccion4.png");
		iniciarImagenes();
		posicionarKernel(0, 0);
		assertFalse(DetectorFruto.detectar(imgResaltada(), 0, 0, posicionador.getKernel()));
	}
	
	@Test
	public void kernelSuperaDimensiones()throws Exception 
	{
		
		
		adaptador = new AdapterImage();
		Imagen imagen = new Imagen("src/test/java/viverbot/recursosTest/arbol.JPG");
		Imagen imgPrueba = new Imagen("src/test/java/viverbot/recursosTest/naranja.png");
		assertEquals(768,imgPrueba.getAlto().intValue());
		assertEquals(768,imgPrueba.getAncho().intValue());
		assertEquals(440,imagen.getAncho().intValue());
		assertEquals(440,imagen.getAlto().intValue());
		ValidadorKernel validador = new ValidadorKernel(); 
		validador.validarKernel(imgPrueba);
		



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
