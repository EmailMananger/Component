package org.trabalhoPoo.interfaces;

import org.trabalhoPoo.factorys.EmailsFactoryInterface;
import org.trabalhoPoo.implemetations.EmailManangerBuilder;

import java.util.concurrent.ExecutorService;

/**
 * Interface para construção do EmailManager
 */
public interface EmailManangerBuilderInterface {

    /**
     * Seta o username da conta que irá enviar os emails
     * @param userName
     * @return
     */
    EmailManangerBuilderInterface setUserName(String userName);

    /**
     * Seta a senha da conta que irá enviar os emails
     * @param password
     * @return
     */
    EmailManangerBuilderInterface setPassword(String password);

    /**
     * Seta o executors que irá enviar os emails em threads separadas
     * @param executor
     * @return
     */
    EmailManangerBuilderInterface setExecutor(ExecutorService executor);

    /**
     * Seta a factory que irá criar os emails
     * @param emailsFactoryInterface
     * @return
     */
    EmailManangerBuilderInterface setEmailsFactoryInterface(EmailsFactoryInterface emailsFactoryInterface);

    /**
     * Seta o username e senha da conta que irá enviar os emails a partir de um obejto com anotações
     * @param usernameAndPasswor
     * @return
     */
    EmailManangerBuilder setUsernameAndPasswor(Object usernameAndPasswor);

    /**
     * Constroi o EmailManager
     * @return
     */
    EmailManagerInterface Build();
}

