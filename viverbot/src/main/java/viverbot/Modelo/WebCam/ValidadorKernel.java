package viverbot.Modelo.WebCam;

public class ValidadorKernel extends Exception{
	
	private static final long serialVersionUID = 1L;

	public boolean validarKernel(Imagen kernel, Imagen imagen) throws Exception
	{

		if(!(kernel.getAncho()<=imagen.getAncho() && kernel.getAlto()<=imagen.getAlto())) 
			this.printStackTrace();
		
		return true;
		
		
	}

}
