package kz.epam.quiz.model.service.db.impl;

import kz.epam.quiz.model.service.db.GenericService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class AbstractService<T, PK extends Serializable> implements GenericService<T, PK> {

    JpaRepository<T, PK> repository;

    public AbstractService(JpaRepository<T, PK> repository) {
        this.repository = repository;
    }

    @Override
    public T getByID(PK key) {
        return repository.getOne(key);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(T entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }
}
