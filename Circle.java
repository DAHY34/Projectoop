public class Circle extends Shape {
	private double raduis;
	public void setraduis(double r) {
		raduis = r ;
	}
	public Circle() {
		super();
	}
	public Circle(double r) {
		super();
		this.raduis = r;
	}
	public Circle(String c , double r) {
		super(c);
		this.raduis=r;
	}
	public Circle(String c) {
		super(c);
	}
    public double getraduis() {
    	return raduis;
    }
    public double getArea() {
    	return Math.PI * raduis *raduis ;
    }
    public double getperimeter() {
    	return 2 * Math.PI * raduis;
    }
    public String toString() {
    	return "The raduis length of circle = " + raduis + "\nThe Area of circle = "+ this.getArea() + "\nThe Perimeter of circle = "+this.getperimeter() +"\nThe circle color is "+super.getcolor();
    }
}