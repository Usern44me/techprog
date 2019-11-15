package com.demo.techprog.spider.impl;

import com.demo.techprog.model.PageAnalysis;
import com.demo.techprog.spider.intface.Writer;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@RequiredArgsConstructor
public class RersultWriter implements Writer<PageAnalysis> {

    private final String fileUri;
    private Path filePath;

    public void write(PageAnalysis result) throws IOException {
        checkAndCreateFileIfNotExist();
        List<String> serialized = result.serialize();
        serialized.add("\n");
        Files.write(filePath, serialized, StandardOpenOption.APPEND);
    }

    private void checkAndCreateFileIfNotExist() throws IOException {
        if (filePath == null) filePath = Paths.get(fileUri);
        if (Files.notExists(filePath)) Files.createFile(filePath);
    }
}
