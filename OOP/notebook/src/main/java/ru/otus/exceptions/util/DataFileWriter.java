package ru.otus.exceptions.util;

import ru.otus.exceptions.exception.WriteDataException;

import java.io.BufferedWriter;
import java.io.IOException;

public class DataFileWriter implements FileWriter {
    private static final String FOLDER_NAME = "data";
    private static final String WRITE_DATA_EXCEPTION_TEMPLATE = "Не удалось сохранить данные";

    @Override
    public void writeData(String fileName, String data) {
        String path = String.format("%s/%s.txt", FOLDER_NAME, fileName);
        try (var writer = new BufferedWriter(new java.io.FileWriter(path, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException ex) {
            throw new WriteDataException(WRITE_DATA_EXCEPTION_TEMPLATE);
        }
    }
}
