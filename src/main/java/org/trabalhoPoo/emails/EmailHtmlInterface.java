package org.trabalhoPoo.emails;

public interface EmailHtmlInterface extends EmailInterface{
    String getHtmlMessage();
    void setHtmlMessage(String htmlMessage);
    String getAltMessage();
    void setAltMessage(String altMessage);
}
