package model;

public class Monster {
	private int hp;
	private double speed;
	private int xPos;
	private int yPos;
	
	public Monster(int hp, double speed, int xPos, int yPos) {
		this.hp = hp;
		this.speed = speed;
		this.xPos = xPos;
		this.yPos = yPos;
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

	public void setSpeed(double speed) {
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
}
