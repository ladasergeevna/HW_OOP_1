package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;
import org.w3c.dom.ls.LSOutput;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) {
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
