package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.article.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

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
        System.out.println();

        //Добавить продукт в корзину, в которой уже нет места
        productBasket.addProduct(new SimpleProduct("Масло", 300));
        Product dress1 = new DiscountedProduct("Платье", 4000, 70);
        productBasket.addProduct(dress1);

        //Поиск товара, который есть в корзине
        System.out.println(productBasket.findProduct("Платье"));
        System.out.println();

        //Поиск товара, которого нет в корзине
        System.out.println(productBasket.findProduct("cheese"));
        System.out.println();

        //Удаление существующего товара по имени, печать удаленных продуктов и содержимого корзины после удаления
        System.out.println("Список удаленных товаров: " + productBasket.removeProduct("Платье"));
        System.out.println("Текущий список товаров в корзине:");
        productBasket.printAllProducts();
        System.out.println();

        //Удаление несуществующего товара по имени, печать удаленных продуктов и содержимого корзины после удаления
        System.out.println("Список удаленных товаров: " + productBasket.removeProduct("Крупа"));
        System.out.println("Текущий список товаров в корзине:");
        productBasket.printAllProducts();
        System.out.println();

        //Очистка корзины
        productBasket.cleanBasket();

        //Печать содержимого пустой корзины
        productBasket.printAllProducts();
        System.out.println();

        //Поиск товара в пустой корзине
        System.out.println(productBasket.findProduct("Платье"));
        System.out.println();

        //Добавление в всех товаров в SearchEngine
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.addAll(dress, rollers, cream, sweets, lollipop, dress1);

        //Добавление статей в SearchEngine
        Article dressGreenArticle = new Article("Инфо о зеленом платье", "Платье зеленое 42 размера");
        Article dressRedArticle = new Article("Инфо о красном платье", "Платье красное 50 размера");
        Article sweetArticle = new Article("Инфо о конфетах в упаковке","Конфеты из молочного шоколада в подарочной коробке");
        Article chocolateArticle = new Article("Инфо о конфетах", "Конфеты из молочного шоколада с начинкой из шоколада");
        Article lollipopArticle = new Article("Инфо о леденцах", "Конфеты леденцовые");

        searchEngine.addSearchable(sweetArticle);
        searchEngine.addSearchable(dressGreenArticle);
        searchEngine.addSearchable(dressRedArticle);
        searchEngine.addSearchable(lollipopArticle);
        searchEngine.addSearchable(chocolateArticle);

        //Поиск товаров и статей по ключевым словам
        System.out.println(searchEngine.search("Конфеты"));
        System.out.println(searchEngine.search("Ролики"));
        System.out.println(searchEngine.search("Крем"));
        System.out.println(searchEngine.search("Платье"));
        System.out.println();

        //Товары с ошибочно заполненными данными
        try {
            Product blank = new SimpleProduct("", 3000);
        } catch (IllegalArgumentException e) {
            System.out.println("Имя товара не может быть пустым");
        }
        try {
            Product secondHand = new SimpleProduct("Бесплатный товар", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Цена должна быть больше нуля");
        }
        try {
            Product jaket = new DiscountedProduct("Куртка", 5000, 500);
        } catch (IllegalArgumentException e) {
            System.out.println("Размер скидки должен быть в диапазоне 0-100");
        }
        System.out.println();

        //Поиск наиболее подходящего элемента по ключевым словам
        String search1 = "шоколад";
        String search2 = "фрукт";

        System.out.println(searchEngine.findBestResult(search1));
        try {
            System.out.println(searchEngine.findBestResult(search2));
        } catch (BestResultNotFound e) {
            System.out.println("Товар '" + search2 + "' не найден!");
        }

    }
}