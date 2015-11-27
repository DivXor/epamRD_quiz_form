package kz.epam.quiz.model.service.impl;

import kz.epam.quiz.model.entity.Quiz;
import kz.epam.quiz.model.service.QuizService;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl extends GenericServiceImpl<Integer, Quiz> implements QuizService {
}
