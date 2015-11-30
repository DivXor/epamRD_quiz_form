package kz.epam.quiz.model.service.db.impl;

import kz.epam.quiz.model.dao.HistoryDao;
import kz.epam.quiz.model.entity.History;
import kz.epam.quiz.model.service.db.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl extends AbstractService<History, Integer> implements HistoryService {

    HistoryDao historyDao;

    @Autowired
    public HistoryServiceImpl(HistoryDao repository) {
        super(repository);
        historyDao = repository;
    }

}
