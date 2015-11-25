package kz.epam.quiz.model.dao;

import kz.epam.quiz.model.dao.test.UserService;
import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.util.SpringWebAppConfig;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringWebAppConfig.class })
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetList() throws Exception {
        List<User> users = userService.getList();
        System.out.println(users);
    }

    @Test
    public void testGetById() throws Exception {
        User user = userService.getByKey(1);
        System.out.println(user);
    }

    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setEmail("test1@example.com");
        userService.persist(user);
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