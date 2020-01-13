package com.demo.techprog.searcher.common;

import com.demo.techprog.model.PageAnalysis;
import com.demo.techprog.searcher.Writer;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@RequiredArgsConstructor
public abstract class ResultWriter implements Writer<PageAnalysis> {

    private static Path filePath;
    private static final String fileUri = "Result.html";


    private static void checkAndCreateFileIfNotExist() throws IOException {
        if (filePath == null) filePath = Paths.get(fileUri);
        if (Files.notExists(filePath)) Files.createFile(filePath);
    }

    public static void write(List<PageAnalysis> result) throws IOException {
        checkAndCreateFileIfNotExist();
        Files.write(filePath, new HtmlGenerator().DoHTML(result), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }
}
