package com.demo.techprog.spider.common;

import com.demo.techprog.model.Page;
import com.demo.techprog.model.PageAnalysis;
import com.demo.techprog.spider.Analyser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
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
                .replaceAll("[^a-zA-Z0-9]", "\n")
                .split("\n", -1);


        return Arrays.stream(words)
                .filter(s -> !s.equals("")).filter(s -> s.length()>3)
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
