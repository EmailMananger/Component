package org.trabalhoPoo.enums;

public enum EmailsTypes {
    SIMPLEEMAIL(1),HTMLEMAIL(2),EMAILWITHATTACHMENT(3);

    public int typeEmail;


    EmailsTypes(int value) {
        typeEmail=value;
    }
}
