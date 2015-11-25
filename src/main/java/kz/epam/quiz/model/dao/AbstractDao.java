package kz.epam.quiz.model.dao;

import java.util.List;

public interface AbstractDao<T> {

    List<T> getList();

    void save(T entity);

    void delete(int id);

    T getById(int id);

    void update(T entity);
}
