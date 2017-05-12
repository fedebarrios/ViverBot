package viverbot.Model.WebCam;

import java.awt.image.Kernel;

import viverbot.Modelo.WebCam.DetectorFruto;
import viverbot.Modelo.WebCam.Imagen;

public class ReconocedorVertical {
	
	private Integer cont = 0;
	public Imagen reconocerFrutos(Imagen generador,int xx, int yy)
	{
		Imagen img = generador;
		Integer y=yy;
		Integer x=xx;
		Integer amountObject=0;
		DetectorFruto detector = new DetectorFruto();
		
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
					
					
				System.out.println("detector.contador: "+x);
		
		cont = x;
		return img;
		
		
	}


	public Integer getCont()
	{
		return cont;
	}

}
