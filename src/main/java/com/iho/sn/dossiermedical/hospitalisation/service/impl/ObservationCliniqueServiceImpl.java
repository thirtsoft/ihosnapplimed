package com.iho.sn.dossiermedical.hospitalisation.service.impl;


import com.iho.sn.dossiermedical.hospitalisation.entity.ObservationClinique;
import com.iho.sn.dossiermedical.hospitalisation.repository.ExamenPhysiqueRepository;
import com.iho.sn.dossiermedical.hospitalisation.repository.ObservationCliniqueRepository;
import com.iho.sn.dossiermedical.hospitalisation.service.ObservationCliniqueService;
import com.iho.sn.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ObservationCliniqueServiceImpl implements ObservationCliniqueService {

    private final ObservationCliniqueRepository observationCliniqueRepository;

    @Override
    public void saveObservationClinique(ObservationClinique observationClinique) {
        observationCliniqueRepository.save(observationClinique);
    }

    @Override
    public void updateObservationClinique(Long id, ObservationClinique observationClinique) {
        if (!observationCliniqueRepository.existsById(id)) {
            log.info("Observation clinique that id is " + id + "not found");
        }
        observationClinique.setId(id);
        observationCliniqueRepository.save(observationClinique);
    }

    @Override
    public ObservationClinique findById(Long id) {
        return observationCliniqueRepository.findObservationCliniqueById(id)
                .orElseThrow(()->new EntityNotFoundException("observation-clinique"));
    }

    @Override
    public List<ObservationClinique> findAllObservationCliniques() {
        return observationCliniqueRepository.findAllObservationCliniques();
    }

    @Override
    public void deleteObservationClinique(Long id) {
        ObservationClinique observationClinique = findById(id);
        observationCliniqueRepository.save(observationClinique);
    }
}