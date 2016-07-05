package com.heb.assortment.core.models;

/**
 * Created by r730819 on 6/27/2016.
 *
 * Email message template that is pre populated
 * with settings values.
 *
 * Is also used when finally sending the message
 * and populating the body in html with message
 */
public class EmailMessageTemplate {
    private String toEmail;
    private String fromEmail;
    private String subject;
    private String message;

    //Constructors
    public EmailMessageTemplate(String fromEmail) {
        this.fromEmail = fromEmail;
    }
    public EmailMessageTemplate(){}

    //Getters and settings
    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString(){
        String emailString = "";
        StringBuilder stringBuilder = new StringBuilder(emailString);

        stringBuilder.append("To: ").append(toEmail).append("\n");
        stringBuilder.append("From: ").append(fromEmail).append("\n");
        stringBuilder.append("Subject: ").append(subject).append("\n");
        stringBuilder.append("Message: ").append(message).append("\n");

        return stringBuilder.toString();
    }

}
