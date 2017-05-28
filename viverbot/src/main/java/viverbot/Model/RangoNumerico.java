package viverbot.Model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RangoNumerico {
	Double minimo;
	Double maximo;

	public RangoNumerico(Double minimo, Double maximo) {
		this.minimo = minimo;
		this.maximo = maximo;
	}

	public Double getMinimo() {
		return minimo;
	}

	public Double getMaximo() {
		return maximo;
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof RangoNumerico)){
			return false;
		}
		else{
			RangoNumerico r = (RangoNumerico) o;
			return r.getMinimo().equals(this.getMinimo()) && r.getMaximo().equals(this.getMaximo());
		}
		
	}
	
	public static ArrayList<RangoNumerico> parseRangoNumerico(String cadena){
		Pattern p = Pattern.compile("[0-9][0-9],[0-9][0-9]");
		Matcher m = p.matcher(cadena);
		String c = "";
		while (m.find()) {
			c = c + m.group(0) + "\n";
		}
		
		String[] rangos = c.split("\n");
		
		ArrayList<RangoNumerico> ret = new ArrayList<RangoNumerico>();
		for(String r : rangos){
			String[] rango = r.split(",");
			RangoNumerico rn = new RangoNumerico(Double.parseDouble(rango[0]),Double.parseDouble(rango[1]));
			ret.add(rn);
		}
		return ret;
	}

	
	

}
