package viverbot.Modelo.WebCam;

import java.awt.image.BufferedImage;

public class ValidadorKernel extends Exception{
	
	private static final long serialVersionUID = 1L;

	public boolean validarKernel(BufferedImage kernel, BufferedImage imagen) throws Exception
	{

		if(!(kernel.getWidth()<=imagen.getWidth() && kernel.getHeight()<=imagen.getHeight())) 
			this.printStackTrace();
		
		return true;
		
		
	}

}
