package com.iho.sn.dossiermedical.hospitalisation.remote.controller.api;

import com.iho.sn.dossiermedical.hospitalisation.remote.model.ExamenComplementaireDetailDs;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.ExamenComplementaireDs;
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


@RequestMapping(value = "/examencomplementaire")
public interface ExamenComplementaireApi {

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ExamenComplementaireDetailDs> creerExamenComplementaire(@RequestBody ExamenComplementaireDs examenComplementaireDs);

    @PutMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ExamenComplementaireDetailDs> updateExamenComplementaire(@PathVariable Long id, @RequestBody ExamenComplementaireDs examenComplementaireDs);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ExamenComplementaireDetailDs> findById(@PathVariable Long id);

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ExamenComplementaireDetailDs>> findAllExamenComplementaires();

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteExamenComplementaire(@PathVariable Long id);
}