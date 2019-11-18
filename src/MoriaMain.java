
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MoriaMain extends JPanel {
	
	
	/**
	 * 
	 *  Caravan Palace
	 * 
	 *     <|°_°|>
	 *  
	 */
	private static final long serialVersionUID = 1L;
	private static final int RECT_SIZE = 5;
	private static boolean map[][];
	private static boolean nextGen[][];
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    static int xMax = (int) Math.floor(screenSize.width / RECT_SIZE);
    static int yMax = (int) Math.floor(screenSize.height / RECT_SIZE);
	
	public MoriaMain() {
		new Timer(100, new TimerListener()).start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int x = 0; x < xMax; x++) {
			for (int y = 0; y < yMax; y++) {
				if (map[y][x]) {
					g.setColor(Color.black);
				} else {
					g.setColor(Color.white);
				}
				g.fillRect(x * RECT_SIZE, y * RECT_SIZE, RECT_SIZE, RECT_SIZE);
			}
		}
		
		g.dispose();
    }
	
	private void updateMap() {
		for (int y = 0; y < yMax; y++)
        {
            for (int x = 0; x < xMax; x++)
            {
                nextGen[y][x] = false;
            }
        }

        for (int y = 0; y < yMax; y++)
        {
            for (int x = 0; x < xMax; x++)
            {
                int neighbours = 0;
                neighbours += checkCell(y - 1, x - 1) ? 1 : 0;
                neighbours += checkCell(y - 1, x) ? 1 : 0;
                neighbours += checkCell(y - 1, x + 1) ? 1 : 0;
                neighbours += checkCell(y, x - 1) ? 1 : 0;
                neighbours += checkCell(y, x + 1) ? 1 : 0;
                neighbours += checkCell(y + 1, x - 1) ? 1 : 0;
                neighbours += checkCell(y + 1, x) ? 1 : 0;
                neighbours += checkCell(y + 1, x + 1) ? 1 : 0;

                if (map[y][x])
                {
                    if (neighbours < 2 || neighbours > 3)
                    {
                        nextGen[y][x] = false;
                    }
                    else
                    {
                        nextGen[y][x] = true;
                    }
                }
                else
                {
                    if (neighbours == 3)
                    {
                        nextGen[y][x] = true;
                    }
                }
            }
        }

        for (int y = 0; y < yMax; y++)
        {
            for (int x = 0; x < xMax; x++)
            {
                map[y][x] = nextGen[y][x];
            }
        }
	}
	
	static boolean checkCell(int y, int x)
    {
        int xx = x;
        int yy = y;
        if (x < 0)
        {
            return false; // xx = xMax - 1;
        }
        if (x >= xMax)
        {
        	return false; // xx = 0;
        }
        if (y < 0)
        {
        	return false; // yy = yMax - 1;
        }
        if (y >= yMax)
        {
        	return false; // yy = 0;
        }
        return map[yy][xx];
    }
	
	class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	updateMap();
            repaint();
        }
    }
	
	public static void main(String args[]) {
		
		JFrame frame = new JFrame("Moria 4  x: " + xMax + " y: " + yMax);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setUndecorated(true);
	    
	    map = new boolean[yMax][xMax];
	    nextGen = new boolean[yMax][xMax];
	    
	    for (int x = 0; x < xMax; x++) {
			for (int y = 0; y < yMax; y++) {
				map[y][x] = false;
			}
		}
	    
	    int middleX = xMax / 2;
        int middleY = yMax / 2;
	    
        // R-pentomino
	    /*
	    map[middleY - 1][middleX - 1] = true;
        map[middleY - 1][middleX] = true;
        map[middleY][middleX] = true;
        map[middleY][middleX + 1] = true;
        map[middleY + 1][middleX] = true;
        */
        
        // Acorn
        map[middleY][middleX-4] = true;
        map[middleY][middleX-3] = true;
        map[middleY-2][middleX-3] = true;
        map[middleY-1][middleX-1] = true;
        map[middleY][middleX] = true;
        map[middleY][middleX+1] = true;
        map[middleY][middleX+2] = true;
	    
	    frame.setSize(xMax * RECT_SIZE, yMax * RECT_SIZE);
	    
	    MoriaMain mainPanel = new MoriaMain();
	    frame.getContentPane().add(mainPanel);
	    mainPanel.setDoubleBuffered(true);
	    
	    frame.setVisible(true);
	}
}
