public class Square extends Rectangle {

    //constructor default
    public Square() {
        super(1.0, 1.0);
    }

    //constructor dengan side
    public Square(double side) {
        super(side, side); // panggil Rectangle
    }

    //constructor lengkap
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    //getter 
    public double getSide() {
        return getWidth(); 
    }

    //set  (ubah keduanya)
    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    //override setWidth supaya masih tetap persegi
    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    //override setLength supaya masih tetap persegi
    @Override
    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    //override toString
    @Override
    public String toString() {
        return "A Square with side=" + getWidth() +
               ", which is a subclass of " + super.toString();
    }
}