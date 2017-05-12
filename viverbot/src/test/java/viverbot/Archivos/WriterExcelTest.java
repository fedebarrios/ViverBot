package viverbot.Archivos;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

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

}
