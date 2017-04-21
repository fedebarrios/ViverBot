package com.losameos.viverbot.archivo;

import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.AireAcondicionado;
import com.losameos.viverbot.archivos.WriterExcel;

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
