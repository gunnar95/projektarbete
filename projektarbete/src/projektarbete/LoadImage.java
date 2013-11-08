/*
 * Läser in en bild och sparar den i minner som en BufferedImage. Bilden nås med metoden getImage().
 * Construktorn tar en parameten, bildens sökväg i form av en string.
 */


package projektarbete;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class LoadImage {
	
	private BufferedImage img;
	
	public LoadImage(String location) throws IOException {
		img = ImageIO.read(new File(location));
	}
	
	public BufferedImage getImage(){
		return img;
	}
	
	/*
	 * calcHorizont() räknar ut data angående bildens horisont (lutning, och en tänkt linjes y-koordinater 
	 * vid höger och vänster kant) och returnerar detta i form av ett HorizontLineobjekt.
	 */
	
	public HorizontLine calcHorizont(){
		
		int leftAvg = 0;
		int rightAvg = 0;
		
		
		int[] columns = new int[8];
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
		
		HorizontLine horizont = new HorizontLine(leftAvg, rightAvg, img.getWidth());
		
		return horizont;
	}
}

