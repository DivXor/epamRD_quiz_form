package kz.epam.quiz.model.service;

import java.util.List;

public interface GenericService<PK, T> {
    public T getByKey(PK key);

    public List<T> getList();

    public void persist(T entity);

    public void delete(T entity);

    public void update(T entity);
}