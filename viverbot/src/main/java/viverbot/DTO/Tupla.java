package viverbot.DTO;

public class Tupla {

	Double x;
	Integer y;
	public Tupla(Double valorX, Integer valorY) {
		
		x = valorX;
		y = valorY;
	}
	public Double getX() {
		return x;
	}
	public Integer getY() {
		return y;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return " [x=" + x + ", y=" + y + "]";
	}
	
	
	

	
}
