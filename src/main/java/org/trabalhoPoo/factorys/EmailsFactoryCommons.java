package org.trabalhoPoo.factorys;

import org.trabalhoPoo.emails.EmailHtlmRunnable;
import org.trabalhoPoo.emails.EmailWithAttachmentInterfaceRunnable;
import org.trabalhoPoo.emails.SimpleEmailInterfaceRunnable;
import org.trabalhoPoo.emails.EmailHtmlInterface;
import org.trabalhoPoo.emails.EmailWithAttachmentInterface;
import org.trabalhoPoo.emails.SimpleEmailInterface;

public class EmailsFactoryCommons implements EmailsFactoryInterface {

    public EmailHtmlInterface getEmailHtml(String userName, String password, String to, String subject, String htmlMessage, String altMessage){
        return new EmailHtlmRunnable(userName, password, to, subject,htmlMessage,altMessage);
    }

    @Override
    public SimpleEmailInterface getSimpleEmail(String userName, String password, String to, String subject, String message) {
        return new SimpleEmailInterfaceRunnable(userName, password, to, message, subject);
    }

    @Override
    public EmailWithAttachmentInterface getEmailAttachment(String userName, String password, String to, String message, String subject, String pathAttachment, String nameAttachment, String descriptionAttachment) {
        return new EmailWithAttachmentInterfaceRunnable(userName, password, to, message, subject, pathAttachment, nameAttachment, descriptionAttachment);
        }
}

