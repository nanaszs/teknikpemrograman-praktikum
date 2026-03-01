public class Rectangle extends Shape {

    private double width;
    private double length;

    //constructor default
    public Rectangle() {
        super();
        width = 1.0;
        length = 1.0;
    }

    //constructor width & length
    public Rectangle(double width, double length) {
        super();
        this.width = width;
        this.length = length;
    }

    //constructor lengkap
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    //getter 
    public double getWidth() {
        return width;
    }

    //setter
    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    // luas
    public double getArea() {
        return width * length;
    }

    //keliling
    public double getPerimeter() {
        return 2 * (width + length);
    }

    //override toString
    @Override
    public String toString() {
        return "A Rectangle with width = " + width + " and length = " + length + ", which is a subclass of " + super.toString();
    }
}