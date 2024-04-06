package org.CodaFofo;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailManager {
    private final String smtp = "smtp.gmail.com";
    private final int port = 465;
    private String userName;
    private String password;
    ExecutorService executor = Executors.newFixedThreadPool(10);

    public EmailManager(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    /**
     * Send email to many targets
     * @param menssage
     * @param subject
     * @param to
     */
    public void sendEmailToMany(String menssage, String subject, List<String> to) {
       for (String target : to) {
           executor.execute(new EmailMessageRunnble(userName, password,target, menssage, subject));
       }
    }
}
