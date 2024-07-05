package com.iho.sn.admin.service;

import com.iho.sn.admin.entities.Profil;

import java.util.List;

public interface ProfilService {

    Profil saveProfil(Profil profil);

    Profil updateProfil(Long id, Profil profil);

    List<Profil> findAllActive();

    Profil findProfilById(Long id);

    Profil findByCode(String code);

    Profil findByLibelle(String libelle);

    Profil findByProfilCode(String code);

    Profil findByCodeFromAction(String code);

    void deleteProfil(Long id);
}
