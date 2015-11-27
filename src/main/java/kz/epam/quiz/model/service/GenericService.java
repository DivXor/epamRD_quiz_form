package kz.epam.quiz.model.service;

import java.util.List;

public interface GenericService<PK, T> {
    T getByKey(PK key);

    List<T> getList();

    void persist(T entity);

    void delete(T entity);

    void update(T entity);
}