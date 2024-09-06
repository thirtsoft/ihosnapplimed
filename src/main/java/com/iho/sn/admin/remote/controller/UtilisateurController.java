package com.iho.sn.admin.remote.controller;

import com.iho.sn.admin.assembler.UtilisateurAssembler;
import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.remote.controller.api.UtilisateurApi;
import com.iho.sn.admin.remote.model.ActivationDs;
import com.iho.sn.admin.remote.model.ActivationRequest;
import com.iho.sn.admin.remote.model.ChangerMotDePasseRequest;
import com.iho.sn.admin.remote.model.ListeUtilisateurDs;
import com.iho.sn.admin.remote.model.ResponseMassageDs;
import com.iho.sn.admin.remote.model.UtilisateurDs;
import com.iho.sn.admin.remote.model.UtilisateurProfilDs;
import com.iho.sn.admin.service.UtilisateurService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.iho.sn.utils.UtilString.getUrl;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@Transactional
@AllArgsConstructor
public class UtilisateurController implements UtilisateurApi {

    private final UtilisateurService utilisateurService;
    private final UtilisateurAssembler utilisateurAssembler;

    @Override
    public ResponseMassageDs creerUtilisateur(UtilisateurDs utilisateurDs, HttpServletRequest request) {
        Utilisateur utilisateur = utilisateurAssembler.assembleUtilisateurFromDs(utilisateurDs);
        try {
            Long id = utilisateurService.saveUtilisateur(utilisateur, getUrl(request));
            return new ResponseMassageDs("OK", id.toString());
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseMassageDs saveUtilisateur(UtilisateurDs utilisateurDs) {
        Utilisateur utilisateur = utilisateurAssembler.assembleUtilisateurFromDs(utilisateurDs);
        try {
            utilisateurService.creerUtilisateur(utilisateur);
            return new ResponseMassageDs("OK", "L'utilisateur a été crée avec succès");
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<UtilisateurDs> updateUtilisateur(UtilisateurDs utilisateurDs) {
        Utilisateur utilisateur = utilisateurAssembler.assembleUtilisateurForUpdateDs(utilisateurDs);
        return new ResponseEntity<>(utilisateurAssembler
                .assembleUtilisateurDsFromEntity(utilisateurService.updateUserPass(utilisateur)), OK);
    }

    @Override
    public ResponseEntity<UtilisateurDs> findUtilisateurById(Long id) {
        return new ResponseEntity<>(utilisateurAssembler
                .assembleUtilisateurDsFromEntity(utilisateurService.findUtilisateurById(id)), OK);
    }

    @Override
    public ResponseEntity<List<ListeUtilisateurDs>> findAllUtilisateurs() {
        return new ResponseEntity<>(utilisateurAssembler
                .assembleListeUtilisateurDsFrom(utilisateurService.findAllUtilisateurs()), OK);
    }

    @Override
    public ResponseEntity<Void> deleteUtilisateur(String email) {
        utilisateurService.deleteUtilisateur(email);
        return new ResponseEntity<>(OK);
    }

    @Override
    public ResponseEntity<UtilisateurProfilDs> findUtilisateurProfil(Long id) {
        return new ResponseEntity<>(utilisateurAssembler
                .assembleUtilisateurProfilDsFromEntity(utilisateurService.findUserById(id)), OK);
    }

    @Override
    public ResponseEntity<String> resetPasswordRequest(ChangerMotDePasseRequest changerMotDePasseRequest,
                                                       HttpServletRequest request) {
        utilisateurService.demandeResetMotDePasse(changerMotDePasseRequest.getEmail());
        return new ResponseEntity<>("Le mot de passe a été réinitialisé avec succès", CREATED);
    }

    @Override
    public ResponseEntity<String> changePassword(ChangerMotDePasseRequest requestUtil) {
        Utilisateur user = utilisateurService.findUtilisateurByEmail(requestUtil.getEmail());
        if (!utilisateurService.oldPasswordIsValid(user, requestUtil.getAncienMotDePasse())) {
            return new ResponseEntity<>("Incorrect old password", HttpStatus.BAD_REQUEST);
        }
        utilisateurService.changePassword(user, requestUtil.getNouveauMotDePasse());
        return new ResponseEntity<>("Password changed successfully", CREATED);
    }

    @Override
    public ResponseEntity<List<UtilisateurDs>> findAllMedecins() {
        return new ResponseEntity<>(utilisateurAssembler
                .assembleEntitiesFrom(utilisateurService.findAllMedecins()), OK);
    }

    @Override
    public ResponseEntity<Void> activatedAccount(String matricule) {
        utilisateurService.activatedAccount(matricule);
        return new ResponseEntity<>(OK);
    }

    @Override
    public ResponseEntity<Void> deactivatedAccount(String matricule) {
        utilisateurService.deactivatedAccount(matricule);
        return new ResponseEntity<>(OK);
    }

    @Override
    public ResponseEntity<String> activationUser(ActivationRequest activationRequest) {
        utilisateurService.createdPassword(activationRequest.getEmail(), activationRequest.getPassword());
        return new ResponseEntity<>("Password Created", CREATED);
    }

    @Override
    public ResponseEntity<ActivationDs> findForActivation(String code) {
        return utilisateurService.findUserForActivation(code);
    }

    @Override
    public String activation(String code) {
        return utilisateurService.lireEnFonctionDuCode(code);
    }
}