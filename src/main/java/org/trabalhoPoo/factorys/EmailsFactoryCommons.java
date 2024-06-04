package org.trabalhoPoo.factorys;

import org.trabalhoPoo.emails.EmailHtlmRunnable;
import org.trabalhoPoo.emails.EmailWithAttachmentInterfaceRunnable;
import org.trabalhoPoo.emails.SimpleEmailInterfaceRunnable;
import org.trabalhoPoo.emails.EmailHtmlInterface;
import org.trabalhoPoo.emails.EmailWithAttachmentInterface;
import org.trabalhoPoo.emails.SimpleEmailInterface;

/**
 * Classe que implementa a interface EmailsFactoryInterface usando como base o Commons Mail
 */
public class EmailsFactoryCommons implements EmailsFactoryInterface {

    /**
     * Retorna um objeto EmailHtmlInterface
     * @param userName - Nome do usuário
     * @param password - Senha do usuário
     * @param to - Email de destino
     * @param subject - Assunto do email
     * @param htmlMessage - Mensagem em HTML
     * @param altMessage- Mensagem alternativa
     * @return EmailHtmlInterface
     */
    public EmailHtmlInterface getEmailHtml(String userName, String password, String to, String subject, String htmlMessage, String altMessage){
        return new EmailHtlmRunnable(userName, password, to, subject,htmlMessage,altMessage);
    }

    /**
     * Retorna um objeto SimpleEmailInterface
     * @param userName - Nome do usuário
     * @param password - Senha do usuário
     * @param to - Email de destino
     * @param subject - Assunto do email
     * @param message - Mensagem do email
     * @return SimpleEmailInterface
     */
    @Override
    public SimpleEmailInterface getSimpleEmail(String userName, String password, String to, String subject, String message) {
        return new SimpleEmailInterfaceRunnable(userName, password, to, message, subject);
    }

    /**
     * Retorna um objeto EmailWithAttachmentInterface
     * @param userName - Nome do usuário
     * @param password - Senha do usuário
     * @param to - Email de destino
     * @param message - Mensagem do email
     * @param subject - Assunto do email
     * @param pathAttachment -  Caminho do arquivo a ser anexado
     * @param nameAttachment - Nome do arquivo a ser anexado
     * @param descriptionAttachment - Descrição do arquivo a ser anexado
     * @return EmailWithAttachmentInterface
     */
    @Override
    public EmailWithAttachmentInterface getEmailAttachment(String userName, String password, String to, String message, String subject, String pathAttachment, String nameAttachment, String descriptionAttachment) {
        return new EmailWithAttachmentInterfaceRunnable(userName, password, to, message, subject, pathAttachment, nameAttachment, descriptionAttachment);
        }
}

