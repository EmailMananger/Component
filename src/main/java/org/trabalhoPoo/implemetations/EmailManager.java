package org.trabalhoPoo.implemetations;

import org.trabalhoPoo.interfaces.EmailManagerInterface;
import org.trabalhoPoo.interfaces.EmailsFactoryInterface;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;

public class EmailManager implements EmailManagerInterface {
    Logger logger = Logger.getLogger(getClass().getName());
    private String userName;
    private String password;
    private ExecutorService executor;
    private EmailsFactoryInterface emailsFactoryInterface;

    /**
     * Construtor padrão
     */
    public EmailManager() {
    }


    /**
     * Seta o nome de usuário
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Seta a senha
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Seta o executor
     * @param executor
     */
    public void setExecutor(ExecutorService executor) {
        this.executor = executor;
    }

    /**
     * Seta a fábrica de emails
     * @param emailsFactoryInterface
     */
    public void setEmailsFactoryInterface(EmailsFactoryInterface emailsFactoryInterface) {
        this.emailsFactoryInterface = emailsFactoryInterface;
    }

    /**
     * Envia um email simples para uma lista de destinatários
     * @param message Mensagem do email que será enviado
     * @param subject Assunto do email que será enviado
     * @param to Lista de destinatários do email
     */
    public void sendSimpleEmailToMany(List<String> to, String message, String subject ) {
       for (String target : to) {
           if (validateEmail(target)) {
               executor.execute(emailsFactoryInterface.getSimpleEmail(userName, password,target, message, subject));
           }else {
               logger.warning("Email inválido: "+target);
           }
       }
    }

    /**
     * Envia um simples email HTML para uma lista de destinatários
     * @param htmlMessage Mensagem em HTML do email que será enviado
     * @param subject Assunto do email que será enviado
     * @param to Lista de destinatários do email
     * @param altMessage Mensagem alternativa do email que será enviado caso o cliente de email não suporte HTML
     */
    public void sendSimpleEmailHtmlToMany(  List<String> to, String htmlMessage, String subject, String altMessage) {
        for (String target : to) {
           if (validateEmail(target)) {
               executor.execute(emailsFactoryInterface.getEmailHtml(userName, password, target, subject, htmlMessage, altMessage));
           }else {
               logger.warning("Email inválido: "+target);
           }
       }
    }

    /**
     * Envia um email com anexo para uma lista de destinatários
     * @param message Mensagem do email que será enviado
     * @param subject Assunto do email que será enviado
     * @param to Lista de destinatários do email
     * @param pathAttachment Caminho do arquivo a ser anexado
     * @param nameAttachment Nome do arquivo a ser anexado
     * @param descriptionAttachment Descrição do arquivo a ser anexado
     */
    public void sendSimpleEmailWithAttachmentToMany(List<String> to, String message, String subject, String pathAttachment, String nameAttachment, String descriptionAttachment) {
        File file = new File(pathAttachment);
        if (file.exists()){
            if (lengthOfFile(file)){
                for (String target : to) {
                    if (validateEmail(target)) {
                        executor.execute(emailsFactoryInterface.getEmailAttachment(userName, password,target, message, subject, pathAttachment, nameAttachment, descriptionAttachment));
                    }else {
                        logger.warning("Email inválido: "+target);
                    }
                }
            }else {
                logger.warning("Arquivo muito grande para ser anexado: "+pathAttachment);
            }
        }else {
            logger.warning("Arquivo não encontrado: "+pathAttachment);
        }

    }
    /**
     * Valida se o email é válido
     * @param email
     * @return
     */
    private static boolean validateEmail(String email){
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    /**
     * Verifica se o arquivo é menor que 25MB
     * @param file
     * @return
     */
    private static boolean lengthOfFile(File file){
        return file.length()<25000000;
    }
}
