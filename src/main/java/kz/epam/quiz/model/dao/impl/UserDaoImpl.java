package kz.epam.quiz.model.dao.impl;

import kz.epam.quiz.model.dao.UserDao;
import kz.epam.quiz.model.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<User> getList() {
        @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) getCurrentSession()
                .createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }

    @Override
    public void save(User entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public void delete(int id) {
        User user = getById(id);
        if (user != null)
            getCurrentSession().delete(user);
    }

    @Override
    public User getById(int id) {
        return getCurrentSession().get(User.class, id);
    }

    @Override
    public void update(User entity) {
        getCurrentSession().update(entity);
    }
}
