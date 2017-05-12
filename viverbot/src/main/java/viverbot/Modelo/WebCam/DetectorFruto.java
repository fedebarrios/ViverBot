package viverbot.Modelo.WebCam;

import java.util.ArrayList;

public class DetectorFruto {

	private Kernel kernel;
	private Integer contador=0;
	private Integer contFruta=0;
	private ArrayList<Kernel> kernelValidos;
	
	public DetectorFruto()
	{
		kernelValidos = new ArrayList<Kernel>();
		contador=0;
		contFruta=0;
	}
	
	
	public Imagen detectObject(int x, int y, Imagen contenedor) {
		
		Imagen primerImg = contenedor;
		
		kernel = new Kernel(x,y);

		if(kernel.getHeight()<primerImg.getAlto() && kernel.getWidth()<primerImg.getAncho()){

		System.out.println("kernelAncho: "+kernel.getWidth()+"kernelAlto"+kernel.getHeight()+" cant px detectador: "+ contador);
		contador=0;
		for(int j=y; j<kernel.getHeight(); j++)
			for(int i=x; i<kernel.getWidth();i++)
				analizarKernel(i,j,primerImg);
		
		}
		return primerImg;
		/*
		iniKernelFruto();
		int cantpxSimilares=0;
		for(int i=0; i<kernel.getDatos().length; i++)
			if(kernel.iesimo(i)==kernelFruto.getKernel().iesimo(i)){
				System.out.println("fruto:"+kernel.iesimo(i)+"gg"+kernelFruto.getKernel().iesimo(i));
				cantpxSimilares += 1;
				
			}
		
		pxSimilares = cantpxSimilares;
		if(cantpxSimilares>0){
			cont +=1;
			return true;
		}
		else
			return false;
				*/
				
	}
	
	private void analizarKernel(int x, int y, Imagen imagenResaltada) {
		
		Integer pixel;
		
		imagenResaltada.getRGB(x, y);

		if(!compararCanales(imagenResaltada))
		{
			pixel =255;
			contador +=1;
			//int nuevoSRGB = (pixel << 16) | (pixel << 8) | pixel;
			formatoSRGB(x,y,pixel,imagenResaltada);

		} else {
			pixel = 0;

			formatoSRGB(x,y,pixel,imagenResaltada);
		}
		
	}
	

	private boolean compararCanales(Imagen imagenResaltada) {
		return imagenResaltada.getColorImagen().getRGB()==-16777216;
	}
	
	private void formatoSRGB(int x, int y, int n,Imagen imagenResaltada)
	{
		imagenResaltada.setRGB(x, y, n);
		kernel.addPx(imagenResaltada.getRGB(x, y));
	
	}
	public int getCont()
	{
		return contador;
	}
	
	public void setCont()
	{
		contador = 0;
	}
	
	

	public Kernel getKernel() {
		return kernel;
	}


	public void setKernel(Kernel kernel) {
		this.kernel = kernel;
	}


	public Integer getContFruta() {
		return contFruta;
	}

	public void setContFruta(Integer contFruta) {
		this.contFruta = contFruta;
	}

	public boolean isFruit() {
		
		
		if(contador>=672 && contador <=676){
			if(validarVecino()){
			contFruta += 1;
			return true;
			}
		}
		return false;
	}
	
	private boolean validarVecino()
	{
		
		System.out.println("ESTADO ARREGLOancho "+kernelValidos.isEmpty()+" TAMAÑO DEL ARREGLO "+kernelValidos.size());

		if(kernelValidos.isEmpty()){
			kernelValidos.add(kernel);
			return true;
		}
		else 
		{
			Kernel kernelAntecesor = kernelValidos.get(kernelValidos.size()-1);
			kernelValidos.add(kernel);
			System.out.println("kernel analizado: "+kernel.getWidth()+" ---- "+kernel.getHeight());
			if(kernelAntecesor.getWidth() == kernel.getWidth()-1 || kernelAntecesor.getHeight() == kernel.getHeight()-1){
				return false;
			}
			else{
				return true;
			}
		}
	}
}
