package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;
import org.w3c.dom.ls.LSOutput;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) {
        if ((name == null) || (name.isBlank())) {
            throw new IllegalArgumentException("Имя товара не может быть пустым");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    @Override
    public abstract String toString();

    public abstract boolean isSpecial();

    public String getSearchTerm() {
        return name;
    }

    public String getSearchContentType() {
        return "PRODUCT";
    }

}
