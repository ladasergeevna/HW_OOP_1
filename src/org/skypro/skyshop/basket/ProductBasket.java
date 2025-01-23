package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchable.Searchable;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productBasketMap;

    public ProductBasket() {
        productBasketMap = new TreeMap<>();
    }

    public void addProduct(Product newProduct) {
        if (newProduct == null) {
            return;
        }
        List<Product> products;
        productBasketMap.computeIfAbsent(newProduct.getName(), key -> new LinkedList<>()).add(newProduct);
    }

    public int getCountProducts() {
        return productBasketMap.size();
    }

    public float getSumPrice() {
        int totalPrice = 0;
        for (List<Product> products : productBasketMap.values()) {
            for (Product product : products) {
                if (product != null) {
                    totalPrice += product.getPrice();
                }
            }
        }
        return totalPrice;
    }

    public void printSumPrice() {
        System.out.println("Итого: " + getSumPrice());

    }

    public void printAllProducts() {
        if (getCountProducts() == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (List<Product> products : productBasketMap.values()) {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public boolean findProduct(String name) {
        for (List<Product> products : productBasketMap.values()) {
            for (Product product : products) {
                if (product.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void cleanBasket() {
        productBasketMap.clear();
        System.out.println("Корзина очищена!");
    }

    public int getAmountOfSpecialProducts() {
        int amount = 0;
        for (List<Product> products : productBasketMap.values()) {
            for (Product product : products) {
                if (product != null && product.isSpecial()) {
                    amount++;
                }
            }
        }
        return amount;
    }

    public List<Product> removeProduct(String name) {
        if (productBasketMap.containsKey(name)) {
            return productBasketMap.remove(name);
        } else {
            return Collections.emptyList();
        }

    }

}