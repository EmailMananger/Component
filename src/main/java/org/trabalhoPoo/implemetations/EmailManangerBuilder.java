package org.trabalhoPoo.implemetations;

import org.trabalhoPoo.anotations.Password;
import org.trabalhoPoo.anotations.User;
import org.trabalhoPoo.factorys.EmailsFactoryCommons;
import org.trabalhoPoo.interfaces.EmailManagerInterface;
import org.trabalhoPoo.interfaces.EmailManangerBuilderInterface;
import org.trabalhoPoo.factorys.EmailsFactoryInterface;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Classe que implementa a interface EmailManangerBuilderInterface e é responsável por construir o objeto EmailManager
 * */
public class EmailManangerBuilder implements EmailManangerBuilderInterface{
    /**
     * Atributos da classe
     */
    private String userName = null;
    private String password = null;
    private ExecutorService executor = Executors.newFixedThreadPool(10);
    private EmailsFactoryInterface emailsFactoryInterface = new EmailsFactoryCommons();
    private Object usernameAndPasswor = null;
    public EmailManangerBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public EmailManangerBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public EmailManangerBuilder setExecutor(ExecutorService executor) {
        this.executor = executor;
        return this;
    }

    public EmailManangerBuilder setEmailsFactoryInterface(EmailsFactoryInterface emailsFactoryInterface) {
        this.emailsFactoryInterface = emailsFactoryInterface;
        return this;
    }

    public EmailManangerBuilder setUsernameAndPasswor(Object usernameAndPasswor) {
        this.usernameAndPasswor = usernameAndPasswor;
        return this;
    }

    public static EmailManangerBuilderInterface builder(){
        return new EmailManangerBuilder();
    }

    /**
     * Constroi o objeto EmailManager
     * @return EmailManagerInterface
     */
    @Override
    public EmailManagerInterface Build() {
        EmailManager emailManager = new EmailManager();
        //Tenta preencher usuario e senha
        if (this.userName != null && this.password != null) {
            emailManager.setUserName(this.userName);
            emailManager.setPassword(this.password);
        }else if(this.usernameAndPasswor!=null){
            if (!preencherUsuarioSenha(this.usernameAndPasswor)){
                throw new RuntimeException("Não foi possível preencher o usuário e senha");
            }
        }
        //Seta o username
        emailManager.setUserName(this.userName);
        //Seta a senha
        emailManager.setPassword(this.password);
        //Seta o Emails factory
        emailManager.setEmailsFactoryInterface(this.emailsFactoryInterface);
        //Seta o executor
        emailManager.setExecutor(this.executor);
        //Reseta os valores
        resetValues();
        //retorna objeto preenchido
        return emailManager;
    }

    /**
     * Reseta os valores do builder
     */
    private void resetValues(){
        this.userName = null;
        this.password = null;
        this.executor = Executors.newFixedThreadPool(10);
        this.emailsFactoryInterface = new EmailsFactoryCommons();
        this.usernameAndPasswor = null;
    }
    /**
     * Preenche o usuario e senha a partir de um objeto com anotações
     * @param usernameAndPasswor
     * @return
     */
    private boolean preencherUsuarioSenha(Object usernameAndPasswor) {
        boolean userPreenchido=false,passwordPreenchido = false;
        Class<?> classe = usernameAndPasswor.getClass();
        Field[] atributos = classe.getDeclaredFields();
        for(Field atributo : atributos){
            atributo.setAccessible(true);
            if (atributo.isAnnotationPresent(User.class)){
                try {
                    this.userName = (String) atributo.get(usernameAndPasswor);
                    userPreenchido = true;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }else if (atributo.isAnnotationPresent(Password.class)){
                try {
                    this.password = (String) atributo.get(usernameAndPasswor);
                    passwordPreenchido = true;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return userPreenchido && passwordPreenchido;
    }
}
