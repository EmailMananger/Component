package org.trabalhoPoo.interfaces;

import java.util.List;

/**
 * Interface para envio de emails
 */
public interface EmailManagerInterface {
    /**
     * Envia um email simples para um destinatário
     * @param to - Destinatário
     * @param message - Mensagem do email
     * @param subject - Assunto do email
     */
    void sendSimpleEmailToMany(List<String> to, String message, String subject );
    /**
     * Envia um email simples para um destinatário
     * @param to - Destinatário
     * @param htmlMessage - Mensagem do email em HTML
     * @param subject - Assunto do email
     * @param altMessage - Mensagem alternativa
     */
    void sendSimpleEmailHtmlToMany(  List<String> to, String htmlMessage, String subject, String altMessage);
    /**
     * Envia um email simples para um destinatário
     * @param to - Destinatário
     * @param message - Mensagem do email
     * @param subject - Assunto do email
     * @param pathAttachment - Caminho do arquivo a ser anexado
     * @param nameAttachment - Nome do arquivo a ser anexado
     * @param descriptionAttachment - Descrição do arquivo a ser anexado
     */
    public void sendSimpleEmailWithAttachmentToMany(List<String> to, String message, String subject, String pathAttachment, String nameAttachment, String descriptionAttachment);
}

