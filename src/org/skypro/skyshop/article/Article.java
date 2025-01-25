package org.skypro.skyshop.article;

import org.skypro.skyshop.searchable.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private String name;
    private String content;

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
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}