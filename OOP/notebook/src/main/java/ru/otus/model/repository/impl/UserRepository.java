package ru.otus.model.repository.impl;

import ru.otus.model.User;
import ru.otus.util.helper.impl.BaseFileHelper;
import ru.otus.model.repository.Repository;
import ru.otus.util.mapper.impl.UserMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class UserRepository implements Repository {
    private final UserMapper mapper;
    private final BaseFileHelper fileHelper;

    public UserRepository(BaseFileHelper fileHelper) {
        this.mapper = new UserMapper();
        this.fileHelper = fileHelper;
    }

    @Override
    public List<User> findAll() {
        return read();
    }

    @Override
    public User create(User user) {
        List<User> users = findAll();
        long max = 0L;
        for (User u : users) {
            long id = u.getId();
            if (max < id) {
                max = id;
            }
        }
        long next = max + 1;
        user.setId(next);
        users.add(user);
        write(users);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> update(Long userId, User update) {
        List<User> users = findAll();
        User editUser = users.stream()
                .filter(u -> u.getId()
                        .equals(userId))
                .findFirst().orElseThrow(() -> new RuntimeException("User not found"));

        if (!update.getFirstName().isEmpty()) {
            editUser.setFirstName(update.getFirstName());
        }
        if (!update.getLastName().isEmpty()) {
            editUser.setLastName(update.getLastName());
        }
        if (!update.getPhone().isEmpty()) {
            editUser.setPhone(update.getPhone());
        }
        write(users);
        return Optional.of(update);
    }

    @Override
    public boolean delete(Long userId) {
        List<User> users = findAll();
        boolean deleted = false;
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId().equals(userId)) {
                iterator.remove();
                deleted = true;
            }
        }
        write(users);

        return deleted;
    }

    private List<User> read() {
        try {
            List<String> lines = fileHelper.readFile();
            List<User> users = new ArrayList<>();
            for (String line : lines) {
                users.add(mapper.toOutput(line));
            }
            return users;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void write(List<User> users) {
        try {
            List<String> lines = new ArrayList<>();
            for (User u : users) {
                lines.add(mapper.toInput(u));
            }
            fileHelper.writeFile(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
