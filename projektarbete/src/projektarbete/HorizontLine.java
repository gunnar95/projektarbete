/*
 * Lagrar data om en bilds horisont och räknar ut horisontens vinkel. Construktorn 
 * tar tre parametrar, horisontens position i y-led i höger och vänsterkant och 
 * bildens bredd.
 */


package projektarbete;

public class HorizontLine {
	
	private int leftY;
	private int rightY;
	private int width;
	private double angle;
	
	public HorizontLine(int leftY, int rightY, int width) {
		this.leftY = leftY;
		this.rightY = rightY;
		angle = calcAngle();
	}
	
	private double calcAngle(){
		int deltaY = leftY - rightY;
		
		double angle = Math.tanh(deltaY / width);
		
		return angle;
	}

	public int getLeftY() {
		return leftY;
	}

	public int getRightY() {
		return rightY;
	}

	public int getWidth() {
		return width;
	}

	public double getAngle() {
		return angle;
	}
}
