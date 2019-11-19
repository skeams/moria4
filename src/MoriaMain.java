
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import render.FrameRenderer;
import render.Map;

public class MoriaMain  {
	
	private static final int PIXEL_SIZE = 20;
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
	static int xMax = screenSize.width;
	static int yMax = screenSize.height;
    
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
	    frame.setSize(xMax, yMax);
	    
	    renderer = new FrameRenderer(xMax, yMax, PIXEL_SIZE);
	    renderer.setDoubleBuffered(true);
	    frame.getContentPane().add(renderer);
	    
	    // TODO: Move and refactor
	    Map testMap = MapLoader.loadMap("src/graphics/testG.png", "src/graphics/testM.png");
	    
	    if (testMap != null) {
	    	renderer.currentMap = testMap;
	    } else {
	    	System.out.println("Baga. Map loading failed");
	    	// TODO: Implement error screen
	    	return;
	    }
	    
        new Timer(100, mainLoop).start();
        
	    frame.setVisible(true);
	}
}
