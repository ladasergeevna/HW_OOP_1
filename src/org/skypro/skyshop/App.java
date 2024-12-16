package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        // Добавить продукты в корзину
        productBasket.addProduct(new SimpleProduct("яйца",300));
        productBasket.addProduct(new SimpleProduct("молоко",300));
        productBasket.addProduct(new FixPriceProduct("батон"));
        productBasket.addProduct(new DiscountedProduct("яблоки", 100,5));
        productBasket.addProduct(new DiscountedProduct("сосиски", 1000,10));

        //Печать списка товаров и общей стоимости
        productBasket.printAllProducts();
        productBasket.printSumPrice();
        System.out.println("Специальных товаров: " + DiscountedProduct.AMOUNT_SPECIAL_PRODUCT);

        System.out.println("");

        //Добавить продукт в корзину, в которой уже нет места
        productBasket.addProduct(new SimpleProduct("масло",300));
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