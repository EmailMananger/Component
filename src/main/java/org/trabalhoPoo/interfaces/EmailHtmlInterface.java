package org.trabalhoPoo.interfaces;

public interface EmailHtmlInterface extends EmailInterface{
    String getHtmlMessage();
    void setHtmlMessage(String htmlMessage);
    String getAltMessage();
    void setAltMessage(String altMessage);
}
