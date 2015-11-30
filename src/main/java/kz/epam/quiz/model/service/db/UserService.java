package kz.epam.quiz.model.service.db;

import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.model.service.db.exceptions.UserAlreadyExistException;
import kz.epam.quiz.model.service.db.exceptions.UserNotExistException;

import java.util.List;

public interface UserService extends GenericService<User, Integer>{
    List<User> findUsersByAnswerId(int id);
    User findByEmail(String email) throws UserNotExistException;
    void createUser(User user) throws UserAlreadyExistException;
}
