package ru.otus.util.helper;

import java.io.IOException;
import java.util.List;

public interface FileHelper {
    List<String> readFile() throws IOException;
    void writeFile(List<String> data) throws IOException;
}
