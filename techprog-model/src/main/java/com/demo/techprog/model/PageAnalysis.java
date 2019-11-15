package com.demo.techprog.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class PageAnalysis {

    private String uri;
    private Map<String, Integer> wordVector;

    public List<String> serialize() {
        List<String> lines = new ArrayList<>();
        wordVector
                .forEach((word, weight) ->
                        lines.add(uri + " " + word + " " + weight)
                );
        return lines;
    }
}
