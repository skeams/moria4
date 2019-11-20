package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import core.Loader;

public class Wiz extends Entity {

	private List<BufferedImage> sprites;
	
	public Wiz(int xPos, int yPos) {
		super(100, 10, 4, 8, xPos, yPos, 0, 0);
		
		sprites = new ArrayList<BufferedImage>();
		sprites.add(Loader.loadImage("src/graphics/wizL.png"));
		sprites.add(Loader.loadImage("src/graphics/wizU.png"));
		sprites.add(Loader.loadImage("src/graphics/wizR.png"));
		sprites.add(Loader.loadImage("src/graphics/wizD.png"));
		
		setSpriteIndex(2);
	}

	@Override
	public boolean mapCollision(int x, int y) {
		return x >= getxPos() + 1 && x < getxPos() + 3 && y >= getyPos() + 6 && y < getyPos() + 8;
	}
	
	/**
	 * Returns correct sprite based on direction.
	 * 
	 * @return
	 */
	public BufferedImage getSprite() {
		return sprites.get(getSpriteIndex());
	}

	/**
	 * Updates sprite index based on x/y direction speed.
	 * 
	 * Needed to keep separate holder for sprite, as movement is
	 * more dynamic and changes more often than the sprite itself.
	 */
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
