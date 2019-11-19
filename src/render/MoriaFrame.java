package render;

import javax.swing.JPanel;

import model.Wiz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class MoriaFrame extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private int PIXEL_SIZE;
	private int xMax;
	private int yMax;
	
	private int xMapOffset;
	private int yMapOffset;
	
	private final int edgePadding = 20;
	
	public Map currentMap;
	public Wiz wiz;
	
	public MoriaFrame(int xMax, int yMax, int PIXEL_SIZE) {
		this.xMax = xMax;
		this.yMax = yMax;
		this.xMapOffset = 0;
		this.yMapOffset = 0;
		this.PIXEL_SIZE = PIXEL_SIZE;
		
		setFocusable(true);
		requestFocus();
		
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent evt) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyReleased(KeyEvent evt) {
				if (evt.getKeyChar() == 'a' || evt.getKeyChar() == 'd') {
					wiz.setxDirection(0);
				}
				if (evt.getKeyChar() == 'w' || evt.getKeyChar() == 's') {
					wiz.setyDirection(0);
				}
				if (wiz.getxDirection() == 0 && wiz.getyDirection() == 0) {
					wiz.setMoving(false);
				} else {
					wiz.updateSpriteIndex();
				}
			}
			
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyChar() == 'a') {
					wiz.setMoving(true);
					wiz.setxDirection(-1);
				}
				
				if (evt.getKeyChar() == 'd') {
					wiz.setMoving(true);
					wiz.setxDirection(1);
				}
				
				if (evt.getKeyChar() == 'w') {
					wiz.setMoving(true);
					wiz.setyDirection(-1);
				}
				
				if (evt.getKeyChar() == 's') {
					wiz.setMoving(true);
					wiz.setyDirection(1);
				}
				wiz.updateSpriteIndex();
			}
		});
	}
	
	public void updateMapOffset() {
		if (wiz.getxPos() + 4 - xMapOffset > (int) Math.floor(xMax / PIXEL_SIZE) - edgePadding) {
			if (xMapOffset < currentMap.getWidth() - (int) Math.floor(xMax / PIXEL_SIZE)) {
				xMapOffset++;
			}
		}
		
		if (wiz.getyPos() + 8 - yMapOffset > (int) Math.floor(yMax / PIXEL_SIZE) - edgePadding) {
			if (yMapOffset < currentMap.getHeight() - (int) Math.floor(yMax / PIXEL_SIZE)) {
				yMapOffset++;
			}
		}
		
		if (wiz.getxPos() - xMapOffset < edgePadding) {
			if (xMapOffset > 0) {
				xMapOffset--;
			}
		}
		
		if (wiz.getyPos() - yMapOffset < edgePadding) {
			if (yMapOffset > 0) {
				yMapOffset--;
			}
		}
	}
	
	public void updateState() {
		wiz.updatePosition();
		updateMapOffset();
	}
	
	/**
	 * ----   Rendering map to screen   ------
	 * 
	 * _______________________________________
	 * ########***^^^^^^^^^^^^^^^^^***########
	 * #####**                         **#####
	 * ###*      You shall not pass       *###
	 * ##                                   ##
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int y = 0; y < (int) Math.floor(yMax / PIXEL_SIZE); y++) {
			for (int x = 0; x < (int) Math.floor(xMax / PIXEL_SIZE); x++) {
				if (x < currentMap.getWidth() && y < currentMap.getHeight()) {
					g.setColor(currentMap.getPixel(xMapOffset + x, yMapOffset + y).getColor());
				} else {
					g.setColor(Color.black);
				}
				g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
			}
		}
		
		BufferedImage wizSprite = wiz.getSprite();
		for (int y = 0; y < wizSprite.getHeight(); y++) {
			for (int x = 0; x < wizSprite.getWidth(); x++) {
				int rgb = wizSprite.getRGB(x, y);
				
				if (rgb != -16777216) { // Black
					g.setColor(new Color(rgb));
					g.fillRect(
						(x + wiz.getxPos() - xMapOffset) * PIXEL_SIZE,
						(y + wiz.getyPos() - yMapOffset) * PIXEL_SIZE,
						PIXEL_SIZE, PIXEL_SIZE
					);
				}
			}
		}
		
		g.dispose();
    }
	
}
