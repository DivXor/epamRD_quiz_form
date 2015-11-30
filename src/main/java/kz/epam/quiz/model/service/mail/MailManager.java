package kz.epam.quiz.model.service.mail;

import kz.epam.quiz.model.entity.MailOutMessage;
import kz.epam.quiz.model.entity.User;

import java.util.Set;

public interface MailManager {

    void sendMail(MailOutMessage message, Set<User> userSet);

}
