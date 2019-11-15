package com.demo.techprog.spider;

import com.demo.techprog.spider.intface.Strategy;

public class Launcher {

    private static Strategy strategy;

    public static void main(String[] args) {
        init(args);
        strategy.execute();
    }

    private static void init(String[] args) {
        //TODO
    }

}
