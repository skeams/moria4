package render;

public class Map {
	private Pixel[][] map;
	private String title;
	
	public Map(int xSize, int ySize, String title) {
		this.title = title;
		this.map = new Pixel[ySize][xSize];
	}

	public Pixel[][] getMap() {
		return map;
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
