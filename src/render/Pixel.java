package render;

import java.awt.Color;

public class Pixel {
	private Color color;
	private boolean isStatic;
	
	public Pixel(Color c, boolean isStatic) {
		this.color = c;
		this.isStatic = isStatic;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}
}
