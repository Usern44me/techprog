package com.demo.techprog.spider.common;

import com.demo.techprog.model.Page;
import com.demo.techprog.model.PageAnalysis;
import com.demo.techprog.spider.Analyser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PageAnalyser implements Analyser<Page, PageAnalysis> {

    private static final BiFunction<String, Integer, Integer> INCREMENTOR = (word, weight) -> weight + 1;

    public PageAnalysis analyse(Page page) {
        return new PageAnalysis(
                page.getUri(),
                countWords(sourceToWords(page.getSource())));
    }

    private List<String> sourceToWords(String source) {
        String[] words = source
                .replaceAll("[^a-zA-Z0-9]*", ";")
                .split(";", -1);
        return Arrays.stream(words)
                .filter(s -> !s.equals(""))
                .collect(Collectors.toList());
    }

    private Map<String, Integer> countWords(List<String> words) {
        HashMap<String, Integer> result = new HashMap<>();
        words.forEach(w -> {
            result.putIfAbsent(w, 1);
            result.computeIfPresent(w, INCREMENTOR);
        });
        return result;
    }
}
