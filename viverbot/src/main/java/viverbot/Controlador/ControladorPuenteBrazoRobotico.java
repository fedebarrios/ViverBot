package viverbot.Controlador;

public class ControladorPuenteBrazoRobotico {
	
	private int x;
	private int y;
	
	public int obtenerDistanciaEjeX() {
		return x;
	}

	public int obtenerDistanciaEjeY() {
		return y;
	}

	public void incrementarEjeX(int x) {
		this.x+=x;
	}

	public void decrementarEjeX(int x) {
		this.x-=x;
	}

	public void incrementarEjeY(int y) {
		this.y+=y;
	}

	public void decrementarEjeY(int y) {
		this.y-=y;
	}
}
