package kz.epam.quiz.model.dao;

import kz.epam.quiz.model.entity.User;

import java.util.List;

public interface UserDao extends GenericDao<Integer, User> {
    List<User> getUsersByAnswerId(int id);
}
