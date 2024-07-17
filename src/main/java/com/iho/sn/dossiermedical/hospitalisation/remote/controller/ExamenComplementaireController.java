package com.iho.sn.dossiermedical.hospitalisation.remote.controller;


import com.iho.sn.dossiermedical.hospitalisation.assembler.ExamenComplementaireAssembler;
import com.iho.sn.dossiermedical.hospitalisation.entity.ExamenComplementaire;
import com.iho.sn.dossiermedical.hospitalisation.remote.controller.api.ExamenComplementaireApi;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.ExamenComplementaireDetailDs;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.ExamenComplementaireDs;
import com.iho.sn.dossiermedical.hospitalisation.service.ExamenComplementaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExamenComplementaireController implements ExamenComplementaireApi {

    private final ExamenComplementaireService examenComplementaireService;
    private final ExamenComplementaireAssembler examenComplementaireAssembler;

    @Override
    public ResponseEntity<ExamenComplementaireDetailDs> creerExamenComplementaire(ExamenComplementaireDs examenComplementaireDs) {
        ExamenComplementaire examenComplementaire = examenComplementaireAssembler.assembleExamenComplementaireFromDs(examenComplementaireDs);
        return new ResponseEntity<>(examenComplementaireAssembler
                .assembleEntitiesToDs(examenComplementaireService.saveExamenComplementaire(examenComplementaire)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ExamenComplementaireDetailDs> updateExamenComplementaire(Long id, ExamenComplementaireDs examenComplementaireDs) {
        ExamenComplementaire examenComplementaire = examenComplementaireAssembler.assembleExamenComplementaireFromDs(examenComplementaireDs);
        return new ResponseEntity<>(examenComplementaireAssembler
                .assembleEntitiesToDs(examenComplementaireService.updateExamenComplementaire(id, examenComplementaire)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ExamenComplementaireDetailDs> findById(Long id) {
        return new ResponseEntity<>(examenComplementaireAssembler.assembleEntitiesToDs(
                examenComplementaireService.findById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ExamenComplementaireDetailDs>> findAllExamenComplementaires() {
        return new ResponseEntity<>(examenComplementaireAssembler.assembleEntitiesFrom(
                examenComplementaireService.findAllExamenComplementaires()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteExamenComplementaire(Long id) {
        examenComplementaireService.deleteExamenComplementaire(id);
    }
}