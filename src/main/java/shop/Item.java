package shop;

import parser.GsonUtils;
import parser.RuntimeTypeAdapterFactory;

import java.util.HashSet;

public class Item {

    private String name;
    private double price;

    private static final RuntimeTypeAdapterFactory<Item> adapter =
            RuntimeTypeAdapterFactory.of(Item.class);

    private static final HashSet<Class<?>> registeredClasses= new HashSet<Class<?>>();

    static {
        GsonUtils.registerType(adapter);
    }

    private synchronized void registerClass() {
        if (!registeredClasses.contains(this.getClass())) {
            registeredClasses.add(this.getClass());
            adapter.registerSubtype(this.getClass());
        }
    }

    public Item() {
        registerClass();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("Class: %s; Name: %s; Price: %s; ", getClass(), name, price);
    }
}
