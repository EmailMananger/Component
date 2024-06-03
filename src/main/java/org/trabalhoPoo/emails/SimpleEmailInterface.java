package org.trabalhoPoo.emails;

public interface SimpleEmailInterface extends EmailInterface{
     /**
      * Retorna a mensagem do email
      * @return String
      */
     String getMessage();
     /**
      * Seta a mensagem do email
      * @param message
      */
     void setMessage(String message);
}
