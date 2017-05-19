package viverbot.Controlador;

public class ControladorPuenteBrazoRobotico {
	//De momento queda hardCodeado con la posicion de inicio cero
	private double _x=0;
	private double _y=0;
	
	public ControladorPuenteBrazoRobotico(){
		_x = obtenerDistanciaEjeX();
		_y = obtenerDistanciaEjeY();
	}
	
	public double obtenerDistanciaEjeX() {
		return _x;
	}

	public double obtenerDistanciaEjeY() {
		return _y;
	}

	public void incrementarEjeX(double x) {
		_x+=x;
	}

	public void decrementarEjeX(double x) {
		_x-=x;
	}

	public void incrementarEjeY(double y) {
		_y+=y;
	}

	public void decrementarEjeY(double y) {
		_y-=y;
	}
}
