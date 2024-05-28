package org.trabalhoPoo.factorys;

import org.trabalhoPoo.implemetations.EmailHtlmRunnable;
import org.trabalhoPoo.implemetations.EmailWithAttachmentInterfaceRunnable;
import org.trabalhoPoo.implemetations.SimpleEmailInterfaceRunnable;
import org.trabalhoPoo.interfaces.EmailHtmlInterface;
import org.trabalhoPoo.interfaces.EmailWithAttachmentInterface;
import org.trabalhoPoo.interfaces.EmailsFactoryInterface;
import org.trabalhoPoo.interfaces.SimpleEmailInterface;

public class EmailsFactory implements EmailsFactoryInterface {

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

