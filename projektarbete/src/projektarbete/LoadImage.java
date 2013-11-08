package projektarbete;

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

