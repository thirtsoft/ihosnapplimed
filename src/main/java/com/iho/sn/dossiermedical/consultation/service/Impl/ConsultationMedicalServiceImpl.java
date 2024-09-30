package com.iho.sn.dossiermedical.consultation.service.Impl;

import com.iho.sn.dossiermedical.consultation.entity.ConsultationMedical;
import com.iho.sn.dossiermedical.consultation.exception.ConsultationMedicalException;
import com.iho.sn.dossiermedical.consultation.remote.model.ConsultationMedicalSearchDs;
import com.iho.sn.dossiermedical.consultation.repository.ConsultationMedicalRepository;
import com.iho.sn.dossiermedical.consultation.service.ConsultationMedicalService;
import com.iho.sn.dossiermedical.patient.entity.Patient;
import com.iho.sn.dossiermedical.patient.service.PatientService;
import com.iho.sn.message.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.iho.sn.utils.ConstantSigps.TYPE_SEXE_PATIENT;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
@RequiredArgsConstructor
public class ConsultationMedicalServiceImpl implements ConsultationMedicalService {

    private final ConsultationMedicalRepository consultationMedicalRepository;
    private final PatientService patientService;

    @Override
    public void saveConsultationMedical(ConsultationMedical consultationMedical) throws ConsultationMedicalException {
        if (consultationMedical == null)
            throw new ConsultationMedicalException(Message.NULL_OBJECT);
        if (consultationMedical.getCode() == null || isBlank(consultationMedical.getCode()))
            throw new ConsultationMedicalException("Le patient est obligatoire");
        if (consultationMedical.getNumeroConsultation() == 0) {
            consultationMedical.setNumeroConsultation(createNumeroConsultation());
        }
        Patient patient = patientService.findByCode(consultationMedical.getCode());
        if (patient.getSexe().equals(TYPE_SEXE_PATIENT)) {
            consultationMedical.setTypePatient(1);
        } else {
            consultationMedical.setTypePatient(0);
        }
        consultationMedical.setActif(true);
        consultationMedicalRepository.save(consultationMedical);

    }

    @Override
    public void updateConsultationMedical(Long id, ConsultationMedical consultationMedical) {
        Optional<ConsultationMedical> consultationMedicalFound = consultationMedicalRepository.findConsultationMedicalById(id);
        if (consultationMedicalFound.isEmpty())
            throw new ConsultationMedicalException(Message.NOT_FOUND_OBJECT);
        consultationMedical.setId(id);
        saveConsultationMedical(consultationMedical);
    }

    @Override
    public ConsultationMedical findById(Long id) {
        return consultationMedicalRepository.findConsultationMedicalById(id).orElseThrow(() ->
                new ConsultationMedicalException(Message.NOT_FOUND_OBJECT));
    }

    @Override
    public List<ConsultationMedical> findAllConsultationMedicals() {
        return consultationMedicalRepository.findAllConsultationMedicals();
    }

    @Override
    public List<ConsultationMedical> findByCriteria(ConsultationMedicalSearchDs searchCriteria) {
        return null;
        //  return consultationMedicalRepository.findAll(new ConsSpecs(searchCriteria));
    }

    @Override
    public List<ConsultationMedical> findAllByPatient(String code) {
        return consultationMedicalRepository.findAllByPatient(code);
    }

    @Override
    public void deleteConsultationMedical(Long id) {
        ConsultationMedical deleted = findById(id);
        deleted.setActif(false);
        consultationMedicalRepository.save(deleted);
    }

    @Override
    public int countConsultationMedicalHomme() {
        return consultationMedicalRepository.countConsultationMedicalHomme();
    }

    @Override
    public int countConsultationMedicalFemme() {
        return consultationMedicalRepository.countConsultationMedicalFemme();
    }

    @Override
    public long countConsultationMedical() {
        return consultationMedicalRepository.countConsultationMedical();
    }

    private synchronized int createNumeroConsultation() {
        int nbr = 0;
        try {
            nbr = consultationMedicalRepository.maxNumeroConsultationMedical();

        } catch (Exception e) {
        }
        return (nbr + 1);
    }
}
