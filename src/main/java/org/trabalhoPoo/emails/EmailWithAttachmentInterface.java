package org.trabalhoPoo.emails;

public interface EmailWithAttachmentInterface extends EmailInterface{
    String getMessage();
    void setMessage(String message) ;
     String getPathAttachment();
     void setPathAttachment(String pathAttachment);
     String getNameAttachment();
     void setNameAttachment(String nameAttachment) ;
     String getDescriptionAttachment();
     void setDescriptionAttachment(String descriptionAttachment);
}
