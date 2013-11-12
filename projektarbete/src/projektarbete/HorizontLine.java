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
			int yPos = 100;
			boolean isWhite = true;
			while(isWhite){
				if(img.getRGB(255 - i, yPos) == Color.BLACK.getRGB()){
					leftAvg += yPos;
					isWhite = false;
				}
				yPos++;
			}
		}
		
		
		for(int i = 0; i <= 3; i++){
			int yPos = 100;
			boolean isWhite = true;
			while(isWhite){
				if(img.getRGB(255 - i, yPos) == Color.BLACK.getRGB()){
					rightAvg += yPos;
					isWhite = false;
					
				}
				yPos++;
			}
		}
		
		leftAvg /= 4;
		rightAvg /= 4;
		
		leftAvg -= 10;			//Drar av 10 pixlar för större felmariginal
		rightAvg -= 10;
		
		
		Line horizont = new Line(0, leftAvg, img.getWidth(), rightAvg);
		
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
