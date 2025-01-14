package com.iho.sn.admin.service;


import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.remote.model.ActivationDs;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UtilisateurService {

    Long saveUtilisateur(Utilisateur utilisateur, String url);

    void creerUtilisateur(Utilisateur utilisateur) throws Exception;

    Utilisateur findUtilisateurById(Long utilisateurId);

    Utilisateur findUserById(Long utilisateurId);

    List<Utilisateur> findAllUtilisateurs();

    Utilisateur findUtilisateurByEmail(String mail);

    Utilisateur updateUserPass(Utilisateur utilisateur);

    String lireEnFonctionDuCode(String code);

    void createdPassword(String email, String password);

    void changePassword(Utilisateur theUser, String newPassword);

    boolean oldPasswordIsValid(Utilisateur user, String ancienMotDePasse);

    void demandeResetMotDePasse(String email);

    Utilisateur findUtilisateurByMatricule(String matricule);

    void deleteUtilisateur(String email);

    List<Utilisateur> findAllMedecins();

    void activatedAccount(String matricule);

    void deactivatedAccount(String matricule);

    ResponseEntity<ActivationDs> findUserForActivation(String code);

}