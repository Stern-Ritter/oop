package ru.otus.solid.model;

public interface Repository<T> {
    T getById(long id);

    void save(T entity);

    boolean update(T entity);

    boolean delete(long id);
}
