package core;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Wiz;
import render.MoriaFrame;
import render.Map;

/**
 *                                   ....
 *                                .'' .'''
 *  .                             .'   :
 *  \\                          .:    :
 *   \\                        _:    :       ..----.._
 *    \\                    .:::.....:::.. .'         ''.
 *     \\                 .'  #-. .-######'     #        '.
 *      \\                 '.##'/ ' ################       :
 *       \\                  #####################         :
 *        \\               ..##.-.#### .''''###'.._        :
 *         \\             :--:########:            '.    .' :
 *          \\..__...--.. :--:#######.'   '.         '.     :
 *          :     :  : : '':'-:'':'::        .         '.  .'
 *          '---'''..: :    ':    '..'''.      '.        :'
 *             \\  :: : :     '      ''''''.     '.      .:
 *              \\ ::  : :     '            '.      '      :
 *               \\::   : :           ....' ..:       '     '.
 *                \\::  : :    .....####\\ .~~.:.             :
 *                 \\':.:.:.:'#########.===. ~ |.'-.   . '''.. :
 *                  \\    .'  ########## \ \ _.' '. '-.       '''.
 *                  :\\  :     ########   \ \      '.  '-.        :
 *                 :  \\'    '   #### :    \ \      :.    '-.      :
 *                :  .'\\   :'  :     :     \ \       :      '-.    :
 *               : .'  .\\  '  :      :     :\ \       :        '.   :
 *               ::   :  \\'  :.      :     : \ \      :          '. :
 *               ::. :    \\  : :      :    ;  \ \     :           '.:
 *                : ':    '\\ :  :     :     :  \:\     :        ..'
 *                   :    ' \\ :        :     ;  \|      :   .'''
 *                   '.   '  \\:                         :.''
 *                    .:..... \\:       :            ..''
 *                   '._____|'.\\......'''''''.:..'''
 *                              \\
 *                            
 * @author martin
 *
 */
public class MoriaMain  {
	
	private static final int PIXEL_SIZE = 30;
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
	static int xMax = screenSize.width;
	static int yMax = screenSize.height;
    
    static MoriaFrame mainFrame;
	
    /**
     * Main Loop
     */
	private static ActionListener mainLoop = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	mainFrame.updateState();
        	mainFrame.repaint();
        }
    };
	
    /**
     * Main Method
     * 
     * @param args
     */
	public static void main(String args[]) {
		
		JFrame frame = new JFrame("Moria 4");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setUndecorated(true);
	    frame.setSize(xMax, yMax);
	    
	    mainFrame = new MoriaFrame(xMax, yMax, PIXEL_SIZE);
	    mainFrame.setDoubleBuffered(true);
	    frame.getContentPane().add(mainFrame);
	    
	    // TODO: Move and refactor
	    Map testMap = Loader.loadMap("src/graphics/outskirtsG.png", "src/graphics/outskirtsM.png");
	    
	    if (testMap != null) {
	    	mainFrame.currentMap = testMap;
	    } else {
	    	System.out.println("Baga. Map loading failed");
	    	// TODO: Implement error screen
	    	return;
	    }
	    
	    mainFrame.wiz = new Wiz(20, 20); // TODO OMFG Move this and refactor!!!!!!!!!!!!!!!!!!!!
	    
        new Timer(30, mainLoop).start();
        
	    frame.setVisible(true);
	}
}
