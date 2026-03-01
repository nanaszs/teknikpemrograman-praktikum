public class Shape {

    private String color;
    private boolean filled;

    //constructor default
    public Shape() {
        color = "green";
        filled = true;
    }

    //constructor dengan parameter
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    //getter color
    public String getColor() {
        return color;
    }

    //setter color
    public void setColor(String color) {
        this.color = color;
    }

    //getter boolean filled namun pakai is
    public boolean isFilled() {
        return filled;
    }

    //setter filled
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    //toString()
    public String toString(){
        return  "A shape with color of " + color + " and " + (filled? "filled" : "not filled");
    }
}