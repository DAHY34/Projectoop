
public class Cube extends ThreeDShape {
	private double side;
	
	public Cube() {
		super();
	}
	public Cube(double s) {
		super();
		this.side=s;
	}
	public Cube(String c) {
	    super.color=c;
	}
	public Cube(String c,double s) {
	    super.color=c;
		this.side=s;
	}
	public void setside(double s) {
		side=s;
	}
	public double getside() {
		return side;
	}
	public double getVolume() {
		return side*side*side;
	}
	public double getArea() {
		return 6*side*side;
	}
	public double getPerimeter() {
        return 12 * side;
	}
	 public String toString() {
	    	return "The side length of cube = " + side + "\nThe Area of cube = "+ this.getArea() + "\nThe Perimeter of cube = "+this.getPerimeter() +"\nThe Volume of cube = "+this.getVolume() +"\nThe cube color is "+super.getcolor();
	    }
	
}
