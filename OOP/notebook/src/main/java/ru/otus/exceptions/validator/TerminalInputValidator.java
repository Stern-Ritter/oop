package ru.otus.exceptions.validator;

import ru.otus.exceptions.exception.BirthDayFormatException;
import ru.otus.exceptions.exception.GenderFormatException;
import ru.otus.exceptions.exception.InputLengthException;
import ru.otus.exceptions.exception.NameFormatException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Pattern;

public class TerminalInputValidator implements InputValidator {
    private final static String SURNAME_PROMPT = "Фамилия";
    private final static String NAME_PROMPT = "Имя";
    private final static String PATRONYMIC_PROMPT = "Отчество";
    private final static String BIRTH_DAY_PROMPT = "дата_рождения";
    private final static String PHONE_PROMPT = "номер_телефона";
    private final static String GENDER_PROMPT = "пол";
    private final static List<String> INPUT_PROMPTS = List.of(
            SURNAME_PROMPT, NAME_PROMPT, PATRONYMIC_PROMPT,
            BIRTH_DAY_PROMPT, PHONE_PROMPT, GENDER_PROMPT);

    public final static String INPUT_PROMPT = String.join(" ", INPUT_PROMPTS);

    private final static String INPUT_PARTS_EXCEPTION_TEMPLATE = String.format(
            "Ввод не соответствует заданному формату: %s и должен состоять из %d частей.",
            INPUT_PROMPT, INPUT_PROMPTS.size());
    private final static String FORMAT_EXCEPTION_TEMPLATE = "Не соответствие формату: %s не %s.";

    private final static String SURNAME_FORMAT = "строка";
    private final static String NAME_FORMAT = "строка";
    private final static String PATRONYMIC_FORMAT = "строка";
    private final static String BIRTH_DAY_FORMAT = "строка формата dd.mm.yyyy";
    private final static String PHONE_FORMAT = "целое беззнаковое число без форматирования";
    private final static String GENDER_FORMAT = "символ латиницей f или m";

    private final static String SURNAME_PATTERN_TEMPLATE = "^[a-zA-Zа-яА-я]+$";
    private final static String NAME_PATTERN_TEMPLATE = "^[a-zA-Zа-яА-я]+$";
    private final static String PATRONYMIC_PATTERN_TEMPLATE = "^[a-zA-Zа-яА-я]+$";
    private final static String BIRTH_DAY_PATTERN_TEMPLATE = "dd.MM.yyyy";
    private final static String PHONE_PATTERN_TEMPLATE = "^[0-9]{7,}$";
    private final static String GENDER_PATTERN_TEMPLATE = "^[f|m]$";

    public void validate(String[] inputParts) {
        isInputPartsValid(inputParts);
        isSurnameValid(inputParts[0]);
        isNameValid(inputParts[1]);
        isPatronymicValid(inputParts[2]);
        isBirthDayValid(inputParts[3]);
        isPhoneValid(inputParts[4]);
        isGenderValid(inputParts[5]);
    }

    private void isInputPartsValid(String[] inputParts) {
        if (inputParts == null || inputParts.length != INPUT_PROMPTS.size()) {
            throw new InputLengthException(INPUT_PARTS_EXCEPTION_TEMPLATE);
        }
    }

    private void isSurnameValid(String name) {
        if (!Pattern.matches(SURNAME_PATTERN_TEMPLATE, name)) {
            throw new NameFormatException(String.format(FORMAT_EXCEPTION_TEMPLATE, SURNAME_PROMPT, SURNAME_FORMAT));
        }
    }

    private void isNameValid(String name) {
        if (!Pattern.matches(NAME_PATTERN_TEMPLATE, name)) {
            throw new NameFormatException(String.format(FORMAT_EXCEPTION_TEMPLATE, NAME_PROMPT, NAME_FORMAT));
        }
    }

    private void isPatronymicValid(String name) {
        if (!Pattern.matches(PATRONYMIC_PATTERN_TEMPLATE, name)) {
            throw new NameFormatException(String.format(FORMAT_EXCEPTION_TEMPLATE, PATRONYMIC_PROMPT, PATRONYMIC_FORMAT));
        }
    }

    private void isBirthDayValid(String birthDate) {
        try {
            DateFormat df = new SimpleDateFormat(BIRTH_DAY_PATTERN_TEMPLATE);
            df.setLenient(false);
            df.parse(birthDate);
        } catch (ParseException ex) {
            throw new BirthDayFormatException(String.format(FORMAT_EXCEPTION_TEMPLATE, BIRTH_DAY_PROMPT, BIRTH_DAY_FORMAT));
        }
    }

    private void isPhoneValid(String phoneNumber) {
        if (!Pattern.matches(PHONE_PATTERN_TEMPLATE, phoneNumber)) {
            throw new BirthDayFormatException(String.format(FORMAT_EXCEPTION_TEMPLATE, PHONE_PROMPT, PHONE_FORMAT));
        }
    }

    private void isGenderValid(String gender) {
        if (!Pattern.matches(GENDER_PATTERN_TEMPLATE, gender)) {
            throw new GenderFormatException(String.format(FORMAT_EXCEPTION_TEMPLATE, GENDER_PROMPT, GENDER_FORMAT));
        }
    }
}
