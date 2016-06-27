package models;

/**
 * Created by r730819 on 6/27/2016.
 */
public class EmailMessageTemplate {
    private String toEmail;
    private String fromEmail;
    private String subject;
    private String message;

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

        stringBuilder.append("To: " + toEmail + "\n");
        stringBuilder.append("From: " + fromEmail + "\n");
        stringBuilder.append("Subject: " + subject + "\n");
        stringBuilder.append("Message: " + message + "\n");

        return stringBuilder.toString();
    }

}
