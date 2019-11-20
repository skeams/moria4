package model;

public abstract class Entity {
	private int hp;
	private int speed; // Max = 10	TODO: Make constants place
	private int speedDelayCount;
	
	private int width;
	private int height;

	private int xPos;
	private int yPos;
	private int xDirection;
	private int yDirection;
	
	private int spriteIndex;
	private boolean moving;
	
	public abstract boolean mapCollision(int x, int y);
	public abstract void updateSpriteIndex();
	
	/**
	 * 
	 * @param hp
	 * @param speed
	 * @param xPos
	 * @param yPos
	 */
	public Entity(int hp, int speed, int width, int height, int xPos, int yPos, int xDirection, int yDirection) {
		this.hp = hp;
		this.speed = speed;
		this.speedDelayCount = speed;
		
		this.width = width;
		this.height = height;
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.xDirection = xDirection;
		this.yDirection = yDirection;
		
		this.moving = false;
		this.spriteIndex = 0;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getxDirection() {
		return xDirection;
	}

	public void setxDirection(int xDirection) {
		this.xDirection = xDirection;
	}

	public int getyDirection() {
		return yDirection;
	}

	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	public int getSpriteIndex() {
		return spriteIndex;
	}

	public void setSpriteIndex(int spriteIndex) {
		this.spriteIndex = spriteIndex;
	}

	/**
	 * 
	 * 
	 * 
	 */
	public void updatePosition() {
		speedDelayCount++;
		
		if (moving && speedDelayCount > 10) {
			speedDelayCount = speed;
			xPos += xDirection;
			yPos += yDirection;
		}
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	public int getSpeedDelayCount() {
		return speedDelayCount;
	}
	public void setSpeedDelayCount(int speedDelayCount) {
		this.speedDelayCount = speedDelayCount;
	}
}
