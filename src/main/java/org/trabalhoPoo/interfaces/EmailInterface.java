package org.trabalhoPoo.interfaces;

public interface EmailInterface extends Runnable {
   String getSmtp();
   void setSmtp(String smtp);
   int getPort() ;
   void setPort(int port);
   String getUserName();
   void setUserName(String userName);
   String getPassword();
   void setPassword(String password);
   String getTo();
    void setTo(String to);
    String getSubject() ;
    void setSubject(String subject);
}
