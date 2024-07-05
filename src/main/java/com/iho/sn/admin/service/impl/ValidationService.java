package com.iho.sn.admin.service.impl;


import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.entities.Validation;
import com.iho.sn.admin.repository.ValidationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.HOURS;

@AllArgsConstructor
@Service
public class ValidationService {

    private ValidationRepository validationRepository;

    public void enregistrerCode(Utilisateur utilisateur, String token) {
        Validation validation = new Validation();
        validation.setUtilisateur(utilisateur);
        Instant creation = Instant.now();
        validation.setCreation(creation);
        Instant expiration = creation.plus(24, HOURS);
        validation.setExpiration(expiration);
        validation.setCode(token);

        this.validationRepository.save(validation);
    }

    public Validation lireEnFonctionDuCode(String code) {
        return this.validationRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Votre code est invalid"));
    }
}