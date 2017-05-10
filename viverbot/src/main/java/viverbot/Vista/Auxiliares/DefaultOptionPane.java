package viverbot.Vista.Auxiliares;

import java.awt.Component;

import javax.swing.JOptionPane;

public class DefaultOptionPane {
	
	public void showMessageDialog(Component parentComponent, String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}
