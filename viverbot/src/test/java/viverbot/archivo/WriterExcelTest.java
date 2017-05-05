package viverbot.archivo;

import viverbot.Archivos.WriterExcel;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.AireAcondicionado;

public class WriterExcelTest {

	public static void main(String[] args) {
		WriterExcel.crearDocumento();
		AireAcondicionado aire = new AireAcondicionado();
		Temperatura temp = new Temperatura(25.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		aire.establecerPotenciaYEstado(temp, rango);

		WriterExcel.registrarAutomatizacion(aire);
	}

}
