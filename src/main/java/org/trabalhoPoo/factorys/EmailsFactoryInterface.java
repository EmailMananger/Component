package org.trabalhoPoo.factorys;

import org.trabalhoPoo.emails.EmailHtmlInterface;
import org.trabalhoPoo.emails.EmailWithAttachmentInterface;
import org.trabalhoPoo.emails.SimpleEmailInterface;

public interface EmailsFactoryInterface {
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
    EmailHtmlInterface getEmailHtml(String userName, String password, String to, String subject, String htmlMessage, String altMessage);
    /**
     * Retorna um objeto SimpleEmailInterface
     * @param userName
     * @param password
     * @param to
     * @param subject
     * @param message
     * @return SimpleEmailInterface
     */
    SimpleEmailInterface getSimpleEmail(String userName, String password, String to, String subject, String message);
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
    EmailWithAttachmentInterface getEmailAttachment(String userName, String password, String to, String message, String subject, String pathAttachment, String nameAttachment, String descriptionAttachment);
}
