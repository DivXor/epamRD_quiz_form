package kz.epam.quiz.model.service.db;

import java.util.List;

public interface GenericService<T, PK> {
    T getByID(PK key);

    List<T> findAll();

    void save(T entity);

    void delete(T entity);
}