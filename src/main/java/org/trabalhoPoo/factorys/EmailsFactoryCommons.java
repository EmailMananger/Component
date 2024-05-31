package org.trabalhoPoo.factorys;

import org.trabalhoPoo.email.EmailHtlmRunnable;
import org.trabalhoPoo.email.EmailWithAttachmentInterfaceRunnable;
import org.trabalhoPoo.email.SimpleEmailInterfaceRunnable;
import org.trabalhoPoo.email.EmailHtmlInterface;
import org.trabalhoPoo.email.EmailWithAttachmentInterface;
import org.trabalhoPoo.email.SimpleEmailInterface;

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

