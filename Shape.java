 public abstract class Shape implements Drawable {
	 
    private final java.util.Date dateCreated;
    String color;
    
    public Shape() {
 	   this.dateCreated = new java.util.Date();
    }
    
    public Shape(String color) {
       this();
 	   this.color = color;
    }
    
    public java.util.Date getDateCreated(){
 	   return dateCreated;
    }
    
    public String getcolor() {
    	return color;
    }
    
    public abstract double getArea();
    
    public abstract double getperimeter();
    
    public String howToDraw() {
    	return "Draw shape";
    }
    
}