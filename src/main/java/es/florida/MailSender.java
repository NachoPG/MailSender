package es.florida;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.io.IOException;

public class MailSender implements Runnable {

    private String email;
    private String subject;
    private String message;

    public MailSender(String email, String subject, String message) {
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            sendEmail(email, subject, message);

        } catch (InterruptedException | IOException | EmailException e) {
            e.printStackTrace();
        }
    }

    private void sendEmail(String email, String subject, String message) throws InterruptedException, IOException, EmailException {
        Email emailSend = new SimpleEmail();
        emailSend.setHostName("localhost");
        emailSend.setSmtpPort(1025);
        emailSend.setFrom("serverbroker@gmail.com");
        emailSend.setSubject(subject);
        emailSend.setMsg(message);
        emailSend.addTo(email);
        emailSend.send();
    }
}
