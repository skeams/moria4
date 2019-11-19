
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import render.FrameRenderer;

public class MoriaMain  {
	
	private static final int PIXEL_SIZE = 8;
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    static int xMax = (int) Math.floor(screenSize.width / PIXEL_SIZE);
    static int yMax = (int) Math.floor(screenSize.height / PIXEL_SIZE);
    
    static FrameRenderer renderer;
	
	private static ActionListener mainLoop = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            renderer.repaint();
        }
    };
	
	public static void main(String args[]) {
		
		JFrame frame = new JFrame("Moria 4");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setUndecorated(true);
	    frame.setSize(xMax * PIXEL_SIZE, yMax * PIXEL_SIZE);
	    
	    renderer = new FrameRenderer(xMax, yMax, PIXEL_SIZE);
	    renderer.setDoubleBuffered(true);
	    frame.getContentPane().add(renderer);
	    
	    int middleX = xMax / 2;
        int middleY = yMax / 2;
	    
        // Acorn
        renderer.map[middleY][middleX-4] = true;
        renderer.map[middleY][middleX-3] = true;
        renderer.map[middleY-2][middleX-3] = true;
        renderer.map[middleY-1][middleX-1] = true;
        renderer.map[middleY][middleX] = true;
        renderer.map[middleY][middleX+1] = true;
        renderer.map[middleY][middleX+2] = true;
        
        new Timer(100, mainLoop).start();
	    
	    frame.setVisible(true);
	}
}
