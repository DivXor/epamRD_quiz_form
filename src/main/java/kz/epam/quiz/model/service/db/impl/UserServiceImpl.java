package kz.epam.quiz.model.service.db.impl;

import kz.epam.quiz.model.dao.UserDao;
import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.model.service.db.UserService;
import kz.epam.quiz.model.service.db.exceptions.UserAlreadyExistException;
import kz.epam.quiz.model.service.db.exceptions.UserNotExistException;
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

    @Override
    public User findByEmail(String email) throws UserNotExistException {
        User user = userDao.findByEmail(email);
        if (user != null)
            return user;
        else
            throw new UserNotExistException();
    }

    @Override
    public void createUser(User user) throws UserAlreadyExistException {
        if (!userDao.isExistsByEmail(user.getEmail()))
            userDao.saveAndFlush(user);
         else
            throw new UserAlreadyExistException();
    }
}
