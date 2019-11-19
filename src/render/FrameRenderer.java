package render;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class FrameRenderer extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private int PIXEL_SIZE;
	private int xMax;
	private int yMax;
	
	private int xMapOffset;
	private int yMapOffset;
	
	public Map currentMap;
	
	public FrameRenderer(int xMax, int yMax, int PIXEL_SIZE) {
		this.xMax = xMax;
		this.yMax = yMax;
		this.xMapOffset = 0;
		this.yMapOffset = 0;
		this.PIXEL_SIZE = PIXEL_SIZE;
	}
	
	/**
	 * Rendering map to screen
	 * 
	 * 
	 * 
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int x = 0; x < (int) Math.floor(xMax / PIXEL_SIZE); x++) {
			for (int y = 0; y < (int) Math.floor(yMax / PIXEL_SIZE); y++) {
				if (x < currentMap.getWidth() && y < currentMap.getHeight()) {
					g.setColor(currentMap.getPixel(xMapOffset + x, yMapOffset + y).getColor());
				} else {
					g.setColor(Color.black);
				}
				g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
			}
		}
		
		g.dispose();
    }
	
}
