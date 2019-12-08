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
        if (args.length % 2 != 0) throw new IllegalArgumentException("Arguments invalid");
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(Config.READ_FROM_FLAG)) {
                readUri = args[++i];
            }
            if (args[i].equals(Config.WRITE_TO_FLAG)) {
                writeUri = args[++i];
            }
        }
        strategy = SpiderStrategy.builder()
                .reader(new UriListReader(readUri))
                .downloader(new PageDownloader())
                .analyser(new PageAnalyser())
                .writer(new ResultWriter(writeUri))
                .build();
    }

}
