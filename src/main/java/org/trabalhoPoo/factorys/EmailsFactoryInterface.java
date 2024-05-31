package org.trabalhoPoo.factorys;

import org.trabalhoPoo.email.EmailHtmlInterface;
import org.trabalhoPoo.email.EmailWithAttachmentInterface;
import org.trabalhoPoo.email.SimpleEmailInterface;

public interface EmailsFactoryInterface {
    EmailHtmlInterface getEmailHtml(String userName, String password, String to, String subject, String htmlMessage, String altMessage);
    SimpleEmailInterface getSimpleEmail(String userName, String password, String to, String subject, String message);
    EmailWithAttachmentInterface getEmailAttachment(String userName, String password, String to, String message, String subject, String pathAttachment, String nameAttachment, String descriptionAttachment);
}
