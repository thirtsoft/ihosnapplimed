package com.iho.sn.dossiermedical.hospitalisation.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.iho.sn.dossiermedical.hospitalisation.entity.ExamenComplementaire;
import com.iho.sn.dossiermedical.hospitalisation.entity.Hospitalisation;
import com.iho.sn.dossiermedical.hospitalisation.entity.TraitementMedical;
import com.iho.sn.dossiermedical.hospitalisation.repository.HospitalisationRepository;
import com.iho.sn.dossiermedical.hospitalisation.service.HospitalisationService;
import com.iho.sn.dossiermedical.patient.entity.Patient;
import com.iho.sn.dossiermedical.patient.service.PatientService;
import com.iho.sn.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.iho.sn.utils.ConstantSigps.TYPE_SEXE_PATIENT;

@Service
@Transactional(propagation = Propagation.REQUIRED)
@Slf4j
@RequiredArgsConstructor
public class HospitalisationServiceImpl implements HospitalisationService {

    private final HospitalisationRepository hospitalisationRepository;
    private final PatientService patientService;


    @Override
    public Long saveHospitalisation(Hospitalisation hospitalisation) {
        if (hospitalisation.getNumeroHospitalisation() == 0) {
            hospitalisation.setNumeroHospitalisation(createNumeroHospitalisation());
        }
        Patient patient = patientService.findByCode(hospitalisation.getCode());
        String sexe = patient.getSexe();
        if (sexe.equals(TYPE_SEXE_PATIENT)) {
            hospitalisation.setTypePatient(1);
        } else {
            hospitalisation.setTypePatient(0);
        }
        Hospitalisation hospitalisationResult = hospitalisationRepository.save(hospitalisation);
        return hospitalisationResult.getId();
    }


    @Override
    public Long updateHospitalisation(Long id, Hospitalisation hospitalisation) {
        Hospitalisation hospitalisationResult = findById(id);
        hospitalisationResult.setDiscussion(hospitalisation.getDiscussion());
        hospitalisationResult.setExamenComplementaire(hospitalisation.getExamenComplementaire());
        hospitalisationResult.setObservationClinique(hospitalisation.getObservationClinique());
        hospitalisationResult.setSynthese(hospitalisation.getSynthese());
        hospitalisationResult.setTraitementMedical(hospitalisation.getTraitementMedical());
        Hospitalisation savedHospitalisationResult = hospitalisationRepository.save(hospitalisationResult);
        return savedHospitalisationResult.getId();
    }

    @Override
    public Hospitalisation findById(Long id) {
        return hospitalisationRepository.findHospitalisationById(id)
                .orElseThrow(() -> new EntityNotFoundException("hospitalisation"));
    }

    @Override
    public List<Hospitalisation> findAllHospitalisations() {
        return hospitalisationRepository.findAllHospitalisations();
    }

    @Override
    public List<Hospitalisation> findAllByPatient(String code) {
        return hospitalisationRepository.findAllByPatient(code);
    }

    @Override
    public void deleteHospitalisation(Long id) {
        Hospitalisation hospitalisation = findById(id);
        hospitalisationRepository.save(hospitalisation);
    }

    @Override
    public boolean addExamBiologicToHospitalisation(Long hospitalisationId, MultipartFile biologic) {
        Hospitalisation hospitalisation = findById(hospitalisationId);
        ExamenComplementaire examenComplementaire = hospitalisation.getExamenComplementaire();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
//        try {
        if (biologic != null) {
//                PiecesJointes piecesJointesDTO = piecesJointesService.findByObjectIdAndIdDocument
//                        (examenComplementaire.getId(), ConstantSigps.TYPE_EXAM_BIO_COMP).orElse(new PiecesJointes());
//                piecesJointesDTO.setObjectId(examenComplementaire.getId());
//                piecesJointesDTO.setDossier("examen_complementaire");
//                piecesJointesDTO.setTypeDocumentId(ConstantSigps.TYPE_EXAM_BIO_COMP);
//                piecesJointesDTO.setNomFichier(biologic.getName());
//                piecesJointesService.savePiecesJointes(biologic, objectMapper.writeValueAsString(piecesJointesDTO));
            return true;
        }
//        } catch (Exception e) {
//            throw new Exception("La consultation n'existe pas.");
//        }
        return false;
    }

