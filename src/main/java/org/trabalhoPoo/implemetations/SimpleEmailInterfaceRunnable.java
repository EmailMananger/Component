package org.trabalhoPoo.implemetations;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.trabalhoPoo.interfaces.SimpleEmailInterface;


public class SimpleEmailInterfaceRunnable extends AbstractEmail implements SimpleEmailInterface {

    Email email = new SimpleEmail();
    private String message;

    public SimpleEmailInterfaceRunnable(String userName, String password, String to, String message, String subject) {
        super(userName, password, to, subject);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
            logger.info("Email simples para "+to+" enviado com sucesso");
        } catch (EmailException e) {
            throw new RuntimeException(e);
        }
    }
}
