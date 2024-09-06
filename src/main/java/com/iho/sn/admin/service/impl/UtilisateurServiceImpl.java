package com.iho.sn.admin.service.impl;


import com.iho.sn.admin.entities.Profil;
import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.event.RegistrationCompleteEvent;
import com.iho.sn.admin.event.listener.RegistrationCompleteEventListener;
import com.iho.sn.admin.remote.model.ActivationDs;
import com.iho.sn.admin.repository.ProfilRepository;
import com.iho.sn.admin.repository.UtilisateurRepository;
import com.iho.sn.admin.service.EnvoieMailService;
import com.iho.sn.admin.service.UtilisateurService;
import com.iho.sn.exception.AlreadyExistsException;
import com.iho.sn.exception.EntityNotFoundException;
import com.iho.sn.message.Message;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import static com.iho.sn.utils.UtilString.generateCommonsLang3Password;
import static com.iho.sn.utils.UtilString.genererMatricule;
import static java.lang.String.format;


@AllArgsConstructor
@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    private static final String UTILISATEUR_INCONNU = "Utilisateur inconnu";

    private final UtilisateurRepository utilisateurRepository;
    private final ValidationService validationService;
    private final ApplicationEventPublisher publisher;
    private final PasswordEncoder passwordEncoder;
    private final RegistrationCompleteEventListener eventListener;
    private final ProfilRepository profilRepository;
    private final EnvoieMailService envoieMailService;

    @Override
    public Long saveUtilisateur(Utilisateur utilisateur, String url) {
        if (utilisateur == null)
            throw new AlreadyExistsException(Message.NULL_OBJECT);
        Optional<Utilisateur> byCode = utilisateurRepository.findUtilisateurByCodeUtilisateur(utilisateur.getCodeUtilisateur());
        if (utilisateur.getId() == null && byCode.isPresent()
                || (utilisateur.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(utilisateur.getId()))) {
            throw new AlreadyExistsException(format("Le code %s est déjà associé à un compte utilisateur .", utilisateur.getCodeUtilisateur()));
        }
        String email = utilisateur.getEmail();
        Optional<Utilisateur> byEmail = utilisateurRepository.findUtilisateurByEmail(email);
        if (utilisateur.getId() == null && byEmail.isPresent()
                || (utilisateur.getId() != null && byEmail.isPresent() && !byEmail.get().getId().equals(utilisateur.getId()))) {
            throw new AlreadyExistsException(format("L'email %s est déjà associé à un compte utilisateur .", email));
        }
        String telephone = utilisateur.getTelephone();
        Optional<Utilisateur> byTelephone = utilisateurRepository.findUtilisateurByTelephone(telephone);
        if (utilisateur.getId() == null && byTelephone.isPresent()
                || (utilisateur.getId() != null && byTelephone.isPresent() && !byTelephone.get().getId().equals(utilisateur.getId()))) {
            throw new AlreadyExistsException(format("Le numéro de téléphone %s est déjà associé à un compte utilisateur .", telephone));
        }
        utilisateur.setMatricule(genererMatricule());
        String defaultPassword = generateCommonsLang3Password();
        utilisateur.setMotdepasse(passwordEncoder.encode(defaultPassword));
        utilisateur.setEst_valide(true);
        var savedUser = utilisateurRepository.saveAndFlush(utilisateur);
        publisher.publishEvent(new RegistrationCompleteEvent(savedUser, url));
        return savedUser.getId();
    }

    @Override
    public void creerUtilisateur(Utilisateur utilisateur) throws Exception {
        String defaultPassword = RandomStringUtils.randomAlphanumeric(8);
        if (utilisateur == null)
            throw new AlreadyExistsException(Message.NULL_OBJECT);
        Optional<Utilisateur> byCode = utilisateurRepository.findUtilisateurByCodeUtilisateur(utilisateur.getCodeUtilisateur());
        if (utilisateur.getId() == null && byCode.isPresent()
                || (utilisateur.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(utilisateur.getId()))) {
            throw new AlreadyExistsException(format("Le code %s est déjà associé à un compte utilisateur .", utilisateur.getCodeUtilisateur()));
        }
        String email = utilisateur.getEmail();
        Optional<Utilisateur> byEmail = utilisateurRepository.findUtilisateurByEmail(email);
        if (utilisateur.getId() == null && byEmail.isPresent()
                || (utilisateur.getId() != null && byEmail.isPresent() && !byEmail.get().getId().equals(utilisateur.getId()))) {
            throw new AlreadyExistsException(format("L'email %s est déjà associé à un compte utilisateur .", email));
        }
        String telephone = utilisateur.getTelephone();
        Optional<Utilisateur> byTelephone = utilisateurRepository.findUtilisateurByTelephone(telephone);
        if (utilisateur.getId() == null && byTelephone.isPresent()
                || (utilisateur.getId() != null && byTelephone.isPresent() && !byTelephone.get().getId().equals(utilisateur.getId()))) {
            throw new AlreadyExistsException(format("Le numéro de téléphone %s est déjà associé à un compte utilisateur .", telephone));
        }
        utilisateur.setMatricule(genererMatricule());
        utilisateur.setMotdepasse(passwordEncoder.encode(defaultPassword));
        utilisateur.setActif(true);
        do {
            utilisateur.setActivation(RandomStringUtils.randomAlphanumeric(15));
        } while (utilisateurRepository.findMailByActivation(utilisateur.getActivation()) != null);

        utilisateur.setEst_valide(true);
        var savedUser = utilisateurRepository.saveAndFlush(utilisateur);
        envoieMailService.sendMailCreationUser(savedUser);
    }

    @Override
    public Utilisateur findUtilisateurById(Long utilisateurId) {
        if (utilisateurId == null) {
            return null;
        }
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurById(utilisateurId);
        Profil profil = profilRepository.findProfilById(utilisateur.getProfil().getId());
        utilisateur.setProfil(profil);
        return utilisateur;
    }

    @Override
    public Utilisateur findUserById(Long utilisateurId) {
        return utilisateurRepository.findUtilisateurById(utilisateurId);
    }

    @Override
    public List<Utilisateur> findAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur findUtilisateurByEmail(String mail) {
        return utilisateurRepository.findByEmail(mail)
                .orElseThrow(() -> new EntityNotFoundException(UTILISATEUR_INCONNU));
    }

    @Override
    public Utilisateur updateUserPass(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public String lireEnFonctionDuCode(String code) {
        var validation = validationService.lireEnFonctionDuCode(code);
        Utilisateur utilisateur = utilisateurRepository.findById(validation.getUtilisateur().getId())
                .orElseThrow(() -> new EntityNotFoundException(UTILISATEUR_INCONNU));
        return utilisateur.getEmail();
    }

    @Override
    public void createdPassword(String email, String password) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(UTILISATEUR_INCONNU));
        utilisateur.setMotdepasse(passwordEncoder.encode(password));
        utilisateur.setActif(true);
    }

    @Override
    public void changePassword(Utilisateur theUser, String newPassword) {
        theUser.setMotdepasse(passwordEncoder.encode(newPassword));
        utilisateurRepository.save(theUser);
    }

    @Override
    public boolean oldPasswordIsValid(Utilisateur user, String ancienMotDePasse) {
        return passwordEncoder.matches(ancienMotDePasse, user.getPassword());
    }

    @Override
    public void demandeResetMotDePasse(String email) {
        Utilisateur utilisateur = this.findUtilisateurByEmail(email);
        String newPassword = generateCommonsLang3Password();
        utilisateur.setMotdepasse(passwordEncoder.encode(newPassword));
        try {
            eventListener.sendPasswordResetVerificationEmail(utilisateur, newPassword);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Utilisateur findUtilisateurByMatricule(String matricule) {
        return utilisateurRepository.findUtilisateurByMatricule(matricule);
    }

    @Override
    public void deleteUtilisateur(String email) {
        var utilisateur = this.findUtilisateurByEmail(email);
        utilisateur.setActif(false);
    }

    @Override
    public List<Utilisateur> findAllMedecins() {
        return utilisateurRepository.findAllMedecins();
    }

    @Override
    public void activatedAccount(String matricule) {
        var utilisateur = this.findUtilisateurByMatricule(matricule);
        utilisateur.setActif(true);
    }

    @Override
    public void deactivatedAccount(String matricule) {
        var utilisateur = this.findUtilisateurByMatricule(matricule);
        utilisateur.setActif(false);
    }

    @Override
    public ResponseEntity<ActivationDs> findUserForActivation(String code) {
        ActivationDs activationDs = new ActivationDs();
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurByActivation(code);
        if(utilisateur != null) {
            activationDs.setEmail(utilisateur.getEmail());
        }
        if(activationDs.getEmail() != null)
            return ResponseEntity.ok(activationDs);
        activationDs.setMessage("Code activation introuvable");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(activationDs);
    }
}