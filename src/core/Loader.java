package core;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import render.Map;
import render.Pixel;

public class Loader {
	
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
	 * Returns image or null if loading failed.
	 * 
	 * @param imagePath
	 * @return
	 */
	public static BufferedImage loadImage(String imagePath) {
		try {
			return ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			return null;
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
		BufferedImage graphicsImage = loadImage(graphicsFilePath);
		BufferedImage maskImage = loadImage(maskFilePath);
		
		if (graphicsImage != null && maskImage != null) {
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
		}
		
		return null;
	}
}



