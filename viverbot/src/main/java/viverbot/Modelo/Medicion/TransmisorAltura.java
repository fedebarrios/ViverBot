package viverbot.Modelo.Medicion;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import viverbot.Modelo.Magnitudes.Altura;

public class TransmisorAltura implements Observer{
	
	private MapperAltura mapper;

	public TransmisorAltura(MapperAltura mediador) {
		this.mapper = mediador;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object alturas) {
		this.Transmitir((ArrayList<Altura>) alturas);
	}

	public void Transmitir(ArrayList<Altura> alturas) {
		this.mapper.relacionar(alturas);
	}

	public MapperAltura getAnalizador() {
		return this.mapper;
	}
}
