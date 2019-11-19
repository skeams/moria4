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
}
