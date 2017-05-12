package viverbot.Modelo.Medicion;

import viverbot.Interfaces.IFrioCalor;
import viverbot.Interfaces.IPotencia;
import viverbot.Modelo.Magnitudes.Temperatura;

public class AireAcondicionado {
	private IPotencia potenciaEstado;
	private IFrioCalor frioCalorEstado;

	public AireAcondicionado() {
		this.potenciaEstado = new Potencia_0();
		this.frioCalorEstado = new Frio();
	}

	public IPotencia getPotenciaEstado() {
		return potenciaEstado;
	}

	public IFrioCalor getFrioCalorEstado() {
		return frioCalorEstado;
	}

	public void setPotenciaEstado(IPotencia potenciaEstado) {
		this.potenciaEstado = potenciaEstado;
	}

	public void setFrioCalorEstado(IFrioCalor frioCalorEstado) {
		this.frioCalorEstado = frioCalorEstado;
	}

	public void ejecutar(Temperatura temp) {
		this.frioCalorEstado.anunciarEstado(this);
		this.potenciaEstado.aplicarPotencia(this, temp);
	}

}
