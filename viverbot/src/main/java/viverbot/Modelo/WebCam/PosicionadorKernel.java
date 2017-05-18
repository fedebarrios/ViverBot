package viverbot.Modelo.WebCam;


public class PosicionadorKernel {
	
	private Kernel kernel;
	private Integer x;
	private Integer y;
	
	public PosicionadorKernel(int vX, int vY, AdapterImage adapter)
	{
		this.x = vX;
		this.y = vY;
		this.kernel = new Kernel(adapter.getWidth(),adapter.getHeight(),adapter.getDatos());
				
	}
	
	public PosicionadorKernel(int vX, int vY, Kernel kernel)
	{
		this.x = vX;
		this.y = vY;
		this.kernel = kernel;
				
	}
	
	public void posicionarKernel(int valorX, int valorY)
	{
		x = valorX;
		y = valorY;
	}
	

	public Kernel getKernel() {
		return kernel;
	}
	
	public Integer getWidthKernel()
	{
		return kernel.getWidth();
	}
	
	public Integer getHeightKernel()
	{
		return kernel.getHeight();
	}

	public Integer getX() {
		return x;
	}


	public Integer getY() {
		return y;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public void setKernel(Kernel kernel) {
		this.kernel = kernel;
	}


	
	

}
