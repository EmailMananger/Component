package org.trabalhoPoo.factorys;

import org.trabalhoPoo.emails.EmailHtlmRunnable;
import org.trabalhoPoo.emails.EmailWithAttachmentInterfaceRunnable;
import org.trabalhoPoo.emails.SimpleEmailInterfaceRunnable;
import org.trabalhoPoo.emails.EmailHtmlInterface;
import org.trabalhoPoo.emails.EmailWithAttachmentInterface;
import org.trabalhoPoo.emails.SimpleEmailInterface;

public class EmailsFactoryCommons implements EmailsFactoryInterface {

    /**
     * Retorna um objeto EmailHtmlInterface
     * @param userName
     * @param password
     * @param to
     * @param subject
     * @param htmlMessage
     * @param altMessage
     * @return EmailHtmlInterface
     */
    public EmailHtmlInterface getEmailHtml(String userName, String password, String to, String subject, String htmlMessage, String altMessage){
        return new EmailHtlmRunnable(userName, password, to, subject,htmlMessage,altMessage);
    }

    /**
     * Retorna um objeto SimpleEmailInterface
     * @param userName
     * @param password
     * @param to
     * @param subject
     * @param message
     * @return SimpleEmailInterface
     */
    @Override
    public SimpleEmailInterface getSimpleEmail(String userName, String password, String to, String subject, String message) {
        return new SimpleEmailInterfaceRunnable(userName, password, to, message, subject);
    }

    /**
     * Retorna um objeto EmailWithAttachmentInterface
     * @param userName
     * @param password
     * @param to
     * @param message
     * @param subject
     * @param pathAttachment
     * @param nameAttachment
     * @param descriptionAttachment
     * @return EmailWithAttachmentInterface
     */
    @Override
    public EmailWithAttachmentInterface getEmailAttachment(String userName, String password, String to, String message, String subject, String pathAttachment, String nameAttachment, String descriptionAttachment) {
        return new EmailWithAttachmentInterfaceRunnable(userName, password, to, message, subject, pathAttachment, nameAttachment, descriptionAttachment);
        }
}

