package kz.epam.quiz.model.service;

import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.model.entity.UserRole;
import kz.epam.quiz.util.SpringWebAppConfig;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringWebAppConfig.class })
@Transactional
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void testGetList() throws Exception {
        List<User> users = userService.getList();
        System.out.println(users);
    }

    @Rollback(value = false)
    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setEmail("test1@example.com");
        user.setPassword("test");
        user.setFirstName("Иван");
        user.setLastName("Иванов");
        user.setRole(UserRole.USER);
        userService.persist(user);
    }


    @Test
    public void testGetListByAnswerId() throws Exception {
        List<User> users = userService.getListByAnswerId(1);
        assertNotNull(users);
    }
}