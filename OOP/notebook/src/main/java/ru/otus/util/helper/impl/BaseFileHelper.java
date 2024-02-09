package ru.otus.util.helper.impl;

import ru.otus.util.helper.FileHelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class BaseFileHelper implements FileHelper {
    private final String fileName;

    public BaseFileHelper(String fileName) throws IOException {
        this.fileName = fileName;
    }

    @Override
    public List<String> readFile() throws IOException {
        try (var reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines().collect(Collectors.toList());
        }
    }

    @Override
    public void writeFile(List<String> data) throws IOException {
        try (var writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName, false)))) {
            for (String line : data) {
                writer.println(line);
            }
            writer.flush();
        }
    }
}
