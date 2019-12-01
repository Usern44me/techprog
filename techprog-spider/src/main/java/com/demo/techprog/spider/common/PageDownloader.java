package com.demo.techprog.spider.common;

import com.demo.techprog.model.Page;
import com.demo.techprog.spider.Downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class PageDownloader implements Downloader<Page>  {

    public Page download(String uri) throws IOException {
        URL url = new URL(uri);
        String sorce = "";
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openConnection().getInputStream(), "UTF-8"));
            while (true) {
                String line = reader.readLine();
                if (line == null)
                    break;
                sorce+= line;
            }

        Page result = new Page(sorce,uri);
        return result;
    }
}
