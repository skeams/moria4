package render;

import java.awt.Color;

public class Pixel {
	private Color color;
	private int pixelState;
	
	public Pixel(Color c, int pixelState) {
		this.color = c;
		this.pixelState = pixelState;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getPixelState() {
		return pixelState;
	}

	public void setPixelState(int pixelState) {
		this.pixelState = pixelState;
	}
}
