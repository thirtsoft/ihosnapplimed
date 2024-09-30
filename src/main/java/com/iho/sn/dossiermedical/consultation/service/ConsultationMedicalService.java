package com.iho.sn.dossiermedical.consultation.service;

import com.iho.sn.dossiermedical.consultation.entity.ConsultationMedical;
import com.iho.sn.dossiermedical.consultation.exception.ConsultationMedicalException;
import com.iho.sn.dossiermedical.consultation.remote.model.ConsultationMedicalSearchDs;

import java.util.List;

public interface ConsultationMedicalService {

    void saveConsultationMedical(ConsultationMedical consultationMedical) throws ConsultationMedicalException;

    void updateConsultationMedical(Long id, ConsultationMedical consultationMedical) throws ConsultationMedicalException;

    ConsultationMedical findById(Long id);

    List<ConsultationMedical> findAllConsultationMedicals();

    List<ConsultationMedical> findByCriteria(ConsultationMedicalSearchDs searchCriteria);

    List<ConsultationMedical> findAllByPatient(String code);

    void deleteConsultationMedical(Long id);

    int countConsultationMedicalHomme();

    int countConsultationMedicalFemme();

    long countConsultationMedical();
}
