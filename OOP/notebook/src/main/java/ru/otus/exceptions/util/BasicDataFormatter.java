package ru.otus.exceptions.util;

public class BasicDataFormatter implements DataFormatter {
    private static final String PART_FORMAT = "<%s>";
    private static final String PART_DELIMITER = " ";

    @Override
    public String format(String[] inputParts) {
        StringBuilder sb = new StringBuilder();
        for (String inputPart : inputParts) {
            sb.append(String.format(PART_FORMAT, inputPart)).append(PART_DELIMITER);
        }
        return sb.toString();
    }
}
