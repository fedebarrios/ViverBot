package viverbot.Model;

import java.util.Calendar;

public class Hora implements Comparable {
	private int hora, minuto, segundo;

	public Hora(int hora, int minuto, int segundo) {
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
	}

	public static Hora obtenerHoraActual() {
		Calendar calendar = Calendar.getInstance();
		int horaActual = calendar.get(Calendar.HOUR_OF_DAY);
		int minutoActual = calendar.get(Calendar.MINUTE);
		int segundoActual = calendar.get(Calendar.SECOND);
		return new Hora(horaActual, minutoActual, segundoActual);

	}

	public static long instanteActual() {
		return System.currentTimeMillis();
	}

	public static long tiempoTranscurrido(long inicio) {
		return Hora.instanteActual() - inicio;
	}

	
	//seguramente se vaya ya que solo lo  usa una clase que ya no va a existir
	@Override
	public int compareTo(Object h) {
		try {
			Hora aux = (Hora) h;
			if (this.getHora() == aux.getHora()) {
				if (this.getMinuto() == aux.getMinuto()) {
					if (this.getSegundo() == aux.getSegundo()) {
						return 0;
					} else if (this.getSegundo() > aux.getSegundo()) {
						return 1;
					} else {
						return -1;
					}

				} else if (this.getMinuto() > aux.getMinuto()) {
					return 1;
				} else {
					return -1;
				}

			} else if (this.getHora() > aux.getHora()) {
				return 1;
			} else {
				return -1;
			}
		} catch (Exception e) {

		}
		return 0;
	}

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}

	@Override
	public boolean equals(Object obj) {
		Hora h;
		if (obj instanceof Hora) {
			h = (Hora) obj;
			if (this.getHora() == h.getHora() && this.getMinuto() == h.getMinuto()
					&& this.getSegundo() == h.getSegundo()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public void incrementarSegundos(int i) {
		int seg = this.getSegundo() + i;
		if (seg >= 60) {
			this.incrementraMinuto(1);
			this.setSegundo(seg - 60);
		}
		else{
			this.setSegundo(seg);
		}

	}

	public void incrementraMinuto(int i) {
		int min = this.getMinuto() + i;
		if (min >= 60) {
			this.incrementarHora(1);
			this.setMinuto(min - 60);
		}
		else{
			this.setMinuto(min);
		}

	}

	public void incrementarHora(int i) {
		int hor = this.getHora() + i;
		if (hor >= 24) {
			this.setHora(hor - 24);
		}
		else{
			this.setHora(hor);
		}
	}
}
