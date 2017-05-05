package viverbot.Archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import viverbot.Modelo.Medicion.AireAcondicionado;

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
		columna.setCellValue("Hora de inicio");
		columna1.setCellValue("Estado");
		columna2.setCellValue("Potencia");
		columna3.setCellValue("Temperatura");

		try {
			FileOutputStream archivo = new FileOutputStream(file);
			libro.write(archivo);
			archivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void registrarAutomatizacion(AireAcondicionado aire) {
		try {
			FileInputStream archivoEntrada = new FileInputStream(file);
			HSSFWorkbook libro = new HSSFWorkbook(archivoEntrada);
			HSSFSheet hoja = libro.getSheet("Registro");
			HSSFRow fila = hoja.createRow(contador);
			HSSFCell columna = fila.createCell(0);
			HSSFCell columna1 = fila.createCell(1);
			HSSFCell columna2 = fila.createCell(2);
			HSSFCell columna3 = fila.createCell(3);
			columna.setCellValue(Calendar.getInstance().getTime().toString());
			columna1.setCellValue(aire.getEstado().toString());
			columna2.setCellValue(aire.getPotencia().toString());
			columna3.setCellValue("NO AUN");
			contador++;
			FileOutputStream archivoSalida = new FileOutputStream(file);
			libro.write(archivoSalida);
			archivoSalida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
