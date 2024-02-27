package ru.otus.oop.util.mapper;

import ru.otus.oop.model.User;

public interface Mapper {
    String toInput(User e);
    User toOutput(String str);
}
