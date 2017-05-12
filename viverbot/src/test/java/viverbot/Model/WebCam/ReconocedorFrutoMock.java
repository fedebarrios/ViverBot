package viverbot.Model.WebCam;

import java.awt.image.Kernel;

import viverbot.Modelo.WebCam.DetectorFruto;
import viverbot.Modelo.WebCam.Imagen;

public class ReconocedorFrutoMock {
	
	private Integer cont = 0;
	private DetectorFruto detector;
	public Imagen reconocerFrutos(Imagen generador,int ancho, int alto)
	{
		Imagen img = generador;
		Integer y=alto;
		Integer x=0;
		Integer amountObject=0;
		detector = new DetectorFruto();
			
	
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
					
					if(detector.getCont()>=674 )
					System.out.println("detector.contador: "+detector.getCont());
			}
			
		cont = amountObject;
		return img;
		
	}


	public DetectorFruto getDetector() {
		return detector;
	}


	public void setDetector(DetectorFruto detector) {
		this.detector = detector;
	}


	public Integer getCont()
	{
		return cont;
	}

}
