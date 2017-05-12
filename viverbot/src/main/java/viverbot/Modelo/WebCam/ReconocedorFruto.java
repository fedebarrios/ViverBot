package viverbot.Modelo.WebCam;

import java.awt.image.Kernel;

public class ReconocedorFruto {
	
	private Integer cont = 0;
	public Imagen reconocerFrutos(Imagen generador)
	{
		Imagen img = generador;
		Integer y=0;
		Integer x=0;
		Integer amountObject=0;
		DetectorFruto detector = new DetectorFruto();
		
		while(y != img.getAlto()&& y < img.getAlto()-27)
		{
			while(x != img.getAncho() && x < img.getAncho()-33)
			{
				img = detector.detectObject(x,y,generador);
				
					if(detector.getCont()==0)
					{
						x += 33;
					}
					else
						{
							x += 1;
						}
					if(detector.isFruit())
						amountObject +=1;
					
					
					System.out.println("detector.contador: "+detector.getCont());
			}
			detector.setCont();
			x=0;
			y += 1;
		}
		cont = amountObject;
		return img;
		
		
	}


	public Integer getCont()
	{
		return cont;
	}

}
