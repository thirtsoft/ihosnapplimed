package com.iho.sn.admin.remote.controller;

import com.iho.sn.admin.assembler.ProfilAssembler;
import com.iho.sn.admin.entities.Profil;
import com.iho.sn.admin.remote.controller.api.ProfilApi;
import com.iho.sn.admin.remote.model.ProfilDs;
import com.iho.sn.admin.remote.model.ResponseMassageDs;
import com.iho.sn.admin.service.ProfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Transactional
@RequiredArgsConstructor
public class ProfilController implements ProfilApi {

    private final ProfilService profilService;
    private final ProfilAssembler profilAssembler;

    @Override
    public ResponseMassageDs creerProfil(ProfilDs profilDs) {
        try {
            Profil profil = profilService.saveProfil(profilAssembler.assembleProfilFromDs(profilDs));
            return new ResponseMassageDs("OK", profil.getId().toString());
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ProfilDs> updateProfil(Long id, ProfilDs profilDs) throws Exception {
        Profil profil = profilAssembler.assembleProfilFromDs(profilDs);
        return new ResponseEntity<>(profilAssembler.assembleEntityToDs(
                profilService.updateProfil(id, profil)
        ), OK);
    }

    @Override
    public ResponseEntity<ProfilDs> findProfilById(Long id) {
        return new ResponseEntity<>(profilAssembler.assembleEntityToDs(
                profilService.findProfilById(id)
        ), OK);
    }

    @Override
    public ResponseEntity<ProfilDs> findByCode(String code) {
        return new ResponseEntity<>(profilAssembler.assembleEntityToDs(
                profilService.findByCode(code)
        ), OK);
    }

    @Override
    public ResponseEntity<ProfilDs> findByLibelle(String libelle) {
        return new ResponseEntity<>(profilAssembler.assembleEntityToDs(
                profilService.findByLibelle(libelle)), OK);
    }

    @Override
    public ResponseEntity<ProfilDs> findByCodeFromAction(String code) {
        return new ResponseEntity<>(profilAssembler.assembleEntityToDs(
                profilService.findByCodeFromAction(code)
        ), OK);
    }

    @Override
    public ResponseEntity<List<ProfilDs>> findAllProfils() {
        return new ResponseEntity<>(profilAssembler.assembleEntitiesFrom(
                profilService.findAllActive()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteProfil(Long id) {
        profilService.deleteProfil(id);
    }
}
