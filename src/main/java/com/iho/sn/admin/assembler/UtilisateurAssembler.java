package com.iho.sn.admin.assembler;

import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.remote.model.ListeUtilisateurDs;
import com.iho.sn.admin.remote.model.UtilisateurDs;
import com.iho.sn.admin.remote.model.UtilisateurProfilDs;
import com.iho.sn.admin.service.ProfilService;
import com.iho.sn.admin.service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UtilisateurAssembler {

    private final ProfilService profilService;
    private final UtilisateurService utilisateurService;
    private final ProfilAssembler profilAssembler;

    public List<ListeUtilisateurDs> assembleListeUtilisateurDsFrom(List<Utilisateur> utilisateurs) {
        return utilisateurs.stream().map(this::assembleListeUtilisateurDsFromEntity).toList();
    }

    public ListeUtilisateurDs assembleListeUtilisateurDsFromEntity(Utilisateur utilisateur) {
        ListeUtilisateurDs listeUtilisateurDs = new ListeUtilisateurDs();
        if (utilisateur.getId() != null) {
            listeUtilisateurDs.setId(utilisateur.getId());
        }
        listeUtilisateurDs.setNom(utilisateur.getNom());
        listeUtilisateurDs.setPrenom(utilisateur.getPrenom());
        listeUtilisateurDs.setEmail(utilisateur.getEmail());
        listeUtilisateurDs.setTelephone(utilisateur.getTelephone());
        listeUtilisateurDs.setActif(utilisateur.isActif());
        return listeUtilisateurDs;
    }

    public List<UtilisateurDs> assembleEntitiesFrom(List<Utilisateur> utilisateurs) {
        return utilisateurs.stream().map(this::assembleUtilisateurDsFromEntity).toList();
    }

    public Utilisateur assembleUtilisateurFromDs(UtilisateurDs utilisateurDs) {
        Utilisateur utilisateur = new Utilisateur();
        if (utilisateurDs.getId() != null) {
            utilisateur.setId(utilisateurDs.getId());
        }
        utilisateur.setCodeUtilisateur(utilisateurDs.getCodeUtilisateur());
        utilisateur.setPrenom(utilisateurDs.getPrenom());
        utilisateur.setNom(utilisateurDs.getNom());
        utilisateur.setEmail(utilisateurDs.getEmail());
        utilisateur.setMotdepasse(utilisateurDs.getMotDePasse());
        utilisateur.setTelephone(utilisateurDs.getTelephone());
    //    utilisateur.setProfil(profilService.findByProfilCode(utilisateurDs.getProfileCode()));
        utilisateur.setFonction(utilisateurDs.getFonction());
        utilisateur.setTypeUtilisateur(utilisateurDs.getTypeUtilisateur());
        utilisateur.setAdresse(utilisateurDs.getAdresse());
        utilisateur.setSexe(utilisateurDs.getSexe());
        utilisateur.setCivilite(utilisateurDs.getCivilite());
        utilisateur.setProfil(profilService.findProfilById(utilisateurDs.getProfilDs().getId()));
        return utilisateur;
    }

    public Utilisateur assembleUtilisateurForUpdateDs(UtilisateurDs utilisateurDs) {
        Utilisateur utilisateur = utilisateurService.findUtilisateurByEmail(utilisateurDs.getEmail());
        utilisateur.setCodeUtilisateur(utilisateurDs.getCodeUtilisateur());
        utilisateur.setPrenom(utilisateurDs.getPrenom());
        utilisateur.setNom(utilisateurDs.getNom());
        utilisateur.setTelephone(utilisateurDs.getTelephone());
        utilisateur.setCivilite(utilisateurDs.getCivilite());
        utilisateur.setSexe(utilisateurDs.getSexe());
        utilisateur.setFonction(utilisateurDs.getFonction());
        utilisateur.setAdresse(utilisateurDs.getAdresse());
        utilisateur.setEducation(utilisateurDs.getEducation());
        utilisateur.setExperience(utilisateurDs.getExperience());
        utilisateur.setDateRecrutement(utilisateurDs.getDateRecrutement());
        return utilisateur;
    }

    public UtilisateurDs assembleUtilisateurDsFromEntity(Utilisateur utilisateur) {
        UtilisateurDs utilisateurDs = new UtilisateurDs();
        if (utilisateur.getId() != null) utilisateurDs.setId(utilisateur.getId());
        utilisateurDs.setCodeUtilisateur(utilisateur.getCodeUtilisateur());
    //    utilisateurDs.setProfileCode(utilisateur.getProfil().getLibelle());
        utilisateurDs.setProfilDs(profilAssembler.assembleEntityToDs(utilisateur.getProfil()));
        utilisateurDs.setPrenom(utilisateur.getPrenom());
        utilisateurDs.setNom(utilisateur.getNom());
        utilisateurDs.setEmail(utilisateur.getEmail());
        utilisateurDs.setMotDePasse(utilisateur.getMotdepasse());
        utilisateurDs.setTelephone(utilisateur.getTelephone());
        utilisateurDs.setMatricule(utilisateur.getMatricule());
        utilisateurDs.setFonction(utilisateur.getFonction());
        utilisateurDs.setAdresse(utilisateur.getAdresse());
        utilisateurDs.setTypeUtilisateur(utilisateur.getTypeUtilisateur());
        utilisateurDs.setCivilite(utilisateur.getCivilite());
        utilisateurDs.setSexe(utilisateur.getSexe());
        utilisateurDs.setActif(utilisateur.isActif());
        return utilisateurDs;
    }

    public UtilisateurProfilDs assembleUtilisateurProfilDsFromEntity(Utilisateur utilisateur) {
        UtilisateurProfilDs utilisateurDs = new UtilisateurProfilDs();
        if (utilisateur.getId() != null) utilisateurDs.setId(utilisateur.getId());
        utilisateurDs.setCodeUtilisateur(utilisateur.getCodeUtilisateur());
        utilisateurDs.setPrenom(utilisateur.getPrenom());
        utilisateurDs.setNom(utilisateur.getNom());
        utilisateurDs.setEmail(utilisateur.getEmail());
        utilisateurDs.setTelephone(utilisateur.getTelephone());
        utilisateurDs.setProfileCode(utilisateur.getProfil().getLibelle());
        utilisateurDs.setMatricule(utilisateur.getMatricule());
        utilisateurDs.setCivilite(utilisateur.getCivilite());
        utilisateurDs.setSexe(utilisateur.getSexe());
        utilisateurDs.setFonction(utilisateur.getFonction());
        utilisateurDs.setAdresse(utilisateur.getAdresse());
        utilisateurDs.setTypeUtilisateur(utilisateur.getTypeUtilisateur());
        utilisateurDs.setDateRecrutement(utilisateur.getDateRecrutement());
        utilisateurDs.setEducation(utilisateur.getEducation());
        utilisateurDs.setExperience(utilisateur.getExperience());
        return utilisateurDs;
    }
}
