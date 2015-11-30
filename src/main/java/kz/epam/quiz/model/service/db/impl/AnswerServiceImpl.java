package kz.epam.quiz.model.service.db.impl;

import kz.epam.quiz.model.dao.AnswerDao;
import kz.epam.quiz.model.entity.Answer;
import kz.epam.quiz.model.service.db.AnswerService;
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
