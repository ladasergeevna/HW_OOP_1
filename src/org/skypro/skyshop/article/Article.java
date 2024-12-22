package org.skypro.skyshop.article;

import org.skypro.skyshop.searchable.Searchable;

public class Article implements Searchable {
    String name;
    String content;

    public Article(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public String toString() {
        return name + ": " + content;
    }

    public String getSearchTerm() {
        return toString();
    }

    public String getSearchContentType() {
        return "Article";
    }
}
