package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

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
        productBasketMap.computeIfAbsent(newProduct.getName(), key -> new LinkedList<>()).add(newProduct);
    }

    public int getCountProducts() {
        return productBasketMap.size();
    }

    public float getSumPrice() {
        return productBasketMap.values().stream().flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printSumPrice() {
        System.out.println("Итого: " + getSumPrice());

    }

    public void printAllProducts() {
        if (getCountProducts() == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        productBasketMap.values().stream().flatMap(Collection::stream)
                .forEach(product -> System.out.println(product));
    }

    public boolean findProduct(String name) {
        return productBasketMap.values().stream().flatMap(Collection::stream)
                .anyMatch(product -> product.getName().equals(name));
    }

    public void cleanBasket() {
        productBasketMap.clear();
        System.out.println("Корзина очищена!");
    }

    public long getAmountOfSpecialProducts() {
        return productBasketMap.values().stream().flatMap(Collection::stream)
                .filter(product -> product.isSpecial())
                .count();
    }

    public List<Product> removeProduct(String name) {
        if (productBasketMap.containsKey(name)) {
            return productBasketMap.remove(name);
        } else {
            return Collections.emptyList();
        }
    }

}