package org.skypro.skyshop.searchable;

public interface Searchable {
    public String getSearchTerm(); // Отображаемый результат поиска

    public String getSearchContentType(); //Тип контента

    default String getStringRepresentation()// Имя объекта
    {
        return this.getClass().getSimpleName() + "-" + getSearchContentType();
    }

}