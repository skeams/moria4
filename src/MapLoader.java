import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import render.Map;
import render.Pixel;

public class MapLoader {
	
	/**
	 * Returns false if size of A and B differ.
	 * 
	 * @param imageA
	 * @param imageB
	 * @return
	 */
	private static boolean sizeMatch(BufferedImage imageA, BufferedImage imageB) {
		return imageB.getWidth() == imageB.getWidth()
			&& imageB.getHeight() == imageB.getHeight();
	}
	
	/**
	 * Returns pixel state based on RGB value.
	 * 
	 * @param color
	 * @return
	 */
	private static int getPixelState(int rgb) {
		switch (rgb) {
			case 0:
				return 1;
			default:
				return 0;
		}
	}
	
	/**
	 * Returns Map object or null if the map-loading failed.
	 * 
	 * @param graphicsFilePath
	 * @param maskFilePath
	 * @return
	 */
	public static Map loadMap(String graphicsFilePath, String maskFilePath) {
		BufferedImage graphicsImage = null;
		BufferedImage maskImage = null;
		
		try {
			graphicsImage = ImageIO.read(new File(graphicsFilePath));
			maskImage = ImageIO.read(new File(maskFilePath));
			
			if (!sizeMatch(graphicsImage, maskImage)) {
				return null;
			}
			
			Map map = new Map(maskImage.getWidth(), maskImage.getHeight(), "<Unset Title>");
			
			for (int y = 0; y < maskImage.getHeight(); y++) {
				for (int x = 0; x < maskImage.getWidth(); x++) {
					Color color = new Color(graphicsImage.getRGB(x, y));
					int pixelState = getPixelState(maskImage.getRGB(x, y));
					map.setPixel(new Pixel(color, pixelState), x, y);
				}
			}
			
			return map;
		} catch (IOException e) {
			// Failed.
		}
		
		return null;
	}
}



