package com.java.mail;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class GEmailSender {

    public boolean sendEmail(String to, String from, String subject, String text){
        boolean flag=false;

        Properties props=new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.debug", "true");

        final String username="atulr7289@gmail.com";
        final String password="Shubh@12";

        Session session = Session.getInstance(props     , new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });


        try {
            MimeMessage message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(to)));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
            flag=true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

}
