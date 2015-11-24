package kz.epam.quiz.model.dao;

import kz.epam.quiz.model.entity.User;

import java.util.List;

public interface GenericDao<T> {

    List<T> getList();

    void save(T entity);

    void delete(int id);

    T getById(int id);

    void update(T entity);
}
