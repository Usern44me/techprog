package com.demo.techprog.searcher;

import java.io.IOException;

public interface Writer<T> {

    void write(T write) throws IOException;
}
