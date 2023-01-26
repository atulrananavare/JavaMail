package com.java.mail;

import java.util.logging.Logger;

public class RunnerClass {
    private final static Logger LOG =
            Logger.getLogger(RunnerClass.class.getName());

    public static void main(String[] args) {
        GEmailSender gmail = new GEmailSender();
        String to = "atulfeb72@gmail.com";
        String from = "atulr7289@gmail.com";
        String subject = "This is java Email send";
        String text = "Hello Atul, Welcome to java Email send Example";
        boolean mail = gmail.sendEmail(to, from, subject, text);

        if(mail){
            LOG.info("Sent email successfully");
        }else{
            LOG.info("email not sent, issue in sending!!!!");
        }
    }
}
