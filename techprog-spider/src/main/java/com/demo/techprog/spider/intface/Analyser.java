package com.demo.techprog.spider.intface;

public interface Analyser<S, R> {

    R analyse(S source);
}
