package viverbot.Controlador.Verificacion;

import java.util.ArrayList;

import viverbot.DAO.PlantaDAO;
import viverbot.DTO.PlantaDTO;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.Hora;
import viverbot.Model.Plantas;
import viverbot.Model.SoporteMovible;
import viverbot.Model.Tupla;
import viverbot.Modelo.Magnitudes.Humedad;
import viverbot.Modelo.Magnitudes.Magnitudes;

public class TransmisorHumedad extends Transmisor {
	private ArrayList<PlantaDTO> plantas;
	private ArrayList<Tupla<PlantaDTO, Humedad>> mediciones;
	private static Magnitudes m = Magnitudes.HUMEDAD;
	private SoporteMovible soporte;
	private static Hora horaInicioDefoult = new Hora(6, 0, 0);
	private Hora horaInicio;
	private static Plantas p = new Plantas();
	private boolean seRealizoTransmision;

	public TransmisorHumedad(SoporteMovible soporte) {
		super(soporte.getColector());
		this.soporte = soporte;
		this.plantas = this.obtenerPlantas();
		this.seRealizoTransmision = false;
		this.horaInicio = horaInicioDefoult;
		this.mediciones = new ArrayList<Tupla<PlantaDTO, Humedad>>();

	}

	@Override
	protected void Trasnmitir() {
		while (!this.seRealizoTransmision) {
			if (this.verificarTiempo()) {
				for (int i = 0; i < this.plantas.size(); i++) {
					moverSoporteMovil(this.plantas.get(i).getUbicacion());
					if (this.soporte.getUbicacion().equals(this.plantas.get(i).getUbicacion())) {
						if (this.realizarMedicion()) {
							Tupla<PlantaDTO, Humedad> t = new Tupla<PlantaDTO, Humedad>(this.plantas.get(i),
									(Humedad) this.mediador.tomarMedicion());
							almacenarMedicion(t);
							System.out.println("La humedad de la planta en la ubicacion "
									+ this.plantas.get(i).getUbicacion().toString() + "es: "
									+ this.mediador.tomarMedicion().getValor());
						}
						else{
							// logica para tomar accion cuando falla la medicion
						}
					}
					else{
						//logica para tomar accion cuando el brazo  no se mueve
					}
				}

				System.out.println("cantidad mediciones: " + this.mediciones.size());
				this.seRealizoTransmision = true;
			} else {
				System.out.println("no es hora de la trasmicion");
			}
		}
	}

	public void moverSoporteMovil(UbicacionDTO u) {
		this.soporte.mover(u);
	}

	protected void almacenarMedicion(Tupla<PlantaDTO, Humedad> t) {

		this.mediciones.add(t);
	}

	@Override
	public boolean verificarTiempo() {
		return Hora.obtenerHoraActual().compareTo(horaInicio) >= 0;
	}

	public static Magnitudes getTipoMagnitud() {
		return m;
	}

	private ArrayList<PlantaDTO> obtenerPlantas() {
		return p.obtenerPlantas();

	}

	public void setHora(Hora h) {
		this.horaInicio = h;
	}

	public boolean isSeRealizoTransmision() {
		return seRealizoTransmision;
	}

	public ArrayList<Tupla<PlantaDTO, Humedad>> getMediciones() {
		return this.mediciones;
	}

	public SoporteMovible getSoporte() {
		return this.soporte;
	}

	public ArrayList<PlantaDTO> getPlantas() {
		return plantas;
	}

	

	public static Hora getHoraInicioDefoult() {
		return horaInicioDefoult;
	}

	public Hora getHoraInicio() {
		return horaInicio;
	}

	public static Plantas getP() {
		return p;
	}

}
