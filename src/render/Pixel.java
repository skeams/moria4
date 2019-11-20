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

	/**
	 * <ul>
	 *   <li>0 = Nothing / Walkable
	 *   <li>1 = Solid / Blocking
	 *   <li>2 = Foreground Pixel
	 *   <li>3 = ?? Dynamic Pixels Blocking ??
	 * </ul>
	 */
	public int getPixelState() {
		return pixelState;
	}

	public void setPixelState(int pixelState) {
		this.pixelState = pixelState;
	}
}
