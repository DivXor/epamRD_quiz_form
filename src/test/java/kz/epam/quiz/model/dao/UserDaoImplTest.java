package kz.epam.quiz.model.dao;

import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.util.SpringWebAppConfig;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringWebAppConfig.class })
@Transactional
public class UserDaoImplTest {

    @Autowired
    private UserDao userDaoImpl;

    @Test
    public void testGetList() throws Exception {
        List<User> users = userDaoImpl.getList();
        System.out.println(users);
    }

    @Test
    public void testGetById() throws Exception {
        User user = userDaoImpl.getById(1);
        System.out.println(user);
    }

    @Test
    @Rollback(false)
    public void testSave() throws Exception {
        User user = new User();
        user.setEmail("test1@example.com");
        userDaoImpl.save(user);
    }

    @Ignore
    @Test
    public void testDelete() throws Exception {

    }

    @Ignore
    @Test
    public void testUpdate() throws Exception {

    }
}