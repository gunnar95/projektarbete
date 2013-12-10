package projektarbete;

import java.awt.Color;
import java.awt.image.BufferedImage;

/*
 * Lagrar data om en bilds horisont och räknar ut horisontens vinkel. Construktorn 
 * tar tre parametrar, horisontens position i y-led i höger och vänsterkant och 
 * bildens bredd.
 */










//
//import java.awt.Color;
//import java.awt.image.BufferedImage;
//
//public class HorizontLine {
//	
//	private BufferedImage img = null;
//	
//	Line line = null;
//
//	private int leftX;
//	private int leftY;
//	private int rigthX;
//	private int rightY;
//	
//	public HorizontLine(BufferedImage image) {
//		this.img = image;
//		
//		line = HorizontLine.calcHorizont(img);
//		this.leftX = line.getLeftX();
//		this.leftY = line.getLeftY();
//		this.rigthX = line.getRightX();
//		this.rightY = line.getRightY();
//	}
//	
//	private static Line calcHorizont(BufferedImage img){
//		
//		int leftAvg = 0;
//		int rightAvg = 0;
//		
//		
//		for(int i = 0; i <= 3; i++){
//			int yPos = 100;
//			boolean isWhite = true;
//			while(isWhite && (yPos < img.getHeight())){
//				
//				//System.out.println(yPos + " " + getRGBAvg(img.getRGB((255 - i), yPos)) + " " + getRGBAvg(img.getRGB((255 - i), yPos + 1)));
//				if(getRGBAvg(img.getRGB((255 - i), yPos)) < 250 && img.getRGB((255 - i), yPos + 1) < 5){
//					leftAvg += yPos;
//
//					isWhite = false;
//				}
//				yPos++;
//			}
//		}
//		
//		
//		for(int i = 0; i <= 3; i++){
//			int yPos = 100;
//			boolean isWhite = true;
//			while(isWhite && (yPos < img.getHeight())){
//				
//				if(getRGBAvg(img.getRGB((255 - i), yPos)) < 5){
//					rightAvg += yPos;
//					isWhite = false;
//					
//				}
//				yPos++;
//			}
//		}
//		
//		leftAvg /= 4;
//		rightAvg /= 4;
//		
//		leftAvg -= 10;			//Drar av 10 pixlar för större felmariginal
//		rightAvg -= 10;
//		
//		
//		Line horizont = new Line(0, leftAvg, img.getWidth(), rightAvg);
//		
//		return horizont;
//	}
//	
//	public static int getRGBAvg(int i){
//		Color c = new Color(i);
//		
//		int r = c.getRed();
//		int g = c.getGreen();
//		int b = c.getBlue();
//		
//		int avgRGB = (r + b + g) / 3;
//		
//		return avgRGB;
//	}
//	
//	public int getLeftX() {
//		return leftX;
//	}
//
//	public int getLeftY() {
//		return leftY;
//	}
//
//	public int getRigthX() {
//		return rigthX;
//	}
//
//	public int getRightY() {
//		return rightY;
//	}
//	
//}



public class HorizontLine{
	
	private BufferedImage img = null;
	int startX;
	int endX;
	int accuracy;
	
	
	public HorizontLine(BufferedImage img, int startX, int endX, int accuracy){
		this.img = img;
		this.startX = startX;
		this.endX = endX;
		this.accuracy = accuracy;
	}
	
	private int getRgbAverege(int x, int y){
		int rgb = img.getRGB(x, y);
		Color c = new Color(rgb);
		int avg = c.getAlpha();
		
		return avg;
	}
	
	public int getHorizontAvg(int startX, int endX, int accuracy){
		if(startX < 0 || endX > img.getWidth()){
			System.out.println("Felaktiga gränser. Kan ej beräkna horisontsnitt i koordinater utanför bilden. \n\n Sätter standardvärdet 0");
			return 0;
		}
		
		int areaWidth = endX - startX;		//Bredd på området som snittet ska beräknas
		int xPos = startX;
		int[] avereges = new int[areaWidth];
		
		for(int i : avereges){
			int over = 0;
			int under = 0;
			int y = accuracy;
			
			
			while(true){
				for(int u = 0; u < accuracy; u++){
					if(getRgbAverege(xPos, (y - u)) > 125){
						over++;
					}
				}
				
				for(int u = 0; u < accuracy; u++){
					if(getRgbAverege(xPos, (y + u)) > 125){
						under++;
					}
				}
				
				xPos++;
				
				if((over > (int)(accuracy * 0.7)) && (under > (accuracy * 0.7))){
					i = y;
					break;
				}
				
			}
			
		}
		
		int avg = 0;
		
		for(int i : avereges){
			avg += i;
		}
		
		avg /= avereges.length;
		
		return avg;
		
	}
	
}
