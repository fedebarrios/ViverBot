package viverbot.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import viverbot.Modelo.Magnitudes.EmptyMedicion;
import viverbot.Modelo.Magnitudes.Medicion;

public class HistorialAltura {
	
	protected Map<Integer, Medicion> historial;
	private int ultimoDia;
	public HistorialAltura(){
		this.historial = new HashMap<Integer, Medicion>();
	}
	
	public int tamaño () {
		return this.historial.size();
	}
	
	public Collection<Medicion> getMediciones(){
		return historial.values();
	}
	
	public Set<Entry<Integer,Medicion>> getEntrySet(){
		return historial.entrySet();
	}

	
	public void agregarRegistro(int dia, Medicion medicion){
		if(!historial.containsKey(dia)){
			historial.put(dia,medicion);	
		}
	}
	
	public void borrarTupla(int dia){
		if(historial.containsKey(dia)){
			historial.remove(dia);	
		}
	}
	
	public Medicion buscarMedicion(int dia){
		if(historial.containsKey(dia)){
			return historial.get(dia);	
		}
		return new EmptyMedicion();
	}
	
	public int diaUltimaMedicion(){
		if(historial.size()==0){
			return 0;
		} else{
			this.ultimoDia = 0;
			historial.forEach((k,v) -> {if(k>ultimoDia) this.ultimoDia = k;});
			return this.ultimoDia;
		}
	}

	public boolean verificarExistente(int i) {
		return historial.containsKey(i);
	}

}
