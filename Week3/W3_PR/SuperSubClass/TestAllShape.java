public class TestAllShape {
    public static void main(String[] args) {

        Shape s = new Shape("red", false);
        System.out.println(s);

        Circle c = new Circle(5.0, "blue", true);
        System.out.println(c);
        System.out.println("Area: " + c.getArea());

        Rectangle r = new Rectangle(4.0, 6.0, "yellow", true);
        System.out.println(r);
        System.out.println("Area: " + r.getArea());

        Square sq = new Square(4.0, "green", true);
        System.out.println(sq);
        System.out.println("Area: " + sq.getArea());
    }
}