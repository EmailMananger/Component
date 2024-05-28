package org.trabalhoPoo.implemetations;

import java.util.logging.Logger;

public abstract class AbstractEmail {
    Logger logger = Logger.getLogger(getClass().getName());
    protected String smtp = "smtp.gmail.com";
    protected int port = 465;
    protected String userName;
    protected String password;
    protected String to;
    protected  String subject;

    public AbstractEmail(String userName, String password, String to, String subject) {
        this.userName = userName;
        this.password = password;
        this.to = to;
        this.subject = subject;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
