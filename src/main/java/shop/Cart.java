package shop;

import java.util.ArrayList;

public class Cart {

    private static final double TAX = 0.2;
    private final String CART_NAME;
    private ArrayList<Item> items = new ArrayList<Item>();
    private double total;

    public Cart(String cartName) {
        CART_NAME = cartName;
    }

    public String getCartName() {
        return CART_NAME;
    }

    public void addItem(Item item) {
        items.add(item);
        total += item.getPrice() + item.getPrice()*TAX;
    }

    public void deleteItem(Item item) {
        items.remove(item);
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public double getTotalPrice() {
        return total;
    }
}
