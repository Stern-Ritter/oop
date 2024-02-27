package ru.otus.oop.solid.util;

public interface ReportCreator<T> {
    void createReport(T entity);
}
