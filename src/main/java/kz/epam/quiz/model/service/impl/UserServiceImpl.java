package kz.epam.quiz.model.service.impl;

import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.model.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<Integer, User> implements UserService {
}
