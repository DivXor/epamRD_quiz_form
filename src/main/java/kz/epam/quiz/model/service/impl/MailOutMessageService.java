package kz.epam.quiz.model.service.impl;

import kz.epam.quiz.model.entity.MailOutMessage;
import kz.epam.quiz.model.service.MailOutMessageService;
import org.springframework.stereotype.Service;

@Service
public class MailOutMessageService extends GenericServiceImpl<Integer, MailOutMessage> implements MailOutMessageService {
}
