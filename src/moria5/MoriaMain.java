package moria5;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class MoriaMain {
	public static void main(String args[]) {
		
		JFrame frame = new JFrame("My First GUI");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setUndecorated(true);
	    
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    
	    int xMax = screenSize.width;
	    int yMax = screenSize.height;
	    
	    frame.setSize(xMax, yMax);
	    
	    
	    frame.setVisible(true);
	}
}
