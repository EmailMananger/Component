package org.CodaFofo;

import java.util.List;

public interface EmailManagerInterface {
    void sendSimpleEmailToMany(List<String> to, String message, String subject );
    void sendSimpleEmailHtmlToMany(  List<String> to, String htmlMessage, String subject, String altMessage);
    public void sendSimpleEmailWithAttachmentToMany(List<String> to, String message, String subject, String pathAttachment, String nameAttachment, String descriptionAttachment);
}

