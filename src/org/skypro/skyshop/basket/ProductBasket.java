package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchable.Searchable;

import java.util.*;

public class ProductBasket {
    private final LinkedList<Product> products;
    private int size = 0;

    public ProductBasket() {
        this.products = new LinkedList<>();
    }

    public int getCountProducts() {
        size = products.size();
        return size;
    }

    public void addProduct(Product newProduct) {
        if (newProduct == null) {
            return;
        }
        products.add(newProduct);
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
        if (getCountProducts() == 0 || products == null) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product product : products) {
            System.out.println(product);
        }
    }
    public boolean findProduct(String name) {
        if (products == null) {
            return false;
        }
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public void cleanBasket() {
        products.clear();
        size = 0;
        System.out.println("Корзина очищена!");
    }

    public int getAmountOfSpecialProducts() {
        int amount = 0;
        for (Product product : products) {
            if (product != null && product.isSpecial()) {
                amount++;
            }
        }
        return amount;
    }

    public List<Product>  removeProduct(String name) {
        Iterator<Product> productIterator = products.iterator();
        List<Product> removedList = new LinkedList<>();
        while (productIterator.hasNext()) {
            Product nextProduct = productIterator.next();
            if (nextProduct.getName().equals(name)) {
                removedList.add(nextProduct);
                productIterator.remove();
            }
        }
        if (removedList.isEmpty() )  {
            throw new IllegalArgumentException("Список пуст");
        }
        return removedList;
    }

}