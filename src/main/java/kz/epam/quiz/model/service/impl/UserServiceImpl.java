package kz.epam.quiz.model.service.impl;

import kz.epam.quiz.model.dao.UserDao;
import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends AbstractService<User, Integer> implements UserService {

    UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao repository) {
        super(repository);
        userDao = repository;
    }

    @Override
    public List<User> findUsersByAnswerId(int id) {
        return userDao.findUsersByAnswerId(id);
    }

}
