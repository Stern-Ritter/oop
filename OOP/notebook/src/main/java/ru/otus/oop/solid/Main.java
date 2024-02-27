package ru.otus.oop.solid;

import ru.otus.oop.solid.model.impl.InMemoryUserRepository;
import ru.otus.oop.solid.util.ReportCreator;
import ru.otus.oop.solid.util.impl.UserReportCreator;
import ru.otus.oop.solid.entity.User;
import ru.otus.oop.solid.model.Repository;

public class Main {
    public static void main(String[] args) {
        startTest();
    }

    private static void startTest() {
        Repository<User> userRepository = new InMemoryUserRepository();
        ReportCreator<User> userReportCreator = new UserReportCreator();

        User user = new User(1L, "Bob");
        userRepository.save(user);
        userReportCreator.createReport(user);
    }
}
