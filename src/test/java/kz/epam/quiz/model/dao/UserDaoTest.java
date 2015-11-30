package kz.epam.quiz.model.dao;

import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.util.SpringDataConfig;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataConfig.class})
@Transactional
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Ignore
    @Test
    public void testFindUsersByAnswerId() throws Exception {

    }

    @Test
    public void testFindByEmail() throws Exception {
        User user = userDao.findByEmail("test1@example.com");
        System.out.println(user);
    }

    @Test
    public void testIsExistsByEmail() throws Exception {
        boolean isTrue = userDao.existsByEmail("test1@example.com");
        boolean isFalse = userDao.existsByEmail("tes@example.com");
        assertTrue(isTrue);
        assertFalse(isFalse);
    }
}