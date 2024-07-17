package com.iho.sn.dossiermedical.hospitalisation.remote.controller;

import com.iho.sn.dossiermedical.hospitalisation.assembler.SyntheseAssembler;
import com.iho.sn.dossiermedical.hospitalisation.remote.controller.api.SyntheseApi;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.SyntheseDs;
import com.iho.sn.dossiermedical.hospitalisation.service.SyntheseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SyntheseController implements SyntheseApi {

    private final SyntheseService syntheseService;
    private final SyntheseAssembler syntheseAssembler;

    @Override
    public ResponseEntity<SyntheseDs> creerSynthese(SyntheseDs syntheseDs) {
        return new ResponseEntity<>(syntheseAssembler.assembleEntityToDs(
                syntheseService.saveSynthese(
                        syntheseAssembler.assembleSyntheseFromDs(syntheseDs)
                )
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SyntheseDs> updateSynthese(Long id, SyntheseDs syntheseDs) {
        return new ResponseEntity<>(syntheseAssembler.assembleEntityToDs(
                syntheseService.updateSynthese(id,
                        syntheseAssembler.assembleSyntheseFromDs(syntheseDs)
                )
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SyntheseDs> findById(Long id) {
        return new ResponseEntity<>(syntheseAssembler.assembleEntityToDs(
                syntheseService.findById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SyntheseDs>> findAllSyntheses() {
        return new ResponseEntity<>(syntheseAssembler.assembleEntitiesFrom(
                syntheseService.findAllSyntheses()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteSynthese(Long id) {
        syntheseService.deleteSynthese(id);
    }
}