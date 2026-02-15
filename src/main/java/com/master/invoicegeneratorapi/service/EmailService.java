package com.master.invoicegeneratorapi.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.properties.mail.smtp.from}")
    private String fromEmail;

    public void sendInvoiceEmail(String toEmail, MultipartFile file) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(fromEmail);
        helper.setTo(toEmail);
        helper.setSubject("Your Invoice");
    	// Designing the HTML Email Body
		String htmlContent = 
			    "<html>" +
			    "<body style='font-family: Arial, sans-serif; color: #333;'>" +
			    "  <p>Dear Customer,</p>" +
			    "  <p>Thank you for your purchase. Please find your invoice attached for your reference.</p>" +
			    "  <p>If you have any questions, feel free to contact us.</p>" +
			    "  <br/>" +
			    "  <p>Kind regards,<br/>" +
			    "  <strong>Finance Team</strong></p>" +
			    "</body>" +
			    "</html>";

		// Set to true to indicate the text is HTML
		helper.setText(htmlContent, true);

		// Attaching the MultipartFile
		if (file != null && !file.isEmpty()) {
			String fileName = "Invoice_"+System.currentTimeMillis()+".pdf";
			helper.addAttachment(fileName, new ByteArrayResource(file.getBytes()));
		}

		mailSender.send(message);
    }
}
