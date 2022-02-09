package com.onlinestore.kodigonlinestore.Controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class MailSender {
    private static Object Session;

    public static  void sendMail(String receiver, String bodyText, String subject) throws Exception {
        System.out.println("Preparando mail");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);

        String myAccountEmail = "projectcinema321@gmail.com";
        String password = "admin123!";

        Session session = javax.mail.Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject(subject);

            Multipart emailContent = new MimeMultipart();

            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(bodyText);

            emailContent.addBodyPart(textBodyPart);
            message.setContent(emailContent);

            Transport.send(message);

            System.out.println("MAIL DELIVERED!");
        }catch (MessagingException mex){
            mex.printStackTrace();
        }
    }
}
