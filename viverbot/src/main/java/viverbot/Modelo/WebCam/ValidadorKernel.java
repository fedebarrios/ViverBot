package viverbot.Modelo.WebCam;

public class ValidadorKernel {
	
	private Imagen imagen;
	
	public ValidadorKernel()
	{
		imagen = new Imagen("src/test/java/viverbot/recursosTest/arbol.JPG");
	}
	
	public boolean validarKernel(Imagen kernel)
	{

		if(kernel.getAncho()<=imagen.getAncho() && kernel.getAlto()<=imagen.getAlto() && kernel.getAncho()>1 && kernel.getAlto()>1) return true;
		else return false;
		
	}

}
