package com.demo.techprog.spider.intface;

import java.io.IOException;

public interface Reader<T> {

    T read() throws IOException;
}
