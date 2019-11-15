package com.demo.techprog.spider.intface;

public interface Downloader<T> {

    T download(String uri);
}
