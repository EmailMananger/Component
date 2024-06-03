package org.trabalhoPoo.emails;

public interface EmailWithAttachmentInterface extends EmailInterface{

    /**
     * Retorna a mensagem do email
     * @return String
     */
    String getMessage();

    /**
     * Seta a mensagem do email
     * @param message
     */
    void setMessage(String message) ;

    /**
     * Retorna o caminho do anexo
     * @return String
     */
    String getPathAttachment();

    /**
     * Seta o caminho do anexo
     * @param pathAttachment
     */
    void setPathAttachment(String pathAttachment);

    /**
     * Retorna o nome do anexo
     * @return String
     */
    String getNameAttachment();

    /**
     * Seta o nome do anexo
     * @param nameAttachment
     */
    void setNameAttachment(String nameAttachment) ;

    /**
     * Retorna a descrição do anexo
     * @return String
     */
    String getDescriptionAttachment();

    /**
     * Seta a descrição do anexo
     * @param descriptionAttachment
     */
    void setDescriptionAttachment(String descriptionAttachment);
}
