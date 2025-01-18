package org.skypro.skyshop.search;

import org.skypro.skyshop.BestResultNotFound;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchable.Searchable;

import java.util.*;

public class SearchEngine {
    private final ArrayList<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public void addSearchable(Searchable newSearchable) {
        if (newSearchable == null) {
            return;
        }
        searchables.add(newSearchable);
    }

    public void addAll(Searchable... searchables) {
        for (Searchable searchable : searchables) {
            addSearchable(searchable);
        }
    }

    public Map<String, Searchable> search(String keyWord) {
        Map<String, Searchable> resultList = new TreeMap<>();
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(keyWord)) {
                resultList.put(searchable.getSearchTerm(), searchable);
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

