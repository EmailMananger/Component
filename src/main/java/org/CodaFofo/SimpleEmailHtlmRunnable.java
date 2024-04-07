package org.CodaFofo;

import org.apache.commons.mail.*;

import java.util.logging.Logger;

public class SimpleEmailHtlmRunnable implements Runnable{
    Logger logger = Logger.getLogger(getClass().getName());
    private String smtp = "smtp.gmail.com";
    private int port = 465;
    private String userName;
    private String password;
    private HtmlEmail email = new HtmlEmail();
    private String to;
    private String subject;
    private String htmlMessage;
    private String altMessage;

    /**
     * Contrutor da classe com informações apenas do email
     * @param userName Nome do usuário da conta que enviará o email
     * @param password Senha da que enviará o email
     * @param to Email do destinatário
     * @param subject Assunto do email
     * @param htmlMessage Mensagem do email em html
     * @param altMessage Mensagem do email em texto
     */
    public SimpleEmailHtlmRunnable(String userName, String password, String to, String subject,String htmlMessage, String altMessage) {
        this.userName = userName;
        this.password = password;
        this.to = to;
        this.subject = subject;
        this.htmlMessage = htmlMessage;
        this.altMessage = altMessage;
    }

    /**
     * Contrutor da classe com informações do email e do servidor smtp para implementação futura
     * @param userName Nome do usuário da conta que enviará o email
     * @param password Senha da que enviará o email
     * @param to Email do destinatário
     * @param subject Assunto do email
     * @param htmlMessage Mensagem do email em html
     * @param altMessage Mensagem do email em texto
     * @param smtp Servidor smtp
     * @param port Porta do servidor smtp
     */
    public SimpleEmailHtlmRunnable(String userName, String password, String to, String subject,String htmlMessage, String altMessage,String smtp, int port) {
        this.userName = userName;
        this.password = password;
        this.to = to;
        this.subject = subject;
        this.htmlMessage = htmlMessage;
        this.altMessage = altMessage;
        this.smtp = smtp;
        this.port = port;
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
            email.setHtmlMsg(htmlMessage);
            email.setTextMsg(altMessage);
            email.addTo(to);
            email.send();
            logger.info("Email HTML para "+to+" enviado com sucesso");
        } catch (EmailException e) {
            throw new RuntimeException(e);
        }
    }
}
