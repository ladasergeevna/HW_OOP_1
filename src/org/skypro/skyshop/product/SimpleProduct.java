package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int simplePrice;

    public SimpleProduct(String name, int simplePrice) {
        super(name);
        this.simplePrice = simplePrice;
    }

    @Override
    public int getPrice() {
        return simplePrice;

    }
    @Override
    public boolean isSpecial() {
        return false;
    }
    @Override
    public String toString() {
        return  getName() + ": " + getPrice ();
    }
}
