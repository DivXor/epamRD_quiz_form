package kz.epam.quiz.model.dao.impl;

import kz.epam.quiz.model.dao.QuizDao;
import kz.epam.quiz.model.entity.Quiz;
import org.springframework.stereotype.Repository;

@Repository
public class QuizDaoImpl extends GenericDaoImpl<Integer, Quiz> implements QuizDao {
}
