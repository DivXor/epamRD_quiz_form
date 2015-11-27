package kz.epam.quiz.model.dao.impl;

import kz.epam.quiz.model.dao.UserDao;
import kz.epam.quiz.model.entity.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends GenericDaoImpl<Integer, User> implements UserDao {
    public static final String SQL_QUERY = "SELECT * FROM USERS " +
            "INNER JOIN HISTORY ON USERS.ID = HISTORY.USER_ID " +
            "INNER JOIN ANSWERS ON HISTORY.ANSWER_ID = ANSWERS.ID " +
            "WHERE ANSWER_ID = :id";

    @Override
    public List<User> getUsersByAnswerId(int id) {
        Query query = getSession().createSQLQuery(SQL_QUERY).addEntity(User.class);
        query.setParameter("id", id);
        return query.list();
    }
}
