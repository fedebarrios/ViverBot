package viverbot.Modelo.WebCam;

import java.awt.Point;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ReconocedorFruto {
	
	private ArrayList<Point> ubicaciones;
	private static final DecimalFormat formatoD = new DecimalFormat("#0.0");

	public ReconocedorFruto()
	{
		ubicaciones = new ArrayList<Point>();
	}
	
	public Integer reconocerFrutos(Imagen imagen, Kernel kernel,float pExpectativa, float pRecibida )
	{
		Integer y=0;
		Integer x=0;
		Integer cantidadF=0;

		while(y != imagen.getAlto()&& y < imagen.getAlto()-kernel.getHeight()){
		while(x != imagen.getAncho() && x < imagen.getAncho()-kernel.getWidth()){				
			if(DetectorFruto.detectar(imagen, x, y, kernel))
			{
				
				ubicaciones.add(new Point(x,y));
				ResaltadorKernel.resaltarKernel(imagen, kernel,x,y);
				cantidadF ++;
				x += kernel.getWidth();
			}
			else
				x++;	
			}
			x=0;
			y ++;
		}
		
		if(!String.valueOf(pExpectativa).equals(formatoD.format(pRecibida)))
		{
			System.out.println(pExpectativa+" valores "+formatoD.format(pRecibida));
			Kernel nuevoKernel = GeneradorProporcional.generarKernelProporcional(kernel, pRecibida-0.1f);
			cantidadF += reconocerFrutos(imagen, nuevoKernel, pExpectativa, pRecibida-0.1f);
		}
		for(Point p: ubicaciones){
			System.out.println("("+p.getX()+","+p.getY()+")");
			System.out.println(ubicaciones.size());
	
		}
		return cantidadF;
		
		
	}

	public ArrayList<Point> getUbicaciones()
	{
		return ubicaciones;
	}

}
