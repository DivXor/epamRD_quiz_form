package kz.epam.quiz.model.service.impl;

import kz.epam.quiz.model.dao.UserDao;
import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends GenericServiceImpl<Integer, User> implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getListByAnswerId(int id) {
        return userDao.getUsersByAnswerId(id);
    }

}
