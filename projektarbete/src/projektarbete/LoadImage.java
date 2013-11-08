package projektarbete;
/*
 * L�ser in en bild och sparar den i minner som en BufferedImage. Bilden n�s med metoden getImage().
 * Construktorn tar en parameten, bildens s�kv�g i form av en string.
 */


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
}

