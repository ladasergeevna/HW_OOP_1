package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        // Добавить продукты в корзину
        productBasket.addProduct("яйца", 300);
        productBasket.addProduct("молоко", 100);
        productBasket.addFixPriceProduct("батон");
        productBasket.addDiscountedProduct("яблоки", 100,5);
        productBasket.addDiscountedProduct("сосиски", 1000,10);

        //Печать списка товаров и общей стоимости
        productBasket.printAllProducts();
        productBasket.printSumPrice();
        System.out.println("Специальных товаров: " + DiscountedProduct.AMOUNT_SPECIAL_PRODUCT);

        System.out.println("");

        //Добавить продукт в корзину, в которой уже нет места
        productBasket.addProduct("oil", 300);
        System.out.println("");

        //Поиск товара, который есть в корзине
        System.out.println(productBasket.findProduct("молоко"));
        System.out.println("");

        //Поиск товара, которого нет в корзине
        System.out.println(productBasket.findProduct("cheese"));
        System.out.println("");

        //Очистка корзины
        productBasket.cleanBasket();

        //Печать содержимого пустой корзины
        productBasket.printAllProducts();
        System.out.println("");

        //Поиск товара в пустой корзине
        System.out.println(productBasket.findProduct("молоко"));

    }
}