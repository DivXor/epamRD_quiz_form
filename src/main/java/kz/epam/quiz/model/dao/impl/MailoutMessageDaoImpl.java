package kz.epam.quiz.model.dao.impl;

import kz.epam.quiz.model.dao.MailOutMessageDao;
import kz.epam.quiz.model.entity.MailOutMessage;
import org.springframework.stereotype.Repository;

@Repository
public class MailOutMessageDaoImpl extends GenericDaoImpl<Integer, MailOutMessage> implements MailOutMessageDao {
}
