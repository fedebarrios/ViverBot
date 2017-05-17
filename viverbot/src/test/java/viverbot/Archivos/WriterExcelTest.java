package viverbot.Archivos;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

import viverbot.Modelo.Medicion.AireAcondicionado;

public class WriterExcelTest {

	@Test
	public void crearDocumentoTest() throws Exception {
		WriterExcel.borrarDocumento();
		WriterExcel.crearDocumento();
		WriterExcel writer = new WriterExcel();
		String ret = Whitebox.invokeMethod(writer, "getPath");
		File file = Whitebox.invokeMethod(writer, "getFile");
		assertNotNull(file);
		assertNotNull(ret);
		assertTrue(file.exists());
	}

	@Test
	public void registrarAutomatizacionTest() throws Exception {
		AireAcondicionado aire = new AireAcondicionado();
		assertNotNull(aire);
		WriterExcel.registrarAutomatizacion(aire);
		WriterExcel writer = new WriterExcel();
		String ret = Whitebox.invokeMethod(writer, "getPath");
		File file = Whitebox.invokeMethod(writer, "getFile");
		assertNotNull(file);
		assertNotNull(ret);
		assertTrue(file.exists());
	}

}
