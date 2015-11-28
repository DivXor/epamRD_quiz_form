package kz.epam.quiz.model.service.impl;

import kz.epam.quiz.model.dao.UserDao;
import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getUsersByAnswerId(int id) {
        return userDao.getUsersByAnswerId(id);
    }

    @Override
    public User getByID(Integer key) {
        return null;// TODO (Илья, 11/28/2015): auto-generated method stub
    }

    @Override
    public List<User> findAll() {
        return null;// TODO (Илья, 11/28/2015): auto-generated method stub
    }

    @Override
    public void save(User entity) {
        // TODO (Илья, 11/28/2015): auto-generated method stub
    }

    @Override
    public void delete(User entity) {
        // TODO (Илья, 11/28/2015): auto-generated method stub
    }

    @Override
    public void update(User entity) {
        // TODO (Илья, 11/28/2015): auto-generated method stub
    }
}
