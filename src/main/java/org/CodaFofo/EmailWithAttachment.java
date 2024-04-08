package org.CodaFofo;

import org.apache.commons.mail.*;

import java.util.logging.Logger;

public class EmailWithAttachment implements Runnable{
    Logger logger = Logger.getLogger(getClass().getName());
    private final String smtp = "smtp.gmail.com";
    private final int port = 465;
    private String userName;
    private String password;
    MultiPartEmail email = new MultiPartEmail();
    EmailAttachment attachment = new EmailAttachment();
    private String to;
    private String message;
    private String subject;
    private String pathAttachment;
    private String nameAttachment;
    private String descriptionAttachment;
    /**
     * Contrutor da classe com informações do email e do servidor smtp para implementação futura
     * @param userName Nome do usuário da conta que enviará o email
     * @param password Senha da que enviará o email
     * @param to Email do destinatário
     * @param message Mensagem do email
     * @param subject Assunto do email
     * @param pathAttachment Caminho do arquivo a ser anexado
     * @param nameAttachment Nome do arquivo a ser anexado
     * @param descriptionAttachment Descrição do arquivo a ser anexado
     */
    public EmailWithAttachment(String userName, String password, String to, String message, String subject, String pathAttachment, String nameAttachment, String descriptionAttachment) {
        this.userName = userName;
        this.password = password;
        this.to = to;
        this.message = message;
        this.subject = subject;
        this.pathAttachment = pathAttachment;
        this.nameAttachment = nameAttachment;
        this.descriptionAttachment = descriptionAttachment;
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
            attachment.setPath(pathAttachment);
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription(descriptionAttachment);
            attachment.setName(nameAttachment);
            email.attach(attachment);
            email.send();
            logger.info("Email com anexo para "+to+" enviado com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
