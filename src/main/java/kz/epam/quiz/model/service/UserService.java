package kz.epam.quiz.model.service;

import kz.epam.quiz.model.entity.User;

import java.util.List;

public interface UserService extends GenericService<Integer, User>{
    List<User> getListByAnswerId(int id);
}
