package com.demo.techprog.spider;

public interface Analyser<S, R> {

    R analyse(S source);
}
