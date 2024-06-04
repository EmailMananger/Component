package org.trabalhoPoo.emails;

import org.apache.commons.mail.*;

import java.util.logging.Logger;
/**
 * Classe que implementa a interface EmailWithAttachmentInterface e faz o envio de um email com anexo
 * usando como base o Commons Email
 */
public class EmailWithAttachmentInterfaceRunnable extends AbstractEmail implements EmailWithAttachmentInterface {
    Logger logger = Logger.getLogger(getClass().getName());

    MultiPartEmail email = new MultiPartEmail();
    EmailAttachment attachment = new EmailAttachment();
    private String message;
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
    public EmailWithAttachmentInterfaceRunnable(String userName, String password, String to, String message, String subject, String pathAttachment, String nameAttachment, String descriptionAttachment) {
        super(userName,password,to,subject);
        this.message = message;
        this.pathAttachment = pathAttachment;
        this.nameAttachment = nameAttachment;
        this.descriptionAttachment = descriptionAttachment;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPathAttachment() {
        return pathAttachment;
    }

    public void setPathAttachment(String pathAttachment) {
        this.pathAttachment = pathAttachment;
    }

    public String getNameAttachment() {
        return nameAttachment;
    }

    public void setNameAttachment(String nameAttachment) {
        this.nameAttachment = nameAttachment;
    }

    public String getDescriptionAttachment() {
        return descriptionAttachment;
    }

    public void setDescriptionAttachment(String descriptionAttachment) {
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
