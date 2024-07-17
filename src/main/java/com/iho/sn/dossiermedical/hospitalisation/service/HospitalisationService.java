package com.iho.sn.dossiermedical.hospitalisation.service;


import com.iho.sn.dossiermedical.hospitalisation.entity.Hospitalisation;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HospitalisationService {

    Long saveHospitalisation(Hospitalisation hospitalisation);

    Long updateHospitalisation(Long id, Hospitalisation hospitalisation);

    Hospitalisation findById(Long id);

    List<Hospitalisation> findAllHospitalisations();

    List<Hospitalisation> findAllByPatient(String code);

    void deleteHospitalisation(Long id);

    boolean addExamBiologicToHospitalisation(Long hospitalisationId, MultipartFile biologic);

    boolean addExamImmunologicToHospitalisation(Long hospitalisationId, MultipartFile immunologic);

    boolean addExamImagerToHospitalisation(Long hospitalisationId, MultipartFile imager);

    boolean addExamHematologicToHospitalisation(Long hospitalisationId, MultipartFile hematologic);

    boolean addProtocolMedicalTraitFileToHospitalisation(Long hospitalisationId, MultipartFile protocol);

    int countHospitalisationHomme();

    int countHospitalisationFemme();

    long countHospitalisation();
}