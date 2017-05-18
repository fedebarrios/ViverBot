package viverbot.Modelo.WebCam;

public class ValidadorKernel extends Exception{
	
	private static final long serialVersionUID = 1L;
	private Imagen imagen;
	
	public ValidadorKernel()
	{
		imagen = new Imagen("src/test/java/viverbot/recursosTest/arbol.JPG");
	}
	
	public boolean validarKernel(Imagen kernel) throws Exception
	{

		if(!(kernel.getAncho()<=imagen.getAncho() && kernel.getAlto()<=imagen.getAlto())) 
			this.printStackTrace();
		
		return true;
		
		
	}

}
