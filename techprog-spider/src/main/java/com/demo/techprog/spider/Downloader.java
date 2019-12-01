package com.demo.techprog.spider;

import java.io.IOException;

public interface Downloader<T> {

    T download(String uri) throws IOException;
}
