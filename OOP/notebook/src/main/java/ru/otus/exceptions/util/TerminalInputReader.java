package ru.otus.exceptions.util;

import ru.otus.exceptions.exception.InputReadException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalInputReader implements InputReader {
    private static final String READ_INPUT_ERROR_TEMPLATE = "Ошибка чтения данных из консоли";
    private final BufferedReader inputReader;

    public TerminalInputReader() {
        inputReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine(String prompt) {
        try {
            System.out.printf("%s: ", prompt);
            return inputReader.readLine();
        } catch (IOException ex) {
            throw new InputReadException(READ_INPUT_ERROR_TEMPLATE, ex);
        }
    }
}
