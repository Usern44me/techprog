package com.demo.techprog.searcher.common;
import com.demo.techprog.model.PageAnalysis;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class SearchResult implements com.demo.techprog.searcher.SearchResult {
    private final String request;
    ArrayList<PageAnalysis> res = new ArrayList<PageAnalysis>();

    public List<PageAnalysis> Search() throws IOException {
        List<String> requestwords = sourceToWords(request);
        List<String> lineNumberReader = new ListReader("UrlList.txt").read();
        for (int i = 0;i < lineNumberReader.size();i++) {
            res.add(new PageAnalysis(lineNumberReader.get(i), countWordsRequest(requestwords,lineNumberReader.get(i))));
        }
        return  res;
    }



    private List<String> sourceToWords(String source) {
        String[] words = source
                .replaceAll("[^a-zA-Z0-9]", "\n")
                .split("\n", -1);
        return Arrays.stream(words)
                .filter(s -> !s.equals(""))
                .collect(Collectors.toList());
    }

    private Map<String, Integer>  countWordsRequest (List<String> words, String uri) throws IOException {
        HashMap<String, Integer> result = new HashMap<>();
        List<String> reslist = new ListReader("ResList.txt").read();
        for (String word : words) {
        for (int i = 0; i < reslist.size(); i++) {
            if(reslist.get(i).contains(uri)) {
                    if (reslist.get(i).contains(word)) {
                        result.put(reslist.get(i).replaceAll(uri,"").replaceAll("[^a-zA-Z]", ""),Integer.parseInt(reslist.get(i).substring(reslist.get(i).length()-4).replaceAll("[^0-9]", "")));
                    }
                }
            }
        }
        return result;
    }


}
