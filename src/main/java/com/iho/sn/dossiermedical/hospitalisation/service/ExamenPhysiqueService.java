package com.iho.sn.dossiermedical.hospitalisation.service;


import com.iho.sn.dossiermedical.hospitalisation.entity.ExamenPhysique;

import java.util.List;

public interface ExamenPhysiqueService {

    ExamenPhysique saveExamenPhysique(ExamenPhysique examen);

    ExamenPhysique updateExamenPhysique(Long id, ExamenPhysique examen);

    ExamenPhysique findById(Long id);

    List<ExamenPhysique> findAllExamenPhysiques();

    void deleteExamenPhysique(Long id);
}