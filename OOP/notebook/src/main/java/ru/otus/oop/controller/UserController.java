package ru.otus.oop.controller;

import ru.otus.oop.model.User;
import ru.otus.oop.model.repository.Repository;
import ru.otus.oop.util.UserValidator;

import java.util.List;
import java.util.Objects;

public class UserController {
    private final UserValidator validator;
    private final Repository repository;

    public UserController(Repository repository) {
        this.validator = new UserValidator();
        this.repository = repository;
    }

    public void saveUser(User user) {
        User validatedUser = validator.validate(user);
        repository.create(validatedUser);
    }

    public User readUser(Long userId) throws Exception {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }

        throw new RuntimeException("User not found");
    }

    public List<User> readAll() {
        return repository.findAll();
    }

    public void updateUser(String userId, User updatedUser) {
        updatedUser.setId(Long.parseLong(userId));
        repository.update(Long.parseLong(userId), updatedUser);
    }

    public boolean deleteUser(Long userId) {
        return repository.delete(userId);
    }
}
