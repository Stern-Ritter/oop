package ru.otus.solid.model.impl;

import ru.otus.solid.model.Repository;
import ru.otus.solid.entity.User;

import java.util.HashMap;

public class InMemoryUserRepository implements Repository<User> {
    private final HashMap<Long, User> users;

    public InMemoryUserRepository() {
        this.users = new HashMap<>();
    }

    @Override
    public User getById(long id) {
        return users.get(id);
    }

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
        System.out.println("Save user: " + user.getName());
    }

    @Override
    public boolean update(User user) {
        User savedUser = users.put(user.getId(), user);
        return savedUser == null;
    }

    @Override
    public boolean delete(long id) {
        User savedUser = users.remove(id);
        return savedUser != null;
    }
}
