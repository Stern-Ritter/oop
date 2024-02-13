package ru.otus.solid;

import ru.otus.solid.model.impl.InMemoryUserRepository;
import ru.otus.solid.util.ReportCreator;
import ru.otus.solid.util.impl.UserReportCreator;
import ru.otus.solid.entity.User;
import ru.otus.solid.model.Repository;

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
