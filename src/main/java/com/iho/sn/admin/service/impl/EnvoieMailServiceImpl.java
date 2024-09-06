package com.iho.sn.admin.service.impl;

import com.iho.sn.admin.entities.ProfileProperties;
import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.service.EnvoieMailService;
import freemarker.template.Template;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import freemarker.template.Configuration;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EnvoieMailServiceImpl implements EnvoieMailService {

    private final JavaMailSender sender;

    private final Configuration freemarkerConfig;

    @Autowired
    private ProfileProperties profileProperties;

    @Value("${spring.mail.username}")
    private String configEmail;



    @Override
    @Async
    public void sendMailCreationUser(Utilisateur utilisateur) throws Exception {
        String first_Connexion = profileProperties.getFrontendUrlAccess() + "/login-page/first-time/";
        String senderName = profileProperties.getSenderName();
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        Map<String, Object> model = new HashMap();
        model.put("url", first_Connexion + utilisateur.getActivation());
        model.put("nomUser", utilisateur.getNom());
        model.put("prenomUser", utilisateur.getPrenom());
        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/");
        Template t = freemarkerConfig.getTemplate("admin/creation-user.ftl");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        helper.setFrom(new InternetAddress(configEmail, senderName));
        helper.setTo(utilisateur.getEmail());
        helper.setText(text, true);
        helper.setSubject("Invitation sur l'application SNAPPLIMED");
        try {
            sender.send(message);
        } catch (Exception e) {
			throw new Exception("Erreur à l'envoi du mail");
        }
    }

    @Override
    @Async
    public void sendMailForgotPass(Utilisateur utilisateur, String motDePasse) throws Exception {
        String host_front = profileProperties.getFrontendUrlAccess();
        String senderName = profileProperties.getSenderName();
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        Map<String, Object> model = new HashMap();
        model.put("url", host_front);
        model.put("nomUser", utilisateur.getNom());
        model.put("prenomUser", utilisateur.getPrenom());
        model.put("email", utilisateur.getEmail());
        model.put("motdepasse", motDePasse);
        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/");
        Template t = freemarkerConfig.getTemplate("admin/mot_de_passe_oublie.ftl");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        helper.setFrom(new InternetAddress(configEmail, senderName));
        helper.setTo(utilisateur.getEmail());
        helper.setText(text, true);
        helper.setSubject("Réinitialisation de votre mot de passe");
        try {
            sender.send(message);
        } catch (Exception e) {
            throw new Exception("Erreur à l'envoi du mail");
        }
    }

    @Override
    public void sendMailUpdatePass(Utilisateur user) throws Exception {
        String host_front = profileProperties.getFrontendUrlAccess();
        String senderName = profileProperties.getSenderName();
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        Map<String, Object> model = new HashMap();
        model.put("url", host_front);
        model.put("nomUser", user.getNom());
        model.put("prenomUser", user.getPrenom());
        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/");
        Template t = freemarkerConfig.getTemplate("admin/mot_de_passe_modidier.ftl");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        helper.setFrom(new InternetAddress(configEmail, senderName));
        helper.setTo(user.getEmail());
        helper.setText(text, true); // set to html
        helper.setSubject("Changement de votre mot de passe");
        try {
            sender.send(message);
        } catch (Exception e) {
            throw new Exception("Erreur à l'envoi du mail");
        }
    }


}
