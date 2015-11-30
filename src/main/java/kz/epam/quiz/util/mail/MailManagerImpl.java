package kz.epam.quiz.util.mail;

import kz.epam.quiz.model.entity.MailOutMessage;
import kz.epam.quiz.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("mailManager")
public class MailManagerImpl implements MailManager {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private SimpleMailMessage message;

    public void sendMail(MailOutMessage mail, Set<User> recepients) {

        final String subject = mail.getTitle();
        final String messageBody = mail.getContent();

        List<String> addresses = new ArrayList<>();

        for (User user : recepients) {
            String email = user.getEmail();
            addresses.add(email);
        }

        String[] addressesArray = new String[addresses.size()];
        addressesArray = addresses.toArray(addressesArray);

        message.setSubject(subject);
        message.setTo(addressesArray);
        message.setText(messageBody);

        this.mailSender.send(message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MailManagerImpl manager = (MailManagerImpl) o;

        if (mailSender != null ? !mailSender.equals(manager.mailSender) : manager.mailSender != null) return false;
        return !(message != null ? !message.equals(manager.message) : manager.message != null);

    }

    @Override
    public int hashCode() {
        int result = mailSender != null ? mailSender.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
