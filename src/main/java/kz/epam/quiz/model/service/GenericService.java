package kz.epam.quiz.model.service;

import java.util.List;

public interface GenericService<T, PK> {
    T getByID(PK key);

    List<T> findAll();

    void save(T entity);

    void delete(T entity);

    void update(T entity);
}