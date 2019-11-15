package com.demo.techprog.spider.common;

import com.demo.techprog.spider.Reader;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RequiredArgsConstructor
public class UriListReader implements Reader<List<String>> {

    private final String fileUri;

    public List<String> read() throws IOException {
        return Files.readAllLines(Paths.get(fileUri));
    }
}
