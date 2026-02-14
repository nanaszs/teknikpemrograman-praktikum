import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanT = new Scanner(System.in);
       
        int T = scanT.nextInt();
        scanT.nextLine();

        for (int i = 0; i < T; i++) {
            String inputT = scanT.nextLine();

            boolean canByte = true;
            try {
                Byte.parseByte(inputT);
            } catch (Exception e) {
                canByte = false;
            }

            boolean canShort = true;
            try {
                Short.parseShort(inputT);
            } catch (Exception e) {
                canShort = false;
            }

            boolean canInt = true;
            try {
                Integer.parseInt(inputT);
            } catch (Exception e) {
                canInt = false;
            }

            boolean canLong = true;
            try {
                Long.parseLong(inputT);
            } catch (Exception e) {
                canLong = false;
            }
            
            if (!canByte && !canShort && !canInt && !canLong) {
                System.out.println(inputT + " can't be fitted anywhere.");
            } else {
                System.out.println(inputT + " can be fitted in:");
                if (canByte) System.out.println("* byte");
                if (canShort) System.out.println("* short");
                if (canInt) System.out.println("* int");
                if (canLong) System.out.println("* long");
            }
        }

        scanT.close();

    }
}