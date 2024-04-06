package org.CodaFofo;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SimpleEmailRunnable implements Runnable{

    private final String smtp = "smtp.gmail.com";
    private final int port = 465;
    private String userName;
    private String password;
    Email email = new SimpleEmail();
    private String to;
    private String message;
    private String subject;
    public SimpleEmailRunnable(String userName, String password, String to, String message, String subject) {
        this.userName = userName;
        this.password = password;
        this.to = to;
        this.message = message;
        this.subject = subject;
    }

    @Override
    public void run() {
        email.setHostName(smtp);
        email.setSmtpPort(port);
        email.setAuthenticator(new DefaultAuthenticator(userName, password));
        email.setSSLOnConnect(true);
        try {
            email.setFrom(userName);
            email.setSubject(subject);
            email.setMsg(message);
            email.addTo(to);
            email.send();
        } catch (EmailException e) {
            throw new RuntimeException(e);
        }
    }
}
