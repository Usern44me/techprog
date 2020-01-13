package com.demo.techprog.searcher.common;
import com.demo.techprog.model.PageAnalysis;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Builder
public class HtmlGenerator {

    public List<String> DoHTML (List<PageAnalysis> result )
    {

        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">");
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
        sb.append("<title>Result of search</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append(" <h1>Result</h1>");
        for(int i = 0;i<result.size();i++) {
            sb.append(" <h1>" + result.get(i).getUri() + "</h1>");
            for (String tmp : result.get(i).getWordVector().keySet()) {
                sb.append(" <p>" + tmp + " " + result.get(i).getWordVector().get(tmp) + "</p>");
            }
        }
        sb.append(" </body>");
        sb.append(" </html>");
        return Arrays.stream(new String[]{sb.toString()})
                .filter(s -> !s.equals(""))
                .collect(Collectors.toList());
    }

}
