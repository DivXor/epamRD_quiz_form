package kz.epam.quiz.model.service;

import kz.epam.quiz.model.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public abstract class GenericServiceImpl<PK, T> implements GenericService<PK, T> {

    @Autowired
    private GenericDao<PK, T> genericDao;

    @Override
    public T getByKey(PK key) {
        return genericDao.getByKey(key);
    }

    @Override
    public List<T> getList() {
        return genericDao.getList();
    }

    @Override
    public void persist(T entity) {
        genericDao.persist(entity);
    }

    @Override
    public void delete(T entity) {
        genericDao.delete(entity);
    }

    @Override
    public void update(T entity) {
        genericDao.update(entity);
    }
}
