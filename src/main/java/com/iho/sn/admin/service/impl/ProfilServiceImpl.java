package com.iho.sn.admin.service.impl;


import com.iho.sn.admin.entities.Profil;
import com.iho.sn.admin.repository.ProfilRepository;
import com.iho.sn.admin.service.ProfilService;
import com.iho.sn.exception.ActionAlreadyExistException;
import com.iho.sn.exception.ProfilAlreadyExistsException;
import com.iho.sn.exception.ProfilNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfilServiceImpl implements ProfilService {

    private final ProfilRepository profilRepository;

    @Override
    public Profil saveProfil(Profil profil) {
        String code = profil.getCode();
        Optional<Profil> byCode = profilRepository.findByProfilCode(code);
        if (profil.getId() == null && byCode.isPresent()
                || (profil.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(profil.getId()))) {
            throw new ActionAlreadyExistException(String.format("Le code %s est déjà associé à pour un autre profil .", code));
        }
        String libelle = profil.getLibelle();
        Optional<Profil> byLibelle = profilRepository.findByProfilLibelle(libelle);
        if (profil.getId() == null && byLibelle.isPresent()
                || (profil.getId() != null && byLibelle.isPresent() && !byLibelle.get().getId().equals(profil.getId()))) {
            throw new ProfilAlreadyExistsException(String.format("Le profil que vous voulez crée %s existe déjà .", libelle));
        }
        profil.setActif(true);
        return profilRepository.save(profil);
    }

    @Override
    public Profil updateProfil(Long id, Profil profil) {
        if (!profilRepository.existsById(id)) {
            log.info("This profil that id is {} not found", id);
        }
        Profil profilResult = profilRepository.findProfilById(id);
        if (profilResult == null) {
            throw new ProfilNotFoundException("This Profil is not found");
        }
        profilResult.setCode(profil.getCode());
        profilResult.setLibelle(profil.getLibelle());
        profilResult.setAction(profil.getAction());
        return profilRepository.save(profilResult);
    }

    @Override
    public List<Profil> findAllActive() {
        return profilRepository.findAllActive();
    }

    @Override
    public Profil findProfilById(Long id) {
        return profilRepository.findProfilById(id);
    }

    @Override
    public Profil findByCode(String code) {
        return profilRepository.findByCode(code);
    }

    @Override
    public Profil findByLibelle(String libelle) {
        return profilRepository.findByLibelle(libelle);
    }

    @Override
    public Profil findByProfilCode(String code) {
        return profilRepository.findByProfilCode(code)
                .orElseThrow(() -> new ProfilNotFoundException("Profil inconnu"));
    }

    @Override
    public Profil findByCodeFromAction(String code) {
        return profilRepository.findByCodeFromAction(code);
    }

    @Override
    public void deleteProfil(Long id) {
        Profil profil = findProfilById(id);
        profil.setActif(false);
        profilRepository.save(profil);
    }
}
