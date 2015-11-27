package kz.epam.quiz.model.dao.impl;

import kz.epam.quiz.model.dao.HistoryDao;
import kz.epam.quiz.model.dao.QuizDao;
import kz.epam.quiz.model.entity.History;
import kz.epam.quiz.model.entity.Quiz;
import org.springframework.stereotype.Repository;

@Repository
public class HistoryDaoImpl extends GenericDaoImpl<Integer, History> implements HistoryDao {
}
