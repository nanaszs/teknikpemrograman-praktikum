public class TestShape {
    public static void main(String[] args) {

        //tes constructor default
        Shape s1 = new Shape();
        System.out.println(s1);

        //tes constructor dengan parameter
        Shape s2 = new Shape("blue", false);
        System.out.println(s2);

        //tes setter
        s1.setColor("yellow");
        s1.setFilled(false);

        System.out.println("Setelah diubah:");
        System.out.println(s1);

        //tes getter
        System.out.println("Color s2: " + s2.getColor());
        System.out.println("Filled s2: " + s2.isFilled());
    }
}