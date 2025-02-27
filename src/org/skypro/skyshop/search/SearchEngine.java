package org.skypro.skyshop.search;

import org.skypro.skyshop.BestResultNotFound;
import org.skypro.skyshop.SearchEngineComparator;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchable.Searchable;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public void addSearchable(Searchable newSearchable) {
        if (newSearchable == null) {
            return;
        }
        searchables.add(newSearchable);
    }

    public void addAll(Searchable... searchables) {
        Collections.addAll(this.searchables, searchables);
    }

    public Set<Searchable> search(String keyWord) {
        Set<Searchable> resultList = new TreeSet<>(new SearchEngineComparator());
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(keyWord)) {
                resultList.add(searchable);
            }
        }
        return resultList;
    }

    public Searchable findBestResult(String search) {
        int maxScore = 0;
        Searchable bestResult = null;
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                int score = countOccurrences(searchable.getSearchTerm(), search);
                if (score > maxScore) {
                    maxScore = score;
                    bestResult = searchable;
                }
            }
        }
        if (maxScore == 0) {
            throw new BestResultNotFound("Товар '" + search + "' не найден!");
        }
        return bestResult;
    }

    public int countOccurrences(String str, String substr) {
        int count = 0;
        for (int index = 0; (index = str.indexOf(substr, index)) != -1; index += substr.length()) {
            count++;
        }
        return count;
    }
}

