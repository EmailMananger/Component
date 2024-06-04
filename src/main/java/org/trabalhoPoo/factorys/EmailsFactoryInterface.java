package org.trabalhoPoo.factorys;

import org.trabalhoPoo.emails.EmailHtmlInterface;
import org.trabalhoPoo.emails.EmailWithAttachmentInterface;
import org.trabalhoPoo.emails.SimpleEmailInterface;

public interface EmailsFactoryInterface {
    /**
     * Retorna um objeto EmailHtmlInterface
     * @param userName - Nome do usuário
     * @param password - Senha do usuário
     * @param to - Destinatário
     * @param subject - Assunto
     * @param htmlMessage - Mensagem em HTML
     * @param altMessage - Mensagem alternativa
     * @return EmailHtmlInterface
     */
    EmailHtmlInterface getEmailHtml(String userName, String password, String to, String subject, String htmlMessage, String altMessage);
    /**
     * Retorna um objeto SimpleEmailInterface
     * @param userName - Nome do usuário
     * @param password - Senha do usuário
     * @param to - Destinatário
     * @param subject - Assunto
     * @param message - Mensagem
     * @return SimpleEmailInterface
     */
    SimpleEmailInterface getSimpleEmail(String userName, String password, String to, String subject, String message);
    /**
     * Retorna um objeto EmailWithAttachmentInterface
     * @param userName - Nome do usuário
     * @param password - Senha do usuário
     * @param to -  Destinatário
     * @param message - Mensagem
     * @param subject - Assunto
     * @param pathAttachment - Caminho do arquivo a ser anexado
     * @param nameAttachment - Nome do arquivo a ser anexado
     * @param descriptionAttachment - Descrição do arquivo a ser anexado
     * @return EmailWithAttachmentInterface
     */
    EmailWithAttachmentInterface getEmailAttachment(String userName, String password, String to, String message, String subject, String pathAttachment, String nameAttachment, String descriptionAttachment);
}
