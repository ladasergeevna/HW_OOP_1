package org.skypro.skyshop.search;

import org.skypro.skyshop.BestResultNotFound;
import org.skypro.skyshop.searchable.Searchable;

public class SearchEngine {
    private static final int MAX_SEARCH_RESULTS = 5;
    private Searchable[] searchables;
    private int size = 0;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public Searchable[] search(String keyWord) {
        Searchable[] results = new Searchable[size];
        int i = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(keyWord)) {
                results[i++] = searchable;
                if (i >= MAX_SEARCH_RESULTS) {
                    break;
                }
            }
        }
        return results;
    }


    public int findSpace() {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void addSearchable(Searchable newSearchable) {
        int i = findSpace();
        if (i == -1) {
            System.out.println("Невозможно добавить элемент");
            return;
        }
        searchables[size++] = newSearchable;
    }

    public void addAll(Searchable... searchables) {
        for (Searchable searchable : searchables) {
            addSearchable(searchable);
        }
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
        if (maxScore == 0){
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