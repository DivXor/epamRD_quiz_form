package kz.epam.quiz.util.mail;

import kz.epam.quiz.model.entity.MailOutMessage;
import kz.epam.quiz.model.entity.User;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class MailManager {

    private static final String host = "smtp.mail.ru";
    private static final String username = "username";
    private static final String password = "password";

    public void sendMail(MailOutMessage mail, Set<User> recepients) {


        //mail information
        String subject = mail.getTitle();
        String from = mail.getAuthor().getEmail();
        String messageBody = mail.getContent();

        List<InternetAddress> addressesList = new ArrayList<>();

        try {
            for(User user : recepients) {
                String email = user.getEmail();
                InternetAddress internetAddress = new InternetAddress(email);
                addressesList.add(internetAddress);
            }
        } catch (AddressException e) {
            e.printStackTrace();
        }

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try{
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            InternetAddress[] addresses = new InternetAddress[addressesList.size()];
            addresses = addressesList.toArray(addresses);

            message.addRecipients(Message.RecipientType.TO, addresses);
            message.setSubject(subject, "UTF-8");
            message.setText(messageBody, "UTF-8");

            Transport.send(message);

        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
