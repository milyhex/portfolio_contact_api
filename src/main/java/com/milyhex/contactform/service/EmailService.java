package com.milyhex.contactform.service;

import com.milyhex.contactform.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(ContactForm form) {
        logger.info("📨 Enviando email desde: {}", form.getEmail());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("milype1998@gmail.com"); 
            message.setSubject("Nuevo mensaje desde el portfolio");
            message.setText(
                "Nombre: " + form.getName() + "\n" +
                "Email: " + form.getEmail() + "\n" +
                "Mensaje:\n" + form.getMessage()
            );

            mailSender.send(message);
            logger.info("✅ Email enviado correctamente.");
        } catch (Exception e) {
            logger.error("❌ Error al enviar el email", e);
        }
    }
}
