package kz.epam.quiz.model.service.db.impl;

import kz.epam.quiz.model.dao.QuizDao;
import kz.epam.quiz.model.entity.Quiz;
import kz.epam.quiz.model.service.db.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl extends AbstractService<Quiz, Integer> implements QuizService {

    QuizDao quizDao;

    @Autowired
    public QuizServiceImpl(QuizDao repository) {
        super(repository);
        quizDao = repository;
    }

}
