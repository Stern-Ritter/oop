package ru.otus.solid.util.impl;

import ru.otus.solid.entity.User;
import ru.otus.solid.util.ReportCreator;

public class UserReportCreator implements ReportCreator<User> {
    @Override
    public void createReport(User user) {
        System.out.println("Report for user: " + user.getName());
    }
}
