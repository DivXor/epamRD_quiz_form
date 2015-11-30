package kz.epam.quiz.model.service.impl;

import kz.epam.quiz.model.dao.AnswerDao;
import kz.epam.quiz.model.dao.QuizDao;
import kz.epam.quiz.model.entity.Answer;
import kz.epam.quiz.model.entity.Quiz;
import kz.epam.quiz.model.service.AnswerService;
import kz.epam.quiz.model.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl extends AbstractService<Answer, Integer> implements AnswerService {

    AnswerDao answerDao;

    @Autowired
    public AnswerServiceImpl(AnswerDao repository) {
        super(repository);
        answerDao = repository;
    }

}
