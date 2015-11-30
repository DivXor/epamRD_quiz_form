package kz.epam.quiz.model.service.impl;

import kz.epam.quiz.model.dao.AnswerDao;
import kz.epam.quiz.model.dao.MailOutMessageDao;
import kz.epam.quiz.model.entity.MailOutMessage;
import kz.epam.quiz.model.service.MailOutMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailOutMessageServiceImpl extends AbstractService<MailOutMessage, Integer> implements MailOutMessageService {

    MailOutMessageDao mailOutMessageDao;

    @Autowired
    public MailOutMessageServiceImpl(MailOutMessageDao repository) {
        super(repository);
        mailOutMessageDao = repository;
    }

}
