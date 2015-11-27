package kz.epam.quiz.model.dao.impl;

import kz.epam.quiz.model.dao.UserDao;
import kz.epam.quiz.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends GenericDaoImpl<Integer, User> implements UserDao {
    public static final String GET_USERS_FROM_ANSWER_HISTORY = "SELECT h.user FROM History h WHERE h.answer.id = :id";

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsersByAnswerId(int id) {
        return getSession().createQuery(GET_USERS_FROM_ANSWER_HISTORY).setParameter("id", id).list();
    }
}
