package viverbot.Model.Medicion;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import viverbot.Model.Magnitudes.Altura;

public class TransmisorAltura implements Observer{
	
	private AnalizadorAltura analizador;

	public TransmisorAltura() {
		this.analizador = new AnalizadorAltura();

	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object temp) {
		this.Transmitir((ArrayList<Altura>) temp);
	}

	public void Transmitir(ArrayList<Altura> temp) {
		this.analizador.analizar(temp);
	}

	public AnalizadorAltura getAnalizador() {
		return this.analizador;
	}
}
