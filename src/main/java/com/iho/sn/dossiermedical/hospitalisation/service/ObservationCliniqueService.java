package com.iho.sn.dossiermedical.hospitalisation.service;


import com.iho.sn.dossiermedical.hospitalisation.entity.ObservationClinique;

import java.util.List;

public interface ObservationCliniqueService {

    void saveObservationClinique(ObservationClinique observationClinique);

    void updateObservationClinique(Long id, ObservationClinique observationClinique);

    ObservationClinique findById(Long id);

    List<ObservationClinique> findAllObservationCliniques();

    void deleteObservationClinique(Long id);
}