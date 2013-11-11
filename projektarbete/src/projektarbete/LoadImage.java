/*
 * L�ser in en bild och sparar den i minner som en BufferedImage. Bilden n�s med metoden getImage().
 * Construktorn tar en parameten, bildens s�kv�g i form av en string.
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
	 * calcHorizont() r�knar ut data ang�ende bildens horisont (lutning, och en t�nkt linjes y-koordinater 
	 * vid h�ger och v�nster kant) och returnerar detta i form av ett HorizontLineobjekt.
	 * 
	 * TODO Ej testad! B�r g�ras.
	 */
	

}

