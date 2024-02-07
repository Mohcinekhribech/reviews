package com.youcode.reviews.app.mail;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MailController {
    private MailService emailService;

    @GetMapping("/sendEmail")
    public String sendEmail() {
        emailService.sendSimpleMessage("mohcinekhribche123@gmail.com", "Test Subject", "Test Message");
        return "Email sent successfully!";
    }
}
