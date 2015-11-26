package kz.epam.quiz.model.service;

import kz.epam.quiz.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<Integer, User> implements UserService {
}
