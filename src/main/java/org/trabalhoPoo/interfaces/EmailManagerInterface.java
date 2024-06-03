package org.trabalhoPoo.interfaces;

import java.util.List;

public interface EmailManagerInterface {
    /**
     * Envia um email simples para um destinatário
     * @param to
     * @param message
     * @param subject
     */
    void sendSimpleEmailToMany(List<String> to, String message, String subject );
    /**
     * Envia um email simples para um destinatário
     * @param to
     * @param htmlMessage
     * @param subject
     * @param altMessage
     */
    void sendSimpleEmailHtmlToMany(  List<String> to, String htmlMessage, String subject, String altMessage);
    /**
     * Envia um email simples para um destinatário
     * @param to
     * @param message
     * @param subject
     * @param pathAttachment
     * @param nameAttachment
     * @param descriptionAttachment
     */
    public void sendSimpleEmailWithAttachmentToMany(List<String> to, String message, String subject, String pathAttachment, String nameAttachment, String descriptionAttachment);
}

