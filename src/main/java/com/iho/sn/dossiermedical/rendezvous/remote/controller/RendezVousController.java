package com.iho.sn.dossiermedical.rendezvous.remote.controller;

import com.iho.sn.admin.remote.model.ResponseMassageDs;
import com.iho.sn.dossiermedical.rendezvous.RendezVousAssembler;
import com.iho.sn.dossiermedical.rendezvous.entity.RendezVous;
import com.iho.sn.dossiermedical.rendezvous.remote.controller.api.RendezVousApi;
import com.iho.sn.dossiermedical.rendezvous.remote.model.RendezVousDeplaceDs;
import com.iho.sn.dossiermedical.rendezvous.remote.model.RendezVousDetailsDs;
import com.iho.sn.dossiermedical.rendezvous.remote.model.RendezvousDs;
import com.iho.sn.dossiermedical.rendezvous.remote.model.RendezvousListeDs;
import com.iho.sn.dossiermedical.rendezvous.service.RendezVousService;
import com.iho.sn.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class RendezVousController implements RendezVousApi {

    private final RendezVousService rendezVousService;

    private final RendezVousAssembler rendezVousAssembler;

    public RendezVousController(RendezVousService rendezVousService,
                                RendezVousAssembler rendezVousAssembler) {
        this.rendezVousService = rendezVousService;
        this.rendezVousAssembler = rendezVousAssembler;
    }

    @Override
    public ResponseMassageDs creerRendezVous(RendezvousDs rendezVousDs) {
        try {
            rendezVousService.saveRendezVous(rendezVousAssembler.assembleRendezVoRendezVoususFromDs(rendezVousDs));
            return new ResponseMassageDs(Message.SUCCESS_MESSAGE, Message.SAVED_OBJECT);
        } catch (Exception e) {
            return new ResponseMassageDs(Message.FAILED_MESSAGE, Message.ERROR_MESSAGE_SAVED);
        }
    }

    @Override
    public ResponseMassageDs updateRendezVous(Long id, RendezvousDs rendezVousDs) {
        try {
            rendezVousService.updateRendezVous(id, rendezVousAssembler.assembleRendezVoRendezVoususFromDs(rendezVousDs));
            return new ResponseMassageDs(Message.SUCCESS_MESSAGE, Message.EDIT_OBJECT);
        } catch (Exception e) {
            return new ResponseMassageDs(Message.FAILED_MESSAGE, Message.ERROR_MESSAGE_EDIT);
        }
    }

    @Override
    public ResponseEntity<RendezVousDetailsDs> getRendezVous(Long id) {
        RendezVousDetailsDs rendezVousResult = rendezVousAssembler.assembleEntitiesToDs(rendezVousService.findById(id));
        return new ResponseEntity<>(rendezVousResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RendezvousListeDs>> getAllRendezVous() {
        List<RendezvousListeDs> rendezVousDsList = rendezVousService.findAllRendezVouss()
                .stream()
                .map(rendezVousAssembler::assembleRendezVousListeDsFromRendezVous)
                .toList();
        return new ResponseEntity<>(rendezVousDsList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RendezVousDetailsDs>> getRendezVousByDoctor(Long matricule) {
        List<RendezVousDetailsDs> rendezVousDsList = rendezVousService.findAllRendezVousByDoctorId(matricule)
                .stream()
                .map(rendezVousAssembler::assembleEntitiesToDs)
                .toList();
        return new ResponseEntity<>(rendezVousDsList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RendezVousDetailsDs>> getTreeLatestRendezVousByPatient(Long patientId) {
        List<RendezVousDetailsDs> rendezVousDsList = rendezVousService.findTreeLatestRendezVousByPatient(patientId)
                .stream()
                .map(rendezVousAssembler::assembleEntitiesToDs)
                .toList();
        return new ResponseEntity<>(rendezVousDsList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RendezVousDetailsDs>> getAllRendezVousInDay() {
        List<RendezVousDetailsDs> rendezVousDsList = rendezVousService.findRendezVousDuJours()
                .stream()
                .map(rendezVousAssembler::assembleEntitiesToDs)
                .toList();
        return new ResponseEntity<>(rendezVousDsList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RendezVousDetailsDs>> getAllRendezVousOfDoctorInMonth(Long matricule) {
        List<RendezVousDetailsDs> rendezVousDsList = rendezVousService.findAllRendezVousOfDoctorInMonth(matricule)
                .stream()
                .map(rendezVousAssembler::assembleEntitiesToDs)
                .toList();
        return new ResponseEntity<>(rendezVousDsList, HttpStatus.OK);
    }

    @Override
    public ResponseMassageDs deplacerRendezVous(RendezVousDeplaceDs rendezVousDeplace) {
        try {
            rendezVousService.deplacezRendezVous(rendezVousAssembler.assembleEntitiesToDeplaceRendezVous(rendezVousDeplace));
            return new ResponseMassageDs(Message.SUCCESS_MESSAGE, Message.DEPLACE_RENDEZ_VOUS);
        } catch (Exception e) {
            return new ResponseMassageDs(Message.FAILED_MESSAGE, Message.ERROR_MESSAGE_RV_DEPLACE);
        }
    }

    @Override
    public ResponseEntity<List<RendezVousDetailsDs>> getRendezVousBySelectedDate(Date dateRv) {
        List<RendezVousDetailsDs> rendezVousDsList = rendezVousService.findRendezVousBySelectedDate(dateRv)
                .stream()
                .map(rendezVousAssembler::assembleEntitiesToDs)
                .toList();
        return new ResponseEntity<>(rendezVousDsList, HttpStatus.OK);
    }

    @Override
    public int countNumberOfRendezVousByDoctorAndDataRendezVous(Long matricule, Date dateRv) {
        return rendezVousService.countNumberOfRendezVousByDoctorAndDataRendezVous(matricule, dateRv);
    }

    @Override
    public ResponseEntity<List<RendezVousDetailsDs>> getAllRendezVousJournaliers(Date dateRv) {
        List<RendezVousDetailsDs> rendezVousDsList = rendezVousService.findAllRendezVousByDay(dateRv)
                .stream()
                .map(rendezVousAssembler::assembleEntitiesToDs)
                .toList();
        return new ResponseEntity<>(rendezVousDsList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RendezVousDetailsDs>> getAllActivesRendezVous() {
        List<RendezVousDetailsDs> rendezVousDsList = rendezVousService.findAllActivesRendezVous()
                .stream()
                .map(rendezVousAssembler::assembleEntitiesToDs)
                .toList();
        return new ResponseEntity<>(rendezVousDsList, HttpStatus.OK);
    }

    @Override
    public ResponseMassageDs deleteRendezVous(Long id) {
        try {
            rendezVousService.deleteRendezVous(id);
            return new ResponseMassageDs(Message.SUCCESS_MESSAGE, Message.DELETE_OBJECT);
        } catch (Exception e) {
            return new ResponseMassageDs(Message.FAILED_MESSAGE, Message.ERROR_MESSAGE_DELETE);
        }
    }
}