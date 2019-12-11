package com.demo.techprog.spider;

import com.demo.techprog.spider.common.*;
import com.demo.techprog.spider.config.Config;

import java.io.IOException;

public class Launcher {

    private static String writeUri;
    private static String readUri;
    private static Strategy strategy;

    public static void main(String[] args) throws IOException {
        init(args);
        strategy.execute();
    }

    private static void init(String[] args) {
        writeUri = "ResList.txt";
        readUri = "UrlList.txt";

        strategy = SpiderStrategy.builder()
                .reader(new UriListReader(readUri))
                .downloader(new PageDownloader())
                .analyser(new PageAnalyser())
                .writer(new ResultWriter(writeUri))
                .build();
    }

}
