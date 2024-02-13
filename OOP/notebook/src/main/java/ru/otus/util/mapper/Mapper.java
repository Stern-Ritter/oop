package ru.otus.util.mapper;

import ru.otus.model.User;

public interface Mapper {
    String toInput(User e);
    User toOutput(String str);
}
