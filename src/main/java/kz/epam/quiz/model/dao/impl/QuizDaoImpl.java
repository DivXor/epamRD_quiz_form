package kz.epam.quiz.model.dao.impl;

import kz.epam.quiz.model.dao.QuizDao;
import kz.epam.quiz.model.entity.Quiz;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuizDaoImpl implements QuizDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Quiz> getList() {
        return null;
    }

    @Override
    public void save(Quiz entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Quiz getById(int id) {
        return null;
    }

    @Override
    public void update(Quiz entity) {

    }
}
