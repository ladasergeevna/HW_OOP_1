package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.article.Article;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        // Добавить продукты в корзину
        Product dress = new SimpleProduct("Платье", 3000);
        Product rollers = new SimpleProduct("Ролики", 2500);
        Product cream = new FixPriceProduct("Крем");
        Product sweets = new DiscountedProduct("Конфеты", 500, 5);
        Product lollipop = new DiscountedProduct("Леденец", 150, 10);
        productBasket.addProduct(dress);
        productBasket.addProduct(rollers);
        productBasket.addProduct(cream);
        productBasket.addProduct(sweets);
        productBasket.addProduct(lollipop);

        //Печать списка товаров и общей стоимости
        productBasket.printAllProducts();
        productBasket.printSumPrice();
        System.out.println("Специальных товаров: " + productBasket.getAmountOfSpecialProducts());

        System.out.println("");

        //Добавить продукт в корзину, в которой уже нет места
        productBasket.addProduct(new SimpleProduct("масло", 300));
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
        System.out.println("");

        //Добавление в всех товаров в SearchEngine
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.addAll(dress, rollers, cream, sweets, lollipop);

        //Добавление статей в SearchEngine
        Article dressArticle = new Article("Инфо о платье", "Платье зеленое 42 размера");
        Article sweetArticle = new Article("Инфо о конфетах", "Конфеты из молочного шоколада в подарочной коробке");
        Article lollipopArticle = new Article("Инфо о леденцах", "Конфеты леденцовые");

        searchEngine.addSearchable(sweetArticle);
        searchEngine.addSearchable(dressArticle);
        searchEngine.addSearchable(lollipopArticle);

        //Поиск товаров и статей по ключевым словам
        System.out.println(Arrays.toString(searchEngine.search("Конфеты")));
        System.out.println(Arrays.toString(searchEngine.search("Ролики")));
        System.out.println(Arrays.toString(searchEngine.search("Крем")));
        System.out.println(Arrays.toString(searchEngine.search("Платье")));

    }
}