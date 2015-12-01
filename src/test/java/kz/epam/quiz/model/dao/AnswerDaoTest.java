package kz.epam.quiz.model.dao;

import kz.epam.quiz.config.SpringDataConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataConfig.class})
@Transactional
public class AnswerDaoTest {

    @Autowired
    AnswerDao answerDao;

    @Test
    public void testFindAll() throws Exception {
        answerDao.findAll();
    }
}