package org.trabalhoPoo.emails;

import java.util.logging.Logger;

public abstract class AbstractEmail {
    Logger logger = Logger.getLogger(getClass().getName());
    protected String smtp = "smtp.gmail.com";
    protected int port = 465;
    protected String userName;
    protected String password;
    protected String to;
    protected  String subject;

    /**
     * Construtor padrão
     */
    public AbstractEmail(String userName, String password, String to, String subject) {
        this.userName = userName;
        this.password = password;
        this.to = to;
        this.subject = subject;
    }

    /**
     * Retorna o smtp
     * @return
     */
    public String getSmtp() {
        return smtp;
    }
    /**
     * Seta o smtp
     * @param smtp
     */
    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    /**
     * Retorna a porta
     * @return
     */
    public int getPort() {
        return port;
    }

    /**
     * Seta a porta
     * @param port
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Retorna o nome de usuário
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Seta o nome de usuário
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Retorna a senha
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Seta a senha
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Retorna o destinatário
     * @return
     */
    public String getTo() {
        return to;
    }

    /**
     * Seta o destinatário
     * @param to
     */
    public void setTo(String to) {
        this.to = to;
    }
    /**
     * Retorna o assunto
     * @return
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Seta o assunto
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
}
