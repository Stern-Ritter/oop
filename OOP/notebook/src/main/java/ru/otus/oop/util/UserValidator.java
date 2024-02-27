package ru.otus.oop.util;

import ru.otus.oop.model.User;

public class UserValidator {

    public User validate(User user) {
        if (!isValid(user)) {
            throw new IllegalArgumentException("Введены не корректные данные");
        }
        user.setFirstName(user.getFirstName().replaceAll(" ", "").trim());
        user.setLastName(user.getLastName().replaceAll(" ", "").trim());
        user.setPhone(user.getPhone().replaceAll(" ", "").trim());
        return user;
    }

    private boolean isValid(User user) {
        return !user.getFirstName().isEmpty()
                && !user.getLastName().isEmpty()
                && !user.getPhone().isEmpty();
    }
}
