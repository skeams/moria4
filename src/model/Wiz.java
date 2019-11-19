package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import core.Loader;

public class Wiz extends Entity {

	private List<BufferedImage> sprites;
	
	public Wiz(int xPos, int yPos) {
		super(100, 9, xPos, yPos, 1, 0);
		
		sprites = new ArrayList<BufferedImage>();
		sprites.add(Loader.loadImage("src/graphics/wizL.png"));
		sprites.add(Loader.loadImage("src/graphics/wizU.png"));
		sprites.add(Loader.loadImage("src/graphics/wizR.png"));
		sprites.add(Loader.loadImage("src/graphics/wizD.png"));
	}

	@Override
	public boolean collision(int x, int y) {
		// TODO Auto-generated method stub
		// TODO Implement
		// TODO Implement
		// TODO Implement
		// TODO Implement
		return false;
	}
	
	/**
	 * Returns correct sprite based on direction.
	 * 
	 * @return
	 */
	public BufferedImage getSprite() {
		return sprites.get(getSpriteIndex());
	}

	@Override
	public void updateSpriteIndex() {
		if (getxDirection() == -1) {
			setSpriteIndex(0);
		} else if (getxDirection() == 1) {
			setSpriteIndex(2);
		} else if (getyDirection() == -1) {
			setSpriteIndex(1);
		} else {
			setSpriteIndex(3);
		}
		
	}
}
