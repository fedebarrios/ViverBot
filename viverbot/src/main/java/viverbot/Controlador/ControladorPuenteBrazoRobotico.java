package viverbot.Controlador;

public class ControladorPuenteBrazoRobotico {
	
	private double x=0;
	private double y=0;
	
	public ControladorPuenteBrazoRobotico(){
		x = obtenerDistanciaEjeX();
		y = obtenerDistanciaEjeY();
	}
	
	public double obtenerDistanciaEjeX() {
		return x;
	}

	public double obtenerDistanciaEjeY() {
		return y;
	}

	public void incrementarEjeX(double x) {
		this.x+=x;
	}

	public void decrementarEjeX(double x) {
		this.x-=x;
	}

	public void incrementarEjeY(double y) {
		this.y+=y;
	}

	public void decrementarEjeY(double y) {
		this.y-=y;
	}
}
