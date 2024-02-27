package ru.otus.exceptions.view;

import ru.otus.exceptions.exception.*;
import ru.otus.exceptions.util.FileWriter;
import ru.otus.exceptions.util.InputReader;
import ru.otus.exceptions.validator.InputValidator;

public class View {
    private final static String INPUT_TEMPLATE = "Фамилия Имя Отчество дата _ рождения номер _ телефона пол";
    private final static String INPUT_PROMPT = String.format("Введите данные в формате: %s", INPUT_TEMPLATE);
    private final static String INPUT_DELIMITER = " ";
    private final static String EXIT_COMMAND = "q";

    private final InputReader inputReader;
    private final InputValidator inputValidator;
    private final FileWriter fileWriter;

    public View(InputReader inputReader, InputValidator inputValidator, FileWriter fileWriter) {
        this.inputReader = inputReader;
        this.inputValidator = inputValidator;
        this.fileWriter = fileWriter;
    }

    public void setup() {
        while (true) {
            try {
                String input = inputReader.readLine(INPUT_PROMPT);
                if (EXIT_COMMAND.equalsIgnoreCase(input)) {
                    break;
                }

                String[] inputParts = input.split(INPUT_DELIMITER);
                String fileName = inputParts[0];

                inputValidator.validate(inputParts);
                fileWriter.writeData(fileName, input);
            } catch (InputReadException | WriteDataException | InputLengthException | NameFormatException |
                     BirthDayFormatException | PhoneFormatException | GenderFormatException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


}
