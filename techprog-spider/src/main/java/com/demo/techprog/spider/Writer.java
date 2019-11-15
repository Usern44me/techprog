package com.demo.techprog.spider;

import java.io.IOException;

public interface Writer<T> {

    void write(T write) throws IOException;
}
