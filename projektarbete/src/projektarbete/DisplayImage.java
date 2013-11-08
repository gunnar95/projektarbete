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
		setVisible(true);
		
		xBorderSize = (getWidth() - getContentPane().getWidth()) / 2;
		System.out.println(xBorderSize);
		yBorderSize = (getHeight() - getContentPane().getHeight() - xBorderSize);
		System.out.println(yBorderSize);
		
	}
	
	public void paint(Graphics g){
		g.drawImage(img, xBorderSize, yBorderSize, null);
	}
	
}

