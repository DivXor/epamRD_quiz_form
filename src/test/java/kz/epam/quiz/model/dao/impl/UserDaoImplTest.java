package kz.epam.quiz.model.dao.impl;

import kz.epam.quiz.model.dao.UserDao;
import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.util.SpringWebAppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringWebAppConfig.class})
@Transactional
public class UserDaoImplTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testGetUsersByAnswerId() throws Exception {
        List<User> userList;
        userList = userDao.getUsersByAnswerId(1);
        System.out.println(userList);
    }
}