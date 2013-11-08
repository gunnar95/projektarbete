package projektarbete;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;


public class DisplayImage extends JFrame {
	
	BufferedImage img;
	int xBorderSize;
	int yBorderSize;
	
	public DisplayImage(String location) throws IOException {
		super();
		
		img = new LoadImage(location).getImage();
		
		setSize(img.getWidth() + xBorderSize * 2, img.getHeight() + yBorderSize + xBorderSize);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		xBorderSize = (getWidth() - getContentPane().getWidth()) / 2;
		yBorderSize = (getHeight() - getContentPane().getHeight() - xBorderSize);
		
	}
	
	public void paint(Graphics g){
		g.drawImage(img, xBorderSize, yBorderSize, null);
	}
	
}

