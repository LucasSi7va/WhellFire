package com.WhellsFirePB.WhellsFirePB.ServiceEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jersey.JerseyProperties.Servlet;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.mail.internet.MimeMessage;


@Service
public class EmailService {
@Autowired
    private JavaMailSender mailSender;

@Value("${spring.mail.username}")
    private String from;


public void sendVerificationEmail(String email , String verificationToken) {
String subject = "Email Verification";
String path = "/cadastro/verify?token=" + verificationToken;
String message = "Please click the link below to verify your email address:\n";
sendEmail(email,  verificationToken , subject, path ,message );
}


public void sendForgotPasswordEmail(String email, String resetToken) {
    String subJect = "Password Reset Request";
    String path = "/forgot-password/reset?token=" + resetToken;
    String message = "Please click the link below to reset your password:\n";
    sendEmail(email,  resetToken , subJect,  path , message);
}


private void sendEmail(String email, String token, String subject, String path, String message) {

try{
     String actionUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
            .queryParam("token", token)
            .toUriString();

   String content = """
                <div style="font-family: Arial, sans-serif; max-width: 600px; margin: auto; padding: 20px; border-radius: 8px; background-color: #f9f9f9;">
                    <h2 style="color: #333;">%s</h2>
                    <p style="font-size: 16px; color: #555;">%s</p>
                    <p><a href="%s" style="display: inline-block; padding: 10px 20px; background-color: #007BFF; color: white; text-decoration: none; border-radius: 4px;">Click Here</a></p>
                    <p style="font-size: 14px; color: #999;">If you did not request this, please ignore this email.</p>
                </div>
                """.formatted(subject, message, actionUrl);


            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setTo(email);
            helper.setSubject(subject);
            helper.setFrom(from);
            helper.setText(content, true);
            mailSender.send(mimeMessage);


} catch (Exception e) {
    e.printStackTrace();
    System.out.println("Error sending email: " + e.getMessage());

}
}
}