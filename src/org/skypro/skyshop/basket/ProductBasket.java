package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int size = 0;

    public ProductBasket() {
        this.products = new Product[5];
    }

    public int findSpace() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void addProduct(String name, int price) {
        int i = findSpace();
        if (i == -1) {
            System.out.println("Невозможно добавить продукт. Корзина уже полная");
            return;
        }
        Product newProduct = new Product(name, price);
        products[size++] = newProduct;
    }


    public float getSumPrice() {
        int totalPrice = 0;
        for (Product product : products) {
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    public void printSumPrice() {
        System.out.println("Итого: " + getSumPrice());

    }

    public void printAllProducts() {
        for (int i = 0; i < products.length; i++) {
            if (size == 0) {
                System.out.println("В корзине пусто");
                break;
            } else if (products[i] == null) {

                break;
            }
            System.out.println(products[i].getName() + ": " + products[i].getPrice());
        }
    }


    public boolean findProduct(String name) {
        for (int i = 0; i < size; i++) {
            if (products[i] == null) {
                continue;
            }
            Product product = products[i];
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
            size = 0;
        }
        System.out.println("Корзина очищена!");
    }
}
