public class RestaurantTest {
    public static void main(String[] args) {

        Item pizza = new Item("Pizza", 100.00f, true, "Italian");
        Item burger = new Item("Burger", 50.00f, true, "American");
        Item fries = new Item("Fries", 20.00f, true, "American");

        Item[] items = new Item[3];
        items[0] = pizza;
        items[1] = burger;
        items[2] = fries;
        Restaurnat KFC = new Restaurnat("KFC", 4.5f, items);

        System.out.println("Your Order is taken" + KFC.order(items[1]));
        KFC.order(items[0]);
        System.out.println("Your bill is " + KFC.bill(items));
    }
}