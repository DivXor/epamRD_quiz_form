package kz.epam.quiz.model.service.impl;

import kz.epam.quiz.model.dao.QuizDao;
import kz.epam.quiz.model.dao.UserDao;
import kz.epam.quiz.model.entity.Quiz;
import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.model.service.QuizService;
import kz.epam.quiz.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl extends AbstractService<Quiz, Integer> implements QuizService {

    QuizDao quizDao;

    @Autowired
    public QuizServiceImpl(QuizDao repository) {
        super(repository);
        quizDao = repository;
    }

}
