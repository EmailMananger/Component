package org.trabalhoPoo.email;

import org.apache.commons.mail.*;

public class EmailHtlmRunnable extends AbstractEmail implements EmailHtmlInterface {

    private HtmlEmail email = new HtmlEmail();
    private String htmlMessage;
    private String altMessage;

    public String getHtmlMessage() {
        return htmlMessage;
    }

    public void setHtmlMessage(String htmlMessage) {
        this.htmlMessage = htmlMessage;
    }

    public String getAltMessage() {
        return altMessage;
    }

    public void setAltMessage(String altMessage) {
        this.altMessage = altMessage;
    }

    /**
     * Contrutor da classe com informações apenas do email
     * @param userName Nome do usuário da conta que enviará o email
     * @param password Senha da que enviará o email
     * @param to Email do destinatário
     * @param subject Assunto do email
     * @param htmlMessage Mensagem do email em html
     * @param altMessage Mensagem do email em texto
     */
    public EmailHtlmRunnable(String userName, String password, String to, String subject, String htmlMessage, String altMessage) {
        super(userName,password,to,subject);
        this.htmlMessage = htmlMessage;
        this.altMessage = altMessage;
    }

    public EmailHtlmRunnable(String userName, String password, String to, String subject) {
        super(userName, password, to, subject);
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
    public EmailHtlmRunnable(String userName, String password, String to, String subject, String htmlMessage, String altMessage, String smtp, int port) {
        super(userName,password,to,subject);
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
