package org.skypro.skyshop.search;

import org.skypro.skyshop.BestResultNotFound;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchable.Searchable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private final ArrayList<Searchable> searchables;

    public SearchEngine(int size) {
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

    public List<Searchable> search(String keyWord) {
        Iterator<Searchable> searchableIterator = searchables.iterator();
        List<Searchable> resultList = new LinkedList<>();
        while (searchableIterator.hasNext()) {
            Searchable nextSearchable = searchableIterator.next();
            if (nextSearchable.getSearchTerm().contains(keyWord)) {
                resultList.add(nextSearchable);
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