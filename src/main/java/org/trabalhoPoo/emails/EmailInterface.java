package org.trabalhoPoo.emails;

public interface EmailInterface extends Runnable {
    /**
     * Retorna o smtp
     * @return String
     */
   String getSmtp();

    /**
     * Seta o smtp
     * @param smtp
     */
   void setSmtp(String smtp);

   /**
    * Retorna a porta
    * @return int
    */
   int getPort() ;

   /**
    * Seta a porta
    * @param port
    */
   void setPort(int port);

   /**
    * Retorna o nome de usuário
    * @return String
    */
   String getUserName();

   /**
    * Seta o nome de usuário
    * @param userName
    */
   void setUserName(String userName);

   /**
    * Retorna a senha
    * @return String
    */
   String getPassword();

   /**
    * Seta a senha
    * @param password
    */
   void setPassword(String password);

   /**
    * Retorna o destinatário
    * @return String
    */
   String getTo();

   /**
    * Seta o destinatário
    * @param to
    */
   void setTo(String to);

   /**
    * Retorna o assunto
    * @return String
    */
   String getSubject() ;

    /**
     * Seta o assunto
     * @param subject
     */
    void setSubject(String subject);
}
