package com.iho.sn.dossiermedical.hospitalisation.remote.controller;

import com.iho.sn.dossiermedical.hospitalisation.assembler.ExamenPhysiqueAssembler;
import com.iho.sn.dossiermedical.hospitalisation.remote.controller.api.ExamenPhysiqueApi;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.ExamenPhysiqueDs;
import com.iho.sn.dossiermedical.hospitalisation.service.ExamenPhysiqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExamenPhysiqueController implements ExamenPhysiqueApi {

    private final ExamenPhysiqueService examenPhysiqueService;

    private final ExamenPhysiqueAssembler examenPhysiqueAssembler;

    @Override
    public ResponseEntity<ExamenPhysiqueDs> creerExamenPhysique(ExamenPhysiqueDs examenPhysiqueDs) {
        return new ResponseEntity<>(examenPhysiqueAssembler.assembleEntityToDs(
                examenPhysiqueService.saveExamenPhysique(examenPhysiqueAssembler.assembleExamenPhysiqueFromDs(examenPhysiqueDs))
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ExamenPhysiqueDs> updateExamenPhysique(Long id, ExamenPhysiqueDs examenPhysiqueDs) {
        return new ResponseEntity<>(examenPhysiqueAssembler.assembleEntityToDs(
                examenPhysiqueService.updateExamenPhysique(id, examenPhysiqueAssembler.assembleExamenPhysiqueFromDs(examenPhysiqueDs))
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ExamenPhysiqueDs> findById(Long id) {
        return new ResponseEntity<>(examenPhysiqueAssembler.assembleEntityToDs(
                examenPhysiqueService.findById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ExamenPhysiqueDs>> findAllExamenPhysiques() {
        return new ResponseEntity<>(examenPhysiqueAssembler.assembleEntitiesFrom(examenPhysiqueService.findAllExamenPhysiques()), HttpStatus.OK);
    }

    @Override
    public void deleteExamenPhysique(Long id) {
        examenPhysiqueService.deleteExamenPhysique(id);
    }
}