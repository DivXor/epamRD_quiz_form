package kz.epam.quiz.util.mail;

import kz.epam.quiz.model.entity.MailOutMessage;
import kz.epam.quiz.model.entity.User;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public final class MailManager {

    private static final String propertiesFile = "mail.properties";

    private MailManager () {}

    public static void sendMail(MailOutMessage mail, Set<User> recepients) {

        Properties prop = new Properties();

        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = loader.getResourceAsStream(propertiesFile);
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final String host = prop.getProperty("mailmanager.host").trim();
        final String username = prop.getProperty("mailmanager.username").trim();
        final String password = prop.getProperty("mailmanager.password").trim();

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

            //header "from" must match with sender
            message.setFrom(new InternetAddress(username));

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
