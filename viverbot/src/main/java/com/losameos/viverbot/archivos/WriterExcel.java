package com.losameos.viverbot.archivos;

import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.losameos.viverbot.Model.Fecha;
import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.AireAcondicionadoState;

public class WriterExcel {
	private final static File file = new File("RegistroAireAcondicionado.xls");
	private static int contador = 1;

	public static void crearDocumento() {
		HSSFWorkbook libro = new HSSFWorkbook();
		HSSFSheet hoja = libro.createSheet("Registro");
		HSSFRow fila = hoja.createRow(0);
		HSSFCell columna = fila.createCell(0);
		HSSFCell columna1 = fila.createCell(1);
		HSSFCell columna2 = fila.createCell(2);
		HSSFCell columna3 = fila.createCell(3);
		HSSFCell columna4 = fila.createCell(4);
		columna.setCellValue("Hora de inicio");
		columna1.setCellValue("Estado");
		columna2.setCellValue("Potencia");
		columna3.setCellValue("Temperatura");
		columna4.setCellValue("Hora de apagado");

		try {
			FileOutputStream archivo = new FileOutputStream(file);
			libro.write(archivo);
			archivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void registrarAutomatizacion(AireAcondicionadoState aire){
		try {
			FileInputStream archivoEntrada = new FileInputStream(file);
			HSSFWorkbook libro = new HSSFWorkbook(archivoEntrada);
			HSSFSheet hoja = libro.getSheet("Registro");
			HSSFRow fila = hoja.createRow(contador);
			HSSFCell columna = fila.createCell(0);
			HSSFCell columna1 = fila.createCell(1);
			HSSFCell columna2 = fila.createCell(2);
			HSSFCell columna3 = fila.createCell(3);
			HSSFCell columna4 = fila.createCell(4);
			columna.setCellValue(aire.getFechaDeInicio().toString() + "/" + aire.getHoraDeInicio().toString());
			columna1.setCellValue(aire.getEstado().toString());
			columna2.setCellValue(aire.getPotencia().toString());
			columna3.setCellValue("NO AUN");
			columna4.setCellValue(aire.getFechaDeFin().toString() + "/" + aire.getHoraDeFin().toString());
			contador++;
			FileOutputStream archivoSalida = new FileOutputStream(file);
			libro.write(archivoSalida);
			archivoSalida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		crearDocumento();
		AireAcondicionadoState aire = new AireAcondicionadoState();
		aire.calorState();
		Temperatura temp = new Temperatura(25.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		aire.estableceCalculadorDePotencia(temp, rango);
		aire.setFechaDeInicio(Fecha.obtenerFechaActual());
		aire.setHoraDeInicio(Hora.obtenerHoraActual());
		aire.setFechaDeFin(Fecha.obtenerFechaActual());
		aire.setHoraDeFin(Hora.obtenerHoraActual());
		
		registrarAutomatizacion(aire);
	}

}
