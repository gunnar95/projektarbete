/*
 * Mainklass, för att testa delar av och köra programmet.
 */


package projektarbete;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {		
		DisplayImage img = new DisplayImage(System.getenv("USERPROFILE") + "\\Google Drive\\Projektarbete Grafisk bildanalys av havsvågor\\ogm_201309151650 B&WkonverteradJPEG.jpg");	
	}
}
