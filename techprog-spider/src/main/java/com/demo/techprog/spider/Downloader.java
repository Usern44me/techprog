package com.demo.techprog.spider;

public interface Downloader<T> {

    T download(String uri);
}
