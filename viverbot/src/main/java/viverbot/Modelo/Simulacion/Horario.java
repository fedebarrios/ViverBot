package viverbot.Modelo.Simulacion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import viverbot.Model.Hora;

public enum Horario {

	MEDIANOCHE, MADRUGADA, AMANECER, MAÑANA, MEDIODIA, TARDE, ATARDECER, NOCHE;
	private static final Map<Integer, Horario> horarios = inicializar();

	public static Horario getHorario(Hora h){
		return horarios.get(h.getHora());
	}

	private  static Map<Integer, Horario> inicializar() {
		Map<Integer, Horario> horarios = new HashMap<Integer, Horario>();
			horarios.put(0, MEDIANOCHE);
			horarios.put(1, MEDIANOCHE);
			horarios.put(2, MEDIANOCHE);
			horarios.put(3, MADRUGADA);
			horarios.put(4, MADRUGADA);
			horarios.put(5, MADRUGADA);
			horarios.put(6, AMANECER);
			horarios.put(7, AMANECER);
			horarios.put(8, AMANECER);
			horarios.put(9, MAÑANA);
			horarios.put(10, MAÑANA);
			horarios.put(11, MAÑANA);
			horarios.put(12, MEDIODIA);
			horarios.put(13, MEDIODIA);
			horarios.put(14, MEDIODIA);
			horarios.put(15, TARDE);
			horarios.put(16, TARDE);
			horarios.put(17, TARDE);
			horarios.put(18, ATARDECER);
			horarios.put(19, ATARDECER);
			horarios.put(20, ATARDECER);
			horarios.put(21, NOCHE);
			horarios.put(22, NOCHE);
			horarios.put(23, NOCHE);

		
		return horarios;
	}
	
	
	

}
