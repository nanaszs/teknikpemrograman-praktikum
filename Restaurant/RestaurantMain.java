public class RestaurantMain {

    public static void main(String[] args) {

        Restaurant menu = new Restaurant();

        menu.tambahMenu("Pizza", 250000, 20);
        menu.tambahMenu("Spaghetti", 80000, 20);
        menu.tambahMenu("Tenderloin Steak", 60000, 30);
        menu.tambahMenu("Chicken Steak", 45000, 30);

        System.out.println("=== MENU AWAL ===");
        menu.tampilMenu();

        System.out.println("\n=== PESAN 5 PIZZA ===");
        menu.pesanMenu(0, 5);

        System.out.println("\n=== MENU SETELAH PESAN ===");
        menu.tampilMenu();
    }
}