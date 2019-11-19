package render;

import java.awt.Color;

import javax.swing.JPanel;

import java.awt.Graphics;

public class FrameRenderer extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private int xMax;
	private int yMax;
	private int PIXEL_SIZE;
	
	public FrameRenderer(int xMax, int yMax, int PIXEL_SIZE) {
		this.xMax = xMax;
		this.yMax = yMax;
		this.map = new boolean[yMax][xMax];
		this.PIXEL_SIZE = PIXEL_SIZE;
		
	    for (int x = 0; x < xMax; x++) {
			for (int y = 0; y < yMax; y++) {
				map[y][x] = false;
			}
		}
	}
	
	public boolean[][] map;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int x = 0; x < xMax; x++) {
			for (int y = 0; y < yMax; y++) {
				if (map[y][x]) {
					g.setColor(Color.black);
				} else {
					g.setColor(Color.white);
				}
				g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
			}
		}
		
		g.dispose();
    }
	
}
