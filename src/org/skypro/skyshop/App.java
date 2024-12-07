package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        // Добавить продукты в корзину
        productBasket.addProduct("bread", 50);
        productBasket.addProduct("eggs", 300);
        productBasket.addProduct("milk", 100);
        productBasket.addProduct("apples", 450);
        productBasket.addProduct("sausage", 1500);

        //Добавить продукт в корзину, в которой уже нет места
        productBasket.addProduct("oil", 300);

        //Печать списка товаров и общей стоимости
        productBasket.printAllProducts();
        productBasket.printSumPrice();
        System.out.println("");

        //Поиск товара, который есть в корзине
        System.out.println(productBasket.findProduct("milk"));
        System.out.println("");

        //Поиск товара, которого нет в корзине
        System.out.println(productBasket.findProduct("cheese"));
        System.out.println("");

        //Очитска корзины
        productBasket.cleanBasket();

        //Печать содержимого пустой корзины
        productBasket.printAllProducts();

        //Поиск товара в пустой корзине
        System.out.println(productBasket.findProduct("shampoo"));

    }
}