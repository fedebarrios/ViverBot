package viverbot.Vista.Auxiliares;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JOptionPane;


public class DefaultOptionPane {

	public void showMessageDialog(Component parentComponent, String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public int showOptionDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon, Object[] options, Object initialValue) {
		return JOptionPane.showOptionDialog(parentComponent, message,title, optionType, messageType, icon, options,  initialValue);
	}
}
