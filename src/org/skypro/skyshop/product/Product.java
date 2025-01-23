package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;
import org.w3c.dom.ls.LSOutput;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
