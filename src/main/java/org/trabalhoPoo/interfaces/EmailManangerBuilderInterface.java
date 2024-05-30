package org.trabalhoPoo.interfaces;

import org.trabalhoPoo.implemetations.EmailManangerBuilder;

import java.util.concurrent.ExecutorService;

public interface EmailManangerBuilderInterface {
    EmailManangerBuilderInterface setUserName(String userName);
    EmailManangerBuilderInterface setPassword(String password);
    EmailManangerBuilderInterface setExecutor(ExecutorService executor);
    EmailManangerBuilderInterface setEmailsFactoryInterface(EmailsFactoryInterface emailsFactoryInterface);
    EmailManangerBuilder setUsernameAndPasswor(Object usernameAndPasswor);
    EmailManagerInterface Build();
}

