package org.skypro.skyshop.searchable;

public interface Searchable {
    String getSearchTerm(); // Отображаемый результат поиска

    String getSearchContentType(); //Тип контента

    default String getStringRepresentation()// Имя объекта
    {
        return this.getClass().getSimpleName() + "-" + getSearchContentType();
    }

    ;


}
