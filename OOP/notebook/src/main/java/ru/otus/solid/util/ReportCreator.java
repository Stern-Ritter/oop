package ru.otus.solid.util;

public interface ReportCreator<T> {
    void createReport(T entity);
}
