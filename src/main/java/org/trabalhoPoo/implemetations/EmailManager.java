package org.trabalhoPoo.implemetations;

import org.trabalhoPoo.anotations.Password;
import org.trabalhoPoo.anotations.User;
import org.trabalhoPoo.factorys.EmailsFactory;
import org.trabalhoPoo.interfaces.EmailManagerInterface;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class EmailManager implements EmailManagerInterface {
    Logger logger = Logger.getLogger(getClass().getName());
    private String userName;
    private String password;
    private ExecutorService executor = Executors.newFixedThreadPool(10);
    private EmailsFactory emailsFactory = new EmailsFactory();
    /**
     * Construtor que recebe como parametro o nome do usuario e a senha como string. Usa como padrão o smtp do gmail e a porta 465.
     * @param userName Nome do usuário da conta que enviará o email
     * @param password Senha da que enviará o email
     */
    public EmailManager(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    /**
     * Construtor que recebe como parametro um objeto genérico com os atributos usuario, senha anotados
     * @param objeto
     */
    public EmailManager(Object objeto) {
        List<String> invalidos = new ArrayList<>();
        Class<?> classe = objeto.getClass();
        Field[] atributos = classe.getDeclaredFields();
        for(Field atributo : atributos){
            atributo.setAccessible(true);
            if (atributo.isAnnotationPresent(User.class)){
                try {
                    this.userName = (String) atributo.get(objeto);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }else if (atributo.isAnnotationPresent(Password.class)){
                try {
                    this.password = (String) atributo.get(objeto);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
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
               executor.execute(emailsFactory.getSimpleEmail(userName, password,target, message, subject));
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
               executor.execute(emailsFactory.getEmailHtml(userName, password, target, subject, htmlMessage, altMessage));
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
                        executor.execute(emailsFactory.getEmailAttachment(userName, password,target, message, subject, pathAttachment, nameAttachment, descriptionAttachment));
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
    private static boolean validateEmail(String email){
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    private static boolean lengthOfFile(File file){
        return file.length()<25000000;
    }
}
