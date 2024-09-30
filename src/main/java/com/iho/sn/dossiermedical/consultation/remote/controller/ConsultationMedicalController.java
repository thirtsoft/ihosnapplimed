package com.iho.sn.dossiermedical.consultation.remote.controller;

import com.iho.sn.dossiermedical.consultation.assembler.ConsultationMedicalAssembler;
import com.iho.sn.dossiermedical.consultation.entity.ConsultationMedical;
import com.iho.sn.dossiermedical.consultation.remote.controller.api.ConsultationMedicalApi;
import com.iho.sn.dossiermedical.consultation.remote.model.ConsultationMedicalDetailsDs;
import com.iho.sn.dossiermedical.consultation.remote.model.ConsultationMedicalDs;
import com.iho.sn.dossiermedical.consultation.remote.model.ConsultationMedicalListeDs;
import com.iho.sn.dossiermedical.consultation.remote.model.ConsultationMedicalSearchDs;
import com.iho.sn.dossiermedical.consultation.service.ConsultationMedicalService;
import com.iho.sn.message.Message;
import com.iho.sn.message.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConsultationMedicalController implements ConsultationMedicalApi {

    private final ConsultationMedicalService consultationMedicalService;
    private final ConsultationMedicalAssembler consultationMedicalAssembler;

    @Override
    public ResponseMessage creerConsultationMedical(ConsultationMedicalDs consultationMedicalDs) {
        ConsultationMedical saved = consultationMedicalAssembler.assembleEntityFromDs(consultationMedicalDs);
        try {
            consultationMedicalService.saveConsultationMedical(saved);
            return new ResponseMessage(Message.SUCCESS_MESSAGE, Message.SAVED_OBJECT);
        } catch (Exception e) {
            return new ResponseMessage(Message.FAILED_MESSAGE, Message.ERROR_MESSAGE_SAVED);
        }
    }

    @Override
    public ResponseMessage updateConsultationMedical(Long id, ConsultationMedicalDs consultationMedicalDs) {
        ConsultationMedical updated = consultationMedicalAssembler.assembleEntityFromDs(consultationMedicalDs);
        try {
            consultationMedicalService.updateConsultationMedical(id, updated);
            return new ResponseMessage(Message.SUCCESS_MESSAGE, Message.EDIT_OBJECT);
        } catch (Exception e) {
            return new ResponseMessage(Message.FAILED_MESSAGE, Message.ERROR_MESSAGE_EDIT);
        }
    }

    @Override
    public ResponseEntity<ConsultationMedicalDetailsDs> findById(Long id) {
        return new ResponseEntity<>(consultationMedicalAssembler.assembleFromEntityToDetailsDs(
                consultationMedicalService.findById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ConsultationMedicalListeDs>> findAllConsultationMedicals() {
        return new ResponseEntity<>(consultationMedicalAssembler.assembleEntitiesFrom(
                consultationMedicalService.findAllConsultationMedicals()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ConsultationMedicalListeDs>> findByCriteria(ConsultationMedicalSearchDs searchDs) {
        return new ResponseEntity<>(consultationMedicalAssembler.assembleEntitiesFrom(
                consultationMedicalService.findByCriteria(searchDs)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ConsultationMedicalDetailsDs>> getConsultationMedicalsDetailsByPatient(String code) {
        return new ResponseEntity<>(consultationMedicalAssembler.assembleConsultationMedicalDetailsDsFromEntities(
                consultationMedicalService.findAllByPatient(code)), HttpStatus.OK);
    }

    @Override
    public ResponseMessage deleteConsultationMedical(Long id) {
        try {
            consultationMedicalService.deleteConsultationMedical(id);
            return new ResponseMessage(Message.SUCCESS_MESSAGE, Message.DELETE_OBJECT);
        } catch (Exception e) {
            return new ResponseMessage(Message.FAILED_MESSAGE, Message.ERROR_MESSAGE_DELETE);
        }
    }

    @Override
    public int countConsultationMedicalHomme() {
        return consultationMedicalService.countConsultationMedicalHomme();
    }

    @Override
    public int countConsultationMedicalFemme() {
        return consultationMedicalService.countConsultationMedicalFemme();
    }

    @Override
    public long countConsultationMedical() {
        return consultationMedicalService.countConsultationMedical();
    }
}
