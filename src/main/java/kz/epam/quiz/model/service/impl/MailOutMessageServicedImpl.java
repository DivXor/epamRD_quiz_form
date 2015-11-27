package kz.epam.quiz.model.service.impl;

import kz.epam.quiz.model.entity.History;
import kz.epam.quiz.model.service.HistoryService;
import org.springframework.stereotype.Service;

@Service
public class MailOutMessageServicedImpl extends GenericServiceImpl<Integer, History> implements HistoryService {
}
