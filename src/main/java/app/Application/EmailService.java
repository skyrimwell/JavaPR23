package app.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;


public class EmailService {
    @Autowired
    public JavaMailSender emailSender;

    @Async
    public void SendEmail(){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("skyrimwell@gmail.com");
        message.setSubject("Test Simple Email");
        message.setText("Hello, Im testing Simple Email");
        // Send Message!
        this.emailSender.send(message);
        System.out.println("Email sent");
    }
}
