package com.iho.sn.dossiermedical.rendezvous.remote.controller.api;

import com.iho.sn.admin.remote.model.ResponseMassageDs;
import com.iho.sn.dossiermedical.rendezvous.remote.model.RendezVousDeplaceDs;
import com.iho.sn.dossiermedical.rendezvous.remote.model.RendezVousDetailsDs;
import com.iho.sn.dossiermedical.rendezvous.remote.model.RendezvousDs;
import com.iho.sn.dossiermedical.rendezvous.remote.model.RendezvousListeDs;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.List;

@RequestMapping(value = "/rendezvous")
public interface RendezVousApi {

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseMassageDs creerRendezVous(@RequestBody RendezvousDs rendezVousDs);

    @PutMapping(value = "/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseMassageDs updateRendezVous(@PathVariable Long id, @RequestBody RendezvousDs rendezVousDs);

    @GetMapping(value = "/details/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<RendezVousDetailsDs> getRendezVous(@PathVariable Long id);

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<RendezvousListeDs>> getAllRendezVous();

    @GetMapping(value = "/by-doctor/{matricule}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<RendezVousDetailsDs>> getRendezVousByDoctor(@PathVariable Long matricule);

    @GetMapping(value = "/treelatest/by-patient/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<RendezVousDetailsDs>> getTreeLatestRendezVousByPatient(@PathVariable Long patientId);

    @GetMapping(value = "/du-jour")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<RendezVousDetailsDs>> getAllRendezVousInDay();

    @GetMapping(value = "/by-doctor/in-month/{matricule}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<RendezVousDetailsDs>> getAllRendezVousOfDoctorInMonth(@PathVariable Long matricule);

    @PostMapping(value = "/deplacez-rendezvous")
    @ResponseStatus(HttpStatus.OK)
    ResponseMassageDs deplacerRendezVous(@RequestBody RendezVousDeplaceDs rendezVousDeplace);

    @GetMapping(value = "/by-date/{dateRv}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<RendezVousDetailsDs>> getRendezVousBySelectedDate(@PathVariable
                                                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                          Date dateRv);

    @GetMapping(value = "/by-doctor/{matricule}/by-date/{dateRv}")
    @ResponseStatus(HttpStatus.OK)
    int countNumberOfRendezVousByDoctorAndDataRendezVous(@PathVariable Long matricule,
                                                         @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                         Date dateRv);
    @GetMapping(value = "/rendezvous-journalier/{dateRv}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<RendezVousDetailsDs>> getAllRendezVousJournaliers(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateRv);

    @GetMapping(value = "/all-actif")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<RendezVousDetailsDs>> getAllActivesRendezVous();

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseMassageDs deleteRendezVous(@PathVariable Long id);

}