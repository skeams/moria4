package render;

public class Map {
	private Pixel[][] map;
	private String title;
	private int width;
	private int height;
	
	public Map(int xSize, int ySize, String title) {
		this.title = title;
		this.width = xSize;
		this.height = ySize;
		this.map = new Pixel[ySize][xSize];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Pixel[][] getMap() {
		return map;
	}
	
	public void setPixel(Pixel pixel, int x, int y) {
		this.map[y][x] = pixel;
	}
	
	public Pixel getPixel(int x, int y) {
		return this.map[y][x];
	}

	public void setMap(Pixel[][] map) {
		this.map = map;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Returns true if any corners of the bounds are outside of the map
	 * or if the bounds collide with solid-state pixels in the map.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	public boolean boundsCollide(int x, int y, int width, int height) {
		if (x < 0 || y < 0) {
			return true;
		}
		
		if (x + width >= this.width || y + height >= this.height) {
			return true;
		}
		
		if (map[y][x].getPixelState() != 0) {
			return true;
		}
		
		if (map[y][x + width].getPixelState() != 0) {
			return true;
		}
		
		if (map[y + height][x].getPixelState() != 0) {
			return true;
		}
		
		if (map[y + height][x + width].getPixelState() != 0) {
			return true;
		}
		
		return false;
	}
}
