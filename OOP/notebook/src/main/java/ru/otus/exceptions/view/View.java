package ru.otus.exceptions.view;

import ru.otus.exceptions.exception.BirthDayFormatException;
import ru.otus.exceptions.exception.GenderFormatException;
import ru.otus.exceptions.exception.InputLengthException;
import ru.otus.exceptions.exception.InputReadException;
import ru.otus.exceptions.exception.NameFormatException;
import ru.otus.exceptions.exception.PhoneFormatException;
import ru.otus.exceptions.exception.WriteDataException;
import ru.otus.exceptions.util.DataFormatter;
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
    private final DataFormatter dataFormatter;

    public View(InputReader inputReader, InputValidator inputValidator, FileWriter fileWriter, DataFormatter dataFormatter) {
        this.inputReader = inputReader;
        this.inputValidator = inputValidator;
        this.fileWriter = fileWriter;
        this.dataFormatter = dataFormatter;
    }

    public void setup() {
        while (true) {
            try {
                String input = inputReader.readLine(INPUT_PROMPT);
                if (EXIT_COMMAND.equalsIgnoreCase(input)) {
                    break;
                }

                String[] inputParts = input.split(INPUT_DELIMITER);
                inputValidator.validate(inputParts);

                String fileName = inputParts[0];
                String data = dataFormatter.format(inputParts);
                fileWriter.writeData(fileName, data);
            } catch (InputReadException | WriteDataException | InputLengthException | NameFormatException |
                     BirthDayFormatException | PhoneFormatException | GenderFormatException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


}