    @Override
    public boolean addExamImmunologicToHospitalisation(Long hospitalisationId, MultipartFile immunologic) {
        Hospitalisation hospitalisation = findById(hospitalisationId);
        ExamenComplementaire examenComplementaire = hospitalisation.getExamenComplementaire();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
//        try {
//            if (immunologic != null) {
//                PiecesJointes piecesJointesDTO = piecesJointesService.findByObjectIdAndIdDocument
//                        (examenComplementaire.getId(), ConstantSigps.TYPE_EXAM_IMMUNO_COMP).orElse(new PiecesJointes());
//                piecesJointesDTO.setObjectId(examenComplementaire.getId());
//                piecesJointesDTO.setDossier("examen_complementaire");
//                piecesJointesDTO.setTypeDocumentId(ConstantSigps.TYPE_EXAM_IMMUNO_COMP);
//                piecesJointesDTO.setNomFichier(immunologic.getName());
//                piecesJointesService.savePiecesJointes(immunologic, objectMapper.writeValueAsString(piecesJointesDTO));
//                return true;
//            } else {
//                throw new Exception("Hospitalisation n'existe pas.");
//            }
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
        return false;
    }

    @Override
    public boolean addExamImagerToHospitalisation(Long hospitalisationId, MultipartFile imager) {
        Hospitalisation hospitalisation = findById(hospitalisationId);
        ExamenComplementaire examenComplementaire = hospitalisation.getExamenComplementaire();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
//        try {
//            if (imager != null) {
//                PiecesJointes piecesJointesDTO = piecesJointesService.findByObjectIdAndIdDocument
//                        (examenComplementaire.getId(), ConstantSigps.TYPE_EXAM_IMG_COMP).orElse(new PiecesJointes());
//                piecesJointesDTO.setObjectId(examenComplementaire.getId());
//                piecesJointesDTO.setDossier("examen_complementaire");
//                piecesJointesDTO.setTypeDocumentId(ConstantSigps.TYPE_EXAM_IMG_COMP);
//                piecesJointesDTO.setNomFichier(imager.getName());
//                piecesJointesService.savePiecesJointes(imager, objectMapper.writeValueAsString(piecesJointesDTO));
//                return true;
//            } else {
//                throw new Exception("La hospitalisation n'existe pas.");
//            }
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
        return false;
    }

    @Override
    public boolean addExamHematologicToHospitalisation(Long hospitalisationId, MultipartFile hematologic) {
        Hospitalisation hospitalisation = findById(hospitalisationId);
        ExamenComplementaire examenComplementaire = hospitalisation.getExamenComplementaire();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
//        try {
//            if (hematologic != null) {
//                PiecesJointes piecesJointesDTO = piecesJointesService.findByObjectIdAndIdDocument
//                        (examenComplementaire.getId(), ConstantSigps.TYPE_EXAM_ANA_COMP).orElse(new PiecesJointes());
//                piecesJointesDTO.setObjectId(examenComplementaire.getId());
//                piecesJointesDTO.setDossier("examen_complementaire");
//                piecesJointesDTO.setTypeDocumentId(ConstantSigps.TYPE_EXAM_ANA_COMP);
//                piecesJointesDTO.setNomFichier(hematologic.getName());
//                piecesJointesService.savePiecesJointes(hematologic, objectMapper.writeValueAsString(piecesJointesDTO));
//                return true;
//            } else {
//                throw new Exception("L'hospitalisation n'existe pas.");
//            }
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
        return false;
    }

    @Override
    public boolean addProtocolMedicalTraitFileToHospitalisation(Long hospitalisationId, MultipartFile protocol) {
        Hospitalisation hospitalisation = findById(hospitalisationId);
        TraitementMedical traitementMedical = hospitalisation.getTraitementMedical();
        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            if (protocol != null) {
//                PiecesJointes piecesJointesDTO = new PiecesJointes();
//                piecesJointesDTO.setObjectId(traitementMedical.getId());
//                piecesJointesDTO.setDossier("traitement_medical");
//                piecesJointesDTO.setTypeDocumentId(ConstantSigps.TYPE_PROTOCOLE_MEDIC);
//                piecesJointesDTO.setNomFichier(protocol.getName());
//                piecesJointesService.savePiecesJointes(protocol, objectMapper.writeValueAsString(piecesJointesDTO));
//                return true;
//            } else {
//                throw new EntityNotFoundException("L'hospitalisation n'existe pas.");
//            }
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
        return false;
    }

    @Override
    public int countHospitalisationHomme() {
        return hospitalisationRepository.countHospitalisationHomme();
    }

    @Override
    public int countHospitalisationFemme() {
        return hospitalisationRepository.countHospitalisationFemme();
    }

    @Override
    public long countHospitalisation() {
        return hospitalisationRepository.countHospitalisation();
    }

    private synchronized int createNumeroHospitalisation() {
        int nbr = 0;
        try {
            nbr = hospitalisationRepository.maxNumeroHospitalisation();

        } catch (Exception e) {
        }
        return (nbr + 1);
    }
}