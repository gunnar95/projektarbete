package projektarbete;

public class Line {
	
	private int leftX;
	private int leftY;
	private int rightX;
	private int rightY;
	private double angle;
	
	public Line(int leftX, int leftY, int rightX, int rightY){
		this.leftX = leftX;
		this.leftY = leftY;
		this.rightX = rightX;
		this.rightY = rightY;
		this.angle = calcAngle();
	}
	
	private double calcAngle(){
		int deltaY = leftY - rightY;
		
		double angle = Math.tanh(deltaY / rightX - rightY);
		
		return angle;
	}

	public int getLeftX() {
		return leftX;
	}

	public int getLeftY() {
		return leftY;
	}

	public int getRightX() {
		return rightX;
	}

	public int getRightY() {
		return rightY;
	}

	public double getAngle() {
		return angle;
	}
	
	
	
}
