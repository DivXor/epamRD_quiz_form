package kz.epam.quiz.model.dao.impl;

import kz.epam.quiz.model.dao.AnswerDao;
import kz.epam.quiz.model.dao.UserDao;
import kz.epam.quiz.model.entity.Answer;
import kz.epam.quiz.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class AnswerDaoImpl extends GenericDaoImpl<Integer, Answer> implements AnswerDao {
}
