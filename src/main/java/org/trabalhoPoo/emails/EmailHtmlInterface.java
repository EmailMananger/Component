package org.trabalhoPoo.emails;

public interface EmailHtmlInterface extends EmailInterface{
    /**
     * Retorna a mensagem em html
     * @return String
     */
    String getHtmlMessage();

    /**
     * Seta a mensagem em html
     * @param htmlMessage
     */
    void setHtmlMessage(String htmlMessage);

    /**
     * Retorna a mensagem alternativa
     * @return String
     */
    String getAltMessage();

    /**
     * Seta a mensagem alternativa
     * @param altMessage
     */
    void setAltMessage(String altMessage);
}
