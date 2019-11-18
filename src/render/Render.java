//package render;
//
//import java.awt.Color;
//import java.awt.image.BufferedImage;
//import java.util.Random;
//import java.awt.Graphics;
//
//public class Render {
//	
//	private static final Random random = new Random();
//	
//	private static int randomColor() {
//        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)).getRGB();
//    }
//	
//	public static void render(Graphics g, int xMax, int yMax) {
//		BufferedImage screen = new BufferedImage(xMax, yMax, BufferedImage.TYPE_INT_RGB);
//		
//		for (int x = 0; x < xMax; x++) {
//			for (int y = 0; y < yMax; y++) {
//				screen.setRGB(x, y, randomColor());
//			}
//		}
//		
//		Graphics s = screen.getGraphics();
//		s.drawImage(screen, 0, 0, this);
//	}
//}
