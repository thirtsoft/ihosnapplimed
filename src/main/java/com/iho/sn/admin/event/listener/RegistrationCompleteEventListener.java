package com.iho.sn.admin.event.listener;


import com.iho.sn.admin.entities.ProfileProperties;
import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.event.RegistrationCompleteEvent;
import com.iho.sn.admin.service.impl.ValidationService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    private final JavaMailSender mailSender;
    private final ValidationService validationService;
    private final ProfileProperties profileProperties;

    @Value("${spring.mail.username}")
    private String configEmail;
    private Utilisateur utilisateur;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        utilisateur = event.getUtilisateur();

        String token = UUID.randomUUID().toString();
        validationService.enregistrerCode(utilisateur, token);

        String url = event.getUrl() + "/utilisateur/activation?code=".concat(token);
        try {
            sendVerificationEmail(url);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        log.info("Click de verification de votre compte :  {}", url);
    }

    private void sendVerificationEmail(String url) throws MessagingException, UnsupportedEncodingException {
        String subject = "Invitation sur l'application SNAPPLIMED";
        String senderName = "Service Médecine";
        String mailContent = "<p> Bonjour, " + utilisateur.getPrenom() + ", </p>" +
                "<p>Le service Médecine Interne l’hôpital est heureux de vous compter parmi ses collaborateurs.<br>" +
                "Vous pouvez cliquer sur le lien ci-dessous pour activer votre compte.</p>" +
                "<a href=\"" + url + "\">activer votre compte</a>" +
                "<p> Cordialement <br> Service d'enregistrement</p>";
        MimeMessage message = mailSender.createMimeMessage();
        var messageHelper = new MimeMessageHelper(message);
        messageHelper.setFrom(configEmail, senderName);
        messageHelper.setTo(utilisateur.getEmail());
        messageHelper.setSubject(subject);
        messageHelper.setText(mailContent, true);
        mailSender.send(message);
    }

    public void sendPasswordResetVerificationEmail(Utilisateur utilisateur, String newPassword) throws MessagingException, UnsupportedEncodingException {
        String subject = "Demande de réinitialisation de mot de passe";
        String senderName = "Service Enregistrement";
        String mailContent = "<p> Bonjour, " + utilisateur.getPrenom() + ", </p>" +
                "<p><b>Vous avez récemment demandé la réinitialisation de votre mot de passe,</b></p>" +
                "<p>Voici votre nouveau mot de passe: " + newPassword + "</p>" +
                "<p>Cordialement <br> Service d'enregistrement</p>";
        MimeMessage message = mailSender.createMimeMessage();
        var messageHelper = new MimeMessageHelper(message);
        messageHelper.setFrom(configEmail, senderName);
        messageHelper.setTo(utilisateur.getEmail());
        messageHelper.setSubject(subject);
        messageHelper.setText(mailContent, true);
        mailSender.send(message);
    }
}