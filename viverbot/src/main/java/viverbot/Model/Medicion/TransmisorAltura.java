package viverbot.Model.Medicion;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import viverbot.Model.Magnitudes.Altura;

public class TransmisorAltura implements Observer{
	
	private MapperAltura mediador;

	public TransmisorAltura(MapperAltura mediador) {
		this.mediador = mediador;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object alturas) {
		this.Transmitir((ArrayList<Altura>) alturas);
	}

	public void Transmitir(ArrayList<Altura> alturas) {
		this.mediador.relacionar(alturas);
	}

	public MapperAltura getAnalizador() {
		return this.mediador;
	}
}
