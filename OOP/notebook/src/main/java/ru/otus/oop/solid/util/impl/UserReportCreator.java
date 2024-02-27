package ru.otus.oop.solid.util.impl;

import ru.otus.oop.solid.entity.User;
import ru.otus.oop.solid.util.ReportCreator;

public class UserReportCreator implements ReportCreator<User> {
    @Override
    public void createReport(User user) {
        System.out.println("Report for user: " + user.getName());
    }
}
