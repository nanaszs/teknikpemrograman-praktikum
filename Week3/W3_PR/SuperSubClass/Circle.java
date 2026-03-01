public class Circle extends Shape {

    private double radius;

    //constructor default
    public Circle() {
        super(); // panggil constructor Shape
        radius = 1.0;
    }

    //constructor radius
    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    //constructor lengkap
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    //getter 
    public double getRadius() {
        return radius;
    }

    //setter
    public void setRadius(double radius) {
        this.radius = radius;
    }

    //hitung luas
    public double getArea() {
        return Math.PI * radius * radius;
    }

    //hitung keliling
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    //override toString
    @Override
    public String toString() {
        return "A Circle with radius=  " + radius + ", which is a subclass of " + super.toString();
    }
}