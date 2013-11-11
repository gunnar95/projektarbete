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
	 * 
	 * TODO Ej testad! Bör göras.
	 */
	

}

