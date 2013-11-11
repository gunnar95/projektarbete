/*
 * Lagrar data om en bilds horisont och räknar ut horisontens vinkel. Construktorn 
 * tar tre parametrar, horisontens position i y-led i höger och vänsterkant och 
 * bildens bredd.
 */


package projektarbete;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class HorizontLine {
	
	private BufferedImage img = null;
	
	Line line = null;

	private int leftX;
	private int leftY;
	private int rigthX;
	private int rightY;
	
	public HorizontLine(BufferedImage image) {
		this.img = image;
		
		line = HorizontLine.calcHorizont(img);
		this.leftX = line.getLeftX();
		this.leftY = line.getLeftY();
		this.rigthX = line.getRightX();
		this.rightY = line.getRightY();
	}
	
	private static Line calcHorizont(BufferedImage img){
		
		int leftAvg = 0;
		int rightAvg = 0;
		
		
		for(int i = 0; i <= 3; i++){
			for(int u = 1; u <= img.getHeight(); u++){
				boolean isWhite = true;
				
				while(isWhite){
					if(img.getRGB(i, u) == Color.BLACK.getRGB()){
						leftAvg += u;
						isWhite = false;
					}
				}
			}
		}
		
		for(int i = 0; i <= 3; i++){
			for(int u = 1; u <= img.getHeight(); u++){
				boolean isWhite = true;
				
				while(isWhite){
					if(img.getRGB(255 - i, u) == Color.BLACK.getRGB()){
						rightAvg += u;
						isWhite = false;
					}
				}
			}
		}
		
		leftAvg /= 4;
		rightAvg /= 4;
		
		leftAvg -= 10;			//Drar av 10 pixlar för större felmariginal
		rightAvg -= 10;
		
		Line horizont = new Line(leftAvg, 0, rightAvg, img.getWidth());
		
		return horizont;
	}
	
	public int getLeftX() {
		return leftX;
	}

	public int getLeftY() {
		return leftY;
	}

	public int getRigthX() {
		return rigthX;
	}

	public int getRightY() {
		return rightY;
	}
	
}
