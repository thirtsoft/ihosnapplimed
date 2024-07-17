package com.iho.sn.dossiermedical.hospitalisation.remote.controller.api;

import com.iho.sn.dossiermedical.hospitalisation.remote.model.ExamenPhysiqueDs;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping(value ="/examenphysique")
public interface ExamenPhysiqueApi {

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ExamenPhysiqueDs> creerExamenPhysique(@RequestBody ExamenPhysiqueDs examenPhysiqueDs);

    @PutMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ExamenPhysiqueDs> updateExamenPhysique(@PathVariable Long id, @RequestBody ExamenPhysiqueDs examenPhysiqueDs);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ExamenPhysiqueDs> findById(@PathVariable Long id);

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ExamenPhysiqueDs>> findAllExamenPhysiques();

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteExamenPhysique(@PathVariable Long id);
}