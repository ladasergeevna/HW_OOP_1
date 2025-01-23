package org.skypro.skyshop;

import org.skypro.skyshop.searchable.Searchable;

import java.util.Comparator;

public class SearchEngineComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable searchable1, Searchable searchable2) {
        int result = Integer.compare(
                searchable1.getSearchTerm().length(),
                searchable2.getSearchTerm().length()
        );
        if (result == 0) {
            return searchable1.getSearchTerm().compareTo(searchable2.getSearchTerm());
        }
        return result;
    }
}
