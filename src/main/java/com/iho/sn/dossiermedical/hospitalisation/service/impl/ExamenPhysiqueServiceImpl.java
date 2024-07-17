package com.iho.sn.dossiermedical.hospitalisation.service.impl;

import com.iho.sn.dossiermedical.hospitalisation.entity.ExamenPhysique;
import com.iho.sn.dossiermedical.hospitalisation.entity.ObservationClinique;
import com.iho.sn.dossiermedical.hospitalisation.repository.ExamenPhysiqueRepository;
import com.iho.sn.dossiermedical.hospitalisation.repository.ObservationCliniqueRepository;
import com.iho.sn.dossiermedical.hospitalisation.service.ExamenPhysiqueService;
import com.iho.sn.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExamenPhysiqueServiceImpl implements ExamenPhysiqueService {

    private final ExamenPhysiqueRepository examenPhysiqueRepository;
    private final ObservationCliniqueRepository observationCliniqueRepository;

    @Override
    public ExamenPhysique saveExamenPhysique(ExamenPhysique examen) {
        ObservationClinique observationClinique = observationCliniqueRepository.findObservationCliniqueById(examen.getObservationCliniqueId())
                .orElseThrow(() -> new EntityNotFoundException("observation-clinique"));
        examen.setObservationCliniqueId(examen.getObservationCliniqueId());
        examen.setObservationClinique(observationClinique);
        return examenPhysiqueRepository.save(examen);
    }

    @Override
    public ExamenPhysique updateExamenPhysique(Long id, ExamenPhysique examen) {
        if (!examenPhysiqueRepository.existsById(id)) {
            log.info("Examen physique that id is " + id + "not found");
        }
        examen.setId(id);
        return examenPhysiqueRepository.save(examen);
    }

    @Override
    public ExamenPhysique findById(Long id) {
        return examenPhysiqueRepository.findExamenPhysiqueById(id);
    }

    @Override
    public List<ExamenPhysique> findAllExamenPhysiques() {
        return examenPhysiqueRepository.findAll();
    }

    @Override
    public void deleteExamenPhysique(Long id) {
        ExamenPhysique examenPhysique = findById(id);
        examenPhysiqueRepository.delete(examenPhysique);
    }
}