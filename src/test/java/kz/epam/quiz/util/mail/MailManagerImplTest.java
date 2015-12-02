package kz.epam.quiz.util.mail;

import kz.epam.quiz.config.MailConfig;
import kz.epam.quiz.config.SpringDataConfig;
import kz.epam.quiz.model.entity.MailOutMessage;
import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.model.service.mail.MailManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MailConfig.class})
public class MailManagerImplTest {

    @Autowired
    MailManager mailManager;

    @Test
    public void sendMailTest() throws Exception {
        MailOutMessage message = new MailOutMessage();
        message.setContent("test text");
        message.setTitle("test title");
        Set<User> userSet = new HashSet<>();
        User user1 = new User();
        user1.setEmail("248163264@bk.ru");
        userSet.add(user1);
        User user2 = new User();
        user2.setEmail("divon.step@gmail.com");
        userSet.add(user2);
        mailManager.sendMail(message, userSet);
    }
}