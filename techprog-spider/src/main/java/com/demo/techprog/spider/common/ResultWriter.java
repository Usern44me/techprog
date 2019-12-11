package com.demo.techprog.spider.common;

import com.demo.techprog.model.PageAnalysis;
import com.demo.techprog.spider.Writer;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
public class ResultWriter implements Writer<PageAnalysis> {

    private final String fileUri;
    private Path filePath;

    private void checkAndCreateFileIfNotExist() throws IOException {
        if (filePath == null) filePath = Paths.get(fileUri);
        if (Files.notExists(filePath)) Files.createFile(filePath);
    }

    public void write(PageAnalysis result) throws IOException {
        checkAndCreateFileIfNotExist();
        List<String> serialized = result.serialize();
        serialized.add("\n");
        Files.write(filePath, serialized, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
       // System.out.println(serialized.toString());
    }


}
