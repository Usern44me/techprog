package com.demo.techprog.spider.common;

import com.demo.techprog.model.Page;
import com.demo.techprog.model.PageAnalysis;
import com.demo.techprog.spider.*;
import lombok.Builder;

import java.io.IOException;
import java.util.List;

@Builder
public class SpiderStrategy implements Strategy {

    private final Reader<List<String>> reader;
    private final Downloader<Page> downloader;
    private final Analyser<Page, PageAnalysis> analyser;
    private final Writer<PageAnalysis> writer;

    public void execute() {
        try {
            List<String> read = reader.read();
            read.stream()
                    .map(downloader::download)
                    .map(analyser::analyse)
                    .forEach(this::write);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void write(PageAnalysis analysis) {
        try {
            writer.write(analysis);
        } catch (IOException e) {
            System.err.println("Error writing " + analysis.getUri());
            e.printStackTrace();
        }
    }
}
