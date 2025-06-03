package com.milyhex.contactform.controller;

import com.milyhex.contactform.model.ContactForm;
import com.milyhex.contactform.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins = { "http://localhost:5500", "http://127.0.0.1:5500" })
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private EmailService emailService;

    @PostMapping("/contact")
    public ResponseEntity<String> sendContact(@RequestBody ContactForm form) {
        logger.info("📬 POST /contact recibido");
        logger.info("🧑 Nombre: {}, 📧 Email: {}", form.getName(), form.getEmail());

        emailService.sendContactEmail(form);

        logger.info("✅ Email procesado con éxito, devolviendo 200 OK");
        return ResponseEntity.ok("Mensaje enviado con éxito 💌");
    }
}
