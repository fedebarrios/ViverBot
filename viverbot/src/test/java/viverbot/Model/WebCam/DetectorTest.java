package viverbot.Model.WebCam;

import static org.junit.Assert.*;


import org.junit.Test;

import viverbot.Modelo.WebCam.DetectorFruto;
import viverbot.Modelo.WebCam.GeneradorImagenes;
import viverbot.Modelo.WebCam.Kernel;
import viverbot.Modelo.WebCam.ObtenedorPath;
import viverbot.Modelo.WebCam.ReconocedorFruto;
import viverbot.Modelo.WebCam.ResaltadorImagen;

public class DetectorTest {
	
	private ResaltadorImagen resaltador;
	private ReconocedorFrutoMock reconocedor;
	private ObtenedorPath obtenedor; 
	private GeneradorImagenes generador;

	@Test
	public void kernelValidoTest() {
		//kernel ubicado sobre ubicacion valida
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbolC.png");
		iniciarReconocimiento(0,168);
		assertTrue(1==reconocedor.getCont());
		clean();
	}
	
	@Test
	public void posicionKernelTest()
	{
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbolC.png");
		iniciarReconocimiento(0, 0);
		assertTrue(27==reconocedor.getDetector().getKernel().getHeight());
		assertTrue(429==reconocedor.getDetector().getKernel().getWidth());
		clean();
	}
	
	@Test
	public void kernelSinDimensiones()
	{
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbolC.png");
		Kernel kernel = new Kernel();
		assertTrue(0==kernel.getHeight());
		assertTrue(0==kernel.getWidth());
		DetectorFrutoMock detector = new DetectorFrutoMock();
		detector.setKernel(kernel);
		detector.detectObject(0, 0, generador.getPrimerImagen());
		assertTrue(0==detector.getCont());
		clean();
	}
	
	@Test
	public void kernelAnalizaPixel()
	{
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbolC.png");
		Kernel kernel = new Kernel();
		assertTrue(0==kernel.getHeight());
		assertTrue(0==kernel.getWidth());
		kernel.setX(1);
		kernel.setY(1);
		DetectorFrutoMock detector = new DetectorFrutoMock();
		detector.setKernel(kernel);
		detector.detectObject(0, 0, generador.getPrimerImagen());
		assertTrue(0==detector.getCont());
		clean();
	}
	
	@Test
	public void kernelSinPixelesTest()
	{
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbolC.png");
		iniciarReconocimiento(0,100);
		assertTrue(0==reconocedor.getCont());
		clean();
		
	}
	
	@Test
	public void kernelSuperaDimensiones()
	{
		inicializar();
		iniciarPath("src/test/java/viverbot/recursosTest/arbolC.png");
		DetectorFruto detector = new DetectorFruto();
		generador.generarImagenes(obtenedor.getPrimerPath(),obtenedor.getSegundoPath());
		detector.detectObject(440, 440, generador.getPrimerImagen());
		assertTrue(0==detector.getCont());
		assertTrue(detector.getKernel().getWidth()>generador.getPrimerImagen().getAncho());
		assertTrue(detector.getKernel().getHeight()>generador.getPrimerImagen().getAlto());

	}
	

	

	
	
	private void inicializar()
	{
		resaltador = new ResaltadorImagen();
		reconocedor = new ReconocedorFrutoMock();
	
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
		reconocedor.reconocerFrutos(resaltador.resaltarImagen(generador),ancho,alto).getRepresentacion();
		System.out.println("cantidad de frutos detectados:"+reconocedor.getCont());

	}
	
	private void clean()
	{
		resaltador = null;
		reconocedor = null;
		obtenedor = null;
		generador = null;
	}
	}
