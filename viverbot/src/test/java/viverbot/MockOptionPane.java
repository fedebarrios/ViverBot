package viverbot;

import java.awt.Component;
import java.awt.HeadlessException;

import javax.swing.Icon;

import viverbot.Vista.Auxiliares.DefaultOptionPane;

public class MockOptionPane extends DefaultOptionPane { 
	private int opcionElegida;

	@Override 
	public void showMessageDialog(Component parentComponent, String message) { 
	}
	
	@Override
	public int showOptionDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon, Object[] options, Object initialValue) throws HeadlessException{
		return opcionElegida ;
	}

	public void setOptionElegida(int i) {
		this.opcionElegida = i;
		
	}
	
}
