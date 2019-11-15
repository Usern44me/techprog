package com.demo.techprog.spider.intface;

import java.io.IOException;

public interface Writer<T> {

    void write(T write) throws IOException;
}
