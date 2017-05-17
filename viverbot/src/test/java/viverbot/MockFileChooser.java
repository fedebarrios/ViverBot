package viverbot;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.File;

import viverbot.Vista.Auxiliares.FileChooser;

public class MockFileChooser extends FileChooser{
	private static final long serialVersionUID = 1L;
	private File file;
	
	public MockFileChooser(){
		file = new File("recursos/arbol.jpg");
	}
	
	public MockFileChooser(String s){
		file = new File(s);
	}
	@Override
	public File getSelectedFile(){
		return file;
	}
	
	@Override
	public int showOpenDialog(Component parent)
            throws HeadlessException{
				return 0;
	}
	
	public void setFile(File file){
		this.file = file;
	}
}
